import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creazione dello storico
        Storico storico = new Storico();

        // Creazione dipendenti
        TeamManager tm = new TeamManager("Mario Rossi", "TM001", "AlphaTeam", 5, null);
        Programmatore p1 = new Programmatore("Luigi Bianchi", "P001", "Java");
        Tester t1 = new Tester("Elisa Verdi", "T001");
        GaranteDellaQualita gq1 = new GaranteDellaQualita("Anna Neri", "GQ001", "ISO 9001", 8);

        // Aggiunta allo storico
        storico.addDipendente(tm);
        storico.addDipendente(p1);
        storico.addDipendente(t1);
        storico.addDipendente(gq1);

        // Creazione progetti
        Progetto progetto1 = new Progetto("Sistema Contabile", "PR001", "Gestione contabilità aziendale", 2,
                LocalDate.of(2025, 3, 1), LocalDate.of(2025, 6, 30), 50000);
        progetto1.add("ProjectCharter.pdf");

        Progetto progetto2 = new Progetto("App Mobile", "PR002", "Applicazione Android e iOS", 1,
                LocalDate.of(2025, 4, 1), LocalDate.of(2025, 10, 1), 80000);

        storico.addProgetto(progetto1);
        storico.addProgetto(progetto2);

        // Assegnazione dipendenti a progetti
        
        
        // Output dimostrativo
        System.out.println("=== Dipendenti ===");
        System.out.println(tm);
        System.out.println(p1);
        System.out.println(t1);
        System.out.println(gq1);

        System.out.println("\n=== Progetti ===");
        System.out.println(progetto1);
        System.out.println(progetto2);

        System.out.println("\n=== Assegnazioni ===");
        System.out.println(assegnazione1);
        System.out.println(assegnazione2);
        System.out.println(assegnazione3);
    }
}
