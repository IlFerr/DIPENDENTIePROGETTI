
import java.util.ArrayList;


public class Storico {
    private ArrayList<Dipendente> dipendentiStorico = new ArrayList<>();
    private ArrayList<Progetto> progettiStorico = new ArrayList<>();

    public Storico() {
    }

    public Dipendente[] getDipendentiStorico() {
        return dipendentiStorico.toArray(new Dipendente[0]);
    }

    public Progetto[] getProgettiStorico() {
        return progettiStorico.toArray(new Progetto[0]);
    }

    public void addDipendente(Dipendente dipendente) {
        dipendentiStorico.add(dipendente);
    }

    public void addProgetto(Progetto progetto) {
        progettiStorico.add(progetto);
    }

    public void removeDipendente(Dipendente dipendente) {
        dipendentiStorico.remove(dipendente);
    }

    public void removeProgetto(Progetto progetto) {
        progettiStorico.remove(progetto);
    }
}
