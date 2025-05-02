public abstract class Dipendente {
    private String id;
    private String nome;
    private int progettiAttivi;

    public Dipendente(String id, String nome, int progettiAttivi) {
        this.id = id;
        this.nome = nome;
        this.progettiAttivi = 0;
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

    public void setProgettiAttivi(int progettiAttivi) {
        this.progettiAttivi = progettiAttivi;
    }
    
    public abstract String getClasse();
    
    @Override
    public String toString() {
        return "Dipendente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
