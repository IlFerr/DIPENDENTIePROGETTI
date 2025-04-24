import java.util.ArrayList;

public class Storico {
    private ArrayList<Dipendente> dipendentiStorico;
    private ArrayList<Progetto> progettiStorico;

    public Storico() {
        dipendentiStorico = new ArrayList<>();
        progettiStorico = new ArrayList<>();
    }

    public void addDipendente(Dipendente dipendente) {
        dipendentiStorico.add(dipendente);
    }

    public void removeDipendente(Dipendente dipendente) {
        dipendentiStorico.remove(dipendente);
    }

    public void addProgetto(Progetto progetto) {
        progettiStorico.add(progetto);
    }

    public void removeProgetto(Progetto progetto) {
        progettiStorico.remove(progetto);
    }
}
