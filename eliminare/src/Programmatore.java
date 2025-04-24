
public class Programmatore extends Dipendente{
    private String linguaggio; // Linguaggio di programmazione del programmatore
    
    /**
     * Costruttore della classe Programmatore
     * @param nome
     * @param id
     * @param linguaggio
     */
    public Programmatore(String nome, String id, String linguaggio) {
        super(nome, id);
        this.linguaggio = linguaggio;
    }
    
    /**
     * Restituisce il linguaggio di programmazione
     * @return linguaggio di programmazione
     */
    public String getLinguaggio() {
        return linguaggio;
    }
    
    /**
     * Imposta il linguaggio di programmazione
     * @param linguaggio linguaggio di programmazione
     */
    public void setLinguaggio(String linguaggio) {
        this.linguaggio = linguaggio;
    }
    
    /**
     * Restituisce una stringa che rappresenta il Programmatore
     * @return stringa che rappresenta il Programmatore
     */
    @Override
    public String toString() {
        return "Programmatore: " + getNome() + ", ID: " + getId() + ", Linguaggio: " + linguaggio + ", Progetti: " + getProgetti().length;
    }
}
