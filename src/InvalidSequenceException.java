
/**
 * InvalidSequenceException occurs if more than 2 of the same character occur in
 * a sequence
 * 
 * @author Matthieu Eric Moundou
 * 
 */

public class InvalidSequenceException extends Exception {
    
    public InvalidSequenceException(String message) {
        super(message); 
    }
    
}
