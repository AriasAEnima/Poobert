/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Eduardo Arias
 */
public class Tablero {
    private int[][] campoJuego;   
    private int cantidadCasillas;
    private int max;
    private int[] idab=new int[]{0,0,0,0};
    
    
    
    /**
     * @param args the command line arguments
     */
    

    public Tablero(int cubos) {
        cantidadCasillas=cubos;  
        max=(int) Math.sqrt(cantidadCasillas*3.5);
        campoJuego=new int[max][max];
        llenarCampo();      
        prepareTableroAleatorio();
        System.out.println("------------------------");
        printTablero();
        System.out.println("Desviacion: Izquierda "+idab[0]+" Derecha "+idab[1]+" Arriba "+idab[2]+" Abajo "+idab[3]);
    }
    
    /**
    * Establece un tablero aleatorio
    * Random ram=new Random(semilla);  
    */
    private void prepareTableroAleatorio(Random semilla){
        int currentX=1;
        int currentY=0;
        campoJuego[currentX][currentY]=0;
        ArrayList<String> dir=posiblesGenerado(currentX,currentY);
        String dirAle=dir.get(semilla.nextInt(dir.size()));       
        int faltantes=cantidadCasillas;
        while (faltantes>0){            
            switch(dirAle){
                case "abajo": 
                    currentY+=1; 
                    idab[3]+=1;
                    break;
                case "derecha": 
                    currentX+=1;
                    idab[1]+=1;
                    break;
                case "arriba": 
                    currentY-=1;
                    idab[2]+=1;
                    break;
                case "izquierda": 
                    currentX-=1;
                    idab[0]+=1;
                    break;
            }                       
            if (campoJuego[currentX][currentY]!=0){
                campoJuego[currentX][currentY]=0;
                faltantes-=1;                   
            }
            dir=posiblesGenerado(currentX,currentY);
            dirAle=dir.get(semilla.nextInt(dir.size()));
        }       
    }
    
     private ArrayList<String> posiblesGenerado(int currentX, int currentY) {
        ArrayList<String> ans=new ArrayList<>();
        if (currentX-1>=0) ans.add("izquierda");      
        if (currentY-1>=0) ans.add("arriba");
        if (currentY+currentX<max-1){            
            ans.add("derecha"); 
            ans.add("abajo");
        } 
        return ans;
    }
    
    private void prepareTableroAleatorio(){
        prepareTableroAleatorio(new Random());
    }
         
    private void llenarCampo() {
        for (int i = 0; i < campoJuego.length; i++) {
            for (int j = 0; j <campoJuego.length; j++) {
                campoJuego[i][j]=-1;
            }            
        }
    }    
    
    private void printTablero(){
        for (int i = 0; i < campoJuego.length; i++) {
            for (int j = 0; j <campoJuego.length; j++) {
                System.out.print(campoJuego[i][j]+" ");
            }      
            System.out.println();
        }
    }
}