public interface Preparable {
    void iniciarPreparacion();
    void terminarPreparacion();
    boolean estaListo();
    int getTiempoCoccion();
}