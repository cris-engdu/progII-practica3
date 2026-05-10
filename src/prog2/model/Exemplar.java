package prog2.model;

import java.io.Serial;
import java.io.Serializable;

public class Exemplar implements InExemplar, Serializable {
    private String id;
    private String titol;
    private String autor;
    private boolean admetPrestecLlarg;
    private boolean isDisponible;
/** constructor d'exemplar*/
    public Exemplar(String id_, String titol_, String autor_, boolean admetPrestecLlarg_) {
        this.id = id_;
        this.titol = titol_;
        this.autor = autor_;
        this.admetPrestecLlarg = admetPrestecLlarg_;
        this.isDisponible = true;
    }
/** funcio per mostrar el text quan es fa un prestec*/
    @Override
    public String toString() {
        return "Id=" + id + ", Titol=" + titol + ", Autor=" + autor + ", Admet Prestec Llarg=" + admetPrestecLlarg + ", Disponible=" + isDisponible;
    }

/** setter d'id*/
    @Override
    public void setId(String id) {
        this.id = id;
    }
/** getter d'id*/
    @Override
    public String getId() {
        return id;
    }
    /** setter de titol*/

    @Override
    public void setTitol(String titol) {
        this.titol = titol;
    }
    /** getter de titol*/

    @Override
    public String getTitol() {
        return titol;
    }
    /** setter d'autor*/

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /** getter d'autor*/

    @Override
    public String getAutor() {
        return autor;
    }
    /** setter per definir si l'exemplar admet el prestec llarg*/

    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {
        this.admetPrestecLlarg = admetPrestecLlarg;
    }
    /** getter de si admet prestec llarg*/

    @Override
    public boolean getAdmetPrestecLlarg() {
        return admetPrestecLlarg;
    }
    /** Funcio getter que retorna si l'exemplar esta disponible*/

    public boolean isDisponible() {
        return isDisponible;
    }
    /** setter per tornar a posar l'exemplar a disponible quan es retornat*/

    public void setDisponible(boolean isDisponible) {
        this.isDisponible = isDisponible;
    }
}
