import java.io.Serializable;

public abstract class Dipendente implements Serializable {
    private String id;                  // ID univoco del dipendente
    private String nome;                // Nome del dipendente
    private int progettiAttivi = 0;     // Numero di progetti attivi a cui il dipendente partecipa

    private static final long serialVersionUID = 1L;    // ID di serializzazione

    // Costruttore
    public Dipendente(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    // Getter
    public String getNome() {
        return nome;
    }

    public int getProgettiAttivi() {
        return progettiAttivi;
    }

    // Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Aumenta il numero di progetti attivi
    public void addProgettoAttivo() {
        progettiAttivi++;
    }

    // Diminuisce il numero di progetti attivi
    public void removeProgettoAttivo() {
        if(progettiAttivi != 0) progettiAttivi--;
    }

    public abstract String getClasse();
    
    @Override
    public String toString() {
        return "Dipendente{" + "id='" + id + '\'' + ", nome='" + nome + '\'' + '}';
    }
}
