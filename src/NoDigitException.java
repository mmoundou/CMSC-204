
/**
 *
 * NoDigitException occurs if a password contains no numerical values
 * 
 * @author Matthieu Eric Moundou
 * 
 */

public class NoDigitException extends Exception {
    
    public NoDigitException(String message) {
        super(message); 
    }
}
