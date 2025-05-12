
public class TeamManager extends Dipendente {
    private int progettiFirmati;

    public TeamManager(String id, String nome, int progettiFirmati) {
        super(id, nome);
        this.progettiFirmati = 0;
    }

    // Getters
    public int getProgettiFirmati() {
        return progettiFirmati;
    }

    // Setter
    public void setProgettiFirmati(int progettiFirmati) {
        this.progettiFirmati = progettiFirmati;
    }

    public String getClasse() {
        return "TeamManager";
    }

    @Override
    public String toString() {
        return "TeamManager{" + "id='" + getId() + '\'' + ", nome='" + getNome() + '\'' + ", progettiFirmati=" + progettiFirmati;
    }
}
