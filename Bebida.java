
public class Bebida implements ItemPedido {

    public static final String NOMBRE_POR_DEFECTO = "Bebida Genérica";
    public static final String TAMANIO_POR_DEFECTO = "1.5 Litros";
    public static final double PRECIO_POR_DEFECTO = 0.0;

    private String nombre;
    private double precio;
    private String tamanio;

    /**
     * Constructor principal
     */
    public Bebida(String nombre, double precio, String tamanio) {
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
        return nombre + " (" + tamanio + ")";
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

    public void setTamanio(String tamanio) {
        if (tamanio != null && !tamanio.trim().isEmpty()) {
            this.tamanio = tamanio.trim();
        } else {
            this.tamanio = TAMANIO_POR_DEFECTO;
        }
    }

    public String getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        return nombre + " [" + tamanio + "] ($" + (int) precio + ")";
    }
}