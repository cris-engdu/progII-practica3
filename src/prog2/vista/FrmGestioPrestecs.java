package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioPrestecs extends JFrame {
    private JList lstPrestecs;
    private JCheckBox ckRetornats;
    private JButton btnAfegirPrestec;
    private JButton btnRetPrestec;
    private JButton btnCancelar;
    private JPanel contentPane;
    private Adaptador adaptador;

    public FrmGestioPrestecs(Adaptador adaptador) {
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setTitle("Gestio Prestecs");
        pack();
        setLocationRelativeTo(null);
        llistaPrestecs();


        btnAfegirPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    FrmAfegirPrestec AfegirPrestec= new FrmAfegirPrestec(FrmGestioPrestecs.this,adaptador);
                    AfegirPrestec.setVisible(true);
                    AfegirPrestec.pack();
                    FrmGestioPrestecs.this.llistaPrestecs();



            }
        });
        btnRetPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos=lstPrestecs.getSelectedIndex();
                if (pos!=-1){
                    try{
                        adaptador.retornarPrestec(pos);
                        JOptionPane.showMessageDialog(FrmGestioPrestecs.this,"El prestec s'ha retornat correctament","Exit",JOptionPane.INFORMATION_MESSAGE);
                        llistaPrestecs();
                    }catch (BiblioException ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }

                }else if (pos==-1){
                    JOptionPane.showMessageDialog(FrmGestioPrestecs.this,"Has de seleccionar un prestec","Avis",JOptionPane.WARNING_MESSAGE);

                }
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioPrestecs.this.dispose();

            }
        });

        ckRetornats.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                llistaPrestecs();
            }
        });
    }
    private void llistaPrestecs(){
        DefaultListModel<String> model= new DefaultListModel<>();
        for (String pr: adaptador.llistarPrestec(ckRetornats.isSelected())){
            model.addElement(pr);
        }
        lstPrestecs.setModel(model);
    }



}
