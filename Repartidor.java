public class Repartidor extends Persona {
    private static final String VEHICULO_POR_DEFECTO = "Moto";
    private String vehiculo;

    public Repartidor(String rut, String nombre, String telefono, String email, String vehiculo) {
        super(rut, nombre, telefono, email);
        setVehiculo(vehiculo);
    }

    @Override
    public String getTipoPersona() { return "Repartidor"; }

    public String getVehiculo() { return vehiculo; }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = (vehiculo != null && !vehiculo.trim().isEmpty()) ? vehiculo.trim() : VEHICULO_POR_DEFECTO;
    }

    @Override
    public String toString() {
        return super.toString() + " | Vehículo: " + vehiculo;
    }
}