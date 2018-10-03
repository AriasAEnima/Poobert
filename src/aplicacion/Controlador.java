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
        prepareCuerpos(pjs,2,3,4);
       
        System.out.println("------------------------");
        Printer.printTablero(tab.getCampo());
        Printer.printCuerpos(fichas);
    }    
    
    public Controlador(){
        this(10,1);
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
    
         
    
    
    
    
    
    
    
    
    
    
    
    static class Printer{
        static void printCuerpos(List<Cuerpo> fichas) {
            synchronized (fichas) {  
                Iterator<Cuerpo> itr = fichas.iterator();  
                while (itr.hasNext()) {  
                    System.out.println(itr.next().demeIdentificador());  
                }  
            }  
        }       
        static void printTablero(int[][] campoJuego){
            int n=campoJuego[campoJuego.length-1].length;
            String line="";
            for (int k=1; k<=n; k++){              
                line+=rept(n/2 - (k+1)/2,'H')+rept(k%2,'.');
                for (int j=0; j<campoJuego[k-1].length;j++){
                    line+=campoJuego[k-1][j];
                }
                System.out.println(line);
                line="";
            }
        }
        
        static String rept(int cantidad,char sb){
            String ans="";
            for (int i=1; i<=cantidad; i++){
                ans+=sb;
            }
            return ans;
        }
   
    }



}     

