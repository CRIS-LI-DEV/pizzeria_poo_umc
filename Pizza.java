public class Pizza {
    // Atributos
    private String nombre;
    private String tamano;
    private double precio;

    // Constructor
    public Pizza(String nombre, String tamano, double precio) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("--- Detalle de la Pizza ---");
        System.out.println("Variedad: " + nombre);
        System.out.println("Tamaño:   " + tamano);
        System.out.println("Precio:   $" + precio);
    }
}