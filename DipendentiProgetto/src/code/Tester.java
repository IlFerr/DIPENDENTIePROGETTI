public class Tester extends Dipendente {
    public Tester(String nome, String id, int progettiAttivi) {
        super(nome, id, progettiAttivi);
    }

    public String getClasse() {
        return "Tester";
    }

    @Override
    public String toString() {
        return super.toString() + " [Tester]";
    }
}
