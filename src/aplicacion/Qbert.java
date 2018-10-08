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
public class Qbert extends Jugador{
    int id;

    public Qbert(int id) {
        super();
        this.id=id;
        int[] opt=posicionOptimaInicial();
        setPos(opt[0],opt[1]);
    }

        
    
    @Override
    public String demeIdentificador() {
          return "Qbert#"+id;
    }
   
    
   
    @Override
    public int[] posicionOptimaInicial() {
       return new int[]{0,0};
    }    

    @Override
    public void move(int x, int y) {
        setPos(x,y);
    }
        
}
