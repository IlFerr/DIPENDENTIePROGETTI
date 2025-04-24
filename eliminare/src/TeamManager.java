
public class TeamManager extends Dipendente {
    private String nomeTeam; // Nome del team
    private int grandezzaTeam; // Grandezza del team
    
    /**
     * Costruttore della classe TeamManager
     * @param nome
     * @param id
     * @param nomeTeam
     * @param grandezzaTeam
     */
    public TeamManager(String nome, String id, String nomeTeam, int grandezzaTeam) {
        super(nome, id);
        this.nomeTeam = nomeTeam;
        this.grandezzaTeam = grandezzaTeam;
    }
    
    /**
     * Restituisce il nome del team
     * @return nome del team
     */
    public String getNomeTeam() {
        return nomeTeam;
    }
    
    /**
     * Restituisce la grandezza del team
     * @return grandezza del team
     */
    public int getGrandezzaTeam() {
        return grandezzaTeam;
    }
    
    /**
     * Imposta il nome del team
     * @param nomeTeam nome del team
     */
    public void setTeamName(String nomeTeam) {
        this.nomeTeam = nomeTeam;
    }
    
    /**
     * Imposta la grandezza del team
     * @param grandezzaTeam grandezza del team
     */
    public void setGrandezzaTeam(int grandezzaTeam) {
        this.grandezzaTeam = grandezzaTeam;
    }
    
    /**
     * Restituisce una stringa che rappresenta il TeamManager
     * @return stringa che rappresenta il TeamManager
     */
    @Override
    public String toString() {
        return super.toString() + ", Team: " + nomeTeam + ", Grandezza: " + grandezzaTeam;
    }
}
