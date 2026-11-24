public interface Preparable {

    enum EstadoPreparacion {
        PENDIENTE("Pendiente de cocina"),
        EN_HORNO("En preparación / horno"),
        LISTO("Listo para entrega");

        private final String descripcion;

        EstadoPreparacion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }
    }

    void avanzarEstado();
    EstadoPreparacion getEstadoPreparacion();
}