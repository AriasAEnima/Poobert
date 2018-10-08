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
public abstract class Jugador  extends Cuerpo{
    private int puntaje;
    private char simbol;
    private int lifes;
    public void golpe(){
        lifes--;
    }
    public int getPuntaje(){
        return puntaje;
    }
    public char getSimbol(){
        return simbol;
    }    
    
    public boolean reaccion(Cuerpo otro) {
        boolean ans=false;
        if (otro instanceof Enemigo){
            golpe();
            ans=true;
        }else if (otro instanceof Objeto){
            ((Objeto) otro).modify(this);
            ans=true;
        }
        return ans;
    }
    public abstract void move(int x, int y);
}
