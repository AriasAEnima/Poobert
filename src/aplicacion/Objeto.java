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
public abstract class Objeto extends Cuerpo {
    public abstract void modify(Cuerpo pj);
    public abstract int[] reubicar();
}
