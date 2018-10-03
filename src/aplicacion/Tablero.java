/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Eduardo Arias
 */
public class Tablero {
    private int[][] campoJuego;   
    private int cantidadCasillas;
    private int base;
    private int[] idab=new int[]{0,0,0,0};
    private final int[][] pascal=new int[][]{{6,21},{8,36},{10,55},{12,78},{14,105}};
    
    
    
    /**
     * @param args the command line arguments
     */
    

    public Tablero(int cubos) {
        cantidadCasillas=cubos;  
        base=cercano(cubos*2);
        campoJuego=new int[base][];
        llenarCampo();        
        prepareTableroAleatorio();        
        System.out.println("Desviacion: Izquierda "+idab[0]+" Derecha "+idab[1]+" Arriba "+idab[2]+" Abajo "+idab[3]);
    }
    
    /**
    * Establece un tablero aleatorio
    * Random ram=new Random(semilla);  
    */
    private void prepareTableroAleatorio(Random semilla){
        int currentX=0;
        int currentY=0;
        campoJuego[currentY][currentX]=0;
        ArrayList<String> dir=posiblesGenerado(currentY,currentX);
        String dirAle=dir.get(semilla.nextInt(dir.size()));       
        int faltantes=cantidadCasillas;
        while (faltantes>0){            
            switch(dirAle){
                case "abajo": 
                    currentY++; 
                    idab[3]++;
                    break;
                case "derecha": 
                    currentX++;
                    currentY++;
                    idab[1]++;
                    break;
                case "arriba": 
                    currentY--;
                    idab[2]++;
                    break;
                case "izquierda": 
                    currentX--;
                    currentY--;
                    idab[0]++;
                    break;
            }              
            
            if (campoJuego[currentY][currentX]!=0){
                campoJuego[currentY][currentX]=0;
                faltantes-=1;                   
            }
            dir=posiblesGenerado(currentY,currentX);
            dirAle=dir.get(semilla.nextInt(dir.size()));
        }       
    }
    
     private ArrayList<String> posiblesGenerado(int currentY, int currentX) {
        ArrayList<String> ans=new ArrayList<>();
        
        ;
        if (0<=currentY-1){
            if (currentX-1>=0)ans.add("izquierda");
            if (campoJuego[currentY-1].length>currentX) ans.add("arriba");  
        }         
        if (currentY+1<campoJuego.length){
            ans.add("abajo");
            if (currentX+1<campoJuego[currentY+1].length) ans.add("derecha");
        }       
        return ans;
    }
    
    private void prepareTableroAleatorio(){
        prepareTableroAleatorio(new Random());
    }
         
    private void llenarCampo() {
        for (int i=1; i<=campoJuego.length ;i++){
            int[] a=new int[i];
            Arrays.fill(a,-1);
            campoJuego[i-1]=a;
        }
    }    
    
   

    private int cercano(int cubos) {
        int ans=pascal[0][0];
        int cercania=Math.abs(pascal[0][1]-cubos);
        int i=0;
        while (i<pascal.length && Math.abs(pascal[i][1]-cubos)<=cercania){
            ans=pascal[i][0];
            cercania=Math.abs(pascal[i][1]-cubos);
            i++;
        }
        System.out.println("Base es "+ans+" con Cubos "+cubos+"----------");
        return ans;
    }

    public int[][] getCampo() {
        return campoJuego;
    }
    
    
}