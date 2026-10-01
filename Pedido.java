public class Pedido {
    private static final int MAX_PIZZAS = 100;

    private Cliente cliente;
    private Repartidor repartidor;
    private Pizza[] pizzas;
    private String direccion;
    private int contadorDePizzas;

    public Pedido(Cliente cli, Repartidor rep, String direccion) {
        this.cliente = cli;
        this.repartidor = rep;
        this.direccion = (direccion != null && !direccion.trim().isEmpty()) ? direccion.trim() : "Retiro en local";
        this.pizzas = new Pizza[MAX_PIZZAS];
        this.contadorDePizzas = 0;
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
            System.out.println("Error: Límite máximo de pizzas alcanzado (" + MAX_PIZZAS + ").");
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void mostrarDetalle() {
        System.out.println("================================");
        System.out.println("       RESUMEN DE PEDIDO        ");
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