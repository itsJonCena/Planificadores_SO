package sample.Planificadores;

import sample.Procesos;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jesus on 03/03/2016.
 */
public class SRTF {

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
//                System.out.println("Removido: " + "Proceso "+tTrans+"\t"+ nuevos.get(0).getTamaño()+"\t" + nuevos.get(0).getTiempo_llegada() + "\t" + nuevos.get(0).getPrioridad());
                proceso.remove(0);
            }
            tTrans++;
        }while(proceso.size()!=0);

        suma=suma/div;
        System.out.println("Tiempo medio: " +suma);
    }
}
