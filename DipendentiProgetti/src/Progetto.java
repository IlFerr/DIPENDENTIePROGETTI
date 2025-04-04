
import java.time.LocalDate;
import java.util.ArrayList;


public class Progetto {
    private String nome;
    private String id;
    private String descrizione;
    private int stato;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private double budget;
    private ArrayList<String> file;

    /**
     * Costruttore della classe Progetto
     * @param nome
     * @param id
     * @param descrizione
     * @param stato
     * @param dataInizio
     * @param dataFine
     * @param budget
     */
    public Progetto(String nome, String id, String descrizione, int stato, LocalDate dataInizio, LocalDate dataFine, double budget) {
        this.nome = nome;
        this.id = id;
        this.descrizione = descrizione;
        this.stato = stato;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.budget = budget;
    }
    
    /**
     * Restituisce il nome del progetto
     * @param nome
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce l'id del progetto
     * @param id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Restituisce la descrizione del progetto
     * @param descrizione
     * @return
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Restituisce lo stato del progetto
     * @param stato
     * @return
     */
    public int getStato() {
        return stato;
    }

    /**
     * Restituisce la data di inizio del progetto
     * @param dataInizio
     * @return
     */
    public LocalDate getDataInizio() {
        return dataInizio;
    }

    /**
     * Restituisce la data di fine del progetto
     * @param dataFine
     * @return
     */
    public LocalDate getDataFine() {
        return dataFine;
    }

    /**
     * Restituisce il budget del progetto
     * @param budget
     * @return
     */
    public double getBudget() {
        return budget;
    }

    /**
     * Setta il nome del progetto
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Setta l'id del progetto
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Setta la descrizione del progetto
     * @param descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Setta lo stato del progetto
     * @param stato
     */
    public void setStato(int stato) {
        if (stato < 0 || stato > 4) throw new IllegalArgumentException("Stato non valido. Deve essere compreso tra 0 e 4.");
        this.stato = stato;
    }

    /**
     * Setta la data di inizio del progetto
     * @param dataInizio
     */
    public void setDataInizio(LocalDate dataInizio) {
        if (dataInizio.isBefore(LocalDate.now())) throw new IllegalArgumentException("La data di inizio deve essere futura.");
        this.dataInizio = dataInizio;
    }

    /**
     * Setta la data di fine del progetto
     * @param dataFine
     */
    public void setDataFine(LocalDate dataFine) {
        if (dataFine.isBefore(dataInizio)) throw new IllegalArgumentException("La data di fine deve essere successiva alla data di inizio.");
        this.dataFine = dataFine;
    }

    /**
     * Setta il budget del progetto
     * @param budget
     */
    public void setBudget(double budget) {
        if (budget < 0) throw new IllegalArgumentException("Il budget deve essere maggiore o uguale a zero.");
        this.budget = budget;
    }

    /**
     * Setta i file del progetto
     * @param file
     */
    public String[] getFile() {
        return file.toArray(new String[0]);
    }

    /**
     * Setta i file del progetto
     * @param file
     */
    public void addFile(String file) {
        this.file.add(file);
    }

    /**
     * Setta i file del progetto
     * @param file
     */
    public void removeFile(String file) {
        this.file.remove(file);
    }
}
