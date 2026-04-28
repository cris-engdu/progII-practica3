package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.Iterator;

public class LlistaUsuaris extends Llista<Usuari> implements Serializable {

    public LlistaUsuaris() {
        super();
    }

    @Override
    public void afegir(Usuari usuari) throws BiblioException {
        Iterator<Usuari> it = llista.iterator();
        while (it.hasNext()) {
            Usuari us = it.next();
            if (us.getEmail().equals(usuari.getEmail())) {
               throw new BiblioException("No es pot afegir dos usuaris amb el mateix email.");
            }
        }
        llista.add(usuari);
    }

    public boolean contains(String email) {
        Iterator<Usuari> it = llista.iterator();
        while (it.hasNext()) {
            Usuari us = it.next();
            if (us.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
