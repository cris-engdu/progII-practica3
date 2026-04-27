package prog2.model;
import java.util.Date;

public abstract class Prestec implements InPrestec{
    private Exemplar exemplar;
    private Usuari usuari;
    private Date dataCreacio;
    private Date dataLimit;
    private boolean isRetornat;

    public Prestec(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) {
        this.exemplar = exemplar_;
        this.usuari = usuari_;
        this.dataCreacio = dataCreacio_;
        this.dataLimit.setTime(dataCreacio.getTime()+duradaPrestec());
        setRetornat(false);
    }

    public String toString() {
        return "Tipus=" + tipusPrestec() + ", Exemplar=" + exemplar.getTitol() + ", Usuari= " + usuari.getNom() +
                ", Data de creacio =" + dataCreacio + ", Data de limite =" + dataLimit + ", Retornat=" + isRetornat;
    }

    @Override
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    @Override
    public Exemplar getExemplar() {
        return exemplar;
    }

    @Override
    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    @Override
    public Usuari getUsuari() {
        return usuari;
    }

    @Override
    public void setDataCreacio(Date data) {
        this.dataCreacio = data;
    }

    @Override
    public Date getDataCreacio() {
        return dataCreacio;
    }

    @Override
    public void setDataLimitRetorn(Date data) {
        this.dataLimit = data;
    }

    @Override
    public Date getDataLimitRetorn() {
        return dataLimit;
    }

    @Override
    public abstract String tipusPrestec();

    @Override
    public void setRetornat(boolean retornat) {
        this.isRetornat = retornat;
    }

    @Override
    public boolean getRetornat() {
        return isRetornat;
    }

    @Override
    public void retorna() {
    }

    @Override
    public abstract long duradaPrestec();

    @Override
    public boolean prestecEndarrerit() {
        Date dataAvui = new Date();
        return dataLimit.after(dataAvui);
    }
}
