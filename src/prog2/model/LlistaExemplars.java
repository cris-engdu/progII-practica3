package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaExemplars extends Llista<Exemplar> implements Serializable {

    public LlistaExemplars() {
        super();
    }
/** en auqesta funcio d'afegir creem un iterador i comprovem si hi ha algu exemplar amb el mateix id sino llança excepcio i sino l'afegeix a la llista*/
    @Override
    public void afegir(Exemplar exemplar) throws BiblioException {
        Iterator<Exemplar> it = llista.iterator();
        while (it.hasNext()) {
            Exemplar ex = it.next();
            if (ex.getId().equals(exemplar.getId())) {
                throw new BiblioException("No es pot afegir dos exemplars amb el mateix identificador.");
            }
        }
        llista.add(exemplar);
    }
/** en aquesta funcio fem que busqui si hi ha l'exemplar amb l'id passat com parametre*/
    public boolean contains(String id) {
        Iterator<Exemplar> it = llista.iterator();
        while (it.hasNext()) {
           Exemplar ex  = it.next();
           if (ex.getId().equals(id)) {
               return true;
           }
        }
        return false;
    }
}
