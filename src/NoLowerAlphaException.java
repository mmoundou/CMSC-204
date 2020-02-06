/*
 *
 * NoLowerAlphaException occurs if a password doesn't contain any lowercase character
 *
 * @author Matthieu Eric Moundou
 *
 */

public class NoLowerAlphaException extends Exception {
    
    public NoLowerAlphaException(String message) {
        super(message); 
    }
    
}
