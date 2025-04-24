public class TeamManager extends Dipendente {
    private String nomeTeam;
    private int grandezzaTeam;

    public TeamManager(String nome, String id, String nomeTeam, int grandezzaTeam) {
        super(nome, id);
        this.nomeTeam = nomeTeam;
        this.grandezzaTeam = grandezzaTeam;
    }

    public String toString() {
        return super.toString() + ", Team: " + nomeTeam + ", Progetti Gestiti: " + grandezzaTeam;
    }
}
