public class Pedido {
    // 1. Constante estática
    private static final int MAX_PIZZAS = 100;

    // 2. Atributo inmutable
    private final int idPedido;

    private Cliente cliente;
    private Repartidor repartidor;
    private Pizza[] pizzas;
    private String direccion;
    private int contadorDePizzas;

    // Constructor actualizado para recibir el idPedido
    public Pedido(int idPedido, Cliente cli, Repartidor rep, String direccion) {
        this.idPedido = idPedido; // Se asigna una sola vez y no cambia más
        this.cliente = cli;
        this.repartidor = rep;
        this.direccion = (direccion != null && !direccion.trim().isEmpty()) ? direccion.trim() : "Retiro en local";
        this.pizzas = new Pizza[MAX_PIZZAS];
        this.contadorDePizzas = 0;
    }

    // Getter para el ID (No lleva setter porque es final)
    public int getIdPedido() {
        return idPedido;
    }

    public boolean agregarPizza(Pizza pizza) {
        if (pizza == null) {
            System.out.println("Error: No se puede agregar una pizza nula.");
            return false;
        }
        if (this.contadorDePizzas < this.pizzas.length) {
            this.pizzas[this.contadorDePizzas] = pizza;
            this.contadorDePizzas++;
            return true;
        } else {
            System.out.println("Error: Limite máximo de pizzas alcanzado (" + MAX_PIZZAS + ").");
            return false;
        }
    }

    public int cuantasPizzasLleva() {
        return this.contadorDePizzas;
    }

    public double total(double porcentaje) {
        if (porcentaje >= 0 && porcentaje <= 100) {
            double suma = 0.0;
            for (int i = 0; i < this.contadorDePizzas; i++) {
                suma += this.pizzas[i].getPrecio();
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

    public void mostrarDetalle() {
        System.out.println("================================");
        System.out.println("   RESUMEN DE PEDIDO #" + idPedido); // Muestra el número de pedido
        System.out.println("================================");
        System.out.println("Cliente:    " + (cliente != null ? cliente.getNombre() : "Sin asignar"));
        System.out.println("Repartidor: " + (repartidor != null ? repartidor.getNombre() : "Sin asignar"));
        System.out.println("Dirección:  " + this.direccion);
        System.out.println("Pizzas ordenadas (" + this.contadorDePizzas + "):");
        for (int i = 0; i < this.contadorDePizzas; i++) {
            System.out.println("  - " + pizzas[i]);
        }
        System.out.println("Total Neto: $" + (int) total());
        System.out.println("================================");
    }
}
