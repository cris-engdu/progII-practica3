package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmAfegirExemplar extends JDialog {
    private JPanel contentPane;
    private JButton btnAfegir;
    private JButton btnCancelar;
    private JTextField txtId;
    private JTextField txtTitol;
    private JTextField txtAutor;
    private JCheckBox ckPrestecLlarg;
    private Adaptador adaptador;
/** Constructor per gestionar la finestra de dialeg d'afegir exemplars*/
    public FrmAfegirExemplar(JFrame parent, Adaptador adaptador) {
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setModal(true);
        setTitle("Afegir Exemplar");
        setSize(400,300);
        setLocationRelativeTo(parent);


        btnAfegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtId.getText().isEmpty() || txtTitol.getText().isEmpty()|| txtAutor.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Omple tots els camps","Avis", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try{
                    //cridem funcio adaptador per afegir exemplar
                    adaptador.afegirExemplar(txtId.getText(),txtTitol.getText(),txtAutor.getText(),ckPrestecLlarg.isSelected());
                    JOptionPane.showMessageDialog(FrmAfegirExemplar.this, "Exemplar afegit correctament", "Exit",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (BiblioException ex ) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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
