package prog2.vista;

import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppBiblioUB extends JFrame {
    private JPanel contentPane;
    private JButton btnGestioUsuaris;
    private JButton btnGestioExemplars;
    private JButton btnGestioPrestec;
    private JButton btnGuardarDades;
    private JButton btnCarregarDades;


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
        btnGestioPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGestioPrestecs Prestec= new FrmGestioPrestecs(adaptador);
                Prestec.setVisible(true);
            }
        });
        btnCarregarDades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmCarregarDades carregar =  new FrmCarregarDades(adaptador);
                carregar.setVisible(true);
            }
        });
        btnGuardarDades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmGuardarDades guardar = new FrmGuardarDades(adaptador);
                guardar.setVisible(true);
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
