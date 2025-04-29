import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Storico storico = new Storico("storico.csv");

        Progetto p = new Progetto("P001", "Progetto AI", 0, "Descrizione progetto", 10000.0, LocalDate.now(), LocalDate.now().plusMonths(3), "charter.pdf");
        storico.registraAggiunta(p);

        Dipendente d = new TeamManager("D001", "Lucia Bianchi", "Team AI", p);
        storico.registraAggiunta(d);

        storico.registraModifica(d, "Cambiato nome team in 'AI Evolution'");

        storico.stampaStorico();
    }
}

