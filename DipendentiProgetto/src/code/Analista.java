public class Analista extends Dipendente {
    public Analista(String id, String nome, int progettiAttivi) {
        super(id, nome, progettiAttivi);
    }

    public String getClasse() {
        return "Analista";
    }

    @Override
    public String toString() {
        return "Analista{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                '}';
    }
}
