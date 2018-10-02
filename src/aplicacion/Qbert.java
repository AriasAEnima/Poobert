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
public class Qbert extends Personaje {
    int id;

    public Qbert(int id) {
        super();
        this.id=id;
        int[] opt=posicionOptimaInicial();
        setPos(opt[0],opt[1]);
    }

    
    public void cambiarPos(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String demeIdentificador() {
          return "Qbert#"+id;
    }

    @Override
    public int reaccion(Cuerpo otro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] posicionOptimaInicial() {
        return Controlador.posicionArriba();
    }    
}
