package prog2.model;

public class Estudiant extends Usuari{
    private final int MaxPrestecsNormals;
    private final int MaxPrestecsLlargs;
/**constructor on definim el limit de prestecs que pot fer un estudiant*/
    public Estudiant(String email, String nom, String adreca) {
        super(email, nom, adreca);
        MaxPrestecsNormals = 2;
        MaxPrestecsLlargs = 1;
    }
/** funcio getter que retorna els prestecs maxim normals que pot fer*/
    public int getMaxPrestecsNormals() {
        return MaxPrestecsNormals;
    }
/** mateixa funcio que l'anterior pero amb els prestecs llargs*/
    public int getMaxPrestecsLlargs() {
        return MaxPrestecsLlargs;
    }

}
