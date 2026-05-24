package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioExemplars extends javax.swing.JFrame {
    private JPanel contentPane;
    private Adaptador  adaptador;
    private JList lstExemplars;
    private JButton btnAcceptar;
    private JButton btnCancelar;

    public FrmGestioExemplars(Adaptador adaptador) {
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setTitle("Gestio Exemplars");
        pack();
        setLocationRelativeTo(null);
        omplirLlistaExemplars();


        btnAcceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    FrmAfegirExemplar afegirExemplar= new FrmAfegirExemplar(FrmGestioExemplars.this,adaptador);
                    afegirExemplar.setVisible(true);
                    FrmGestioExemplars.this.omplirLlistaExemplars();
                    afegirExemplar.pack();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(FrmGestioExemplars.this,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioExemplars.this.dispose();
            }
        });
    }

    private void omplirLlistaExemplars(){
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String m: adaptador.llistarExemplars()){
            model.addElement(m);
        }
        lstExemplars.setModel(model);
    }
}
