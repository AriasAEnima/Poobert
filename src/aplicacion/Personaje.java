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
public abstract class Personaje extends Cuerpo{
    public Personaje(int x, int y){
       super(x,y);
    }

    @Override
    public int reaccion(Cuerpo otro) {
        return (otro instanceof Mina)? -100:0;      
    }
    
    public abstract void cambiarPos(int x,int y);
}
