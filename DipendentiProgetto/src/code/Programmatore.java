public class Programmatore extends Dipendente {
    private String linguaggio;

    public Programmatore(String nome, String id, String linguaggio) {
        super(nome, id);
        this.linguaggio = linguaggio;
    }

    // Getter e Setter
    public String getLinguaggio() {
        return linguaggio;
    }

    public void setLinguaggio(String linguaggio) {
        this.linguaggio = linguaggio;
    }

    public String getClasse() {
        return "Programmatore";
    }

    @Override
    public String toString() {
        return super.toString() + ", Linguaggio: " + linguaggio + " [Programmatore]";
    }
}
