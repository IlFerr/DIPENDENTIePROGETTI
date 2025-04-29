import java.time.LocalDateTime;

public class EventoStorico {
    private String tipoOperazione;
    private String oggettoCoinvolto;
    private String dettaglio;
    private LocalDateTime timestamp;

    public EventoStorico(String tipoOperazione, String oggettoCoinvolto, String dettaglio, LocalDateTime timestamp) {
        this.tipoOperazione = tipoOperazione;
        this.oggettoCoinvolto = oggettoCoinvolto;
        this.dettaglio = dettaglio;
        this.timestamp = timestamp;
    }

    public EventoStorico(String tipoOperazione, String oggettoCoinvolto, String dettaglio) {
        this(tipoOperazione, oggettoCoinvolto, dettaglio, LocalDateTime.now());
    }

    public String toCSV() {
        return tipoOperazione + "," + oggettoCoinvolto + "," + dettaglio.replace(",", ";") + "," + timestamp;
    }

    public static EventoStorico fromCSV(String riga) {
        String[] campi = riga.split(",", 4);
        return new EventoStorico(
            campi[0],
            campi[1],
            campi[2],
            LocalDateTime.parse(campi[3])
        );
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + tipoOperazione + " - " + oggettoCoinvolto + " - " + dettaglio;
    }
}
