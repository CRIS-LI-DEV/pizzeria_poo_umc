public class Repartidor extends Persona {
    // Atributos propios
    private String vehiculo;
    private String patente;
    private int pedidosEntregados;

    // Constructor
    public Repartidor(String rut, String nombre, String telefono, String email, String vehiculo, String patente) {
        super(rut, nombre, telefono, email);
        this.vehiculo = vehiculo;
        this.patente = patente;
        this.pedidosEntregados = 0;
    }

    // Getters y Setters
    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getPedidosEntregados() {
        return pedidosEntregados;
    }

    // Método propio
    public void registrarEntrega() {
        pedidosEntregados++;
        System.out.println(getNombre() + " entregó un pedido. Van " + pedidosEntregados + " en total.");
    }

    // Sobrescribe mostrarContacto de Persona
    @Override
    public void mostrarContacto() {
        super.mostrarContacto();
        System.out.println("Vehículo: " + vehiculo);
        System.out.println("Patente:  " + patente);
        System.out.println("Pedidos entregados: " + pedidosEntregados);
    }
}