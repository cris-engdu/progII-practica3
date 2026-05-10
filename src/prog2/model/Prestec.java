package prog2.model;
import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Date;

public abstract class Prestec implements InPrestec, Serializable {
    private Exemplar exemplar;
    private Usuari usuari;
    private Date dataCreacio;
    private Date dataLimit;
    private boolean isRetornat;
/** constructor de prestec*/
    public Prestec(Exemplar exemplar_, Usuari usuari_, Date dataCreacio_) {
        this.exemplar = exemplar_;
        this.usuari = usuari_;
        this.dataCreacio = dataCreacio_;
        this.dataLimit=new Date();
        this.dataLimit.setTime(dataCreacio.getTime()+duradaPrestec());
        setRetornat(false);
    }

    public String toString() {
        return "Tipus=" + tipusPrestec() + ", Exemplar=" + exemplar.getTitol() + ", Usuari= " + usuari.getNom() +
                ", Data de creacio =" + dataCreacio + ", Data de limite =" + dataLimit + ", Retornat=" + isRetornat;
    }
    /** setter d'exemplar*/

    @Override
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }
    /** getter d'exemplar*/

    @Override
    public Exemplar getExemplar() {
        return exemplar;
    }

    /** setter d'usuari*/

    @Override
    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }
    /** getter d'usuari*/

    @Override
    public Usuari getUsuari() {
        return usuari;
    }

    /** setter per definir la data de creació*/
    @Override
    public void setDataCreacio(Date data) {
        this.dataCreacio = data;
    }

    /** getter de la data de creació del prestec*/
    @Override
    public Date getDataCreacio() {
        return dataCreacio;
    }

    /** setter per definir la data de retorn*/
    @Override
    public void setDataLimitRetorn(Date data) {
        this.dataLimit = data;
    }

    /** getter per retornar la data de limit*/
    @Override
    public Date getDataLimitRetorn() {
        return dataLimit;
    }

    /** funcio abstracte ja que necessita que cada classe filla d'aquesta especifiqui quin tipus de prestec es*/
    @Override
    public abstract String tipusPrestec();

    /** setter per definir si el prestec ha estat retornat*/
    @Override
    public void setRetornat(boolean retornat) {
        this.isRetornat = retornat;
    }

    /** getter per si ha estat retornat el prestec*/
    @Override
    public boolean getRetornat() {
        return isRetornat;
    }

    /** en aquesta funcio de retorna fem que si ja ha estat retornat llança excepcio i sino el fem que ja ha estat retornat i el marquem com a disponible
     * i per ultim si el prestec es llarg o normal el restem als que te ja l'usuari fets
     */
    @Override
    public void retorna() {
        if (this.isRetornat) {
            throw new BiblioException("Error, prestec ja retornat");
        }
        this.isRetornat=true;
        this.exemplar.setDisponible(true);

        if (this.tipusPrestec().equals("Llarg")){
            this.usuari.setNumPrestecsLlargs(this.usuari.getNumPrestecsLlargs()-1);
        }else{
            this.usuari.setNumPrestecsNormals(this.usuari.getNumPrestecsNormals()-1);
        }

    }

    /** funcio abstracte ja que necessita que cada classe filla d'aquesta especifiqui la durada del prestec*/
    public abstract long duradaPrestec();

    /** en aquesta unicament comprovem que el prestec no estigui retornat ja i sino comprovem que la data actual no superi la data limit del prestec */
    @Override
    public boolean prestecEndarrerit() {
        if (this.isRetornat){
            return false;
        }
        Date dataAvui = new Date();
        return dataAvui.after(dataLimit);
    }
}
