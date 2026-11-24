// OCP y DIP: Contrato abierto a nuevas políticas de descuento sin modificar Pedido.
public interface EstrategiaDescuento {
    double calcularDescuento(double subtotal);
    String getDescripcionDescuento();
}