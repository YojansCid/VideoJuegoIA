package videojuego;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import javax.swing.JPanel;



import static videojuego.Constantes.heightGameWorld;
import static videojuego.Constantes.ruta;
import static videojuego.Constantes.widthGameWorld;



public class Lienzo extends Canvas implements Constantes {
   public  Laberinto laberinto;
   public Adversario adversario1, adversario2,adversario3,adversario4,
           adversario5,adversario6,adversario7,adversario8,adversario9,
           adversario10;
   public Image fondo;
    public Lienzo() {
        
        
        
        laberinto = new Laberinto(this);
        adversario1=new Adversario(laberinto);
        adversario2=new Adversario(laberinto);
        adversario3=new Adversario(laberinto);
        adversario4=new Adversario(laberinto);
        adversario5=new Adversario(laberinto);
        adversario6=new Adversario(laberinto);
        adversario7=new Adversario(laberinto);
        adversario8=new Adversario(laberinto);
        adversario9=new Adversario(laberinto);
        adversario10=new Adversario(laberinto);
       
        //color fondo
        this.setBackground(Color.CYAN);
        this.setSize(laberinto.ancho, laberinto.largo);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt){
                identificarCelda(evt);
                repaint();
            }
    });
        
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                laberinto.chequearTecla(e);
                repaint();
            }          
        });
        
        Timer lanzadorTareas = new Timer();
        lanzadorTareas.scheduleAtFixedRate(adversario1, 100, 1000);
        lanzadorTareas.scheduleAtFixedRate(adversario2, 0, 250);
        lanzadorTareas.scheduleAtFixedRate(adversario3, 0, 100);
        lanzadorTareas.scheduleAtFixedRate(adversario4, 0, 700);
        lanzadorTareas.scheduleAtFixedRate(adversario5, 0, 800);
        lanzadorTareas.scheduleAtFixedRate(adversario6, 0, 1100);
        lanzadorTareas.scheduleAtFixedRate(adversario7, 0, 5000);
        lanzadorTareas.scheduleAtFixedRate(adversario8, 0, 5000);
        lanzadorTareas.scheduleAtFixedRate(adversario9, 0, 500);
        lanzadorTareas.scheduleAtFixedRate(adversario10, 0, 100);
        
        
        
    }

    private void identificarCelda(java.awt.event.MouseEvent e){
        for(int i=0;i<heightGameWorld;i++){
            for (int j=0;j<widthGameWorld;j++){
                if(laberinto.celdas[i][j].dentro_area(e.getX(),e.getY())){
                    if ((e.getModifiers() & InputEvent.BUTTON1_MASK)==InputEvent.BUTTON1_MASK){
                        System.out.println("Boton derecho - "+"Poner Obstaculo");
                        laberinto.celdas[i][j].tipo='O';
                    }else{
                        System.out.println("Boton izq"+"poner adversario");
                        laberinto.celdas[i][j].tipo='A';
                    }
                }
            }
        }
    }
    
    private void identificarCasilla(MouseEvent evt){
        for(int i=0; i < heightGameWorld; i++)
            for(int j=0; j < widthGameWorld; j++)
                if(laberinto.celdas[i][j].dentro_area(evt.getX(),evt.getY())){
                    if((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
                        System.out.println("Boton derecho - " + "Poner obstaculo");
                        laberinto.celdas[i][j].tipo='O';
                    }else{
                        System.out.println("Boton izquierdo - " + "Poner adversario");
                        laberinto.celdas[i][j].tipo='A';
                    }
                }
    }
    
    // llamado la primera vez que se 'pinta'
    @Override
    public void paint(Graphics g) {
        laberinto.paintComponent(g);
     HiloMusica player=new HiloMusica(ruta+"/musica/guile.wav",3);
        player.run();
        
    }

    // llamado cuando se 'repinta'
    @Override
    public void update(Graphics g) {
        laberinto.update(g);
    }

}
