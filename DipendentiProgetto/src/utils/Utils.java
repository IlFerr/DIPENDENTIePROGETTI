import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Questa classe contiene qualche metodo che potrebbe esserti utile nell'implementazione della GUI.
 * 
 * Non c'è nessun bisogno di usarli tutti!
 * 
 * @author dosse
 */
public class Utils {
    
    /**
     * Converte un LocalDateTime in una stringa user friendly nel formato giorno mese anno ore:minuti
     * 
     * @param t il LocalDateTime da convertire
     * @return stringa formattata bene
     */
    public static String formattaDataEOra(LocalDateTime t){
        return t.format(DateTimeFormatter.ofPattern("d MMM uuuu HH:mm"));
    }
    
    /**
     * Converte un LocalDateTime in un Date che può essere usato in uno Spinner
     * 
     * @param t il LocalDateTime da convertire
     * @return la stessa data e ora convertita in Date
     */
    public static Date convertiLocalDateTimeInDate(LocalDateTime t){
        return Date.from(t.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * Converte un Date in un LocalDateTime
     * 
     * @param t il Date da convertire
     * @return la stessa data e ora convertita in LocalDateTime
     */
    public static LocalDateTime convertiDateInLocalDateTime(Date t){
        return t.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    /**
     * Converte una data in formato giorno, mese, anno, ore, minuti in un LocalDateTime
     * 
     * @param giorno
     * @param mese
     * @param anno
     * @param ore
     * @param minuti
     * @return la data e ora convertita in LocalDateTime
     */
    public static LocalDateTime convertiGiornoMeseAnnoOreMinutiInLocalDateTime(int giorno, int mese, int anno, int ore, int minuti){
        return LocalDateTime.of(anno, mese, giorno, ore, minuti);
    }
    
}