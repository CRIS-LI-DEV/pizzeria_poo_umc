import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaloDeAjo implements ItemPedido, Preparable, Personalizable {

    public static final String NOMBRE_POR_DEFECTO = "Palos de Ajo";
    public static final String TAMANIO_POR_DEFECTO = "Porción Regular";
    public static final double PRECIO_POR_DEFECTO = 3500.0;
    public static final int TIEMPO_DEFAULT_MINUTOS = 10;

    private String nombre;
    private double precio;
    private String tamanio;
    private int tiempoCoccionMinutos;
    private Pizza.EstadoPreparacion estado;
    private final List<String> ingredientes;

    public PaloDeAjo(String nombre, double precio, String tamanio, int tiempoCoccionMinutos) {
        setNombre(nombre);
        setPrecio(precio);
        cambiarTamanio(tamanio);
        this.tiempoCoccionMinutos = (tiempoCoccionMinutos > 0) ? tiempoCoccionMinutos : TIEMPO_DEFAULT_MINUTOS;
        this.estado = Pizza.EstadoPreparacion.PENDIENTE;
        this.ingredientes = new ArrayList<>();
        this.ingredientes.add("Mantequilla de Ajo");
        this.ingredientes.add("Orégano");
        this.ingredientes.add("Queso Mozzarella");
    }

    public PaloDeAjo(String nombre, double precio) {
        this(nombre, precio, TAMANIO_POR_DEFECTO, TIEMPO_DEFAULT_MINUTOS);
    }

    public PaloDeAjo() {
        this(NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, TAMANIO_POR_DEFECTO, TIEMPO_DEFAULT_MINUTOS);
    }

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

    @Override
    public void agregarIngrediente(String ingrediente) {
        if (ingrediente != null && !ingrediente.trim().isEmpty()) {
            this.ingredientes.add(ingrediente.trim());
        }
    }

    @Override
    public void quitarIngrediente(String ingrediente) {
        if (ingrediente != null) {
            this.ingredientes.remove(ingrediente.trim());
        }
    }

    @Override
    public void cambiarTamanio(String nuevoTamanio) {
        if (nuevoTamanio != null && !nuevoTamanio.trim().isEmpty()) {
            this.tamanio = nuevoTamanio.trim();
        } else {
            this.tamanio = TAMANIO_POR_DEFECTO;
        }
    }

    @Override
    public String getTamanio() {
        return tamanio;
    }

    @Override
    public List<String> getIngredientes() {
        return Collections.unmodifiableList(this.ingredientes);
    }

    @Override
    public String getNombre() {
        return nombre + " (" + tamanio + ")";
    }

    @Override
    public double getPrecio() {
        return precio;
    }

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

    public Pizza.EstadoPreparacion getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return getNombre() + " ($" + (int) precio + ") - Estado: " + estado + " - Ingredientes: " + ingredientes;
    }
}