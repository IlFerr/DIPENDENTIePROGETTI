import java.io.Serializable;
import java.time.LocalDateTime;

public class Storico implements Serializable {
    private String azione;
    private LocalDateTime data;
    private String dettagli;

    private static final long serialVersionUID = 1L;

    public Storico(String azione, String dettagli) {
        this.azione = azione;
        this.data = LocalDateTime.now();
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

    @Override
    public String toString() {
        return "Storico{" + "azione='" + azione + '\'' + ", data=" + data + ", dettagli='" + dettagli + '\'' + '}';
    }
}
