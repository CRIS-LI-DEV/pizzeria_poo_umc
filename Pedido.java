import java.util.ArrayList;
import java.util.List;

public class Pedido {

    // Atributo inmutable
    private final int idPedido;

    private Cliente cliente;
    private Repartidor repartidor;
    private List<ItemPedido> items;
    private String direccion;

    // Constructor actualizado para recibir el idPedido y inicializar la lista de ítems
    public Pedido(int idPedido, Cliente cliente, Repartidor repartidor, String direccion) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.repartidor = repartidor;
        this.direccion = (direccion != null && !direccion.trim().isEmpty()) ? direccion.trim() : "Retiro en local";
        this.items = new ArrayList<>();
    }

    // Getter para el ID (No lleva setter porque es final)
    public int getIdPedido() {
        return idPedido;
    }

    public boolean agregarItem(ItemPedido item) {
        if (item == null) {
            System.out.println("Error: No se puede agregar un producto nulo.");
            return false;
        }
        this.items.add(item);
        return true;
    }

    public int cantidadItems() {
        return this.items.size();
    }

    public double total(double porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 100) {
            double suma = 0.0;
            for (ItemPedido item : this.items) {
                suma += item.getPrecio();
            }
            double descuento = suma * (porcentaje / 100.0);
            return suma - descuento;
        } else {
            System.out.println("Porcentaje inválido: debe estar entre 0 y 100.");
            return 0.0;
        }
    }

    public double total() {
        return total(0.0);
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Validación 1: Evita que se inyecte un cliente nulo
    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Error: El cliente no puede ser nulo.");
        } else {
            this.cliente = cliente;
        }
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    // Validación 2: Evita que se inyecte un repartidor nulo
    public void setRepartidor(Repartidor repartidor) {
        if (repartidor == null) {
            System.out.println("Error: El repartidor no puede ser nulo.");
        } else {
            this.repartidor = repartidor;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    // Validación 3: Evita direcciones vacías
    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            System.out.println("Error: La dirección no puede estar vacía.");
        } else {
            this.direccion = direccion.trim();
        }
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void mostrarDetalle() {
        System.out.println("================================");
        System.out.println("   RESUMEN DE PEDIDO #" + idPedido);
        System.out.println("================================");
        System.out.println("Cliente:    " + (cliente != null ? cliente.getNombre() : "Sin asignar"));
        System.out.println("Repartidor: " + (repartidor != null ? repartidor.getNombre() : "Sin asignar"));
        System.out.println("Dirección:  " + this.direccion);
        System.out.println("Productos ordenados (" + this.items.size() + "):");
        for (ItemPedido item : this.items) {
            System.out.println("  - " + item);
        }
        System.out.println("Total Neto: $" + (int) total());
        System.out.println("================================");
    }
}