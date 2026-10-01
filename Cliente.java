public class Cliente extends Persona {
    private String direccion;

    public Cliente() {
        super();
        this.direccion = "Sin dirección registrada";
    }

    public Cliente(String rut, String nombre, String telefono, String email, String direccion) {
        super(rut, nombre, telefono, email);
        setDireccion(direccion);
    }

    public Cliente(String rut, String nombre, String telefono, String email) {
        this(rut, nombre, telefono, email, "Sin dirección registrada");
    }

    @Override
    public String getTipoPersona() {
        return "Cliente";
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != null && !direccion.trim().isEmpty()) {
            this.direccion = direccion.trim();
        } else {
            this.direccion = "Sin dirección registrada";
        }
    }

    public void realizarPedido() {
        System.out.println(getNombre() + " solicito envio a: " + this.direccion);
    }

    @Override
    public void mostrarContacto() {
        super.mostrarContacto();
        System.out.println("Dirección: " + this.direccion);
    }

    @Override
    public String toString() {
        return super.toString() + " | Dirección: " + direccion;
    }
}