public class Repartidor extends Persona {
    private String vehiculo;
    private String patente;
    private int pedidosEntregados;

    public Repartidor() {
        super();
        this.vehiculo = "No especificado";
        this.patente = "S/P";
        this.pedidosEntregados = 0;
    }

    public Repartidor(String rut, String nombre, String telefono, String email, String vehiculo, String patente) {
        super(rut, nombre, telefono, email);
        setVehiculo(vehiculo);
        setPatente(patente);
        this.pedidosEntregados = 0;
    }

    @Override
    public String getTipoPersona() {
        return "Repartidor";
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        if (vehiculo != null && !vehiculo.trim().isEmpty()) {
            this.vehiculo = vehiculo.trim();
        } else {
            this.vehiculo = "No especificado";
        }
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if (patente != null && !patente.trim().isEmpty()) {
            this.patente = patente.trim().toUpperCase();
        } else {
            this.patente = "S/P";
        }
    }

    public int getPedidosEntregados() {
        return pedidosEntregados;
    }

    public void registrarEntrega() {
        this.pedidosEntregados++;
        System.out.println(getNombre() + " entregó un pedido. Total entregados: " + this.pedidosEntregados);
    }

    @Override
    public void mostrarContacto() {
        super.mostrarContacto();
        System.out.println("Vehículo:  " + this.vehiculo);
        System.out.println("Patente:   " + this.patente);
        System.out.println("Entregas:  " + this.pedidosEntregados);
    }

    @Override
    public String toString() {
        return super.toString() + " | Vehículo: " + vehiculo + " (" + patente + ") | Entregas: " + pedidosEntregados;
    }
}