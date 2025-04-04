import java.util.ArrayList;

public class Dipendente {
    private String nome; // Nome del dipendente
    private String id; // ID del dipendente
    private ArrayList<Progetto> progetti = new ArrayList<>(); // Lista dei progetti associati al dipendente
    
    /**
     * Costruttore della classe Dipendente.
     * @param nome Nome del dipendente.
     * @param id ID del dipendente.
     */
    public Dipendente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    /**
     * Restituisce il nome del dipendente.
     * @return Nome del dipendente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce l'ID del dipendente.
     * @return ID del dipendente.
     */
    public String getId() {
        return id;
    }

    /**
     * Imposta il nome del dipendente.
     * @param nome Nome del dipendente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Imposta l'ID del dipendente.
     * @param id ID del dipendente.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Restituisce la lista dei progetti associati al dipendente.
     * @return Array di progetti.
     */
    public Progetto[] getProgetti() {
        return progetti.toArray(new Progetto[0]);
    }

    /**
     * Aggiunge un progetto alla lista dei progetti del dipendente.
     * @param progetto Progetto da aggiungere.
     */
    public void addProgetto(Progetto progetto) {
        progetti.add(progetto);
    }

    /**
     * Rimuove un progetto dalla lista dei progetti del dipendente.
     * @param progetto Progetto da rimuovere.
     */
    public void removeProgetto(Progetto progetto) {
        progetti.remove(progetto);
    }

    /**
     * Restituisce una rappresentazione in forma di stringa del dipendente.
     * @return Stringa che rappresenta il dipendente.
     */
    @Override
    public String toString() {
        return "Dipendente: " + nome + ", ID: " + id + ", Progetti: " + progetti.size();
    }
    
}
