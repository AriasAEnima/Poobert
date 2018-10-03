/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;

/**
 *
 * @author Eduardo Arias
 */
public abstract class Personaje extends Cuerpo{
    public Personaje(){
       super();
    }

     /**
     * Retorna un valor negativo (como puntos de vida) si le afecta moverse
     * hacia ese lugar, positivo si genera daño al oponente y 0 si no posible 
     * (neutral) una interaccion con este
     * @param otro Cuerpo
     * @return 
     */
    public abstract int reaccion(Cuerpo otro); 
    
    public abstract int[] nuevoMovimiento(ArrayList<Cuerpo> fichas,int[][] campo);
          
   
}
