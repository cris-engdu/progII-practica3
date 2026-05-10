package prog2.adaptador;

import prog2.model.Dades;
import prog2.model.Exemplar;
import prog2.model.Prestec;
import prog2.model.Usuari;
import prog2.vista.BiblioException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Adaptador implements Serializable {
    private Dades dades;

    public Adaptador() {
        this.dades = new Dades();
    }
/** funcio per guardar les dades on creem els objectes necessaris i despres els tanquem perque es guardin correctament i no hi hagi cap problema*/
    public void guardaDades(String camiDesti) throws BiblioException {
        try {
            FileOutputStream file = new FileOutputStream(camiDesti);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this.dades);
            out.close();
            file.close();
        } catch (IOException e) {
            throw new BiblioException("Error al guardar dades.");
        }
    }
/** en aquesta a partir del nom del fitxer donat, llegim les dades i tanquem esl objectes creats*/
    public void carregaDades(String camiOrigen) throws BiblioException {
        try {
            FileInputStream file = new FileInputStream(camiOrigen);
            ObjectInputStream in = new ObjectInputStream(file);
            this.dades = (Dades) in.readObject();
            in.close();
            file.close();
        } catch (IOException e) {
            throw new BiblioException("Error al carregar dades.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
/** Utilitzem la classe dades per afegir els exemplars*/
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }
    /** Utilitzem la classe dades per afegir els usuaris*/

    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }
    /** Utilitzem la classe dades per afegir els prestecs*/

    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }
    /** Utilitzem la classe dades per retornar els prestecs*/

    public void retornarPrestec(int prestecPos) throws BiblioException {
        dades.retornarPrestec(prestecPos);
    }
    /** Utilitzem la classe dades per mostrar els usuaris*/

    public ArrayList<String> llistarUsuaris() {
        ArrayList<String> strLlista = new ArrayList<String>();
        ArrayList<Usuari> llistaUsuaris = dades.recuperaUsuaris();
        for (Usuari usuari : llistaUsuaris) {
            strLlista.add(usuari.toString());
        }
        return strLlista;
    }
    /** Utilitzem la classe dades per mostrar els exemplars*/

    public ArrayList<String> llistarExemplars() {
        ArrayList<String> strLlista = new ArrayList<String>() ;
        ArrayList<Exemplar> llistaExemplars = dades.recuperaExemplars();
        for (Exemplar exemplar : llistaExemplars) {
            strLlista.add(exemplar.toString());
        }
        return strLlista;
    }

    /** Utilitzem la classe dades per mostrar els prestecs, on si es true mostra nomes els no retornats
     *  i si es false tots els prestecs.*/
    public ArrayList<String> llistarPrestec(boolean noRetornats) {
        ArrayList<String> strLlista = new ArrayList<String>();
        ArrayList<Prestec> llistaPrestecs = null;

        if (noRetornats) {
            llistaPrestecs = dades.recuperaPrestecsNoRetornats();
        } else {
            llistaPrestecs =  dades.recuperaPrestecs();
        }

        for (Prestec prestec : llistaPrestecs) {
                    strLlista.add(prestec.toString());
        }

        return strLlista;
    }
}
