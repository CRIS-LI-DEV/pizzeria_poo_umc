import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// SRP: Representa un ítem de palos de ajo con estado de preparación y opciones de personalización.
// OCP: Implementa ItemPedido, Preparable y Personalizable sin acoplar Pedido a clases concretas.
public class PaloDeAjo implements ItemPedido, Preparable, Personalizable {
    private static final String NOMBRE_POR_DEFECTO = "Palos de Ajo";
    private static final double PRECIO_POR_DEFECTO = 3490.0;
    private static final String TAMANIO_POR_DEFECTO = "Normal";
    private static final double COSTO_INGREDIENTE_EXTRA = 700.0;
    private static final int INGREDIENTES_BASE_INCLUIDOS = 2;

    private String nombre;
    private double precioBase;
    private String tamanio;
    private final List<String> ingredientes;
    private EstadoPreparacion estado;

    public PaloDeAjo() {
        this(NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, TAMANIO_POR_DEFECTO, List.of("Ajo", "Orégano"));
    }

    public PaloDeAjo(String nombre, double precio) {
        this(nombre, precio, TAMANIO_POR_DEFECTO, List.of("Ajo", "Orégano"));
    }

    public PaloDeAjo(String nombre, double precioBase, String tamanio, List<String> ingredientesIniciales) {
        setNombre(nombre);
        setPrecio(precioBase);
        cambiarTamanio(tamanio);
        this.ingredientes = new ArrayList<>();
        if (ingredientesIniciales != null) {
            for (String ingrediente : ingredientesIniciales) {
                agregarIngrediente(ingrediente);
            }
        }
        this.estado = EstadoPreparacion.PENDIENTE;
    }

    @Override
    public String getNombre() {
        return nombre + " (" + tamanio + ")";
    }

    @Override
    public double getPrecio() {
        int extras = Math.max(0, ingredientes.size() - INGREDIENTES_BASE_INCLUIDOS);
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
            if (!contieneIngredienteIgnorandoCase(limpio)) {
                ingredientes.add(limpio);
            }
        }
    }

    @Override
    public void quitarIngrediente(String ingrediente) {
        if (ingrediente != null && !ingrediente.trim().isEmpty()) {
            String objetivo = ingrediente.trim();
            ingredientes.removeIf(item -> item.equalsIgnoreCase(objetivo));
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

    private boolean contieneIngredienteIgnorandoCase(String candidato) {
        for (String actual : ingredientes) {
            if (actual.equalsIgnoreCase(candidato)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getNombre() + " - Ingredientes: " + ingredientes
                + " ($" + (int) getPrecio() + ") [" + estado.getDescripcion() + "]";
    }
}