import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class Storico {
    private ArrayList<EventoStorico> eventi = new ArrayList<>();
    private String pathFileCSV;
    private ArrayList<Dipendente> dipendenti = new ArrayList<>();
    private ArrayList<Progetto> progetti = new ArrayList<>();

    public Storico(String pathFileCSV) {
        this.pathFileCSV = pathFileCSV;
        caricaDaFile();
    }

    public void registraAggiunta(String oggetto, String descrizione) {
        registra(new EventoStorico("AGGIUNTA", oggetto, descrizione));
    }

    public void registraRimozione(String oggetto, String descrizione) {
        registra(new EventoStorico("RIMOZIONE", oggetto, descrizione));
    }

    public void registraModifica(String oggetto, String descrizione) {
        registra(new EventoStorico("MODIFICA", oggetto, descrizione));
    }

    private void registra(EventoStorico evento) {
        eventi.add(evento);
        salvaEventoSuFile(evento);
    }

    public void stampaStorico() {
        eventi.forEach(System.out::println);
    }

    public EventoStorico[] getEventi() {
        return eventi.toArray(new EventoStorico[0]);
    }

    // Operazioni di salva e carica di file
    private void salvaEventoSuFile(EventoStorico evento) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileCSV, true))) {
            writer.write(evento.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dell'evento: " + e.getMessage());
        }
    }

    private void caricaDaFile() {
        if (!Files.exists(Paths.get(pathFileCSV))) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFileCSV))) {
            String riga;
            while ((riga = reader.readLine()) != null) {
                eventi.add(EventoStorico.fromCSV(riga));
            }
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento dello storico: " + e.getMessage());
        }
    }

    // Operazioni sui dipendenti
    public void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
        registraAggiunta("Diendente:" + dipendente.getNome() + " (" + dipendente.getId() + ")", "Aggiunto " + dipendente.getClasse());
    }

    public void rimuoviDipendente(Dipendente dipendente) {
        dipendenti.remove(dipendente);
        registraRimozione("Diendente:" + dipendente.getNome() + " (" + dipendente.getId() + ")", "Rimosso " + dipendente.getClasse());
    }

    public Dipendente[] getDipendenti() {
        return dipendenti.toArray(new Dipendente[0]);
    }

    // Operazioni sui progetti
    public void aggiungiProgetto(Progetto progetto) {
        progetti.add(progetto);
        registraAggiunta("Progetto:" + progetto.getNome() + " (" + progetto.getId() + ")", progetto.getDescrizione());
    }

    public void rimuoviProgetto(Progetto progetto) {
        progetti.remove(progetto);
        registraRimozione("Progetto:" + progetto.getNome() + " (" + progetto.getId() + ")", progetto.getDescrizione());
    }

    public Progetto[] getProgetti() {
        return progetti.toArray(new Progetto[0]);
    }

    // Operazioni di ordinamento e ricerca dipendenti
    public Dipendente[] ordinaDipendentiAlfabetico() {
        ArrayList<Dipendente> copiaDipendenti = new ArrayList<>(dipendenti);
        copiaDipendenti.sort((d1, d2) -> d1.getNome().compareToIgnoreCase(d2.getNome()));
        return copiaDipendenti.toArray(new Dipendente[0]);
    }

    public Dipendente[] ordinaDipendentiPerClasse() {
        ArrayList<Dipendente> copiaDipendenti = new ArrayList<>(dipendenti);
        copiaDipendenti.sort((d1, d2) -> d1.getClasse().compareToIgnoreCase(d2.getClasse()));
        return copiaDipendenti.toArray(new Dipendente[0]);
    }

    public Dipendente[] cercaDipendente(String nome){
        ArrayList<Dipendente> ricerca=new ArrayList<>();
        for(Dipendente p:dipendenti){
            if(p.getNome().toLowerCase().contains(nome.toLowerCase())) ricerca.add(p);
        }
        return ricerca.toArray(new Dipendente[0]);
    }
    
    // Operazioni di ordinamento e ricerca progetti
    public Progetto[] ordinaProgettiAlfabetico() {
        ArrayList<Progetto> copiaProgetti = new ArrayList<>(progetti);
        copiaProgetti.sort((d1, d2) -> d1.getNome().compareToIgnoreCase(d2.getNome()));
        return copiaProgetti.toArray(new Progetto[0]);
    }

    public Progetto[] ordinaProgettiPerStato() {
        ArrayList<Progetto> copiaProgetti = new ArrayList<>(progetti);
        copiaProgetti.sort((p1, p2) -> Integer.compare(p1.getStato(), p2.getStato()));
        return copiaProgetti.toArray(new Progetto[0]);
    }

    public Progetto[] ordinaProgettiPerDataInizio() {
        ArrayList<Progetto> copiaProgetti = new ArrayList<>(progetti);
        copiaProgetti.sort((p1, p2) -> p1.getDataInizio().compareTo(p2.getDataInizio()));
        return copiaProgetti.toArray(new Progetto[0]);
    }

    public Progetto[] ordinaProgettiPerDataFine() {
        ArrayList<Progetto> copiaProgetti = new ArrayList<>(progetti);
        copiaProgetti.sort((p1, p2) -> p1.getDataFine().compareTo(p2.getDataFine()));
        return copiaProgetti.toArray(new Progetto[0]);
    }

    public Progetto[] cercaProgetto(String nome){
        ArrayList<Progetto> ricerca=new ArrayList<>();
        for(Progetto p:progetti){
            if(p.getNome().toLowerCase().contains(nome.toLowerCase())) ricerca.add(p);
        }
        return ricerca.toArray(new Progetto[0]);
    }

    // Operazioni di ordinamento eventi
    ArrayList<EventoStorico> copiaEventi = new ArrayList<>(eventi);

    public EventoStorico[] ordinaEventiAlfabetico() {
        copiaEventi.sort((e1, e2) -> e1.getDescrizione().compareTo(e2.getDescrizione()));
        return copiaEventi.toArray(new EventoStorico[0]);
    }
}
