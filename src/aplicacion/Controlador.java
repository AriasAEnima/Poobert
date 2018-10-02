/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo Arias
 */
public class Controlador {
    List<Cuerpo> fichas ;  
    Tablero tab;

    public Controlador(int cubos,int pjs) {
        tab=new Tablero(cubos);
        fichas=Collections.synchronizedList(new ArrayList<>());
        prepareCuerpos(pjs,1,1,1);
        printCuerpos();
    }    
    
    public Controlador(){
        this(20,1);
    }
    public static void main(String[] args) {
       Controlador con=new Controlador();
    }

    private void prepareCuerpos(int pjs,int sn, int mb, int mine) {
       agregarTipoCuerpo("aplicacion.Qbert",pjs);
       agregarTipoCuerpo("aplicacion.Snake",sn);
       agregarTipoCuerpo("aplicacion.MegaBall",mb);
       agregarTipoCuerpo("aplicacion.Mina",mine);
    }   
    
    private void agregarTipoCuerpo(String tipo,int cantidad){
        Object object = null;        
        try {
           Class<?> cl = Class.forName(tipo);
           Constructor<?> cons = cl.getConstructor(int.class);
           for (int i=1; i<=cantidad ;i++){
               Object o = cons.newInstance(i);
               fichas.add((Cuerpo) o);
           }           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
    public static int[] posicionArriba(){
        return new int[]{0,0};
    }
    
    public static int[] posicionAbajo(){
        return new int[]{0,0};
    }

    private void printCuerpos() {
        synchronized (fichas) {  
            Iterator<Cuerpo> itr = fichas.iterator();  
            while (itr.hasNext()) {  
                System.out.println(itr.next().demeIdentificador());  
            }  
        }  
    }    
  
}
