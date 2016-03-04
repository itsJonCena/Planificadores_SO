package sample.Planificadores;

import sample.Procesos;

import java.util.ArrayList;

/**
 * Created by Jesus on 03/03/2016.
 */
public class Prioridad {
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

}
