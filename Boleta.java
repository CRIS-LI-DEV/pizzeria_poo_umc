public class Boleta {
    private int numeroTransaccion;
    private String estado;

    // El constructor recibe el ID del pedido para amarrarse a él
    public Boleta(int idReferencia) {
        this.numeroTransaccion = idReferencia * 1024;
        this.estado = "Emitida";
    }

    public void mostrarBoleta(double total) {
        System.out.println("BOLETA N° " + numeroTransaccion + " [" + estado + "] - Total pagado: $" + (int) total);
    }
}