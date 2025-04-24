public class Programmatore extends Dipendente {
    private String linguaggio;

    public Programmatore(String nome, String id, String linguaggio) {
        super(nome, id);
        this.linguaggio = linguaggio;
    }

    public String toString() {
        return super.toString() + ", Linguaggio: " + linguaggio + " [Programmatore]";
    }
}
