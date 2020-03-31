
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the ConcordanceDataManager
 * which is implemented from the ConcordanceDataManagerInterface
 * 
 * @author Matthieu Eric Moundou
 *
 */

public class ConcordanceDataManager_STUDENT_Test {
    
	private ConcordanceDataManagerInterface concordanceManager = new ConcordanceDataManager();
	private File input, output;
        private String string; 

	/**
	 * setUp creates an instance of ConcordanceDataManager
	 * Create a string for testing
	 * @throws Exception
         * 
	 */
        
	@Before
	public void setUp() throws Exception {
		concordanceManager = new ConcordanceDataManager();
                
                string = "Love is such a funny thing\n" + 
                            "Let it run amok\n" +
                                "and it can ruin your life"; 
 
	}

	/**
	 * Set concordanceManager reference to null
	 * @throws Exception
         * 
	 */
        
	@After
	public void tearDown() throws Exception {
		concordanceManager = null;
	}

	/**
	 * Test for the createConcordanceArray method
	 * Use the String text created in setUp()
         * 
	 */
        
	@Test
	public void testCreateConcordanceArray() {
		
                ArrayList<String> words = concordanceManager.createConcordanceArray(string);
                
		assertEquals(words.get(0),"amok: 2\n");
		assertEquals(words.get(1), "can: 3\n");
		assertEquals(words.get(2),"funny: 1\n");
		assertEquals(words.get(3),"let: 2\n");
		assertEquals(words.get(4),"life: 3\n");
		assertEquals(words.get(5),"love: 1\n");
		assertEquals(words.get(6),"ruin: 3\n");
		assertEquals(words.get(7),"run: 2\n");
		assertEquals(words.get(8),"such: 1\n");
		assertEquals(words.get(9),"thing: 1\n");
		assertEquals(words.get(10),"your: 3\n");
                
	}
	
	
	/**
	 * Test for createConcordanceFile method
	 * This is intended to be used with the test file:
	 * Now_is_the_time.txt
         * 
	 */
        
	@Test
	public void testCreateConcordanceFileA() {
            
		ArrayList<String> words = new ArrayList<>();
                
		try {
                    
			input = new File("Test1.txt");
                    try (PrintWriter inFile = new PrintWriter(input)) {
                        
                        inFile.print("Love is such a funny thing\n" +
                                "Let it run amok\n" +
                                "and it can ruin your life");
                        
                    }
			output = new File("Test1Out.txt");
                        
                    try (PrintWriter outFile = new PrintWriter(output)) {
                        
                        outFile.print(" ");
                        
                        concordanceManager.createConcordanceFile(input, output);
                        
                            try (Scanner scan = new Scanner(output)) {
                                
                                while (scan.hasNext())
                                    words.add(scan.nextLine());
                                
                            }
                    }
		 
			assertEquals(words.get(0),"amok: 2");
                        assertEquals(words.get(1), "can: 3");
                        assertEquals(words.get(2),"funny: 1");
                        assertEquals(words.get(3),"let: 2");
                        assertEquals(words.get(4),"life: 3");
                        assertEquals(words.get(5),"love: 1");
                        assertEquals(words.get(6),"ruin: 3");
                        assertEquals(words.get(7),"run: 2");
                        assertEquals(words.get(8),"such: 1");
                        assertEquals(words.get(9),"thing: 1");
                        assertEquals(words.get(10),"your: 3");
                        
                        
		} catch (FileNotFoundException e) {
                    
			// TODO Auto-generated catch block
			fail("This should not have caused an FileNotFoundException");
                        
		} catch (Exception e) {
                    
			// TODO Auto-generated catch block
			fail("This should not have caused an Exception");
                        
		}
                
	}

	/**
	 * Test for createConcordanceFile method
	 * Create an input "Test.txt" 
	 * and an output "TestOut.txt"
	 */
	
	@Test
	public void testCreateConcordanceFileB() {
		ArrayList<String> words = new ArrayList<String>();
		try {
			input = new File("Test2.txt");
			PrintWriter inFile = new PrintWriter(input);
			inFile.print("Into the woods,\n" + 
					"It's time to go,\n" + 
					"I hate to leave,\n" + 
					"I have to go.\n" + 
					"Into the woods\n" + 
					"It's time, and so\n" + 
					"I must begin my journey.\n" + 
					"Into the woods\n" + 
					"And through the trees\n" + 
					"To where I am\n" + 
					"Expected ma'am\n" + 
					"Into the woods\n" + 
					"To Grandmother's house\n" + 
					"And home before dark.\n");
			inFile.close();
			output = new File("TestOut1.txt");
			PrintWriter outFile = new PrintWriter(output);
		 
			concordanceManager.createConcordanceFile(input, output);
			Scanner scan = new Scanner(output);
			while (scan.hasNextLine())
			{
				words.add(scan.nextLine());
				
			}

			scan.close();
			outFile.close();
		for(int i=0; i<words.size(); i++)
			System.out.println(words.get(i));
		
			 
			assertEquals("before: 14", words.get(0));
			assertEquals("begin: 7", words.get(1));
			assertEquals("dark: 14", words.get(2));
			assertEquals("expected: 11", words.get(3));
			assertEquals("grandmother's: 13", words.get(4));
			assertEquals("into: 1, 5, 8, 12", words.get(9));
			assertEquals("journey: 7", words.get(11));
			assertEquals("woods: 1, 5, 8, 12", words.get(19));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateConcordanceFileC() {
		try {
			input = new File("Test3.txt");
			input.setReadable(false);
			output = new File("Test3Out.txt");
                    try (PrintWriter outFile = new PrintWriter(output)) {
                        outFile.print(" ");
                        
                        concordanceManager.createConcordanceFile(input, output);
                        assertTrue("This should have raised an exception", false);
                    }
		
		} catch (FileNotFoundException e) {
			assertTrue("This should have raised a FileNotFoundexception", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateConcordanceFileD() {
		try {
			input = new File("Test3.txt");
			output = new File("Test3Out.txt");
			output.setWritable(false);
			
			concordanceManager.createConcordanceFile(input, output);
			assertTrue("This should have raised an exception", false);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			assertTrue("This should have raised a FileNotFoundException", true);
		}
	}
	
}
