package sample.Planificadores;
import sample.Procesos;

import java.util.ArrayList;

/**
 * Created by Jesus on 03/03/2016.
 */
public class FCFS {
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
        System.out.println("Tiempo medio de espera: " + medio);

    }


}
