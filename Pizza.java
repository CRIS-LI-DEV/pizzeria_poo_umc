import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza implements Preparable, Personalizable, ItemPedido {

    public static final String NOMBRE_POR_DEFECTO = "Pizza Personalizada";
    public static final String TAMANIO_POR_DEFECTO = "Mediana";
    public static final double PRECIO_POR_DEFECTO = 0.0;
    public static final int TIEMPO_DEFAULT_MINUTOS = 15;

    public enum EstadoPreparacion {
        PENDIENTE,
        EN_PREPARACION,
        LISTO
    }

    private String nombre;
    private double precio;
    private String tamanio;
    private int tiempoCoccionMinutos;
    private EstadoPreparacion estado;
    private final List<String> ingredientes;

    public Pizza(String nombre, double precio, int tiempoCoccionMinutos) {
        setNombre(nombre);
        setPrecio(precio);
        this.tiempoCoccionMinutos = (tiempoCoccionMinutos > 0) ? tiempoCoccionMinutos : TIEMPO_DEFAULT_MINUTOS;
        this.tamanio = TAMANIO_POR_DEFECTO;
        this.estado = EstadoPreparacion.PENDIENTE;
        this.ingredientes = new ArrayList<>();
    }

    public Pizza(String nombre, double precio) {
        this(nombre, precio, TIEMPO_DEFAULT_MINUTOS);
    }

    public Pizza() {
        this(NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, TIEMPO_DEFAULT_MINUTOS);
    }

    @Override
    public void iniciarPreparacion() {
        this.estado = EstadoPreparacion.EN_PREPARACION;
        System.out.println("Comenzando preparación de " + this.nombre + ".");
    }

    @Override
    public void terminarPreparacion() {
        this.estado = EstadoPreparacion.LISTO;
        System.out.println("Pizza " + this.nombre + " horneada y lista.");
    }

    @Override
    public boolean estaListo() {
        return this.estado == EstadoPreparacion.LISTO;
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

    public EstadoPreparacion getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return getNombre() + " ($" + (int) precio + ") - Estado: " + estado + " - Ingredientes: " + ingredientes;
    }
}