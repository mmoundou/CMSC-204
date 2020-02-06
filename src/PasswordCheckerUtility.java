
/**
 * 
 * PasswordUtilityChecker class tests whether a given password is valid or invalid 
 * 
 * @author Matthieu Eric MOUNDOU
 * 
 */


import java.util.ArrayList;
import java.util.regex.Pattern;


public class PasswordCheckerUtility {

    
    public PasswordCheckerUtility() {}
    
    
    /**
     * 
     * isValidPassword checks whether a password is valid or not valid
     * @param passwordString is a string parameter that holds the value of password
     * @return boolean value indicating the state of the password--"true" for a valid password
     * and "false" for an invalid password
     * 
     * @throws InvalidSequenceException if password features more than 2 instances
     * of the same character
     * @throws LengthException if length is less than 6 characters
     * @throws NoDigitException if password contains no digit
     * @throws NoLowerAlphaException if password contains no lowercase alphabetic
     * @throws NoUpperAlphaException if password contains no uppercase alphabetic
     * 
     */
    
    public static boolean isValidPassword(String passwordString)
                               throws LengthException,
                                      NoDigitException,
                                      NoUpperAlphaException,
                                      NoLowerAlphaException,
                                      InvalidSequenceException {
        
        if (passwordString.length() < 6)
            throw new LengthException("The password must be at least 6 characters long");
        
        else if (!(isMatched("(?s).*[A-Z].*", passwordString)))
            throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
        
        else if (!(isMatched(".*[a-z].*", passwordString)))
            throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
        
        else if (!(isMatched("(.)*(\\d)(.)*", passwordString)))
            throw new NoDigitException("The password must contain at least one digit");
        
        else if (uniqueCharacters(passwordString))
            throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence"); 
        
        return true; 
         
    }
    
    
    /**
     * 
     * isWeakPassword  is a boolean method that indicate whether a password is weak
     * A password is considered weak if it contains between 6 and 10 characters 
     * It's worth noting that a weak password is not an invalid password
     * 
     * @param passwordString represents a string to hold the value of a given password  
     * @return a boolean value indicating the state of passwordString:
     * "true" indicates that the password is weak and "false" indicates that it's not
     * 
     * @throws InvalidSequenceException if password contains more than 2 of the same
     * character in a sequence
     * @throws LengthException if passwordString is less than 6 characters long
     * @throws NoDigitException if password doesn't contain a numerical value
     * @throws NoLowerAlphaException if password doesn't contain a lowercase character
     * @throws NoUpperAlphaException if password doesn't contain an uppercase character
     * 
     */
    
    public static boolean isWeakPassword (String passwordString) throws LengthException, 
                                                                        NoUpperAlphaException, 
                                                                        NoLowerAlphaException, 
                                                                        NoDigitException, 
                                                                        InvalidSequenceException {
        
        isValidPassword(passwordString); 
        
        return (passwordString.length() >= 6 && passwordString.length() <= 9);
        
    }
    
    
    /**
     * 
     * validPasswords returns an ArrayList of invalid passwords with the status of each 
     * It's worth noting that weak passwords are not considered invalid  
     * The ArrayList of invalid passwords will be of format specified by the 
     * assignment documentation 
     * @param passwords represents an ArrayList of strings that will hold a 
     * collection of passwords 
     * @return an ArrayList (of Strings) of invalid passwords with their status
     * 
     */
    
    public static ArrayList<String> validPasswords(ArrayList<String> passwords) {         
        
        ArrayList<String> pwdWithStatus = new ArrayList<>();  
        
        for(int i = 0; i < passwords.size(); i++) {

            try {
            
                isValidPassword(passwords.get(i));
            
            }
            
            catch (InvalidSequenceException | LengthException | NoDigitException | NoLowerAlphaException | NoUpperAlphaException e) {
                pwdWithStatus.add(passwords.get(i) + " " + e.getMessage());   
            }

        }
    
        return pwdWithStatus; 
        
    }
    
    
    /**
     * isMatched is a method that indicates whether a given String matches a 
     * particular regex
     * @param regex is a string variable holding the value of our regex 
     * @param password is a string variable holding the value of a given
     * password
     * @return a boolean value indicating whether our password matches the corresponding
     * regex
     */
    
    private static boolean isMatched(String regex, String password) { 
        
       return Pattern.compile(regex).matcher(password).matches();
       
    }
    
    
    /**
     * uniqueCharacters determines whether a given password has more than 2
     * instances of any one character in a sequence
     * @param password is a variable of type String that holds the value of a given
     * password
     * @return a boolean value indicating whether a given password has more than 2
     * of the same character in a sequence
     */
    
    private static boolean uniqueCharacters(String password) { 
        
        boolean invalidSeq = false; 
       
        for (int i = 0; i < password.toCharArray().length; i++) {
            
            if(i > (password.toCharArray().length - 3))
                break;
            
            else if (password.toCharArray()[i] == password.toCharArray()[i + 1]
                    && password.toCharArray()[i] == password.toCharArray()[i + 2])
                invalidSeq = true; 
            
        }

        return invalidSeq; 
        
    }
   
}
