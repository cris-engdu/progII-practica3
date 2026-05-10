package prog2.model;

public class Professor extends Usuari{
    private final int MaxPrestecsNormals;
    private final int MaxPrestecsLlargs;
/** constructor de professor on s'especifica el maxim dels tipus de prestecs*/
    public Professor(String email, String nom, String adreca) {
        super(email, nom, adreca);
        MaxPrestecsNormals = 2;
        MaxPrestecsLlargs = 2;
    }
/** getter que retorna el maxim de prestecs normals que pot fe*/
    @Override
    public int getMaxPrestecsNormals() {
        return this.MaxPrestecsNormals;
    }
/** getter que retorna el maxim de prestecs llargs que pot fer*/
    @Override
    public int getMaxPrestecsLlargs() {
        return this.MaxPrestecsLlargs;
    }
}
