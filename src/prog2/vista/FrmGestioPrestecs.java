package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmGestioPrestecs extends JDialog {
    private Adaptador adaptador;
    private JPanel contentPane;
    private JList lstPrestecs;
    private JCheckBox chkRetornats;
    private JButton btnAfegirPrestec;
    private JButton btnSortir;
    private JButton btnRetornarPrestec;

    public FrmGestioPrestecs(Adaptador adaptador) {
        this.adaptador = adaptador;
        setContentPane(contentPane);
        setSize(700, 400);
        setModal(true);
        setLocationRelativeTo(null);
        chkRetornats.setSelected(true);

        btnAfegirPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAfegirPrestec frmAfegirPrestec = new FrmAfegirPrestec(adaptador);
                frmAfegirPrestec.setVisible(true);

            }
        });
        btnRetornarPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FrmRetornarPrestec frmRetornarPrestec = new FrmRetornarPrestec(adaptador);
                    frmRetornarPrestec.pack();
                    frmRetornarPrestec.setVisible(true);
                    llistaPrestecs(chkRetornats.isSelected());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FrmGestioPrestecs.this,
                                                                ex.getMessage(),
                                                                "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        chkRetornats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llistaPrestecs(chkRetornats.isSelected());
            }
        });
    }

    public void llistaPrestecs(boolean noRetornats) {
        ArrayList<String> prestecs = adaptador.llistarPrestec(noRetornats);
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String p : prestecs) {
            model.addElement(p);
        }
        lstPrestecs.setModel(model);
    }
}
