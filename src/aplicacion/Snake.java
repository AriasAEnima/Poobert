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
public class Snake extends Enemigo {
    int id;

    public Snake(int id) {
        super();
        this.id=id;
    }

    

    @Override
    public int[] posicionOptimaInicial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String demeIdentificador() {
          return "Snake#"+id;
    }

    @Override
    public int[] nuevoMovimiento(ArrayList<Cuerpo> fichas, int[][] campo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   

    
    
}
