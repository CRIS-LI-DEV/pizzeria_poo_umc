public class Direccion {
    private static final String CALLE_POR_DEFECTO = "Sin calle registrada";
    private static final String NUMERO_POR_DEFECTO = "S/N";
    private static final String COMUNA_POR_DEFECTO = "Viña del Mar";

    private String calle;
    private String numero;
    private String comuna;

    public Direccion(String calle, String numero, String comuna) {
        setCalle(calle);
        setNumero(numero);
        setComuna(comuna);
    }

    public Direccion() {
        this(CALLE_POR_DEFECTO, NUMERO_POR_DEFECTO, COMUNA_POR_DEFECTO);
    }

    // --- Getters y Setters con validaciones ---

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = (calle != null && !calle.trim().isEmpty()) ? calle.trim() : CALLE_POR_DEFECTO;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = (numero != null && !numero.trim().isEmpty()) ? numero.trim() : NUMERO_POR_DEFECTO;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = (comuna != null && !comuna.trim().isEmpty()) ? comuna.trim() : COMUNA_POR_DEFECTO;
    }

    @Override
    public String toString() {
        return calle + " #" + numero + ", " + comuna;
    }
}