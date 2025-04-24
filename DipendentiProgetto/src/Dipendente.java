public class Dipendente {
    protected String nome;
    protected String id;

    public Dipendente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String toString() {
        return "Dipendente: " + nome + ", ID: " + id;
    }
}
