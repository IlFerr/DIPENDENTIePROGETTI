
import java.util.ArrayList;

public class TeamManager extends Dipendente {
    private String nomeTeam;
    private int grandezzaTeam;
    private ArrayList<Dipendente> team = new ArrayList<>();
    private Progetto progetto;

    public TeamManager(String nome, String id, String nomeTeam, int grandezzaTeam, Progetto progetto) {
        super(nome, id);
        this.nomeTeam = nomeTeam;
        this.grandezzaTeam = grandezzaTeam;
        this.progetto = progetto;
    }

    public void addDipendente(Dipendente p) {
        team.add(p);
    }

    public void removeDipendente(Dipendente p) {
        team.remove(p);
    }

    // return array

    public String toString() {
        return super.toString() + ", Team: " + nomeTeam + ", Progetti Gestiti: " + grandezzaTeam;
    }
}
