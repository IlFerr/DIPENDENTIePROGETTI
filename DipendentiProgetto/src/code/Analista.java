public class Analista extends Dipendente {
    public Analista(String id, String nome) {
        super(id, nome);
    }

    @Override
    public String toString() {
        return "Analista{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                '}';
    }
}
