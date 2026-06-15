package Refactorizacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventosAnuales extends EventosAnuales2 {

    public EventosAnuales(int eventosAlAnno) {
        int eventosAlAnno1 = eventosAlAnno;
        this.setEventosAlAnno(eventosAlAnno1);
    }

    public int getTotalDelTiempo() {
        int i = 0;
        int duracionTotal = i;
        return extracted(duracionTotal);
    }

    public String[] ObservacionEventos(String nombreEvento) {
        String[] observacionesArray = null;
        for (Evento evento : eventos) {
            if (evento.getNombreEvento().equalsIgnoreCase(nombreEvento)) {
                List<String> listaObservaciones = evento.getObservaciones();
                observacionesArray = new String[listaObservaciones.size()];
                for (int i = 0; i < observacionesArray.length; i++)
                    observacionesArray[i] = listaObservaciones.get(i);
            }
        }
        return observacionesArray;
    }
    public List<Evento> getEventoPorTipo (TipoEvento tipoEvento) {
        List<Evento> eventosPorTipo = new ArrayList<>();
        for (Evento evento : eventos)
            if (evento.getTipoEvento().equals(tipoEvento))
                eventosPorTipo.add(evento);
        return eventosPorTipo;
    }
    public List<Evento> getEventoPorFecha (LocalDate fechaEvento) {
        List<Evento> eventosPorFecha = new ArrayList<>();
        for (Evento evento : eventos)
            if (evento.getFechaEvento().equals(fechaEvento))
                eventosPorFecha.add(evento);
        return eventosPorFecha;
    }

    public void setEventosAlAnno(int eventosAlAnno) {
        this.eventosAlAnno = eventosAlAnno;
    }
}
