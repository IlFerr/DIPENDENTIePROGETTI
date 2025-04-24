
import java.time.LocalDate;

public class Assegnazione {
    private Dipendente dipendente; // Dipendente associato all'assegnazione
    private Progetto progetto; // Progetto associato all'assegnazione
    private LocalDate dataInizio; // Data di inizio dell'assegnazione
    private LocalDate dataFine; // Data di fine dell'assegnazione

    /**
     * Costruttore della classe Assegnazione.
     * @param dipendente Dipendente associato all'assegnazione.
     * @param progetto Progetto associato all'assegnazione.
     * @param dataInizio Data di inizio dell'assegnazione.
     * @param dataFine Data di fine dell'assegnazione.
     */
    public Assegnazione(Dipendente dipendente, Progetto progetto, LocalDate dataInizio, LocalDate dataFine) {
        this.dipendente = dipendente;
        this.progetto = progetto;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public Progetto getProgetto() {
        return progetto;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataInizio(LocalDate dataInizio) {
        if (dataInizio.isAfter(dataFine)) throw new IllegalArgumentException("La data di inizio non può essere dopo la data di fine.");
        this.dataInizio = dataInizio;
    }

    public void setDataFine(LocalDate dataFine) {
        if (dataFine.isBefore(dataInizio)) throw new IllegalArgumentException("La data di fine non può essere prima della data di inizio.");
        this.dataFine = dataFine;
    }
    
    public String toString() {
        return "Assegnazione: " + dipendente.getNome() + " al progetto " + progetto.getNome() + " dal " + dataInizio + " al " + dataFine;
    }
}
