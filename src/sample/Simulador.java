/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Jesus Guillermo
 */
public class Simulador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Random ra = new Random();
        int tamaño,tiempo_llegada,prioridad;
        int rango = 30;
        int numprocess = 5;
        ArrayList<Procesos> proceso = new ArrayList<>();
//        for (int i = 0; i < numprocess; i++) {
//            tamaño = (int)(Math.random()*(rango-1+1)+1);
//            tiempo_llegada = ra.nextInt(rango);
//            prioridad = (int)(Math.random()*(rango-1+1)+1);
//            if(i == 0) {   
//                Procesos p = new Procesos(tamaño,0, prioridad,"proceso " + (i+1));
//                proceso.add(p);
//            }
//            else{
//                Procesos p = new Procesos(tamaño,tiempo_llegada, prioridad,"proceso " + (i+1));
//                proceso.add(p);
//            }
//            
//        }
        
        proceso.add(new Procesos(3, 0, 4,"proceso 1"));
        proceso.add(new Procesos(5, 1, 1,"proceso 2"));
        proceso.add(new Procesos(2, 3, 5,"proceso 3"));
        proceso.add(new Procesos(5, 9, 3,"proceso 4"));
        proceso.add(new Procesos(5, 12, 2,"proceso 5"));

        Collections.sort(proceso);

        
        Algoritmos_de_Procesos.fcfs(proceso);
        Algoritmos_de_Procesos.sjf(proceso);
        Algoritmos_de_Procesos.prioridad(proceso);
        Algoritmos_de_Procesos.Round_Robin(proceso);
        Algoritmos_de_Procesos.interrupcion(proceso);
       
        
        // TODO code application logic here
    }  
}
