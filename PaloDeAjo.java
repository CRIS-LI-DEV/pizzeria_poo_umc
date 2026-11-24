// DIP: Depende de la abstracción Preparable.EstadoPreparacion en lugar de acoplarse a la clase concreta Pizza.
public class PaloDeAjo implements ItemPedido, Preparable {
    private static final String NOMBRE_POR_DEFECTO = "Palos de Ajo";
    private static final double PRECIO_POR_DEFECTO = 3490.0;

    private String nombre;
    private double precio;
    private EstadoPreparacion estado;

    public PaloDeAjo(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
        this.estado = EstadoPreparacion.PENDIENTE;
    }

    public PaloDeAjo() {
        this(NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO);
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) {
        this.nombre = (nombre != null && !nombre.trim().isEmpty()) ? nombre.trim() : NOMBRE_POR_DEFECTO;
    }

    public void setPrecio(double precio) {
        this.precio = (precio >= 0) ? precio : PRECIO_POR_DEFECTO;
    }

    @Override
    public void avanzarEstado() {
        if (estado == EstadoPreparacion.PENDIENTE) {
            estado = EstadoPreparacion.EN_HORNO;
        } else if (estado == EstadoPreparacion.EN_HORNO) {
            estado = EstadoPreparacion.LISTO;
        }
    }

    @Override
    public EstadoPreparacion getEstadoPreparacion() {
        return estado;
    }

    @Override
    public String toString() {
        return nombre + " ($" + (int) precio + ") [" + estado.getDescripcion() + "]";
    }
}