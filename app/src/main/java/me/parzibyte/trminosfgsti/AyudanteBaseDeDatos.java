package me.parzibyte.trminosfgsti;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AyudanteBaseDeDatos extends SQLiteOpenHelper {
    private static final String NOMBRE_BASE_DE_DATOS = "terminos";
    private static final int RESULTADOS_POR_BUSQUEDA = 15;
    private static final int VERSION_BASE_DE_DATOS = 1;
    private static final String BATCH_INSERT = "INSERT INTO terminos(termino, definicion) VALUES ('Análisis predictivo','algoritmos aplicados a patrones de información sobre actividades y comportamientos que sirven de base estadísticamente válida para la predicción de posibles resultados futuros.'),\n" +
            "('Arquitectura orientada a servicios','una arquitectura de software en la que se empaquetan funciones nuevas y existentes y se proporcionan como servicios.'),\n" +
            "('Asynchronous Java and XML (AJAX)','una técnica de desarrollo que aumenta la capacidad de respuesta de las páginas web mediante el intercambio de pequeñas cantidades de datos de modo que la página web entera no se tenga que recargar cada vez que el usuario solicita un cambio.'),\n" +
            "('Balance Scorecard (Indicadores de desempeño)','un entorno de trabajo para la identificación de las métricas empresariales más allá de las medidas financieras básicas utilizadas normalmente. Entre los indicadores de desempeño se cuentan medidas de clientes, procesos y personas, así como información financiera. Vinculan objetivos estratégicos y métricas operacionales.'),\n" +
            "('BAM','acrónimo de Business Activity Monitoring (supervisión de la actividad de negocio), se trata de un software para la supervisión en tiempo real de los procesos de negocio.'),\n" +
            "('BPEL','acrónimo de Business Process Execution Language (lenguaje de ejecución de procesos de negocio), se trata de un lenguaje XML para la especificación de procesos de negocio ejecutables, aplicado principalmente a la orquestación de los servicios web.'),\n" +
            "('BPM','acrónimo de Business Process Management (gestión de procesos de negocio), se trata de los métodos, técnicas y herramientas empleados para diseñar, representar, controlar y analizar procesos de negocio operacionales en los que están implicados personas, sistemas, aplicaciones, datos y organizaciones.'),\n" +
            "('BPM Suite (BPMS)','un completo conjunto de software que facilita todos los aspectos de la gestión de procesos de negocio como diseño de procesos, flujo de trabajo, aplicaciones, integración y supervisión de la actividad para entornos centrados tanto en los sistemas como en el ser humano.'),\n" +
            "('BPMN','acrónimo de Business Process Modeling Notation (notación de creación de modelos de procesos de negocio), se trata de una notación gráfica estandarizada para representar los procesos de negocio en un flujo de trabajo, que facilita la mejora de la comunicación y la portabilidad de los modelos de proceso.'),\n" +
            "('Cadena de suministro','el sistema de personas, actividades, información y recursos que participan en el movimiento de un producto o servicio del proveedor al cliente.'),\n" +
            "('CAF','acrónimo de Composite Application Frameworks (entorno de aplicaciones compuestas), se trata de una plataforma software para el desarrollo de aplicaciones e interfaces de usuario basadas en la reutilización modular y la composición de servicios, lógica, componentes de interfaz de usuario y procesos de negocio.'),\n" +
            "('CPI','acrónimo de Continuous Process Improvement (mejora continua de los procesos), constituye un incesante esfuerzo por descubrir y eliminar las causas de los problemas en el rendimiento de los procesos de negocio y aumentar la creación de valor y la productividad.'),\n" +
            "('Desarrollo de aplicaciones sin código','herramientas y técnicas dirigidas a ensamblar componentes de código, servicios y controles, así como marcos de desarrollo, con la finalidad de crear nuevas aplicaciones mediante asistentes y formularios.'),\n" +
            "('DIFOT','acrónimo de Delivered In-Full and On-Time (entrega completa y a tiempo), se trata de una medida clave del rendimiento de la cadena de suministro, que mide la frecuencia con la que el cliente obtiene lo que desea cuando lo desea.'),\n" +
            "('DMAIC','el acrónimo de las cinco fases de la metodología Six'),\n" +
            "('Sigma','Define (definir), Measure (medir), Analyze (analizar), Improve (mejorar), Control (controlar); se utiliza para resolver problemas de procesos y problemas de negocio a través de datos y métodos analíticos.'),\n" +
            "('EAI','acrónimo de Enterprise Application Integration (integración de aplicaciones empresariales), son las herramientas y práctica de vincular aplicaciones y datos informáticos con el fin de conseguir ventajas operacionales y empresariales.'),\n" +
            "('Entorno de procesos','la arquitectura de un proceso extendido o de un conjunto de procesos que permite un conjunto de funciones empresariales.'),\n" +
            "('ESB','acrónimo de Enterprise Service Bus (bus de servicios corporativos), es parte de la categoría de infraestructura de middleware. Un ESB es un elemento de la arquitectura de software que proporciona servicios fundamentales para los sistemas de información a través de un motor de mensajería controlado por eventos.'),\n" +
            "('Flujo de trabajo (Workflow)','un patrón orquestado y repetible de actividad empresarial habilitado por la organización sistemática de recursos en procesos que transforman materiales, proporcionan servicios o procesan información.'),\n" +
            "('Flujo de valor','el flujo de materiales e información que recorre un proceso para entregar a un cliente un producto o servicio.'),\n" +
            "('Gobierno','un marco para la toma de decisiones y la atribución de responsabilidad que produce resultados deseables dentro de la organización. El entorno de gobierno determina el qué, quién y cómo de la toma de decisiones empresariales.'),\n" +
            "('Helga','la fuerza omnipresente de BPM.'),\n" +
            "('ICE','acrónimo de Integrated Composition Environment (entorno de composición integrado), se trata de un conjunto de herramientas basado en servicios y controlado por modelos para el ensamblado colaborativo de aplicaciones débilmente acopladas, basadas en procesos de negocio y dirigidas a la obtención de resultados.'),\n" +
            "('KPI','acrónimo de Key Performance Indicators (indicadores clave de desempeño), es cualquier conjunto de métricas financieras y no financieras que se pueden utilizar para cuantificar el rendimiento empresarial. Por ejemplo, el tiempo del ciclo de procesos.'),\n" +
            "('Lean','una metodología de mejora basada en una definición de valor centrada en el cliente que proporciona ese valor de la manera más efectiva posible, a través de la combinación de la eliminación de los puntos de ineficiencia y un personal motivado y comprometido.'),\n" +
            "('Modelización de procesos','una prescripción representativa de cómo debe funcionar un conjunto de actividades en un flujo y secuencia con el fin de conseguir con regularidad los resultados deseados.'),\n" +
            "('Orquestación','la organización, coordinación, ejecución y gestión automatizadas de aplicaciones, sistemas, integración y servicios informáticos complejos.'),\n" +
            "('Optimización de los procesos','la práctica de realizar cambios y ajustes en un proceso con el fin de mejorar su eficiencia o efectividad.'),\n" +
            "('Optimización del rendimiento','la práctica de realizar ajustes y cambios en las actividades y procesos de negocio con la finalidad de mejorar el rendimiento.'),\n" +
            "('Panel (Dashboard)','una presentación visual que indica el estado de una compañía o proceso de negocio mediante indicadores clave de desempeño numéricos y gráficos.'),\n" +
            "('Portal','un entorno software que, a través de una interfaz unitaria facilitada mediante un navegador web, permite a las personas gestionar información y procesos entre sistemas y organizaciones.'),\n" +
            "('Primero mida (Measure First)','la práctica de comenzar un proyecto o iniciativa BPM midiendo en primer lugar el estado actual de un proceso de negocio con el fin de establecer una línea de base válida.'),\n" +
            "('Proceso','un conjunto de actividades, material y/o flujo de información que transforma un conjunto de entradas en resultados definidos.'),\n" +
            "('Propietario del proceso','el individuo responsable del rendimiento y los recursos de un proceso, y quien aporta a los proyectos apoyo, recursos y experiencia funcional. El propietario del proceso es responsable de implementar mejoras en los procesos.'),\n" +
            "('Reglas de negocio','la codificación formal de las políticas y acciones empresariales en prácticas operacionales legales que se extraen del código de aplicación y se mantienen con independencia del mismo.'),\n" +
            "('Simulación','la creación de modelos por ordenador de una situación hipotética que se puede analizar para determinar cómo puede funcionar una aplicación dada de sistemas cuando se implementan.'),\n" +
            "('Six Sigma','un conjunto probado de herramientas analíticas, técnicas de control de proyectos, métodos de generación de informes y técnicas de gestión que se combinan para elaborar mejoras muy importantes en la solución de problemas y el rendimiento empresarial.'),\n" +
            "('Tiempo del ciclo','el tiempo total que transcurre desde el momento en que se inicia una tarea, producto o servicio hasta que finaliza.'),\n" +
            "('TQM','acrónimo de Total Quality Management (gestión de calidad total), se trata de una estrategia de gestión que integra la conciencia de la calidad en todas las estructuras y procesos organizativos.'),\n" +
            "('Transformación empresarial','una iniciativa empresarial basada en programación que alinea personas, procesos y tecnología a fin de lograr cambios y mejoras significativos en el rendimiento.'),\n" +
            "('Visibilidad empresarial','herramientas y técnicas que proporcionan visibilidad en tiempo real y una comprensión profunda de las actividades y procesos de negocio.'),\n" +
            "('Voz del cliente','la representación de las necesidades y deseos, expresados y sin expresar, del destinatario del resultado de un proceso, un producto o un servicio; se expresa por lo general como una especificación, requisito o expectativa.'),\n" +
            "('WSDL','acrónimo de Web Service Definition Language (lenguaje de definición de servicio web), se trata de un formato XML para la descripción de servicios de red como un conjunto de puntos de acceso que operan sobre mensajes que contienen información basada en documentos o en procedimientos.'),\n" +
            "('WYMIWYR','What You Model Is What You Run un acrónimo que engloba cómo un BPMS completamente integrado conecta la creación de modelos con el entorno de tiempo de ejecución.'),\n" +
            "('XPDL','acrónimo de XML Process Definition Language (lenguaje de definición de proceso XML), es un lenguaje de definición de procesos basado en XML que permite la representación y edición de forma coherente de modelos de procesos mediante herramientas de creación de dichos modelos.'),\n" +
            "('TICS','Son sistemas, herramientas que digitalizan señales analógicas, sonidos, texto e imágenes y pueden ser manejadas en tiempo real'),\n" +
            "('E/A','Enterprise architecture'),\n" +
            "('SWOT','Strengths, Weaknesses, Opportunities, Threats. (lo mismo que FODA)'),\n" +
            "('FODA','Fortalezas, Oportunidades, Debiidades, Amenazas'),\n" +
            "('BI','Business Intelligence, Inteligencia de negocios'),\n" +
            "('KDD','Descubrimiento de Conocimiento en Bases de Datos'),\n" +
            "('Data Warehouse','Es la respuesta de la tecnología de información a la descentralización en la toma de decisiones.'),\n" +
            "('Agentes','Los agentes son programas que piensan. Ellos pueden realizar tareas a un nivel muy básico sin necesidad de intervención humana.'),\n" +
            "('Data mining','minería de datos, descubrir información oculta'),\n" +
            "('e-Commerce','Es el tipo de transacción económica (compra venta) que se realiza a través de medios electrónicos. Una empresa comúnmente presente en la red, vende bienes y servicios a través de Internet o medios similares.'),\n" +
            "('e-Business','Se trata de un término más amplio que el de eCommerce y se refiere a todas las transacciones, negocios y operaciones comerciales que se realizan utilizando las TIC. En este caso, todos los procesos de la organización están soportados en aplicaciones basadas en redes de computadoras y están integrados todos entre sí.'),\n" +
            "('B2C','Negocio a cliente, ciudadano o consumidor'),\n" +
            "('B2B','Negocio a negocio'),\n" +
            "('B2G','Negocio a gobierno'),\n" +
            "('B2E','Negocio a empleado'),\n" +
            "('C2C','consumidor a consumidor'),\n" +
            "('C2B','Consumidor a Negocio'),\n" +
            "('A2B/C/A','Administration to Business/Consumer/Administration (egoverment)'),\n" +
            "('e-procurement','es la automatización de procesos internos y externos relacionados con el requerimiento, compra, suministro, pago y control de productos utilizando internet como medio de comunicación entre el cliente y el proveedor'),\n" +
            "('EDI','Intercambio electrónico de datos'),\n" +
            "('SCM','Supply Chain Management'),\n" +
            "('ERM','Enterprise Relationship Management'),\n" +
            "('KM','Knowledge Management'),\n" +
            "('CRM','Customer Relationship Management'),\n" +
            "('DSS','Decision Support Systems'),\n" +
            "('Benchmarking','Es una valiosa herramienta de administración debido a que proporciona un enfoque disciplinario y lógico para comprender y evaluar de manera objetiva las fortalezas y debilidades de una compañía, en comparación con lo mejor de lo mejor. Los administradores constituyen el desarrollo, aplicación y actualización de los planes de acción específicos que mejorarán su desempeño. Para formar parte integral del proceso de administración, el benchmarking depende, en última instancia, de dos actividades; el respaldo de la alta dirección y el compromiso para emplearlo de manera efectiva. Punto de arranque, asegurarse de seleccionar las actividades y mediciones más adecuadas contra las cuales compararse, llevando a cabo una revisión de la mejor inteligencia competitiva que sea posible conseguir.'),\n" +
            "('Rightsizing','Proceso de reestructurar y racionalizar una organización para mejorar su efectividad y reducir costos. La operación es menos drástica que la de downsizing, que a menudo puede conducir a excesos y dar como resultado la anorexia empresarial. Una operación de rightsizing puede requerir aumentar el tamaño de una organización para, por ejemplo, hacer frente a una mayor demanda, aunque por lo general se usa la palabra como eufemismo de un moderado y controlado downsizing, o sea, achicamiento de la empresa con reducción de personal.(Oxford) El significado literal de la palabra es dar a la empresa su tamaño adecuado, reducirla si es demasiado grande, agrandarla si es demasiado pequeña.'),\n" +
            "('Empowerment','es un sistema que consiste en potenciar la motivación y los resultados de todos los colaboradores de una empresa, a través de le delagación y la transmisión de poder'),\n" +
            "('Consultoría y mentoría','Puede ser descrito como un método y la técnica que se puede utilizar para guiar a una persona a un nuevo aprendizaje en marcos de tiempo definidos. un proceso que permite el aprendizaje y desarrollo para producir y por lo tanto para mejorar el rendimiento.'),\n" +
            "('Just in time','El método justo a tiempo (traducción del inglés Just in Time) es un sistema de organización de la producción para las fábricas, de origen japonés. También conocido como método Toyota o JIT, permite aumentar la productividad. Permite reducir el costo de la gestión y por pérdidas en almacenes debido a stocks innecesarios. De esta forma, no se produce bajo suposiciones, sino sobre pedidos reales.'),\n" +
            "('Outsourcing','La subcontratación (también conocido como outsourcing, por su término en inglés) es el proceso económico en el cual una empresa determinada mueve o destina los recursos orientados a cumplir ciertas tareas, a una empresa externa, por medio de un contrato. Esto se da especialmente en el caso de la subcontratación de empresas especializadas. Para ello, pueden contratar sólo al personal, en cuyo caso los recursos los aportará el cliente (instalaciones, hardware y software), o contratar tanto el personal como los recursos. El termino outsourcing traduce una mejora en los servicios dentro de una economia en busca de progreso dentro de la apertura economica tratando de ser competentes en el comercio internacional.'),\n" +
            "('Reingeniería:Es repensar de manera fundamental los procesos de negocios y rediseñarlos radicalmente, con el fin de obtener dramáticos logros en el desempeño. Los factores clave del concepto son','la orientación hacia los procesos, el cambio radical y la gran magnitud de los resultados esperados. La reingeniería es un enfoque de procesos. Un proceso de negocios es un conjunto de actividades relacionadas entre sí que recibe uno o mas insumos y crea un producto de valor para el cliente. Un proceso tiene un proveedor, un cliente y una serie de actividades relacionadas entre sí que convierten los insumos en un producto o servicio.'),\n" +
            "('BCS','es la representación en una estructura coherente, de la estrategia del negocio a través de objetivos claramente encadenados entre sí, medidos con los indicadores de desempeño, sujetos al logro de unos compromisos determinados y respaldados por un conjunto de iniciativas o proyectos.'),\n" +
            "('Coaching','Es una formación individualizada. Algunos expertos lo definen como un proceso de orientación y entrenamiento que muchas compañías prestan a directivos que están consolidados en sus puestos y que son valiosos para las propias empresas. A través de este modo de ser y hacer del coaching se ayuda a estos ejecutivos a ser más eficaces en sus puestos. No sólo se benefician los empleados de ellos, sino también las empresas.'),\n" +
            "('KANO','Teoría de desarrollo de productos y de satisfacción del cliente desarrollada en la década de 1980 por el profesor Noriaki Kano, que clasifica a las preferencias del cliente en cinco categorías'),\n" +
            "('MARCOS DE REFERENCIA','COBIT, ISO/IEC, ITIL'),\n" +
            "('ITIL','Biblioteca de Infraestructura de Tecnologías de Información'),\n" +
            "('COBIT','Objetivos de Control para Información y Tecnologías Relacionadas (COBIT, en inglés Control Objectives for Information and related Technology)'),\n" +
            "('Planear y Organizar (PO)',' Estrategias y tácticas. Identificar la manera en que TI pueda contribuir de la mejor manera al logro de los objetivos del negocio. Proporciona dirección para la entrega de soluciones (AI) y la entrega de servicio (DS).'),\n" +
            "('Adquirir e Implementar (AI)','Identificación de soluciones, desarrollo o adquisición, cambios y/o mantenimiento de sistemas existentes. Proporciona las soluciones y las pasa para convertirlas en servicios.'),\n" +
            "('Entregar y Dar Soporte (DS)','Cubre la entrega de los servicios requeridos. Incluye la prestación del servicio, la administración de la seguridad y de la continuidad, el soporte del servicio a los usuarios, la administración de los datos y de las instalaciones operacionales. Recibe las soluciones y las hace utilizables por los usuarios finales.'),\n" +
            "('Monitorear y Evaluar (ME)','Todos los procesos de TI deben evaluarse de forma regular en el tiempo en cuanto a su calidad y cumplimiento de los requerimientos de control. Este dominio abarca la administración del desempeño, el monitoreo del control interno, el cumplimiento regulatorio y la aplicación del gobierno. Monitorear todos los procesos para asegurar que se sigue la dirección provista.'),\n" +
            "('RACI','MODELO RACI. R Responsable - Realiza la actividad dentro del proceso. A Responsable Final - Solamente una persona es responsable de una tarea. C Consultado - Participan aportando información y conocimiento. I Informado - Se mantienen al tanto de avances de día a día sobre las ejecuciones. del proceso y calidad.');";

    public AyudanteBaseDeDatos(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS terminos(termino TEXT, definicion TEXT);");
        db.execSQL("CREATE INDEX IF NOT EXISTS terminoIndice ON terminos(termino);");
        db.execSQL(BATCH_INSERT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS terminos;");
    }

    public ArrayList<Termino> buscarPorTermino(String busqueda) {
        ArrayList<Termino> terminos = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("terminos",
                new String[]{"termino", "definicion"},
                "termino LIKE ?", new String[]{"%" + busqueda + "%"},
                null, null, null, String.valueOf(RESULTADOS_POR_BUSQUEDA));
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    terminos.add(
                            new Termino(
                                    cursor.getString(
                                            cursor.getColumnIndex("termino")
                                    ),
                                    cursor.getString(
                                            cursor.getColumnIndex("definicion")
                                    )
                            ));
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return terminos;
    }
}
