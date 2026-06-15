package Refactorizacion;

import java.time.LocalDate;
import java.util.List;

public class MainEventos {
    public static void main(String[] args) {
        Evento eventoSanAnton = new Evento("San Antón", 600, TipoEvento.CARRERA,
                LocalDate.of(2027, 1, 17));
        System.out.println(eventoSanAnton);
        eventoSanAnton.addObservacion("nocturna");
        eventoSanAnton.addObservacion("antorchas");
        System.out.println(eventoSanAnton);
        EventosAnuales eventosAnuales = new EventosAnuales(2027);
        eventosAnuales.addEvento(eventoSanAnton);
        Evento eventoFutbol = new Evento("Partido de liga", 200,
                TipoEvento.PARTIDO, LocalDate.of(2027, 10, 17));
        eventosAnuales.addEvento(eventoFutbol);
        eventosAnuales.addEvento(new Evento("ajedrez", 100, TipoEvento.JUEGO_MESA,
                LocalDate.of(2027, 2, 28)));
        List<Evento> eventosCarrera = eventosAnuales.getEventoPorTipo(TipoEvento.CARRERA);
        System.out.println(eventosCarrera);


    }
}
