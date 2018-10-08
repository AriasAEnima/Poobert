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
    private int x,y;
    private boolean ingame;
    public Cuerpo(){
        ingame=true;
    }
       
    
    public void setPos(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public int[] getPos(){
        return new int[]{x,y};
    }
    
    public boolean getInGame(){
        return ingame;
    }
    
    public void outGame(){
        ingame=false;
    }
    
     public void inGame(){
        ingame=true;
    }
    
      
    public abstract int[] posicionOptimaInicial();
    
    public abstract String demeIdentificador();
    
    public abstract boolean reaccion(Cuerpo otro);  
    
    
}
