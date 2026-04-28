package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaExemplars extends Llista<Exemplar> implements Serializable {

    public LlistaExemplars() {
        super();
    }

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
