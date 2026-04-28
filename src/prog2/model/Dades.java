package prog2.model;

import prog2.vista.BiblioException;

import java.util.ArrayList;

public class Dades implements InDades{
    @Override
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
            iterator<Exemplar> it= llistaExemplars.iterator();
            while (it.hasNext()){
                Exemplar ex= it.next();
                if (ex.getId().equals(id)){
                    throw new BiblioException("Error, aquest exemplar ja esta afegit");
                }
            }
            Exemplar ex= new Exemplar(id, titol, autor, admetPrestecLlarg);
            llistaExemplars.add(ex);
    }


    @Override
    public ArrayList<Exemplar> recuperaExemplars() {

        return llistaExemplars;
    }



    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
            iterator<Usuari>it=llistaUsuaris.iterator();
            while (it.hasNext()){
                Usuari us=it.next();
                if (us.getEmail().equals(email)){
                    throw new BiblioException("Error, aquest correu ja esta registrat");
                }
            }
            if (esEstudiant){
                Usuari us=new Estudiant(email,nom,adreca);
            }else{
                Usuari us=new Professor(email,nom,adreca);
            }
    }

    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        return llistaUsuaris;
    }

    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        //recuperar prestamo viendo poscion exemplar i usuari i veure condicions de usuari si pot fer el prestec
    }

    @Override
    public void retornarPrestec(int position) throws BiblioException {
            Prestec pr= llistaPrestecs.get(position);
            if(pr.getRetornat()) {
                throw new BiblioException("Error, aquest prestec ja ha estat retornat");
            }else{
                pr.setRetornat(true);
            }
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return llistaPrestecs;
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        ArrayList<Prestec> prestecs=new ArrayList<>();
        iterator<Prestec>it=llistaPrestecs.iterator();
        while (it.hasNext()){
            Prestec pr=it.next();
            if (!pr.getRetornat()){
                prestecs.add(pr);
            }
        }
        return prestecs;
    }
}
