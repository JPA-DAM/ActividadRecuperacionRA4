package Refactorizacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombreEvento;
    private int duracionEvento;
    private TipoEvento tipoEvento;
    private List<String> observaciones = new ArrayList<>();
    private LocalDate fechaEvento;

    public Evento(String nombreEvento, int duracionEvento, TipoEvento tipoEvento,
                  LocalDate fechaEvento) {
        this.nombreEvento = nombreEvento;
        this.duracionEvento = duracionEvento;
        this.tipoEvento = tipoEvento;
        this.fechaEvento = fechaEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public int getDuracionEvento() {
        return duracionEvento;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public List<String> getObservaciones() {
        return observaciones;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }
    public void addObservacion (String observacion) {
        observaciones.add(observacion);
    }
    public void cambiarDuracion (int duracionExtra) {
        duracionEvento += duracionExtra;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    //Carrera popula de Jaén-Pista de atletismo, necesidad de jueces-20 minutos-15/1/2024
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(nombreEvento).append('-').
                append(observaciones.toString().replaceAll("[\\[\\]]", "")).append('-').
                append(duracionEvento).append(" minutos-").
                append(fechaEvento.getDayOfMonth()).append('/').
                append(fechaEvento.getMonthValue()).append('/').
                append(fechaEvento.getYear());
        return sBuilder.toString();
    }
}
