/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jesus Guillermo
 */
public class Algoritmos_de_Procesos {
    
    public static void fcfs(ArrayList<Procesos> lista){
        System.out.println("Algoritmo FCFS");
        double time = 0;
        ArrayList<Procesos> lista_proceso = new ArrayList<>(lista);
        double result = 0;
        int [] llegada = new int[lista_proceso.size()];
        //int [] llegada1 = new int[lista_proceso.size()];
        System.out.println("Proceso\t\t" + "Rafaga\tTiempo\t" + "Prioridad\t");
        System.out.println();
        for (int i = 0; i < lista_proceso.size(); i++) {
            System.out.println(lista_proceso.get(i).getNombre_proceso() +"\t"+ lista_proceso.get(i).getTamaño()+"\t" + lista_proceso.get(i).getTiempo_llegada() + "\t" + lista_proceso.get(i).getPrioridad());
            if(i == 0){
                llegada[i] = lista_proceso.get(i).getTamaño();
            }
            else{
                llegada[i] = llegada[i-1] + lista_proceso.get(i).getTamaño();
            }
        }
        int entro = 0;
        for (int i = 0; i < lista_proceso.size()-1; i++) {
            entro = entro + lista_proceso.get(i).getTamaño();
            time = time + (entro-lista_proceso.get(i+1).getTiempo_llegada());
        }
        double medio = time/lista_proceso.size();
        System.out.println();
        System.out.println("Tiempo medio: " + medio);
        
    }
    
    public static void sjf(ArrayList<Procesos> lista) throws InterruptedException{
        System.out.println();
        ArrayList<Procesos> lista_proceso = new ArrayList<>(lista);
        int llegada = 0;
        double time = 0;
        ArrayList<Procesos> orden = new ArrayList<>();
        System.out.println("Algoritmo SJF");
        System.out.println();
        System.out.println("Proceso\t\t" + "Rafaga\tTiempo\t" + "Prioridad\t");
        while(!lista_proceso.isEmpty()) {
            int menor = 0;
            for (int i = 0; i < lista_proceso.size(); i++) {
                if(lista_proceso.get(i).getTiempo_llegada()<= llegada){
                    if(lista_proceso.get(menor).getTamaño() <= lista_proceso.get(i).getTamaño()){
                        menor = menor;
                    }else{
                        menor = i;
                    }
                }
            }
            System.out.println(lista_proceso.get(menor).getNombre_proceso() +"\t"+ lista_proceso.get(menor).getTamaño()+"\t" + lista_proceso.get(menor).getTiempo_llegada() + "\t" + lista_proceso.get(menor).getPrioridad());
            llegada = llegada + lista_proceso.get(menor).getTamaño();
            orden.add(lista_proceso.get(menor));
            lista_proceso.remove(menor);
        }
        int entro=0;
        System.out.println();
//        System.out.println("Simulacion: ");
//        for (int i = 0; i < orden.size(); i++) {
//            for (int j = 0; j < orden.get(i).getTamaño(); j++) {
//                System.out.print("#");
//                Thread.sleep(280);
//            }
//            System.out.print("|");
//        }
        for (int i = 0; i < orden.size()-1; i++) {
            entro = entro + orden.get(i).getTamaño();
            time = time + (entro-orden.get(i+1).getTiempo_llegada());
        }
        double medio = time/orden.size();
        System.out.println("Tiempo medio: " + medio);
    }
    public static void interrupcion(ArrayList<Procesos> lista){
        ArrayList<Procesos> lista_proceso = new ArrayList<>(lista);
         System.out.println("Algoritmo STRF");
        ArrayList<Procesos> proceso = new ArrayList<>();
        int div=lista_proceso.size();
        int tTrans = 1;
        int a;
        double suma=0;
        System.out.println("Proceso\t\t" + "Rafaga\tTiempo\t" + "Prioridad\t");
        System.out.println();
        for (int h = 0; h < lista_proceso.size(); h++) {
            System.out.println(lista_proceso.get(h).getNombre_proceso() +"\t"+ lista_proceso.get(h).getTamaño()+"\t" + lista_proceso.get(h).getTiempo_llegada() + "\t" + lista_proceso.get(h).getPrioridad());
   
        }
        System.out.println();
        do{
            if(lista_proceso.size()>0){
            for(int z=0;z<lista_proceso.size();z++){
                if(tTrans>=lista_proceso.get(z).tiempo_llegada)
                {
                    proceso.add(lista_proceso.get(z));
                    //System.out.println("Agregado: " + "Proceso "+tTrans+"\t"+ lista_proceso.get(z).getTamaño()+"\t" + lista_proceso.get(z).getTiempo_llegada() + "\t" + lista_proceso.get(z).getPrioridad());
                    lista_proceso.remove(z);
                }
            }
            }
            for(int m=0;m<proceso.size();m++){
                proceso.get(m).setReg();
            }
            Collections.sort(proceso);
            a=proceso.get(0).getTamaño()-1;
            proceso.get(0).setTamaño(a);
            if(proceso.get(0).getTamaño()<=0)
            {
                suma=(suma+tTrans)-(proceso.get(0).getTiempo_llegada()+proceso.get(0).getReten());
//                System.out.println("Removido: " + "Proceso "+tTrans+"\t"+ proceso.get(0).getTamaño()+"\t" + proceso.get(0).getTiempo_llegada() + "\t" + proceso.get(0).getPrioridad());
                proceso.remove(0);
            }
            tTrans++;
        }while(proceso.size()!=0);
        
        suma=suma/div;
        System.out.println("Tiempo medio: " +suma);
    }
    public static void prioridad(ArrayList<Procesos> lista) throws InterruptedException{
        System.out.println();
        ArrayList<Procesos> lista_proceso = new ArrayList<>(lista);
        int llegada = 0;
        double time = 0;
        ArrayList<Procesos> orden = new ArrayList<>();
        System.out.println("Algoritmo Prioridad");
        System.out.println();
        System.out.println("Proceso\t\t" + "Rafaga\tTiempo\t" + "Prioridad\t");
        while(!lista_proceso.isEmpty()) {
            int menor = 0;
            for (int i = 0; i < lista_proceso.size(); i++) {
                if(lista_proceso.get(i).getTiempo_llegada()<= llegada){
                    if(lista_proceso.get(menor).getPrioridad() <= lista_proceso.get(i).getPrioridad()){
                        menor = menor;
                    }else{
                        menor = i;
                    }
                }
            }
            System.out.println(lista_proceso.get(menor).getNombre_proceso() +"\t"+ lista_proceso.get(menor).getTamaño()+"\t" + lista_proceso.get(menor).getTiempo_llegada() + "\t" + lista_proceso.get(menor).getPrioridad());
            llegada = llegada + lista_proceso.get(menor).getTamaño();
            orden.add(lista_proceso.get(menor));
            lista_proceso.remove(menor);
        }
        int entro=0;
        System.out.println();
//        System.out.println("Simulacion: ");
//        for (int i = 0; i < orden.size(); i++) {
//            for (int j = 0; j < orden.get(i).getTamaño(); j++) {
//                System.out.print("#");
//                Thread.sleep(280);
//            }
//            System.out.print("|");
//        }
        for (int i = 0; i < orden.size()-1; i++) {
            entro = entro + orden.get(i).getTamaño();
            time = time + (entro-orden.get(i+1).getTiempo_llegada());
        }
        double medio = time/orden.size();
        System.out.println("Tiempo medio: " + medio);
    }
     public static void Round_Robin(ArrayList<Procesos> lista){
         System.out.println();
         ArrayList<Procesos> lista_proceso = new ArrayList<>(lista);
         for (int i = 0; i < lista_proceso.size(); i++) {
             lista_proceso.get(i).getReg();
         }
         System.out.println("Algoritmo Round Robin");
        int q = 6;
        int aux,cont = 0;
        System.out.println("Proceso\t\t" + "Rafaga\tTiempo\t" + "Prioridad\t");
        ArrayList<Integer> auxiliar = new ArrayList<>();
        ArrayList<String> gant = new ArrayList<>();
         ArrayList<Integer> gant_value = new ArrayList<>();
//         System.out.println("lista antes de entrar al for: " + lista_proceso);
        for (int i = 0; i < lista_proceso.size(); i++) {
            auxiliar.add(lista_proceso.get(i).getTamaño());
            System.out.println(lista_proceso.get(i).getNombre_proceso() +"\t"+ lista_proceso.get(i).getTamaño()+"\t" + lista_proceso.get(i).getTiempo_llegada() + "\t" + lista_proceso.get(i).getPrioridad());
        }
        
        
//        System.out.println(auxiliar);
        gant_value.add(0);
        while (validate(auxiliar)) {            
            for (int i = 0; i < auxiliar.size(); i++) {
                if(q < auxiliar.get(i)){
                    aux = auxiliar.get(i) - q;
                    auxiliar.set(i, aux);
                    //gant.add("proceso " + (i+1));
                    gant.add(lista_proceso.get(i).nombre_proceso);
                    cont+= q;
                    gant_value.add(cont);
                }
                else{
                    if(auxiliar.get(i) != 0){
                        gant.add(lista_proceso.get(i).nombre_proceso);
                        //gant.add("proceso " + (i+1));
                        cont+=auxiliar.get(i);
                        gant_value.add(cont);
                        auxiliar.set(i, 0);
                    }
                    else{
                        auxiliar.set(i, 0);
                    }
                    
                }
            }
//            System.out.println(auxiliar);
        }
//        System.out.println(gant_value);
//        gant_value.remove(gant_value.size()-1);
//        System.out.println(gant);
//        System.out.println(gant_value);
         System.out.println();
        System.out.println("Tiempo medio: " + calcular_TP(gant, gant_value,lista_proceso.size(), q, lista_proceso));
    }
    
    public static double calcular_TP(ArrayList<String> gant, ArrayList<Integer> gant_value, int n,int q,ArrayList<Procesos> lista_proceso){
        int resultado;
        int cont = 0;
        double T_promedio = 0;
        for (int i = 0; i < n; i++) {
            cont=0;
            resultado = 0;
            for (int j = gant.size()-1; j >= 0; j--) {
                if(gant.get(j).equals("proceso " + (i+1))){
                    if(cont  == 0){
                        resultado += gant_value.get(j);
                        cont = 1;
                    }
                    else{
                        resultado-= q;
                    }
                }
            }
           resultado = resultado - lista_proceso.get(getT_llegada(lista_proceso, i)).getTiempo_llegada();
           T_promedio += resultado;
           
        }
        return T_promedio/lista_proceso.size();
    }
    
    public static int getT_llegada(ArrayList<Procesos> lista_proceso, int n){
        for (int i = 0; i <lista_proceso.size(); i++) {
            if(lista_proceso.get(i).getNombre_proceso().equals("proceso " + (n+1)))
                return i;
        }
        return 0;
    }
    
    public static boolean validate(ArrayList<Integer> lista){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i) != 0)
                return true;
        }
        return false;
    }
}
