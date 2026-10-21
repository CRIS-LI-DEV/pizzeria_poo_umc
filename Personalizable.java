import java.util.List;

public interface Personalizable {
    void agregarIngrediente(String ingrediente);
    void quitarIngrediente(String ingrediente);
    void cambiarTamanio(String tamanio);
    List<String> getIngredientes();
}