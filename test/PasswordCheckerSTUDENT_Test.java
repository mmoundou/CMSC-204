
/**
 * 
 * STUDENT tests for the methods of PasswordChecker
 * @author Matthieu Eric MOUNDOU
 * 
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasswordCheckerSTUDENT_Test {
    
        ArrayList<String> passwords;

	@Before
	public void setUp() throws Exception {
            
            String[] passwordsArray = {"xxyyzzwwaa", "volvo", "Relie", "zavazone", 
                                        "ballon", "UpperLetter", "123Soleil", "aaalove", 
                                        "Xy2PTer3", "noReplyDotCom", "XTZ234", "1401BirchwoodDrive", "Sheraz", "934MerlinStreet", 
                                        "august30", "abcdef", "Applesxx", "aa11b", "pilotProject", "myPassword", 
                                        "myPassword2", "AABB123"};
            
            passwords = new ArrayList<>();
            passwords.addAll(Arrays.asList(passwordsArray));
            
		
	}

	@After
	public void tearDown() throws Exception {
            passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
        
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Xy2PTer3"));
			PasswordCheckerUtility.isValidPassword("Xy2P");
                        PasswordCheckerUtility.isValidPassword("Lines");
                        PasswordCheckerUtility.isValidPassword("Lines2");
                        PasswordCheckerUtility.isValidPassword("Lines23");
			assertTrue("Did not throw lengthException",false);
                        
                        PasswordCheckerUtility.isValidPassword("Lines23a"); 
                        PasswordCheckerUtility.isValidPassword("Lines23an");
                        PasswordCheckerUtility.isValidPassword("Lines23and");
                        
                        
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
        
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("1401BirchwoodDrive"));
			PasswordCheckerUtility.isValidPassword("zavazone");
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
        
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("AABB123"));
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
        
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
        
	@Test
	public void testIsWeakPassword()
	{
		try{
                    
                    /*
                        The tests below make sure that isWeakPassword behaves well
                        outside and within the bounds of what counts as a weak password
                    */
                    
                        assertEquals(true, PasswordCheckerUtility.isWeakPassword("Lines2"));
                        assertEquals(true, PasswordCheckerUtility.isWeakPassword("Lines23"));
                        assertEquals(true, PasswordCheckerUtility.isWeakPassword("Lines23a"));
                        assertEquals(true, PasswordCheckerUtility.isWeakPassword("Lines23an"));
                        assertEquals(false, PasswordCheckerUtility.isWeakPassword("Lines23and"));
                        
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
        
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("1234aaAA"));
			PasswordCheckerUtility.isValidPassword("AAAlove1");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
        
	@Test
	public void testIsValidPasswordNoDigit()
	{
            try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("Wbrlota1"));
			PasswordCheckerUtility.isValidPassword("Wbrlota1");
			assertTrue("Did not throw a NoDigitException",true);
                        PasswordCheckerUtility.isValidPassword("Volvo9");  
                        
		}
		catch(NoDigitException e)
		{
			assertTrue("NoDigitException was successfully caught",true);
		}
		catch(InvalidSequenceException | LengthException | NoLowerAlphaException | NoUpperAlphaException e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an NoDigitException",false);
		}
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
        
	@Test
	public void testIsValidPasswordSuccessful()
	{
            try{ 
                
                assertEquals(true, PasswordCheckerUtility.isValidPassword("Xy2PTer3"));
                assertEquals(true, PasswordCheckerUtility.isValidPassword("123Soleil"));
                assertEquals(true, PasswordCheckerUtility.isValidPassword("14601BirchwoodDrive"));
                assertEquals(true, PasswordCheckerUtility.isValidPassword("934MerlinStreet")); 
                
                assertTrue("This statement will be reached only if no exception was thrown", true);    
                
            }
            catch (InvalidSequenceException | LengthException | NoDigitException | NoLowerAlphaException | NoUpperAlphaException e) {
                assertTrue("No password-specific exception should have been thrown", false); 
            }
		
	}
	
        /**
         * Test whether isWeakPassword throws the relevant exceptions when needed
         */
        
        @Test
        public void testIsWeakForValidPasswords() {
            
            //"Lines", "constitutional", "CONSTITUTIONAL", "ResTinG", "Orarnrgrer1rrr"
            
            try {
                PasswordCheckerUtility.isWeakPassword("Lines");   
            }
            catch(LengthException e) {
                assertTrue("LengthException was successfully caught", true);
            }
            catch(InvalidSequenceException | NoDigitException | NoLowerAlphaException | NoUpperAlphaException e) {
                assertTrue("Threw an exception other than LengthException", false);
            }
            
            try {
                PasswordCheckerUtility.isWeakPassword("constitutional");
            }
            catch(NoUpperAlphaException e) {
                assertTrue("NoUpperAlphaException was successfully caught", true);
            }
            catch(InvalidSequenceException | LengthException | NoDigitException | NoLowerAlphaException e) {
                assertTrue("Threw an exception other than NoUpperAlphaException", false);
            }
            
            try {
                PasswordCheckerUtility.isWeakPassword("CONSTITUTIONAL");
            }
            catch(NoLowerAlphaException e) {
                assertTrue("NoLowerAlphaException was successfully caught", true);
            }
            catch(InvalidSequenceException | LengthException | NoDigitException | NoUpperAlphaException e) {
                assertTrue("Threw an exception other than NoLowerAlphaException", false);
            }
            
            
            try{
                PasswordCheckerUtility.isWeakPassword("ResTinG");
            }
            catch(NoDigitException e) {
                assertTrue("NoDigitException was successfully caught", true); 
            }
            catch(InvalidSequenceException | LengthException | NoLowerAlphaException | NoUpperAlphaException e) {
                assertTrue("Threw an exception other than NoDigitException", false);
            }
            
            try{
                PasswordCheckerUtility.isWeakPassword("Orarnrgrer1rrr");
            }
            catch(InvalidSequenceException e) {
                assertTrue("InvalidSequenceException was successfully caught", true);
            }
            catch(LengthException | NoDigitException | NoLowerAlphaException | NoUpperAlphaException e) {
                assertTrue("Threw an exception other than InvalidSequenceException", false);
            }

        }
        
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
        
	@Test
	public void testValidPasswords() {
            
		ArrayList<String> results;
                
		results = PasswordCheckerUtility.validPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "xxyyzzwwaa");
                String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase")); 
		scan = new Scanner(results.get(1)); 
		assertEquals(scan.next(), "volvo");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("characters"));
		scan = new Scanner(results.get(2)); 
		assertEquals(scan.next(), "Relie");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("characters"));
		scan = new Scanner(results.get(3)); 
		assertEquals(scan.next(), "zavazone");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
                scan = new Scanner(results.get(4)); //
		assertEquals(scan.next(), "ballon");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		scan = new Scanner(results.get(5)); //
		assertEquals(scan.next(), "UpperLetter");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
                scan = new Scanner(results.get(6)); //
		assertEquals(scan.next(), "aaalove");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		scan = new Scanner(results.get(7)); 
		assertEquals(scan.next(), "noReplyDotCom");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
                
	}
	
}
