// SRP: Única responsabilidad de representar y emitir el comprobante financiero del pedido.
public class Boleta {
    private static final int FACTOR_TRANSACCION = 1024;
    private static final String ESTADO_INICIAL = "Emitida";

    private final int numeroTransaccion;
    private final String estado;

    public Boleta(int idReferencia) {
        this.numeroTransaccion = idReferencia * FACTOR_TRANSACCION;
        this.estado = ESTADO_INICIAL;
    }

    public int getNumeroTransaccion() { return numeroTransaccion; }
    public String getEstado() { return estado; }

    public void mostrarBoleta(double total) {
        System.out.println("BOLETA N° " + numeroTransaccion + " [" + estado + "] - Total pagado: $" + (int) total);
    }
}