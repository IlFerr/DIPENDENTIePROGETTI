import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class Storico {
    private ArrayList<EventoStorico> eventi = new ArrayList<>();
    private final String pathFileCSV;

    public Storico(String pathFileCSV) {
        this.pathFileCSV = pathFileCSV;
        caricaDaFile();
    }

    public void registraAggiunta(String oggetto) {
        registra(new EventoStorico("AGGIUNTA", oggetto));
    }

    public void registraRimozione(String oggetto) {
        registra(new EventoStorico("RIMOZIONE", oggetto));
    }

    public void registraModifica(String oggetto) {
        registra(new EventoStorico("MODIFICA", oggetto));
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
}
