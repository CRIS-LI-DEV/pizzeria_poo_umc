// OCP: Implementación base de estrategia nula sin alterar el flujo de cobro de Pedido.
public class SinDescuento implements EstrategiaDescuento {
    @Override
    public double calcularDescuento(double subtotal) {
        return 0.0;
    }

    @Override
    public String getDescripcionDescuento() {
        return "Sin descuento aplicado";
    }
}
//