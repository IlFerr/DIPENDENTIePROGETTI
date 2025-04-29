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

    @Override
    public String toString() {
        return super.toString() + ", Linguaggio: " + linguaggio + " [Programmatore]";
    }
}
