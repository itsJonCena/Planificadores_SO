package sample;

/**
 * Created by Alex on 23/02/16.
 */
public class Proceso {
    private String id;
    private int tiempoLlegada;
    private int tiempoProcesador;
    private int prioridad;

    public void setId(String id){
        this.id=id;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public void setTiempoProcesador(int tiempoProcesador) {
        this.tiempoProcesador = tiempoProcesador;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getTiempoProcesador() {
        return tiempoProcesador;
    }

    public String getId() {
        return id;
    }
}
