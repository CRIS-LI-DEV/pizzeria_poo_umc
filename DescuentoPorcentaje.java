public class DescuentoPorcentaje implements EstrategiaDescuento {
    private double porcentaje;

    public DescuentoPorcentaje(double porcentaje) {
        this.porcentaje = (porcentaje >= 0 && porcentaje <= 100) ? porcentaje : 0.0;
    }

    @Override
    public double calcularDescuento(double subtotal) {
        return subtotal * (porcentaje / 100.0);
    }
}