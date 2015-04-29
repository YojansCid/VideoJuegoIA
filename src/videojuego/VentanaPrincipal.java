package videojuego;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Pedro on 14-04-2015.
 */
public class VentanaPrincipal extends JFrame implements Constantes {

    public Lienzo lienzo;

    public VentanaPrincipal() {
        lienzo = new Lienzo();
        lienzo.setFocusable(true);
        lienzo.requestFocus();
        this.setTitle("Laberinto");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(lienzo,BorderLayout.CENTER);
        this.setSize(lienzo.getWidth()+20, lienzo.getHeight()+40);
        
    }
}
