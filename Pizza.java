public class Pizza {
    private String nombre;
    private double precio;

    public Pizza(String nombre, double precio) {
        this.nombre = (nombre != null && !nombre.trim().isEmpty()) ? nombre.trim() : "Margarita";
        this.precio = (precio >= 0) ? precio : 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    @Override
    public String toString() {
        return nombre + " ($" + (int) precio + ")";
    }
}