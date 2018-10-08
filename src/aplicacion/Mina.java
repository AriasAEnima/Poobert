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
public class Mina extends Objeto{
    int id;
    public Mina(int id) {
        super();
        this.id=id;
    }      

    @Override
    public void modify(Cuerpo pj) {
        pj.outGame();
    }

    @Override
    public int[] reubicar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] posicionOptimaInicial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String demeIdentificador() {
         return "Mina#"+id;
    }

    @Override
    public boolean reaccion(Cuerpo otro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
