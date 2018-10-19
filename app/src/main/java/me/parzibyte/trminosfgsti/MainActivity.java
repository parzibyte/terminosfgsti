package me.parzibyte.trminosfgsti;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    int indice = 0;
    List<Termino> resultados;
    TextView textViewDefinicion, textViewTermino, textViewPaginacion;
    Button buttonAnterior, buttonSiguiente;

    public void refrescarTermino() {
        if (resultados.size() > 0) {
            textViewTermino.setText(resultados.get(indice).getTermino());
            textViewDefinicion.setText(resultados.get(indice).getDefinicion());
            textViewPaginacion.setText(getString(R.string.paginacion, indice + 1, resultados.size()));
        } else {
            textViewTermino.setText("");
            textViewDefinicion.setText(getString(R.string.no_hay_resultados));
            textViewPaginacion.setText("");
        }

        refrescarEstadoDeBotones();
    }

    public boolean puedeIrAlSiguienteResultado() {
        return resultados != null && resultados.size() > 0 && indice + 1 < resultados.size();
    }

    public boolean puedeIrAlResultadoAnterior() {
        return resultados != null && resultados.size() > 0 && indice > 0;
    }

    public void mostrarElPrimerResultado() {

        indice = 0;
        refrescarTermino();
    }

    public void mostrarSiguienteResultado() {
        if (puedeIrAlSiguienteResultado()) {
            indice++;
            refrescarTermino();
        }

    }

    public void refrescarEstadoDeBotones() {
        if (resultados == null || resultados.size() <= 0) {
            deshabilitarBotonAnterior();
            deshabilitarBotonSiguiente();
            return;
        }

        if (indice + 1 >= resultados.size()) {
            deshabilitarBotonSiguiente();
        } else {
            habilitarBotonSiguiente();
        }

        if (indice - 1 < 0) {
            deshabilitarBotonAnterior();
        } else {
            habilitarBotonAnterior();
        }
    }

    public void mostrarResultadoAnterior() {
        if (puedeIrAlResultadoAnterior()) {
            indice--;
            refrescarTermino();
        }
    }

    public void habilitarBotonSiguiente() {
        buttonSiguiente.setVisibility(View.VISIBLE);
    }

    public void deshabilitarBotonSiguiente() {
        buttonSiguiente.setVisibility(View.INVISIBLE);
    }

    public void habilitarBotonAnterior() {
        buttonAnterior.setVisibility(View.VISIBLE);
    }

    public void deshabilitarBotonAnterior() {
        buttonAnterior.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AyudanteBaseDeDatos ayudanteBaseDeDatos = new AyudanteBaseDeDatos(getApplicationContext());

        textViewDefinicion = findViewById(R.id.textViewResultados);
        textViewTermino = findViewById(R.id.textViewTermino);
        textViewPaginacion = findViewById(R.id.textViewPaginacion);
        buttonAnterior = findViewById(R.id.buttonAnterior);
        buttonSiguiente = findViewById(R.id.buttonSiguiente);
        EditText editTextBusqueda = findViewById(R.id.editTextBusqueda);
        editTextBusqueda.addTextChangedListener(new TextWatcher() {

            // Antes de que el texto cambie (no debemos modificar nada aquí)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            //Cuando esté cambiando...(no debemos modificar el texto aquí)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            /*
             * Aquí el texto ya ha cambiado completamente, tenemos el texto actualizado en pocas palabras
             *
             * Por cierto, aquí sí podemos modificar el texto pero debemos tener cuidado para no caer en
             * un ciclo infinito
             * */
            @Override
            public void afterTextChanged(Editable s) {
                String busqueda = s.toString();
                if (!"".equals(busqueda)) {
                    resultados = ayudanteBaseDeDatos.buscarPorTermino(busqueda);
                    mostrarElPrimerResultado();
                } else {
                    resultados.clear();
                    mostrarElPrimerResultado();
                }
            }
        });

        textViewTermino.setText("");
        textViewPaginacion.setText("");
        textViewDefinicion.setMovementMethod(new ScrollingMovementMethod());


        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarResultadoAnterior();
            }
        });


        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarSiguienteResultado();
            }
        });

        TextView textViewCreditos = findViewById(R.id.textViewCreditos);
        textViewCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView mensaje = new TextView(getApplicationContext());
                mensaje.setPadding(20, 10, 20, 10);
                final SpannableString spannableString = new SpannableString(
                        "Programada por Luis C.B.\n\n" +
                                "Iconos diseñados por Freepik: http://www.freepik.com desde https://www.flaticon.es con licencia CC 3.0 BY http://creativecommons.org/licenses/by/3.0\n\n" +
                                "Código fuente disponible en: https://github.com/parzibyte/terminosfgsti");
                Linkify.addLinks(spannableString, Linkify.WEB_URLS);
                mensaje.setText(spannableString);
                mensaje.setMovementMethod(LinkMovementMethod.getInstance());

                AlertDialog alerta = new AlertDialog
                        .Builder(MainActivity.this)
                        .setTitle("Acerca de")
                        .setView(mensaje)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .create();
                alerta.show();
            }
        });

        refrescarEstadoDeBotones();
    }
}
