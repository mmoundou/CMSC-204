/*

  object is created if a given password contains no digit

  @author Matthieu Eric Moundou

*/

public class UnmatchedException extends Exception {
    
    public UnmatchedException () {
        super("The passwords do not match");    
    }
    
}
