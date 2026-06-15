package Refactorizacion;

import java.util.List;

public interface Anuales {
    default int extracted(int duracionTotal) {
        for (Evento evento : eventos)
            duracionTotal += evento.getDuracionEvento();
        return duracionTotal;
    }

    Evento getEventoMasReciente();

    List<Evento> getEventosMasUnaHora();
}
