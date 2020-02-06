
/**
 * LengthException occurs if a password contains less than 6 characters
 *
 * @author Matthieu Eric Moundou
 * 
 */

public class LengthException extends Exception {
    
    public LengthException(String message) {
        super(message); 
    }
    
}
