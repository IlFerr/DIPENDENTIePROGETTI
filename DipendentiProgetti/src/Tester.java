
public class Tester extends Dipendente {
    /**
     * Costruttore della classe Tester
     * @param nome
     * @param id
     */
    public Tester(String nome, String id) {
        super(nome, id);
    }

    /**
     * Restituisce una stringa che rappresenta il Tester
     * @return stringa che rappresenta il Tester
     */
    @Override
    public String toString() {
        return "Tester: " + getNome() + ", ID: " + getId() + ", Progetti: " + getProgetti().length;
    }
}
