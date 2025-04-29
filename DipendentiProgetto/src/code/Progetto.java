import java.time.LocalDate;
import java.util.ArrayList;

public class Progetto {
    private String nome;
    private String id;
    private String descrizione;
    private int stato; // 0: Requisiti, 1: Non avviato, 2: In corso, 3: Completato, 4: Annullato
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private double budget;
    private ArrayList<String> file;

    public Progetto(String nome, String id, String descrizione, int stato, LocalDate dataInizio, LocalDate dataFine, double budget) {
        this.nome = nome;
        this.id = id;
        this.descrizione = descrizione;
        this.stato = stato;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.budget = budget;
        this.file = new ArrayList<>();
    }

    public void add(String file) {
        this.file.add(file);
    }

    public void remove(String file) {
        this.file.remove(file);
    }

    public String toString() {
        return "Progetto: " + nome + ", ID: " + id + ", Stato: " + stato + ", Budget: €" + budget;
    }
}
