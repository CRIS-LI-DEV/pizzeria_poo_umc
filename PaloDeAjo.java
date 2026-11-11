public class PaloDeAjo implements ItemPedido, Preparable {

    public static final String NOMBRE_POR_DEFECTO = "Palos de Ajo";
    public static final String TAMANIO_POR_DEFECTO = "Porción Regular";
    public static final double PRECIO_POR_DEFECTO = 3500.0;
    public static final int TIEMPO_DEFAULT_MINUTOS = 10;
    public static final double RECARGO_QUESO = 1500.0;

    private String nombre;
    private double precio;
    private String tamanio;
    private boolean conQuesoExtra;
    private int tiempoCoccionMinutos;
    private Pizza.EstadoPreparacion estado;

    /**
     * Constructor principal
     */
    public PaloDeAjo(String nombre, double precio, String tamanio, boolean conQuesoExtra, int tiempoCoccionMinutos) {
        setNombre(nombre);
        setTamanio(tamanio);
        this.conQuesoExtra = conQuesoExtra;
        
        double precioBase = (precio >= 0) ? precio : PRECIO_POR_DEFECTO;
        this.precio = conQuesoExtra ? precioBase + RECARGO_QUESO : precioBase;
        
        this.tiempoCoccionMinutos = (tiempoCoccionMinutos > 0) ? tiempoCoccionMinutos : TIEMPO_DEFAULT_MINUTOS;
        this.estado = Pizza.EstadoPreparacion.PENDIENTE;
    }

    /**
     * Constructor secundario
     */
    public PaloDeAjo(String nombre, double precio, boolean conQuesoExtra) {
        this(nombre, precio, TAMANIO_POR_DEFECTO, conQuesoExtra, TIEMPO_DEFAULT_MINUTOS);
    }

    /**
     * Constructor por defecto
     */
    public PaloDeAjo() {
        this(NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, TAMANIO_POR_DEFECTO, false, TIEMPO_DEFAULT_MINUTOS);
    }

    // --- Métodos de la interfaz Preparable ---

    @Override
    public void iniciarPreparacion() {
        this.estado = Pizza.EstadoPreparacion.EN_PREPARACION;
        System.out.println("Preparando " + this.nombre + ".");
    }

    @Override
    public void terminarPreparacion() {
        this.estado = Pizza.EstadoPreparacion.LISTO;
        System.out.println("Palos de ajo horneados y listos.");
    }

    @Override
    public boolean estaListo() {
        return this.estado == Pizza.EstadoPreparacion.LISTO;
    }

    @Override
    public int getTiempoCoccion() {
        return this.tiempoCoccionMinutos;
    }

    // --- Métodos de la interfaz ItemPedido ---

    @Override
    public String getNombre() {
        return nombre + " (" + tamanio + ")" + (conQuesoExtra ? " [Con Queso Extra]" : "");
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    // --- Getters y Setters ---

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            this.nombre = NOMBRE_POR_DEFECTO;
        }
    }

    public void setTamanio(String tamanio) {
        if (tamanio != null && !tamanio.trim().isEmpty()) {
            this.tamanio = tamanio.trim();
        } else {
            this.tamanio = TAMANIO_POR_DEFECTO;
        }
    }

    public boolean isConQuesoExtra() {
        return conQuesoExtra;
    }

    public void setConQuesoExtra(boolean conQuesoExtra) {
        if (this.conQuesoExtra != conQuesoExtra) {
            if (conQuesoExtra) {
                this.precio += RECARGO_QUESO;
            } else {
                this.precio -= RECARGO_QUESO;
            }
            this.conQuesoExtra = conQuesoExtra;
        }
    }

    public Pizza.EstadoPreparacion getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return getNombre() + " ($" + (int) precio + ") - Estado: " + estado;
    }
}