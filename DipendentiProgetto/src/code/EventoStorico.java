import java.time.LocalDateTime;

public class EventoStorico {
    private String tipoOperazione;
    private String oggettoCoinvolto;
    private LocalDateTime timestamp;

    public EventoStorico(String tipoOperazione, String oggettoCoinvolto, LocalDateTime timestamp) {
        this.tipoOperazione = tipoOperazione;
        this.oggettoCoinvolto = oggettoCoinvolto;
        this.timestamp = timestamp;
    }

    public EventoStorico(String tipoOperazione, String oggettoCoinvolto) {
        this(tipoOperazione, oggettoCoinvolto, LocalDateTime.now());
    }

    public String toCSV() {
        return tipoOperazione + "," + oggettoCoinvolto + "," + timestamp;
    }

    public static EventoStorico fromCSV(String riga) {
        String[] campi = riga.split(",", 4);
        return new EventoStorico(campi[0], campi[1], LocalDateTime.parse(campi[2]));
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + tipoOperazione + " - " + oggettoCoinvolto;
    }
}
