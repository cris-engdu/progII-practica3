package prog2.model;

public class Estudiant extends Usuari{
    private final int MaxPrestecsNormals;
    private final int MaxPrestecsLlargs;

    public Estudiant(String nom, String email, String adreca) {
        super(nom, email, adreca);
        MaxPrestecsNormals = 2;
        MaxPrestecsLlargs = 1;
    }

    public int getMaxPrestecsNormals() {
        return MaxPrestecsNormals;
    }

    public int getMaxPrestecsLlargs() {
        return MaxPrestecsLlargs;
    }

}
