public class Cliente extends Persona {
    // RELACIÓN: Asociación — Cliente mantiene una referencia a un objeto Direccion independiente.
    private Direccion direccion;

    public Cliente() {
        super();
        this.direccion = new Direccion();
    }

    public Cliente(String rut, String nombre, String telefono, String email, Direccion direccion) {
        super(rut, nombre, telefono, email);
        setDireccion(direccion);
    }

    @Override
    public String getTipoPersona() { return "Cliente"; }

    public Direccion getDireccion() { return direccion; }

    public void setDireccion(Direccion direccion) {
        this.direccion = (direccion != null) ? direccion : new Direccion();
    }

    @Override
    public String toString() {
        return super.toString() + " | Dirección: " + direccion;
    }
}