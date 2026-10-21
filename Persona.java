public abstract class Persona {

    // Constantes para valores por defecto
    public static final String RUT_POR_DEFECTO = "S/R";
    public static final String NOMBRE_POR_DEFECTO = "Anónimo";
    public static final String NO_REGISTRADO = "No registrado";

    private final String rut;
    private String nombre;
    private String telefono;
    private String email;

    /**
     * Constructor Canónico / Principal.
     * Centraliza la asignación y validación de atributos.
     */
    public Persona(String rut, String nombre, String telefono, String email) {
        this.rut = (rut != null && !rut.trim().isEmpty()) ? rut.trim() : RUT_POR_DEFECTO;
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
    }

    /**
     * Constructor secundario: sin email.
     */
    public Persona(String rut, String nombre, String telefono) {
        this(rut, nombre, telefono, NO_REGISTRADO);
    }

    /**
     * Constructor secundario: datos básicos de identificación.
     */
    public Persona(String rut, String nombre) {
        this(rut, nombre, NO_REGISTRADO, NO_REGISTRADO);
    }

    /**
     * Constructor por defecto.
     */
    public Persona() {
        this(RUT_POR_DEFECTO, NOMBRE_POR_DEFECTO, NO_REGISTRADO, NO_REGISTRADO);
    }

    // Método abstracto obligatorio para subclases
    public abstract String getTipoPersona();

    // Getters y Setters con validaciones
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            this.nombre = NOMBRE_POR_DEFECTO;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.trim().isEmpty()) {
            this.telefono = telefono.trim();
        } else {
            this.telefono = NO_REGISTRADO;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email.trim();
        } else {
            this.email = NO_REGISTRADO;
        }
    }

    // Métodos de comportamiento
    public void mostrarContacto() {
        System.out.println("=== Ficha de Contacto (" + getTipoPersona() + ") ===");
        System.out.println("Nombre:   " + this.nombre);
        System.out.println("RUT:      " + this.rut);
        System.out.println("Teléfono: " + this.telefono);
        System.out.println("Email:    " + this.email);
    }

    public boolean tieneTelefonoValido() {
        return this.telefono != null && !this.telefono.equals(NO_REGISTRADO) && this.telefono.length() >= 8;
    }

    @Override
    public String toString() {
        return "[" + getTipoPersona() + "] RUT: " + rut + " | Nombre: " + nombre + " | Teléfono: " + telefono + " | Email: " + email;
    }
}