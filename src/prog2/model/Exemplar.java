package prog2.model;

import java.io.Serial;
import java.io.Serializable;

public class Exemplar implements InExemplar, Serializable {
    private String id;
    private String titol;
    private String autor;
    private boolean admetPrestecLlarg;
    private boolean isDisponible;

    public Exemplar(String id_, String titol_, String autor_, boolean admetPrestecLlarg_) {
        this.id = id_;
        this.titol = titol_;
        this.autor = autor_;
        this.admetPrestecLlarg = admetPrestecLlarg_;
        this.isDisponible = true;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", Titol=" + titol + ", Autor=" + autor + ", Admet Prestec Llarg=" + admetPrestecLlarg + ", Disponible=" + isDisponible;
    }
/** funcions de getters i de setters dels diferents atributs*/
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setTitol(String titol) {
        this.titol = titol;
    }

    @Override
    public String getTitol() {
        return titol;
    }

    @Override
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {
        this.admetPrestecLlarg = admetPrestecLlarg;
    }

    @Override
    public boolean getAdmetPrestecLlarg() {
        return admetPrestecLlarg;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public void setDisponible(boolean isDisponible) {
        this.isDisponible = isDisponible;
    }
}
