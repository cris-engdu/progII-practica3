package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FrmGestioUsuaris extends JFrame {
    private JPanel contentPane;
    private JList lstUsuaris;
    private JButton btnAcceptar;
    private JButton btnTancar;
    private Adaptador adaptador;

    public FrmGestioUsuaris(Adaptador adaptador){
        this.adaptador=adaptador;
        setContentPane(contentPane);
        pack();
        setTitle("Gestio d'usuaris");
        setLocationRelativeTo(null);

        llistaUsuaris();
        btnAcceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirUsuari afegirUsuari = new FrmAfegirUsuari(FrmGestioUsuaris.this,adaptador);
                afegirUsuari.setVisible(true);
                llistaUsuaris();
            }
        });

        btnTancar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioUsuaris.this.dispose();
            }
        });

    }

    private void llistaUsuaris(){
        ArrayList<String>Usuaris = adaptador.llistarUsuaris();
        DefaultListModel<String> model= new DefaultListModel<>();
        for (String u: Usuaris){
            model.addElement(u);
        }
        lstUsuaris.setModel(model);
    }







}