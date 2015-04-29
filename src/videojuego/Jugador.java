/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static videojuego.Constantes.heightGameWorld;
import static videojuego.Constantes.widthGameWorld;

/**
 *
 * @author yoxx7_000
 */
public class Jugador implements Constantes {
    
    public Laberinto laberinto ;
    public int i_jugador , j_jugador ;
    
    public Jugador (Laberinto l){
        
        laberinto=l;
        i_jugador=0;
        j_jugador=0;
        l.celdas[i_jugador][j_jugador].tipo='J';
        
    }
    
    
    
    
     public void mover_arriba(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador > 0){
            if(laberinto.celdas[i_jugador][j_jugador-1].tipo!='O'){
                laberinto.celdas[i_jugador][j_jugador].tipo='C';
                j_jugador-=1;
                
                if(laberinto.celdas[i_jugador][j_jugador].tipo!='A'){
                    
                laberinto.celdas[i_jugador][j_jugador].tipo='J';
                }
                else{
                    JOptionPane.showMessageDialog(null, "muerto :(");
                    System.out.println("mauri weko");
                }
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
            if(laberinto.celdas[i_jugador][j_jugador+1].tipo!='O'){
                laberinto.celdas[i_jugador][j_jugador].tipo='C';
                j_jugador+=1;
                if(laberinto.celdas[i_jugador][j_jugador].tipo!='A'){
                    
                laberinto.celdas[i_jugador][j_jugador].tipo='J';
                }
                else{
                    JOptionPane.showMessageDialog(null, "muerto :(");
                }
                
            }
        }else{
            System.out.println("Imposible bajar");
        }
    }
    
    public void mover_izquierda(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador > 0){
            if(laberinto.celdas[i_jugador-1][j_jugador].tipo!='O'){
                laberinto.celdas[i_jugador][j_jugador].tipo='C';
                i_jugador-=1;
                
                if(laberinto.celdas[i_jugador][j_jugador].tipo!='A'){
                    
                laberinto.celdas[i_jugador][j_jugador].tipo='J';
                }
                else{
                    JOptionPane.showMessageDialog(null, "muerto :(");
                }
              
            }
        }else{
            System.out.println("Imposible ir a izquierda");
        }
    }
    
    public void mover_derecha(){
        System.out.println("Jugador esta en:"+i_jugador+" ,"+j_jugador);
        if(j_jugador < heightGameWorld-1){
            if(laberinto.celdas[i_jugador+1][j_jugador].tipo!='O'){
                laberinto.celdas[i_jugador][j_jugador].tipo='C';
                i_jugador+=1;
                
                if(laberinto.celdas[i_jugador][j_jugador].tipo!='A'){
                    
                laberinto.celdas[i_jugador][j_jugador].tipo='J';
                }
                else{
                    JOptionPane.showMessageDialog(null, "muerto :(");
                }
                
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
    
    public void paintComponent(Graphics g) {
        //update(g);
        for (int i = 0; i < heightGameWorld; i++) {

            for (int j = 0; j < widthGameWorld; j++) {

                laberinto.celdas[i][j].paintComponent(g);
            }
        }
    }
    
    
}
