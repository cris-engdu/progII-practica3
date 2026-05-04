package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class Dades implements InDades, Serializable {
    private LlistaExemplars llistaExemplars;
    private LlistaUsuaris llistaUsuaris;
    private LlistaPrestecs llistaPrestecs;

    public Dades(){
        llistaExemplars=new LlistaExemplars();
        llistaUsuaris=new LlistaUsuaris();
        llistaPrestecs=new LlistaPrestecs();
    }
    @Override
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
            Exemplar ex= new Exemplar(id, titol, autor, admetPrestecLlarg);
            llistaExemplars.afegir(ex);
    }


    @Override
    public ArrayList<Exemplar> recuperaExemplars() {

        return llistaExemplars.getArrayList();
    }



    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
            Usuari us;
            if (esEstudiant){
               us=new Estudiant(email,nom,adreca);
            }else{
               us=new Professor(email,nom,adreca);
            }
            llistaUsuaris.afegir(us);
    }

    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        return llistaUsuaris.getArrayList();
    }

    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {

        if (exemplarPos < 0 || exemplarPos >= llistaExemplars.getSize()) {
            throw new BiblioException(("Error, posicio del exemplar no valida"));
        }
        if ((usuariPos < 0) || usuariPos >= llistaUsuaris.getSize()) {
            throw new BiblioException("Error, posicio de l'usuari no valida");
        }
        Exemplar ex = llistaExemplars.getAt(exemplarPos);
        Usuari us = llistaUsuaris.getAt(usuariPos);

        if (esLlarg && !ex.getAdmetPrestecLlarg()) {
            throw new BiblioException("Error, aquest exemplar no admet el prestec llarg");
        }

        Iterator<Prestec> it = llistaPrestecs.getArrayList().iterator();
        while (it.hasNext()) {
            Prestec p = it.next();
            if (p.getExemplar().equals(ex) && !p.getRetornat()) {
                throw new BiblioException("Error, aquest exemplar no esta disponible");
            }
            if ((p.getUsuari().getEmail().equals(us.getEmail()) && !p.getRetornat())&& p.prestecEndarrerit()) {
                throw new BiblioException("Error,l'usuari te prestecs endarrerits");
            }
        }
        if (esLlarg){
            if (us.getNumPrestecsLlargs()>=us.getMaxPrestecsLlargs()){
                throw new BiblioException("Error, l'usuari excedeix el limit prestecs llargs");
            }
        }else{
            if (us.getNumPrestecsNormals()>=us.getMaxPrestecsNormals()){
                throw new BiblioException("Error, l'usuari excedeix el limit de prestecs normals");
            }
        }

        Prestec nouP;
        Date datactual=new Date();
        if (esLlarg){
            nouP=new PrestecLlarg(ex,us,datactual);
            us.setNumPrestecsLlargs(us.getNumPrestecsLlargs()+1);
            ex.setDisponible(false);

        }else{
            nouP=new PrestecNormal(ex,us,datactual);
            us.setNumPrestecsNormals(us.getNumPrestecsNormals()+1);
            ex.setDisponible(false);
        }
        llistaPrestecs.afegir(nouP);
    }

    @Override
    public void retornarPrestec(int position) throws BiblioException {
            if (position < 0 || position>=llistaPrestecs.getSize()){
                throw new BiblioException(("Error, posicio de prestec no valida"));
            }
            Prestec pr= llistaPrestecs.getAt(position);
               pr.retorna();

    }

    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return llistaPrestecs.getArrayList();
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        ArrayList<Prestec> prestecs=new ArrayList<>();
        Iterator<Prestec>it=llistaPrestecs.getArrayList().iterator();
        while (it.hasNext()){
            Prestec pr=it.next();
            if (!pr.getRetornat()){
                prestecs.add(pr);
            }
        }
        return prestecs;
    }
}
