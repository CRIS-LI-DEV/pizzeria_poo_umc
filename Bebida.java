public class Bebida implements ItemPedido {

    // --- Definición del Enum para los tamaños ---
    public enum TamanioBebida {
        INDIVIDUAL("0.5 Litros"),
        MEDIANA("1.0 Litro"),
        FAMILIAR("1.5 Litros"),
        TRES_LITROS("3.0 Litros");

        private final String descripcion;

        TamanioBebida(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }

    // --- Constantes por defecto ---
    public static final String NOMBRE_POR_DEFECTO = "Bebida Genérica";
    public static final TamanioBebida TAMANIO_POR_DEFECTO = TamanioBebida.FAMILIAR;
    public static final double PRECIO_POR_DEFECTO = 0.0;

    // --- Atributos ---
    private String nombre;
    private double precio;
    private TamanioBebida tamanio;

    /**
     * Constructor principal con Enum
     */
    public Bebida(String nombre, double precio, TamanioBebida tamanio) {
        setNombre(nombre);
        setPrecio(precio);
        setTamanio(tamanio);
    }

    /**
     * Constructor secundario con tamaño por defecto
     */
    public Bebida(String nombre, double precio) {
        this(nombre, precio, TAMANIO_POR_DEFECTO);
    }

    /**
     * Constructor por defecto
     */
    public Bebida() {
        this(NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, TAMANIO_POR_DEFECTO);
    }

    // --- Métodos de la interfaz ItemPedido ---

    @Override
    public String getNombre() {
        return nombre + " (" + tamanio.getDescripcion() + ")";
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    // --- Getters y Setters con validaciones ---

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            this.nombre = NOMBRE_POR_DEFECTO;
        }
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            this.precio = PRECIO_POR_DEFECTO;
        }
    }

    public void setTamanio(TamanioBebida tamanio) {
        if (tamanio != null) {
            this.tamanio = tamanio;
        } else {
            this.tamanio = TAMANIO_POR_DEFECTO;
        }
    }

    public TamanioBebida getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        return nombre + " [" + tamanio.getDescripcion() + "] ($" + (int) precio + ")";
    }
}