

/**
 *
 * NoUpperAlphaException occurs if a password contains no uppercase character
 * 
 * @author Matthieu Eric Moundou
 * 
 */

public class NoUpperAlphaException extends Exception {
    
    public NoUpperAlphaException(String message) {
        super(message); 
    }
    
}
