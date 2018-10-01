/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author Eduardo Arias
 */
public abstract class Cuerpo {
    int[] pos;
    public Cuerpo(int x,int y){
        pos=new int[]{x,y};       
    }
    
    
    /**
     * Retorna un valor negativo (como puntos de vida) si le afecta moverse
     * hacia ese lugar, positivo si genera daño al oponente y 0 si no posible 
     * (neutral) una interaccion con este
     * @param otro Cuerpo
     * @return 
     */
    public abstract int reaccion(Cuerpo otro);
    
    
    
}
