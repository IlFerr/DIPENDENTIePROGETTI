import java.time.LocalDateTime;

public class EventoStorico {
    private String tipoOperazione;
    private String oggettoCoinvolto;
    private LocalDateTime timestamp;
    private String descrizione;

    public EventoStorico(String tipoOperazione, String oggettoCoinvolto, LocalDateTime timestamp, String descrizione) {
        this.tipoOperazione = tipoOperazione;
        this.oggettoCoinvolto = oggettoCoinvolto;
        this.timestamp = timestamp;
        this.descrizione = descrizione;
    }

    public EventoStorico(String tipoOperazione, String oggettoCoinvolto, String descrizione) {
        this(tipoOperazione, oggettoCoinvolto, LocalDateTime.now(), descrizione);
    }

    public String getTipoOperazione() {
        return tipoOperazione;
    }

    public String getOggettoCoinvolto() {
        return oggettoCoinvolto;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String toCSV() {
        return tipoOperazione + "," + oggettoCoinvolto + "," + descrizione + "," + timestamp;
    }

    public static EventoStorico fromCSV(String riga) {
        String[] campi = riga.split(",", 4);
        return new EventoStorico(campi[0], campi[1], LocalDateTime.parse(campi[2]), campi[3]);
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + tipoOperazione + " - " + oggettoCoinvolto + ": " + descrizione;
    }
}
