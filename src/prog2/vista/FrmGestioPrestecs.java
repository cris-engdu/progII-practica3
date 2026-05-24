package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.model.LlistaPrestecs;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGestioPrestecs extends JFrame {
    private JList<String> lstPrestecs;
    private JCheckBox ckRetornats;
    private JButton btnAfegirPrestec;
    private JButton btnRetPrestec;
    private JButton btnCancelar;
    private JPanel contentPane;
    private Adaptador adaptador;

    /** Constructor per gestionar el formulari de gestio de prestecs*/

    public FrmGestioPrestecs(Adaptador adaptador) {
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setTitle("Gestio Prestecs");
        pack();
        setLocationRelativeTo(null);
        llistaPrestecs();
        lstPrestecs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


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
                        //fem els casos on si filtrem per prestecs no retornats poder retornar-los segons la seva posicio
                        int pos1;
                        if(ckRetornats.isSelected()){
                            pos1=adaptador.getPosicionsNoRetornats().get(pos);
                        }else{
                            pos1=pos;
                        }
                        //cridar funcio retornar d'adaptador
                        adaptador.retornarPrestec(pos1);
                        JOptionPane.showMessageDialog(FrmGestioPrestecs.this,"El prestec s'ha retornat correctament","Exit",JOptionPane.INFORMATION_MESSAGE);
                        llistaPrestecs();
                    }catch (BiblioException ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }

                }else{
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


        ckRetornats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llistaPrestecs();
            }
        });
    }

    /** metode per mostar els prestecs*/
    private void llistaPrestecs(){
        DefaultListModel<String> model= new DefaultListModel<>();
        for (String pr: adaptador.llistarPrestec(ckRetornats.isSelected())){
            model.addElement(pr);
        }
        lstPrestecs.setModel(model);
    }



}
