package prog2.model;

public class Professor extends Usuari{
    private final int MaxPrestecsNormals;
    private final int MaxPrestecsLlargs;

    public Professor(String nom, String email, String adreca) {
        super(nom, email, adreca);
        MaxPrestecsNormals = 2;
        MaxPrestecsLlargs = 2;
    }

    @Override
    public int getMaxPrestecsNormals() {
        return this.MaxPrestecsNormals;
    }

    @Override
    public int getMaxPrestecsLlargs() {
        return this.MaxPrestecsLlargs;
    }
}
