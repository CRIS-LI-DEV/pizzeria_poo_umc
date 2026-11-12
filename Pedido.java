import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private final int idPedido;
    private Persona cliente;
    private Persona repartidor;
    private List<ItemPedido> items;
    private String direccion;
    
    // COMPOSICIÓN: El Pedido es dueño de su Boleta
    private Boleta boleta;

    public Pedido(int idPedido, Persona cliente, Persona repartidor, String direccion) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.repartidor = repartidor;
        this.direccion = (direccion != null && !direccion.trim().isEmpty()) ? direccion.trim() : "Retiro en local";
        this.items = new ArrayList<>();
        
        // COMPOSICIÓN: El contenedor (Pedido) crea su parte internamente (Boleta)
        this.boleta = new Boleta(idPedido);
    }

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

    public double total(EstrategiaDescuento estrategia) {
        double suma = 0.0;
        for (ItemPedido item : this.items) {
            suma += item.getPrecio();
        }
        if (estrategia == null) {
            return suma;
        }
        double descuento = estrategia.calcularDescuento(suma);
        return suma - descuento;
    }

    public double total() {
        return total(new SinDescuento());
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        if (cliente == null) {
            System.out.println("Error: El cliente no puede ser nulo.");
        } else {
            this.cliente = cliente;
        }
    }

    public Persona getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Persona repartidor) {
        if (repartidor == null) {
            System.out.println("Error: El repartidor no puede ser nulo.");
        } else {
            this.repartidor = repartidor;
        }
    }

    public String getDireccion() {
        return direccion;
    }

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

    // Método para demostrar la Composición en el Main
    public void imprimirBoletaFinal(EstrategiaDescuento estrategia) {
        this.boleta.mostrarBoleta(this.total(estrategia));
    }
}