package videojuego;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Created by Pedro on 14-04-2015.
 */
public class Celda  extends JComponent implements Constantes{
    public BufferedImage jugador, obstaculo, camino, adversario;
    //cordenada x y
    public int x;
    public int y;
    public char tipo;
    BufferedReader soldier[];
    public int indexSprite;
    //anchura altura
    //public int altura;
    //public int anchura;

    //const
    public Celda(int x, int y,char tipo) {
        this.x = x;
        this.y = y;
        this.tipo=tipo;
        //this.altura = x + sizeCell;
        //this.anchura = y + sizeCell;
        try{
            jugador = ImageIO.read(new File("images/jugador.png"));
            obstaculo = ImageIO.read(new File("images/obstaculo.png"));
            camino = ImageIO.read(new File("images/camino.png"));
            adversario = ImageIO.read(new File("images/adversario.png"));
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    //metodo llamado cuando repaint
    @Override
    public void update(Graphics g){
        switch(tipo){
            case 'J': g.drawImage(jugador, x, y, this); break;
            case 'O': g.drawImage(obstaculo, x, y, this); break;
            case 'C': g.drawImage(camino, x, y, this); break;
            case 'A': g.drawImage(adversario, x, y, this); break;
        }
    }
    
    //calcula si el clic esta dentro del area de la celda
    public boolean dentro_area(int xp,int yp){
        Rectangle r=new Rectangle(x,y,sizeCell,sizeCell);
        return r.contains(new Point(xp,yp));
    }
    
    // metodo para dibujar celda
    @Override
    public void paintComponent(Graphics graphics) {
        graphics.drawRect(x, y, sizeCell, sizeCell);
    }

}
