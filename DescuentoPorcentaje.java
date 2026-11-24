// OCP: Extiende el cálculo de rebajas sin modificar la clase Pedido.
public class DescuentoPorcentaje implements EstrategiaDescuento {
    private static final double PORCENTAJE_MINIMO = 0.0;
    private static final double PORCENTAJE_MAXIMO = 100.0;

    private final double porcentaje;

    public DescuentoPorcentaje(double porcentaje) {
        this.porcentaje = (porcentaje >= PORCENTAJE_MINIMO && porcentaje <= PORCENTAJE_MAXIMO)
                ? porcentaje
                : PORCENTAJE_MINIMO;
    }

    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * (porcentaje / PORCENTAJE_MAXIMO);
    }

    @Override
    public String getDescripcionDescuento() {
        return "Descuento del " + porcentaje + "%";
    }
}