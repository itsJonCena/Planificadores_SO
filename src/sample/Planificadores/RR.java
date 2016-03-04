package sample.Planificadores;

import sample.Procesos;

import java.util.ArrayList;

/**
 * Created by Jesus on 03/03/2016.
 */
public class RR {
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
                    //gant.add("nuevos " + (i+1));
                    gant.add(lista_proceso.get(i).nombre_proceso);
                    cont+= q;
                    gant_value.add(cont);
                }
                else{
                    if(auxiliar.get(i) != 0){
                        gant.add(lista_proceso.get(i).nombre_proceso);
                        //gant.add("nuevos " + (i+1));
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
                if(gant.get(j).equals("nuevos " + (i+1))){
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
            if(lista_proceso.get(i).getNombre_proceso().equals("nuevos " + (n+1)))
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
