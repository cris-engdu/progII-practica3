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



    public FrmAfegirUsuari(JFrame parent,Adaptador adaptador) {
        super(parent);
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setModal(true);
        setTitle("Afegir Usuari");
        setSize(400,300);
        setLocationRelativeTo(parent);


        btnAfegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email= txtEmail.getText();
                String nom= txtNom.getText();
                String adreca=txtAdreca.getText();
                boolean esEstudiant= ckEstudiant.isSelected();
            try {

                adaptador.afegirUsuari(email, nom, adreca, esEstudiant);
            } catch (BiblioException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
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
