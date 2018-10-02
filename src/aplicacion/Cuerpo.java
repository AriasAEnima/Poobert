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
    int x,y;
    public Cuerpo(){
    }
    
    public void setPos(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public int[] getPos(){
        return new int[]{x,y};
    }
      
    public abstract int[] posicionOptimaInicial();
    
    public abstract String demeIdentificador();
    
    
}
