public class GaranteDellaQualita extends Dipendente {
    private String certificazione;
    private int anniDiEsperienza;

    public GaranteDellaQualita(String nome, String id, String certificazione, int anniDiEsperienza) {
        super(nome, id);
        this.certificazione = certificazione;
        this.anniDiEsperienza = anniDiEsperienza;
    }

    public String toString() {
        return super.toString() + ", Certificazione: " + certificazione + ", Anni di Esperienza: " + anniDiEsperienza + " [Garante Qualità]";
    }
}
