import java.time.LocalDateTime;

public class Storico {
    private String azione;
    private LocalDateTime data;
    private String dettagli;

    public Storico(String azione, LocalDateTime data, String dettagli) {
        this.azione = azione;
        this.data = data;
        this.dettagli = dettagli;
    }

    public Storico(String azione, String dettagli) {
        this.azione = azione;
        this.dettagli = dettagli;
    }

    public String getAzione() {
        return azione;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getDettagli() {
        return dettagli;
    }

    public String toCSV() {
        return azione + "," + data + "," + dettagli;
    }

    public static Storico fromCSV(String riga) {
        String[] campi = riga.split(",", 4);
        return new Storico(campi[0], LocalDateTime.parse(campi[1]), campi[2]);
    }

    @Override
    public String toString() {
        return "Storico{" + "azione='" + azione + '\'' + ", data=" + data + ", dettagli='" + dettagli + '\'' + '}';
    }
}
