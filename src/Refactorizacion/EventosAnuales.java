package Refactorizacion;

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

    public void setEventosAlAnno(int eventosAlAnno) {
        this.eventosAlAnno = eventosAlAnno;
    }
}
