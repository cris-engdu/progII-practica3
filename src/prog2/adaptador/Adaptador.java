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
            out.writeObject(this.dades);
            out.close();
            file.close();
        } catch (IOException e) {
            throw new BiblioException("Error al guardar dades.");
        }
    }

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

}
