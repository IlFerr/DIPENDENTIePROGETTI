import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Azienda {
    // Costanti per i tipi di operazione
    private static final String AGGIUNTA = "AGGIUNTA";
    private static final String RIMOZIONE = "RIMOZIONE";
    private static final String MODIFICA = "MODIFICA";

    // Attributis
    private ArrayList<Dipendente> dipendenti = new ArrayList<>();
    private ArrayList<Progetto> progetti = new ArrayList<>();
    private ArrayList<Storico> eventi = new ArrayList<>();
    private final String pathFileCSV = "storico.csv"; // Percorso del file CSV

    // Costruttore
    public Azienda(ArrayList<Dipendente> dipendenti, ArrayList<Progetto> progetti, ArrayList<Storico> eventi) {
        this.dipendenti = dipendenti;
        this.progetti = progetti;
        this.eventi = eventi;
    }

    // Metodi per la gestione dello storico
    public void registraAggiunta(String descrizione) {
        registra(new Storico(AGGIUNTA, descrizione));
    }

    public void registraRimozione(String descrizione) {
        registra(new Storico(RIMOZIONE, descrizione));
    }

    public void registraModifica(String descrizione) {
        registra(new Storico(MODIFICA, descrizione));
    }

    private void registra(Storico evento) {
        eventi.add(evento);
        salvaEventoSuFile(evento);
    }

    public void stampaStorico() {
        eventi.forEach(System.out::println);
    }

    public Storico[] getEventi() {
        return eventi.toArray(new Storico[0]);
    }

    // Metodi per la gestione dei file
    private void salvaEventoSuFile(Storico evento) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileCSV, true))) {
            writer.write(evento.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dell'evento: " + e.getMessage());
        }
    }

    private void caricaDaFile() {
        if (!Files.exists(Paths.get(pathFileCSV)))
            return;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFileCSV))) {
            String riga;
            while ((riga = reader.readLine()) != null) {
                eventi.add(Storico.fromCSV(riga));
            }
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento dello storico: " + e.getMessage());
        }
    }

    // Metodi per la gestione dei dipendenti
    public void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
        registraAggiunta("Dipendente: " + dipendente.getNome() + " (" + dipendente.getId() + ")");
    }

    public void rimuoviDipendente(Dipendente dipendente) {
        dipendenti.remove(dipendente);
        registraRimozione("Dipendente: " + dipendente.getNome() + " (" + dipendente.getId() + ")");
    }

    public void modificaDipendente(Dipendente dipendente, String nuovaClasse) {
        registraModifica("Dipendente: " + dipendente.getNome() + " (" + dipendente.getId() + ") Modificato in " + nuovaClasse);
    }

    public Dipendente[] getDipendenti() {
        return dipendenti.toArray(new Dipendente[0]);
    }

    public Dipendente[] ordinaDipendentiAlfabetico() {
        ArrayList<Dipendente> copiaDipendenti = new ArrayList<>(dipendenti);
        copiaDipendenti.sort(Comparator.comparing(Dipendente::getNome, String.CASE_INSENSITIVE_ORDER));
        return copiaDipendenti.toArray(new Dipendente[0]);
    }

    public Dipendente[] ordinaDipendentiPerClasse() {
        ArrayList<Dipendente> copiaDipendenti = new ArrayList<>(dipendenti);
        copiaDipendenti.sort(Comparator.comparing(Dipendente::getClasse, String.CASE_INSENSITIVE_ORDER));
        return copiaDipendenti.toArray(new Dipendente[0]);
    }

    public Dipendente[] cercaDipendente(String nome) {
        return dipendenti.stream()
                .filter(d -> d.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toArray(Dipendente[]::new);
    }

    // Metodi per la gestione dei progetti
    public void aggiungiProgetto(Progetto progetto) {
        progetti.add(progetto);
        registraAggiunta("Progetto: " + progetto.getNome() + " (" + progetto.getId() + ")");
    }

    public void rimuoviProgetto(Progetto progetto) {
        progetti.remove(progetto);
        registraRimozione("Progetto: " + progetto.getNome() + " (" + progetto.getId() + ")");
    }

    public void modificaProgetto(Progetto progetto, String nuovaDescrizione) {
        registraModifica("Progetto: " + progetto.getNome() + " (" + progetto.getId() + ") Modificato in " + nuovaDescrizione);
    }

    public Progetto[] getProgetti() {
        return progetti.toArray(new Progetto[0]);
    }

    public Progetto[] ordinaProgettiAlfabetico() {
        ArrayList<Progetto> copiaProgetti = new ArrayList<>(progetti);
        copiaProgetti.sort(Comparator.comparing(Progetto::getNome, String.CASE_INSENSITIVE_ORDER));
        return copiaProgetti.toArray(new Progetto[0]);
    }

    public Progetto[] ordinaProgettiPerStato() {
        ArrayList<Progetto> copiaProgetti = new ArrayList<>(progetti);
        copiaProgetti.sort(Comparator.comparingInt(Progetto::getStato));
        return copiaProgetti.toArray(new Progetto[0]);
    }

    public Progetto[] cercaProgetto(String nome) {
        return progetti.stream()
                .filter(p -> p.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toArray(Progetto[]::new);
    }

    // Metodi per la gestione degli eventi
    public Storico[] ordinaEventiAlfabetico() {
        ArrayList<Storico> copiaEventi = new ArrayList<>(eventi);
        copiaEventi.sort(Comparator.comparing(Storico::getDettagli));
        return copiaEventi.toArray(new Storico[0]);
    }

    public Storico[] ordinaEventiPerData() {
        ArrayList<Storico> copiaEventi = new ArrayList<>(eventi);
        copiaEventi.sort(Comparator.comparing(Storico::getData).reversed());
        return copiaEventi.toArray(new Storico[0]);
    }

    public Storico[] cercaEventoStorico(String nome) {
        return eventi.stream()
                .filter(e -> e.getDettagli().toLowerCase().contains(nome.toLowerCase()))
                .toArray(Storico[]::new);
    }
}
