import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.Comparator;

public class Azienda {
    private ArrayList<Dipendente> dipendenti = new ArrayList<>();
    private ArrayList<Progetto> progetti = new ArrayList<>();
    private ArrayList<Storico> eventi = new ArrayList<>();

    public Azienda(ArrayList<Dipendente> dipendenti, ArrayList<Progetto> progetti, ArrayList<Storico> eventi) {
        this.dipendenti = dipendenti;
        this.progetti = progetti;
        this.eventi = eventi;
    }

    public void registraAggiunta(String descrizione) {
        registra(new Storico("AGGIUNTA", descrizione));
    }

    public void registraRimozione(String oggetto, String descrizione) {
        registra(new Storico("RIMOZIONE", oggetto, descrizione));
    }

    public void registraModifica(String oggetto, String descrizione) {
        registra(new Storico("MODIFICA", oggetto, descrizione));
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

    // Operazioni di salva e carica di file
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

    // Operazioni sui dipendenti
    public void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
        registraAggiunta("Diendente: " + dipendente.getNome() + " (" + dipendente.getId() + ")", "Aggiunto " + dipendente.getClasse());
    }

    public void rimuoviDipendente(Dipendente dipendente) {
        dipendenti.remove(dipendente);
        registraRimozione("Diendente: " + dipendente.getNome() + " (" + dipendente.getId() + ")", "Rimosso " + dipendente.getClasse());
    }

    public void modificaDipendente(Dipendente dipendente, String nuovaClasse) {
        registraModifica("Diendente: " + dipendente.getNome() + " (" + dipendente.getId() + ")", "Modificato in " + nuovaClasse);
    }

    public Dipendente[] getDipendenti() {
        return dipendenti.toArray(new Dipendente[0]);
    }

    // Operazioni sui progetti
    public void aggiungiProgetto(Progetto progetto) {
        progetti.add(progetto);
        registraAggiunta("Progetto: " + progetto.getNome() + " (" + progetto.getId() + ")", "Aggiunto " + progetto.getDescrizione());
    }

    public void rimuoviProgetto(Progetto progetto) {
        progetti.remove(progetto);
        registraRimozione("Progetto: " + progetto.getNome() + " (" + progetto.getId() + ")", "Rimosso " + progetto.getDescrizione());
    }

    public void modificaProgetto(Progetto progetto, String nuovaDescrizione) {
        registraModifica("Progetto: " + progetto.getNome() + " (" + progetto.getId() + ")", "Modificato in " + nuovaDescrizione);
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

    public Dipendente[] cercaDipendente(String nome) {
        ArrayList<Dipendente> ricerca = new ArrayList<>();
        for (Dipendente p : dipendenti) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase()))
                ricerca.add(p);
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

    public Progetto[] cercaProgetto(String nome) {
        ArrayList<Progetto> ricerca = new ArrayList<>();
        for (Progetto p : progetti) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase()))
                ricerca.add(p);
        }
        return ricerca.toArray(new Progetto[0]);
    }

    // Operazioni di ordinamento e di ricerca eventi
    public Storico[] ordinaEventiAlfabetico() {
        ArrayList<Storico> copiaEventi = new ArrayList<>(eventi);
        copiaEventi.sort((e1, e2) -> e1.getDescrizione().compareTo(e2.getDescrizione()));
        return copiaEventi.toArray(new Storico[0]);
    }

    public Storico[] ordinaEventiPerData() {
        ArrayList<Storico> copiaEventi = new ArrayList<>(eventi);
        copiaEventi.sort(Comparator.comparing(Storico::getTimestamp).reversed());
        return copiaEventi.toArray(new Storico[0]);
    }

    public Storico[] ordinaEventiPerTipoOperazione() {
        ArrayList<Storico> copiaEventi = new ArrayList<>(eventi);
        copiaEventi.sort(Comparator.comparing(Storico::getTipoOperazione));
        return copiaEventi.toArray(new Storico[0]);
    }

    public Storico[] ordinaEventiPerOggettoCoinvolto() {
        ArrayList<Storico> copiaEventi = new ArrayList<>(eventi);
        copiaEventi.sort(Comparator.comparing(Storico::getOggettoCoinvolto));
        return copiaEventi.toArray(new Storico[0]);
    }

    public Storico[] cercaEventoStorico(String nome) {
        ArrayList<Storico> ricerca = new ArrayList<>();
        for (Storico e : eventi) {
            if (e.getOggettoCoinvolto().toLowerCase().contains(nome.toLowerCase())) {
                ricerca.add(e);
            }
        }
        return ricerca.toArray(new Storico[0]);
    }
}
