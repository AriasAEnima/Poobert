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
public class MegaBall extends Enemigo{
    int id;

    public MegaBall(int id) {
        super();
        this.id=id;
    }

   
    @Override
    public String demeIdentificador() {
        return "Megaball#"+id;
    }
   

    @Override
    public int[] nuevoMovimiento(ArrayList<Cuerpo> fichas, int[][] campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public int[] posicionOptimaInicial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
