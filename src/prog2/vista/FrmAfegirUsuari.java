package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAfegirUsuari extends JDialog {
    private JPanel contentPane;
    private JTextField txtEmail;
    private JTextField txtNom;
    private JTextField txtAdreca;
    private JCheckBox ckEstudiant;
    private JButton btnAfegir;
    private JButton btnCancelar;
    private Adaptador adaptador;


    /** Constructor per gestionar la finestra de dialeg d'afegir usuaris*/

    public FrmAfegirUsuari(JFrame parent,Adaptador adaptador) {
        super(parent);
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setModal(true);
        setTitle("Afegir Usuari");
        pack();
        setLocationRelativeTo(parent);


        btnAfegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email= txtEmail.getText();
                String nom= txtNom.getText();
                String adreca=txtAdreca.getText();
                boolean esEstudiant= ckEstudiant.isSelected();
                if (email.isEmpty() || nom.isEmpty() || adreca.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Omple tots els camps","Avis", JOptionPane.WARNING_MESSAGE);
                    return;
                }

            try {
                //cridar funcio afegir usuari
                adaptador.afegirUsuari(email, nom, adreca, esEstudiant);
                JOptionPane.showMessageDialog(FrmAfegirUsuari.this, "Usuari afegit correctament.", "Exit",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (BiblioException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }
}
