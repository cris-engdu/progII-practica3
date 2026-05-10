package prog2.model;

import java.io.Serializable;

public abstract class Usuari implements InUsuari, Serializable {
    private String email;
    private String nom;
    private String adreca;
    private int numPrestecsNormals;
    private int numPrestecsLlargs;
/** constructor d'usuari*/
    public Usuari(String email_, String nom_, String adreca_) {
        this.email = email_;
        this.nom = nom_;
        this.adreca = adreca_;
        setNumPrestecsNormals(0);
        setNumPrestecsLlargs(0);
    }
/** funcio que retorna la informacio de l'usuari */
    public String toString() {
        return "Tipus=" + this.tipusUsuari() + ", Email=" + this.email + ", Nom=" + this.nom + ", Adreca=" + this.adreca +
                "Num. prestecs normals= " + this.numPrestecsNormals + ", Num. prestecs llargs=" + this.numPrestecsLlargs;
    }
    /** setter d'email*/
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    /** getter d'email*/
    @Override
    public String getEmail() {
        return email;
    }

    /** setter de nom*/
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    /** setter de nom*/
    @Override
    public String getNom() {
        return nom;
    }

    /** setter de l'adreça*/
    @Override
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    /** getter de l'adreça*/
    @Override
    public String getAdreca() {
        return adreca;
    }

    /**  funcio que retorna el tipus d'usuari, es a dir si es professor o estudiant*/
    @Override
    public String tipusUsuari() {
        return this.getClass().getSimpleName();
    }

    /** setter per definir el nombre de prestecs normals*/
    @Override
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.numPrestecsNormals = numPrestecsNormals;
    }

    /** getter per retornar el nombre de prestecs normals fets*/
    @Override
    public int getNumPrestecsNormals() {
        return numPrestecsNormals;
    }

    /** setter per definir el nombre de prestecs llargs*/
    @Override
    public void setNumPrestecsLlargs(int numPrestecsLlargs) {
        this.numPrestecsLlargs = numPrestecsLlargs;
    }
    /** getter per retornar el nombre de prestecs llargs fets*/
    @Override
    public int getNumPrestecsLlargs() {
        return numPrestecsLlargs;
    }
/** funcio abstracte perque en la classe professor i estudiant s'especifiqui aquesta funció*/
    @Override
    public abstract int getMaxPrestecsNormals();

    /** funcio abstracte perque en la classe professor i estudiant s'especifiqui aquesta funció*/
    @Override
    public abstract int getMaxPrestecsLlargs();
}
