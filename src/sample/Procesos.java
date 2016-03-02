/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.Queue;

/**
 *
 * @author Jesus Guillermo
 */
public class Procesos implements Comparable<Procesos>{
    String nombre_proceso;
    int reten;
    boolean reg=true;
    int tiempo_llegada;
    int tamaño;
    int prioridad;
    public Procesos(int tamaño, int tiempo, int prioridad, String Nombre){
        tiempo_llegada = tiempo;
        this.tamaño = tamaño;
        this.prioridad = prioridad;
        nombre_proceso = Nombre;
    }
    
    public Procesos(){}
    public int getReten()
    {
        return reten;
    }
    public int getTiempo_llegada(){
        return tiempo_llegada;
    }
    
    public int getTamaño(){
        return tamaño;
    }
    
    public int getPrioridad(){
       return prioridad;
    }
    
   public String getNombre_proceso(){
       return nombre_proceso;
   }
    public void setReg()
    {
        reg=false;
    }
    public void getReg(){
        reg = true;
    }
    
    public void setTamaño(int y)
    {
        tamaño=y;
    }
    public int compareTo(Procesos p){
        if(reg){
            if(this.tiempo_llegada < p.tiempo_llegada){
                return -1;
             }
             else{
            if(this.tiempo_llegada > p.tiempo_llegada)
                return 1;
            }
        }
        else
        {
           if(this.tamaño < p.tamaño){
            return -1;
            }
            else{
                if(this.tamaño > p.tamaño)
                return 1;
            } 
        }
        return 0;
    }
    
    public String toString() {
            return getTamaño() + ":" + getTiempo_llegada()+ ":" + getPrioridad();
    }
    
}
