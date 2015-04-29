package videojuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Pedro on 14-04-2015.
 */
public class Laberinto extends JComponent implements Constantes {

    public int ancho,largo;
    Lienzo lienzo;
    //las casillas n x m
    public Celda[][] celdas;
    public int i_jugador,j_jugador;
    Jugador jugador;
    public Laberinto(Lienzo l){
        celdas = new Celda[heightGameWorld][widthGameWorld];
        for (int i = 0; i < heightGameWorld; i++) {
            for (int j = 0; j < widthGameWorld; j++) {
                celdas[i][j] = new Celda(i + (i * sizeCell), j + (j * sizeCell), 'C');
            }
        }
        
        //Indico donde esta el jugador
        i_jugador=0;
        j_jugador=0;
        celdas[i_jugador][j_jugador].tipo='J';
        lienzo=l;
        jugador=new Jugador(this);
        
        this.ancho = widthGameWorld * sizeCell;
        this.largo = heightGameWorld * sizeCell;
        this.setSize(ancho, largo);
    }
/*
    public void update(Graphics g){
        
    }
  */  
    public void mover_arriba(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador > 0){
            if(celdas[i_jugador][j_jugador-1].tipo!='O'){
                celdas[i_jugador][j_jugador].tipo='C';
                j_jugador-=1;
                celdas[i_jugador][j_jugador].tipo='J';
            }else{
                System.out.println("Contra pared");
            }
        }else{
            System.out.println("Imposible subir");
        }
    }
    
    public void mover_abajo(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador < widthGameWorld-1){
            if(celdas[i_jugador][j_jugador+1].tipo!='O'){
                celdas[i_jugador][j_jugador].tipo='C';
                j_jugador+=1;
                celdas[i_jugador][j_jugador].tipo='J';
            }
        }else{
            System.out.println("Imposible bajar");
        }
    }
    
    public void mover_izquierda(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador > 0){
            if(celdas[i_jugador-1][j_jugador].tipo!='O'){
                celdas[i_jugador][j_jugador].tipo='C';
                i_jugador-=1;
                celdas[i_jugador][j_jugador].tipo='J';
            }
        }else{
            System.out.println("Imposible ir a izquierda");
        }
    }
    
    public void mover_derecha(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador < heightGameWorld-1){
            if(celdas[i_jugador+1][j_jugador].tipo!='O'){
                celdas[i_jugador][j_jugador].tipo='C';
                i_jugador+=1;
                celdas[i_jugador][j_jugador].tipo='J';
            }
        }else{
            System.out.println("Imposible ir a izquierda");
        }
    }
 
    public void chequearTecla(KeyEvent evento){
        if ( evento.getKeyCode() == 38){
            System.out.println("Mover arriba");
            mover_arriba();
        }
        if ( evento.getKeyCode() == 40){
            System.out.println("Mover abajo");
            mover_abajo();
        }
        if ( evento.getKeyCode() == 37){
            System.out.println("Mover izquierda");
            mover_izquierda();
        }
        if ( evento.getKeyCode() == 39){
            System.out.println("Mover derecha");
            mover_derecha();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        //update(g);
        for (int i = 0; i < heightGameWorld; i++) {

            for (int j = 0; j < widthGameWorld; j++) {

                celdas[i][j].paintComponent(g);
            }
        }
    }
    
@Override
    public void update(Graphics g){
        for(int i=0;i<heightGameWorld;i++){
            for(int j=0;j<widthGameWorld;j++){
                celdas[i][j].update(g);
                }
            }
        }


}
