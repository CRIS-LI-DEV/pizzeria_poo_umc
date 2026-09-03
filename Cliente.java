public class Cliente extends Persona {
    
    // Atributo propio
    private String direccion;

    // Constructor
    public Cliente(String rut, String nombre, String telefono, String email, String direccion) {
        super(rut, nombre, telefono, email);
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Método propio de la clase hija
    public void realizarPedido() {
        System.out.println(getNombre() + " solicitó envío a: " + direccion);
    }

    // Método
    @Override
    public String toString() {
        return super.toString() + " | Dirección: " + direccion;
    }
}