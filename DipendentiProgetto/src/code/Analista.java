public class Analista extends Dipendente {
    public Analista(String id, String nome) {
        super(id, nome);
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
