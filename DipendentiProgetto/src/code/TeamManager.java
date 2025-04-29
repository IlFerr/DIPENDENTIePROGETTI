
import java.util.ArrayList;

public class TeamManager extends Dipendente {
    private String nomeTeam;
    private ArrayList<Dipendente> membriTeam = new ArrayList<>(); // Lista dei membri del team
    private Progetto progetto; // Progetto associato al team

    public TeamManager(String id, String nome, String nomeTeam, Progetto progetto) {
        super(id, nome);
        this.nomeTeam = nomeTeam;
        this.progetto = progetto;
    }

    // Getters
    public String getNomeTeam() {
        return nomeTeam;
    }

    public String getProgetto() {
        return progetto.getNome();
    }

    // Setter
    public void setNomeTeam(String nomeTeam) {
        this.nomeTeam = nomeTeam;
    }

    // Aggiunta e rimozione membri del team
    public void addMembroTeam(Dipendente dipendente) {
        if(membriTeam.contains(dipendente)) throw new IllegalArgumentException("Il dipendente è gia presente nel team");
        membriTeam.add(dipendente);
    }

    public void removeMembroTeam(Dipendente dipendente) {
        if(!membriTeam.contains(dipendente)) throw new IllegalArgumentException("Il dipendente non è presente nel team");
        membriTeam.remove(dipendente);
    }

    // Restituisce un array di Dipendente
    public Dipendente[] getMembriTeam() {
        return membriTeam.toArray(new Dipendente[0]);
    }

    @Override
    public String toString() {
        return "TeamManager{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", nomeTeam='" + nomeTeam + '\'' +
                ", progetto=" + progetto.getNome() +
                ", membriTeam=" + membriTeam +
                '}';
    }
}
