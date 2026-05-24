package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrmCarregarDades extends JFrame {
    private JTextField txtNomFitxer;
    private JPanel contentPane;
    private JButton btnSelecciona;
    private JButton btnCarregar;
    private JButton btnCancelar;
    private Adaptador adaptador;
    private File fitxer;
    /** Constructor per gestionar el formulari per carregar dades*/

    public FrmCarregarDades(Adaptador adaptador) {
        this.adaptador=adaptador;
        setContentPane(contentPane);
        setTitle("Carregar Dades");
        setSize(400,300);
        setLocationRelativeTo(null);


        btnSelecciona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Selector de fitxer
                JFileChooser chooser = new JFileChooser();

                // Resultat indica si s'ha seleccionat un fitxer
                int resultat = chooser.showOpenDialog(FrmCarregarDades.this);
                if (resultat == JFileChooser.APPROVE_OPTION) {
                    // Obtenim fitxer
                    fitxer = chooser.getSelectedFile();

                    // Escrivim la ruta del fitxer al quadre de text
                    txtNomFitxer.setText(fitxer.toString());
                }
            }
        });


        btnCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fitxer == null) {
                    JOptionPane.showMessageDialog(FrmCarregarDades.this,
                            "Selecciona un arxiu.");
                } else {
                    try {
                        adaptador.carregaDades(fitxer.getPath());
                        JOptionPane.showMessageDialog(FrmCarregarDades.this, "Les dades s'han carregat correctament.", "Exit",JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (BiblioException ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCarregarDades.this.dispose();
            }
        });
    }
}
