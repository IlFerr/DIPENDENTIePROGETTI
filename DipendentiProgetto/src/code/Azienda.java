import java.io.*;
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
    private String storicoCSV = "storico.csv"; // Percorso del file CSV
    private String pathDipendenti = "dipendenti.dat";
    private String pathProgetti = "progetti.dat";
    private String pathStorico = "storico.dat";

    // Costruttore
    public Azienda(ArrayList<Dipendente> dipendenti, ArrayList<Progetto> progetti, ArrayList<Storico> eventi) {
        this.dipendenti = dipendenti;
        this.progetti = progetti;
        this.eventi = eventi;
    }

    // Metodi per la gestione dello storico
    public void registraAggiunta(String descrizione) {
        eventi.add(new Storico(AGGIUNTA, descrizione));
    }

    public void registraRimozione(String descrizione) {
        eventi.add(new Storico(RIMOZIONE, descrizione));
    }

    public void registraModifica(String descrizione) {
        eventi.add(new Storico(MODIFICA, descrizione));
    }

    public Storico[] getEventi() {
        return eventi.toArray(new Storico[0]);
    }

    // Metodi per la gestione dei file
    public boolean salvaStoricoSuCSV(){
        FileWriter w = null;
        try {
            w = new FileWriter(storicoCSV);
            w.write("Azione,Dettagli,Data\n");
            for (Storico s : eventi) {
                w.write(s.getAzione() + "," + s.getDettagli() + "," + s.getData() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Errore di scrittura " + e);
            return false;
        }
        
        if (w != null) {
            try {
                w.flush();
                w.close();
            } catch (Exception e) {
                return false;
            }
        }
        
        return true;
    }

    public boolean salvaSuFile(){
        try{
            ObjectOutputStream oosDipendenti = new ObjectOutputStream(new FileOutputStream(pathDipendenti));
            ObjectOutputStream oosProgetti = new ObjectOutputStream(new FileOutputStream(pathProgetti));
            ObjectOutputStream oosStorico = new ObjectOutputStream(new FileOutputStream(pathProgetti));
            
            oosDipendenti.writeObject(dipendenti);
            oosProgetti.writeObject(progetti);
            oosStorico.writeObject(eventi);

            oosDipendenti.flush();
            oosDipendenti.close();
            oosProgetti.flush();
            oosProgetti.close();
            oosStorico.flush();
            oosStorico.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean caricaDaFile() {
        try (ObjectInputStream oisDipendenti = new ObjectInputStream(new FileInputStream(pathDipendenti));
            ObjectInputStream oisProgetti = new ObjectInputStream(new FileInputStream(pathProgetti));
            ObjectInputStream oisStorico = new ObjectInputStream(new FileInputStream(pathStorico))) {
            
            dipendenti = (ArrayList<Dipendente>) oisDipendenti.readObject();
            progetti = (ArrayList<Progetto>) oisProgetti.readObject();
            eventi = (ArrayList<Storico>) oisStorico.readObject();
            
            return true;
        } catch (Exception e) {
            return false;
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

    public Dipendente[] cercaDipendente(String s) {
        s = s.toLowerCase();
        ArrayList<Dipendente> dip = new ArrayList<>();
        for(Dipendente d: dipendenti){
            if(d.getNome().contains(s) || s.contains(d.getNome()) || d.getId().contains(s) || s.contains(d.getId())){
                dip.add(d);
            }
        }
        return dip.toArray(new Dipendente[0]);
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

    public Progetto[] ordinaProgettiPerDataFine() {
        ArrayList<Progetto> copiaProgetti = new ArrayList<>(progetti);
        copiaProgetti.sort(Comparator.comparing(Progetto::getDataFine));
        return copiaProgetti.toArray(new Progetto[0]);
    }

    public Progetto[] cercaProgetto(String s) {
        s = s.toLowerCase();
        ArrayList<Progetto> pro = new ArrayList<>();
        for(Progetto p: progetti){
            if(p.getNome().contains(s) || s.contains(p.getNome()) || p.getId().contains(s) || s.contains(p.getId())){
                pro.add(p);
            }
        }
        return pro.toArray(new Progetto[0]);
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

    public Storico[] ordinaEventiPerAzione() {
        ArrayList<Storico> copiaEventi = new ArrayList<>(eventi);
        copiaEventi.sort(Comparator.comparing(Storico::getAzione));
        return copiaEventi.toArray(new Storico[0]);
    }

    public Storico[] cercaEventoStorico(String s) {
        s = s.toLowerCase();
        ArrayList<Storico> ret = new ArrayList<>();
        for(Storico e: eventi){
            if(e.getDettagli().contains(s) || s.contains(e.getDettagli()) || e.getAzione().contains(s) || s.contains(e.getAzione())){
                ret.add(e);
            }
        }
        return ret.toArray(new Storico[0]);
    }
}
