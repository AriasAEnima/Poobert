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
public abstract class Enemigo extends Cuerpo {
    
    public abstract int[] nuevoMovimiento(ArrayList<Cuerpo> fichas, int[][] campo);
    
    @Override
    public boolean reaccion(Cuerpo otro) {
        boolean ans=false;
        if (otro instanceof Jugador){
            ((Jugador) otro).golpe();
            ans=true;
        }else if(otro instanceof Objeto){
            ((Objeto) otro).modify(this);
            ans=true;
        }
        return ans;
    }
}
