
import java.util.ArrayList;

public class TeamManager extends Dipendente {
    private String nomeTeam;
    private ArrayList<Dipendente> membriTeam = new ArrayList<>(); // Lista dei membri del team
    private String progetto; // Progetto associato al team

    public TeamManager(String id, String nome, int progettiAttivi, String nomeTeam, String progetto) {
        super(id, nome, progettiAttivi);
        this.nomeTeam = nomeTeam;
        this.progetto = progetto;
    }

    // Getters
    public String getNomeTeam() {
        return nomeTeam;
    }

    public String getProgetto() {
        return progetto;
    }

    // Setter
    public void setNomeTeam(String nomeTeam) {
        this.nomeTeam = nomeTeam;
    }

    public void setProgetto(String progetto) {
        this.progetto = progetto;
    }

    // Aggiunta e rimozione membri del team
    public void aggiungiMembroTeam(Dipendente dipendente) {
        if(membriTeam.contains(dipendente)) throw new IllegalArgumentException("Il dipendente è gia presente nel team");
        membriTeam.add(dipendente);
        dipendente.setProgettiAttivi(dipendente.getProgettiAttivi() + 1);
    }

    public void rimuoviMembroTeam(Dipendente dipendente) {
        if(!membriTeam.contains(dipendente)) throw new IllegalArgumentException("Il dipendente non è presente nel team");
        membriTeam.remove(dipendente);
        dipendente.setProgettiAttivi(dipendente.getProgettiAttivi() - 1);
    }

    // Restituisce un array di Dipendente
    public Dipendente[] getMembriTeam() {
        return membriTeam.toArray(new Dipendente[0]);
    }

    public String getClasse() {
        return "TeamManager";
    }

    @Override
    public String toString() {
        return "TeamManager{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", nomeTeam='" + nomeTeam + '\'' +
                ", progetto=" + progetto +
                ", membriTeam=" + membriTeam +
                '}';
    }
}
