public class Persona {
    private String rut;
    private String nombre;
    private String telefono;
    private String email;

    public Persona() {
        this.rut = "";
        this.nombre = "Sin Nombre";
        this.telefono = "";
        this.email = "";
    }

    public Persona(String rut, String nombre, String telefono, String email) {
        setRut(rut);
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
    }

    public Persona(String rut, String nombre, String telefono) {
        this(rut, nombre, telefono, "No registrado");
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (rut != null && !rut.trim().isEmpty()) {
            this.rut = rut.trim();
        } else {
            this.rut = "S/R";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            this.nombre = "Anónimo";
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.trim().isEmpty()) {
            this.telefono = telefono.trim();
        } else {
            this.telefono = "No registrado";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email.trim();
        } else {
            this.email = "No registrado";
        }
    }

    public void mostrarContacto() {
        System.out.println("=== Ficha de Contacto ===");
        System.out.println("Nombre:   " + this.nombre);
        System.out.println("RUT:      " + this.rut);
        System.out.println("Teléfono: " + this.telefono);
        System.out.println("Email:    " + this.email);
    }

    public boolean tieneTelefonoValido() {
        return this.telefono != null && !this.telefono.equals("No registrado") && this.telefono.length() >= 8;
    }

    public String toString() {
        return "RUT: " + rut + " | Nombre: " + nombre + " | Teléfono: " + telefono + " | Email: " + email;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return rut != null ? rut.equals(persona.rut) : persona.rut == null;
    }
}