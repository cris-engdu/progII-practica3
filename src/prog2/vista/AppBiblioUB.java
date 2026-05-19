package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppBiblioUB extends JFrame {
    private JPanel contentPane;
    private JButton btnGestioUsuaris;
    private JButton btnGestioExemplars;


    private Adaptador adaptador;


    public AppBiblioUB(){
        this.adaptador=new Adaptador();
        setContentPane(contentPane);
        setTitle("Biblio UB");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,400);
        setLocationRelativeTo(null);
        btnGestioUsuaris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioUsuaris dialog= new FrmGestioUsuaris(adaptador);
                dialog.setVisible(true);
            }
        });
        btnGestioExemplars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioExemplars Exemplar= new FrmGestioExemplars(adaptador);
                Exemplar.setVisible(true);

            }
        });
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(() ->{
            AppBiblioUB app = new AppBiblioUB();
            app.setVisible(true);
        });

    }

}
