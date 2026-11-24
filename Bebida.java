public class Bebida implements ItemPedido {

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

    private static final String NOMBRE_POR_DEFECTO = "Bebida Genérica";
    private static final TamanioBebida TAMANIO_POR_DEFECTO = TamanioBebida.FAMILIAR;
    private static final double PRECIO_POR_DEFECTO = 0.0;

    private String nombre;
    private double precio;
    private TamanioBebida tamanio;

    public Bebida(String nombre, double precio, TamanioBebida tamanio) {
        setNombre(nombre);
        setPrecio(precio);
        setTamanio(tamanio);
    }

    public Bebida(String nombre, double precio) {
        this(nombre, precio, TAMANIO_POR_DEFECTO);
    }

    public Bebida() {
        this(NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, TAMANIO_POR_DEFECTO);
    }

    @Override
    public String getNombre() {
        return nombre + " (" + tamanio.getDescripcion() + ")";
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre != null && !nombre.trim().isEmpty()) ? nombre.trim() : NOMBRE_POR_DEFECTO;
    }

    public void setPrecio(double precio) {
        this.precio = (precio >= 0) ? precio : PRECIO_POR_DEFECTO;
    }

    public void setTamanio(TamanioBebida tamanio) {
        this.tamanio = (tamanio != null) ? tamanio : TAMANIO_POR_DEFECTO;
    }

    public TamanioBebida getTamanio() {
        return tamanio;
    }

    @Override
    public String toString() {
        return nombre + " [" + tamanio.getDescripcion() + "] ($" + (int) precio + ")";
    }
}