package prog2.adaptador;

import prog2.model.Dades;
import prog2.vista.BiblioException;

import java.io.*;

public class Adaptador implements Serializable {
    private Dades dades;

    public Adaptador() {
        this.dades = new Dades();
    }

    public void guardaDades(String camiDesti) throws BiblioException {
        try {
            FileOutputStream file = new FileOutputStream(camiDesti);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this);
            out.close();
            file.close();
        } catch (IOException e) {
            throw new BiblioException("Error al guardar dades.");
        }
    }

    public Dades carregaDades(String camiOrigen) throws BiblioException {
        try {
            FileInputStream file = new FileInputStream(camiOrigen);
            ObjectInputStream in = new ObjectInputStream(file);
            Dades dades = (Dades) in.readObject();
            return dades;
        } catch (IOException e) {
            throw new BiblioException("Error al carregar dades.");
        }
    }

}
