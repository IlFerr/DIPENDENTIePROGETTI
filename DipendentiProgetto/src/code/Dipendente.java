import java.io.Serializable;
import java.util.ArrayList;


public abstract class Dipendente implements Serializable {
    private String id;
    private String nome;
    private ArrayList<String> progettiAttivi = new ArrayList<>();

    public Dipendente(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Progetto[] getProgettiAttivi() {
        return progettiAttivi.toArray(new Progetto[0]);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addProgettoAttivo(String idProgetto) {
        progettiAttivi.add(idProgetto);
    }

    public void removeProgettoAttivo(String idProgetto) {
        progettiAttivi.remove(idProgetto);
    }
    
    public abstract String getClasse();
    
    @Override
    public String toString() {
        return "Dipendente{" + "id='" + id + '\'' + ", nome='" + nome + '\'' + '}';
    }
}
