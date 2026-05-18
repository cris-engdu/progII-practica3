package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FrmGestioUsuaris extends JDialog {
    private JPanel contentPane;
    private JList lstUsuaris;
    private JButton btnAcceptar;
    private JButton btnTancar;
    private Adaptador adaptador;

    public FrmGestioUsuaris(JFrame parent, Adaptador adaptador) {
        super(parent);
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setSize(700,400);
        setModal(true);
        setTitle("Gestio d'usuaris");
        setLocationRelativeTo(parent);

        llistaUsuaris();
        btnAcceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirUsuari dialog = new FrmAfegirUsuari(parent, adaptador);
                dialog.setVisible(true);
                llistaUsuaris();
            }
        });

        btnTancar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
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
