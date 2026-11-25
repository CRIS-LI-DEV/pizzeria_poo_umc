import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// OCP: Extiende el menú implementando ItemPedido, Preparable y Personalizable sin alterar Pedido.
public class Pizza implements ItemPedido, Preparable, Personalizable {
    private static final String NOMBRE_POR_DEFECTO = "Pizza Margarita";
    private static final double PRECIO_POR_DEFECTO = 8990.0;
    private static final String TAMANIO_POR_DEFECTO = "Mediana";
    private static final double COSTO_INGREDIENTE_EXTRA = 1000.0;

    private String nombre;
    private double precioBase;
    private String tamanio;
    private final List<String> ingredientes;
    private EstadoPreparacion estado;

    public Pizza(String nombre, double precio) {
        this(nombre, precio, TAMANIO_POR_DEFECTO, List.of("Queso Mozzarella", "Salsa de Tomate"));
    }

    public Pizza(String nombre, double precioBase, String tamanio, List<String> ingredientesIniciales) {
        setNombre(nombre);
        setPrecio(precioBase);
        cambiarTamanio(tamanio);
        this.ingredientes = new ArrayList<>();
        if (ingredientesIniciales != null) {
            for (String ing : ingredientesIniciales) {
                if (ing != null && !ing.trim().isEmpty()) {
                    this.ingredientes.add(ing.trim());
                }
            }
        }
        this.estado = EstadoPreparacion.PENDIENTE;
    }

    public Pizza() {
        this(NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO);
    }

    @Override
    public String getNombre() {
        return nombre + " (" + tamanio + ")";
    }

    @Override
    public double getPrecio() {
        int extras = Math.max(0, ingredientes.size() - 2);
        return precioBase + (extras * COSTO_INGREDIENTE_EXTRA);
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre != null && !nombre.trim().isEmpty()) ? nombre.trim() : NOMBRE_POR_DEFECTO;
    }

    public void setPrecio(double precio) {
        this.precioBase = (precio >= 0) ? precio : PRECIO_POR_DEFECTO;
    }

    @Override
    public void agregarIngrediente(String ingrediente) {
        if (ingrediente != null && !ingrediente.trim().isEmpty()) {
            String limpio = ingrediente.trim();
            if (!ingredientes.contains(limpio)) {
                ingredientes.add(limpio);
            }
        }
    }

    @Override
    public void quitarIngrediente(String ingrediente) {
        if (ingrediente != null) {
            ingredientes.remove(ingrediente.trim());
        }
    }

    @Override
    public void cambiarTamanio(String tamanio) {
        this.tamanio = (tamanio != null && !tamanio.trim().isEmpty())
                ? tamanio.trim()
                : TAMANIO_POR_DEFECTO;
    }

    @Override
    public String getTamanio() {
        return tamanio;
    }

    @Override
    public List<String> getIngredientes() {
        return Collections.unmodifiableList(ingredientes);
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
        return getNombre() + " - Ingredientes: " + ingredientes
                + " ($" + (int) getPrecio() + ") [" + estado.getDescripcion() + "]";
    }
}