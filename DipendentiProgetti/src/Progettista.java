
public class Progettista extends Dipendente {
    /**
     * Costruttore della classe Progettista
     * @param nome
     * @param id
     */
    public Progettista(String nome, String id) {
        super(nome, id);
    }

    /**
     * Restituisce una stringa che rappresenta il Progettista
     * @return stringa che rappresenta il Progettista
     */
    @Override
    public String toString() {
        return "Progettista: " + getNome() + ", ID: " + getId() + ", Progetti: " + getProgetti().length;
    }
}
