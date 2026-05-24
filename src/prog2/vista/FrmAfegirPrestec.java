package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.*;

public class FrmAfegirPrestec extends JDialog {
    private JPanel contentPane;
    private JButton btnAfegirPretec;
    private JButton btnCancelar;
    private JComboBox cbExemplars;
    private JComboBox cbUsuaris;
    private JCheckBox ckEsllarg;
    private Adaptador adaptador;

    public FrmAfegirPrestec(JFrame parent, Adaptador adaptador) {
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setModal(true);
        setTitle("Afegir Prestec");
        setLocationRelativeTo(parent);
        setSize(850,400);
        combos();

        btnAfegirPretec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });


    }

    private void onOK() {
        // add your code here
        try{
            adaptador.afegirPrestec(cbExemplars.getSelectedIndex(),cbUsuaris.getSelectedIndex(),ckEsllarg.isSelected());
            dispose();

        }catch(BiblioException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void combos(){
        for (String ex: adaptador.llistarExemplars() ){
            cbExemplars.addItem(ex);
        }
        for (String us: adaptador.llistarUsuaris()){
            cbUsuaris.addItem(us);
        }
    }


}
