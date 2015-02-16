package multiformat;

/**
 * Created by Tanja on 12-2-2015.
 */
public class NumberBaseException extends RuntimeException{

    public NumberBaseException(char usedNumber, String base){
        super("Value '" + usedNumber + "' not allowed with base '" + base+ "'");
    }
}
