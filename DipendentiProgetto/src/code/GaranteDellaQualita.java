public class GaranteDellaQualita extends Dipendente {
    private String certificazione;
    private int anniDiEsperienza;

    public GaranteDellaQualita(String nome, String id, int progettiAttivi, String certificazione, int anniDiEsperienza) {
        super(nome, id, progettiAttivi);
        this.certificazione = certificazione;
        this.anniDiEsperienza = anniDiEsperienza;
    }

    // Getter e Setter
    public String getCertificazione() {
        return certificazione;
    }

    public int getAnniDiEsperienza() {
        return anniDiEsperienza;
    }

    public void setCertificazione(String certificazione) {
        this.certificazione = certificazione;
    }

    public void setAnniDiEsperienza(int anniDiEsperienza) {
        this.anniDiEsperienza = anniDiEsperienza;
    }

    public String getClasse() {
        return "Garante della Qualità";
    }

    @Override
    public String toString() {
        return super.toString() + ", Certificazione: " + certificazione + ", Anni di Esperienza: " + anniDiEsperienza + " [Garante Qualità]";
    }
}
