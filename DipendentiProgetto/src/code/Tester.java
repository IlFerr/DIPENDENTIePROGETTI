public class Tester extends Dipendente {
    public Tester(String nome, String id) {
        super(nome, id);
    }

    public String getClasse() {
        return "Tester";
    }

    @Override
    public String toString() {
        return super.toString() + " [Tester]";
    }
}
