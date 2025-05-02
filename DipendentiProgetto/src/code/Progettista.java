public class Progettista extends Dipendente {
    public Progettista(String nome, String id, int progettiAttivi) {
        super(nome, id, progettiAttivi);
    }

    public String getClasse() {
        return "Progettista";
    }

    @Override
    public String toString() {
        return super.toString() + " [Progettista]";
    }
}