package me.parzibyte.trminosfgsti;

public class Termino {
    private String termino, definicion;

    public Termino() {
    }

    public Termino(String termino, String definicion) {
        this.termino = termino;
        this.definicion = definicion;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    @Override
    public String toString() {
        return "Termino{" +
                "termino='" + termino + '\'' +
                ", definicion='" + definicion + '\'' +
                '}';
    }
}
