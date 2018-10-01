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
public class poobertLogic {
    private int[][] campoJuego;
    private ArrayList<Cuerpo> cuerpos;
    private int cantidadCasillas;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       poobertLogic game=new poobertLogic(20);
    }

    public poobertLogic(int cubos) {
        cantidadCasillas=cubos;  
        int max=(int) (Math.sqrt(cantidadCasillas*1.7));
        campoJuego=new int[max][max];
        llenarCampo();
        System.out.println(campoJuego[0][0]);
        //prepareTableroAleatorio();
    }
    
    /**
    * Establece un tablero aleatorio
    * Random ram=new Random(semilla);  
    */
    private void prepareTableroAleatorio(Random semilla){
        int currentX=1;
        int currentY=0;
        ArrayList<String> dir=posiblesGenerado(currentX,currentY);
        String dirAle=dir.get(semilla.nextInt(dir.size()-1));       
        int faltantes=cantidadCasillas;
        while (faltantes>0){
            switch(dirAle){
                case "abajo": 
                    currentY+=1; 
                case "derecha": 
                    currentX+=1;
                case "arriba": 
                    currentY-=1;
                case "izquierda": 
                    currentX-=1;
            }  
            if (campoJuego[currentX][currentY]!=0){
                campoJuego[currentX][currentY]=0;
                faltantes-=1;
            }
        }       
    }
    
     private ArrayList<String> posiblesGenerado(int currentX, int currentY) {
        ArrayList<String> ans=new ArrayList<>();
        if (currentX-1>0) ans.add("izquierda");      
        if (currentY-1>0) ans.add("arriba");
        if (currentY+currentX<cantidadCasillas/2){
            ans.add("derecha"); 
            ans.add("abajo");
        } 
        return ans;
    }
    
    private void prepareTableroAleatorio(){
        prepareTableroAleatorio(new Random());
    }
    
    
    private int[] posicionOptimaInicial(Cuerpo objetivo){
        int[] ans=new int[]{0,0};
        if (objetivo instanceof Mina){
            ans=aleatorioNoEsquinas();
        }else{
        }
        return ans;
    }

    
	
    private int[] aleatorioNoEsquinas() {
        return new int[]{0,0};
    }

    private void llenarCampo() {
        for (int i = 0; i < campoJuego.length; i++) {
            for (int j = 0; j <campoJuego.length; j++) {
                campoJuego[i][j]=-1;
            }            
        }
    }    
}
