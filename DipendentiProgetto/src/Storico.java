import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.LocalDateTime;

public class Storico {
    private List<EventoStorico> eventi = new ArrayList<>();
    private final String pathFileCSV;

    public Storico(String pathFileCSV) {
        this.pathFileCSV = pathFileCSV;
        caricaDaFile();
    }

    public void registraAggiunta(Object oggetto) {
        registra(new EventoStorico("AGGIUNTA", oggetto.getClass().getSimpleName(), oggetto.toString()));
    }

    public void registraRimozione(Object oggetto) {
        registra(new EventoStorico("RIMOZIONE", oggetto.getClass().getSimpleName(), oggetto.toString()));
    }

    public void registraModifica(Object oggetto, String dettaglioModifica) {
        registra(new EventoStorico("MODIFICA", oggetto.getClass().getSimpleName(), dettaglioModifica));
    }

    private void registra(EventoStorico evento) {
        eventi.add(evento);
        salvaEventoSuFile(evento);
    }

    public void stampaStorico() {
        eventi.forEach(System.out::println);
    }

    public List<EventoStorico> getEventi() {
        return new ArrayList<>(eventi);
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
