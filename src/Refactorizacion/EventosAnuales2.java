package Refactorizacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class EventosAnuales2 implements Anuales {
    public static final int INT = 60;
    public static final int INT1 = 1;
    public static final int MONTH = 1;
    public static final int DAY_OF_MONTH = 1;
    protected int eventosAlAnno;
    protected List<Evento> eventos = new ArrayList<>();

    public void addEvento(Evento evento) {
        eventos.add(evento);
    }

    @Override
    public Evento getEventoMasReciente() {
        if (eventos.isEmpty() || eventos == null)
            return null;
        Evento eventoMasReciente = new Evento(null, 0, TipoEvento.CARRERA,
                LocalDate.of(getEventosAlAnno() - INT1, MONTH, DAY_OF_MONTH));
        for (Evento evento : eventos)
            if (evento.getFechaEvento().isAfter(eventoMasReciente.getFechaEvento()))
                eventoMasReciente = evento;
        return eventoMasReciente;
    }

    @Override
    public List<Evento> getEventosMasUnaHora() {
        List<Evento> eventosMasUnaHora = new ArrayList<>();
        for (Evento evento : eventos)
            if (evento.getDuracionEvento() > INT)
                eventosMasUnaHora.add(evento);
        return eventosMasUnaHora;
    }

    public int getEventosAlAnno() {
        return eventosAlAnno;
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
}
