import java.io.Serializable;
import java.time.LocalDate;

public class Progetto implements Serializable{
    private String id;              // ID univoco del progetto
    private String nome;            // Nome del progetto
    private int stato;              // Stato del progetto (0: in corso, 1: completato, 2: annullato, 3: scaduto)
    private String descrizione;     // Descrizione del progetto
    private double budget;          // Budget del progetto
    private LocalDate dataInizio;   // Data di inizio del progetto
    private LocalDate dataFine;     // Data di fine del progetto
    private String file;            // File associato al progetto (Project charter, preventivi, nulla osta…), è un semplice elenco con i nomi dei file

    private static final long serialVersionUID = 1L; // ID di serializzazione

    public Progetto(String id, String nome, int stato, String descrizione, double budget, LocalDate dataFine, String file) {
        this.id = id;
        this.nome = nome;
        this.stato = stato;
        this.descrizione = descrizione;
        this.budget = budget;
        this.dataFine = dataFine;
        this.file = file;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getStato() {
        return stato;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getBudget() {
        return budget;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public String getFile() {
        return file;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStato(int stato) {
        this.stato = stato;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setDataFine(LocalDate dataFine) {
        if (dataFine.isBefore(dataInizio)) {
            throw new IllegalArgumentException("La data di fine non può essere prima della data di inizio.");
        }
        this.dataFine = dataFine;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Progetto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", stato=" + stato +
                ", descrizione='" + descrizione + '\'' +
                ", budget=" + budget +
                ", dataFine=" + dataFine +
                ", file='" + file + '\'' +
                '}';
    }
}
