package sample;

import java.util.ArrayList;
import java.util.Collections;
import sample.Controller;

/**
 * Created by Alex on 03/03/16.
 */
public class Modelo extends Thread {

    public static ArrayList<Procesos> nuevos = new ArrayList<>();

    @Override
    public void run() {

        nuevos.add(new Procesos(3, 0, 4,"nuevos 1"));
        nuevos.add(new Procesos(5, 1, 1,"nuevos 2"));
        nuevos.add(new Procesos(2, 3, 5,"nuevos 3"));
        nuevos.add(new Procesos(5, 9, 3,"nuevos 4"));
        nuevos.add(new Procesos(5, 12, 2,"nuevos 5"));


        Collections.sort(nuevos);


        Algoritmos_de_Procesos.fcfs(nuevos);
        try {
            Algoritmos_de_Procesos.sjf(nuevos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Algoritmos_de_Procesos.prioridad(nuevos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Algoritmos_de_Procesos.Round_Robin(nuevos);
        Algoritmos_de_Procesos.interrupcion(nuevos);


    }

    public ArrayList<Procesos> getNuevos() {
        return nuevos;
    }
}
