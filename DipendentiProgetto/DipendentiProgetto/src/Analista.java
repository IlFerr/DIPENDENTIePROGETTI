public class Analista extends Dipendente {
    public Analista(String nome, String id) {
        super(nome, id);
    }

    public String toString() {
        return super.toString() + " [Analista]";
    }
}
