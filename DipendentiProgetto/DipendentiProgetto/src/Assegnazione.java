import java.time.LocalDate;

public class Assegnazione {
    private Dipendente dipendente;
    private Progetto progetto;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public Assegnazione(Dipendente dipendente, Progetto progetto, LocalDate dataInizio, LocalDate dataFine) {
        this.dipendente = dipendente;
        this.progetto = progetto;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String toString() {
        return dipendente + " assegnato a " + progetto + " dal " + dataInizio + " al " + dataFine;
    }
}
