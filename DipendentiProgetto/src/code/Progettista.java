public class Progettista extends Dipendente {
    public Progettista(String nome, String id) {
        super(nome, id);
    }

    public String getClasse() {
        return "Progettista";
    }

    @Override
    public String toString() {
        return super.toString() + " [Progettista]";
    }
}