
public class GaranteDellaQualita extends Dipendente {
    private String certificazione; // Certificazione del garante della qualità
    private int anniDiEsperienza; // Anni di esperienza del garante della qualità

    /**
     * Costruttore della classe GaranteDellaQualita
     * @param nome Nome del garante della qualità
     * @param id ID del garante della qualità
     * @param certificazione Certificazione del garante della qualità
     * @param anniDiEsperienza Anni di esperienza del garante della qualità
     */
    public GaranteDellaQualita(String nome, String id, String certificazione, int anniDiEsperienza) {
        super(nome, id);
        this.certificazione = certificazione;
        this.anniDiEsperienza = anniDiEsperienza;
    }

    /**
     * Restituisce la certificazione del garante della qualità
     * @return certificazione del garante della qualità
     */
    public String getCertificazione() {
        return certificazione;
    }

    /**
     * Restituisce gli anni di esperienza del garante della qualità
     * @return anni di esperienza del garante della qualità
     */
    public int getAnniDiEsperienza() {
        return anniDiEsperienza;
    }

    /**
     * Imposta la certificazione del garante della qualità
     * @param certificazione certificazione del garante della qualità
     */
    public void setCertificazione(String certificazione) {
        this.certificazione = certificazione;
    }

    /**
     * Imposta gli anni di esperienza del garante della qualità
     * @param anniDiEsperienza anni di esperienza del garante della qualità
     */
    public void setAnniDiEsperienza(int anniDiEsperienza) {
        this.anniDiEsperienza = anniDiEsperienza;
    }

    /**
     * Restituisce una stringa che rappresenta il GaranteDellaQualita
     * @return stringa che rappresenta il GaranteDellaQualita
     */
    @Override
    public String toString() {
        return super.toString() + ", Certificazione: " + certificazione + ", Anni di esperienza: " + anniDiEsperienza;
    }
}
