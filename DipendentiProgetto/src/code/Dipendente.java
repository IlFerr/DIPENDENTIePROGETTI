import java.io.Serializable;
import java.util.ArrayList;


public abstract class Dipendente implements Serializable {
    private String id;
    private String nome;
    private int progettiAttivi = 0;

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

    public int getProgettiAttivi() {
        return progettiAttivi;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addProgettoAttivo() {
        progettiAttivi++;
    }

    public void removeProgettoAttivo() {
        progettiAttivi--;
    }
    
    public abstract String getClasse();
    
    @Override
    public String toString() {
        return "Dipendente{" + "id='" + id + '\'' + ", nome='" + nome + '\'' + '}';
    }
}
