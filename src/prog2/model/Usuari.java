package prog2.model;

public abstract class Usuari implements InUsuari {
    private String email;
    private String nom;
    private String adreca;
    private int numPrestecsNormals;
    private int numPrestecsLlargs;

    public Usuari(String email_, String nom_, String adreca_) {
        this.email = email_;
        this.nom = nom_;
        this.adreca = adreca_;
        setNumPrestecsNormals(0);
        setNumPrestecsLlargs(0);
    }

    public String toString() {
        return "Tipus=" + this.tipusUsuari() + ", Email=" + this.email + ", Nom=" + this.nom + ", Adreca=" + this.adreca +
                "Num. prestecs normals= " + this.numPrestecsNormals + ", Num. prestecs llargs=" + this.numPrestecsLlargs;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    @Override
    public String getAdreca() {
        return adreca;
    }

    @Override
    public String tipusUsuari() {
        return this.getClass().getName();
    }

    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.numPrestecsNormals = numPrestecsNormals;
    }

    @Override
    public int getNumPrestecsNormals() {
        return numPrestecsNormals;
    }

    @Override
    public void setNumPrestecsLlargs(int numPrestecsLlargs) {
        this.numPrestecsLlargs = numPrestecsLlargs;
    }

    @Override
    public int getNumPrestecsLlargs() {
        return numPrestecsLlargs;
    }

    @Override
    public abstract int getMaxPrestecsNormals();

    @Override
    public abstract int getMaxPrestecsLlargs();
}
