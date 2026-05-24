package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FrmGuardarDades extends JFrame {
    private Adaptador adaptador;
    private File fitxer;
    private JPanel contentPane;
    private JTextField txtNomFitxer;
    private JButton btnSelecciona;
    private JButton btnSortir;
    /** Constructor per gestionar el formulari de guardar dades*/

    public FrmGuardarDades(Adaptador adaptador) {
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setTitle("Guardar Dades");
        setSize(400,300);
        setLocationRelativeTo(null);

        btnSelecciona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser =  new JFileChooser();
                int resultat = chooser.showSaveDialog(FrmGuardarDades.this);
                if (resultat == JFileChooser.APPROVE_OPTION) {
                    fitxer = chooser.getSelectedFile();
                    txtNomFitxer.setText(fitxer.toString());

                    try {
                        adaptador.guardaDades(fitxer.getPath());
                        JOptionPane.showMessageDialog(FrmGuardarDades.this, "Les dades s'han guardat correctament.", "Exit",JOptionPane.INFORMATION_MESSAGE);
                    } catch (BiblioException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnSortir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGuardarDades.this.dispose();
            }
        });
    }
}
