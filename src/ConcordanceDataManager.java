
/**
 * This program makes a concordance for a file or a String.  
 * A concordance lists all the words that occur in the file or String,
 * along with all the line numbers on which each word occurs.
 * (Words of length less than 3 are omitted, "and" and "the" are omitted.)
 * Strip out all punctuation, except apostrophes that occur in the 
 * middle of a word, i.e. letís, weíd, etc.
 * 
 * Uses an object that implements ConcordanceDataStructureInterface
 * 
 * @author Matthieu Eric Moundou
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class ConcordanceDataManager implements ConcordanceDataManagerInterface {
    
    private static ConcordanceDataStructure dataStructure;
    private final int TABLE_SIZE = 347;


    /**
     * concordanceDataManager() creates a new ConcordanceDataStructure
     * 
     */
    
    public ConcordanceDataManager() {
        
        dataStructure = new ConcordanceDataStructure(TABLE_SIZE);
        
    }
    
    /**
     * 
     * Display the words in Alphabetical Order followed by a :, 
     * followed by the line numbers in numerical order, followed by a newline
     * here's an example:
     * after: 129, 175
     * agree: 185
     * agreed: 37
     * all: 24, 93, 112, 175, 203
     * always: 90, 128
     * 
     * @param input a String (usually consist of several lines) to 
     * make a concordance of
     * @return an ArrayList of Strings.  Each string has one word,
     * followed by a :, followed by the line numbers in numerical order,
     * followed by a newline.
     * 
     */

    @Override
    public ArrayList<String> createConcordanceArray(String input) {

        int lineNum = 1;
        String string; 

        while (!input.isEmpty()) {
            
            if (!input.contains("\n")) {

                string = input;
                input = "";
                
            } 
            
            else {
                
                string = input.substring(0, input.indexOf("\n"));
                input = input.substring(input.indexOf("\n") + 1);
                
            }
            
            while (!string.isEmpty()) {
                
                string = string.toLowerCase();
                string = string.replaceAll("[^a-zA-Z0-9'\\s]+", "");
                string = string.replaceAll("and |the ", "");
                
                String[] checkWords;
                checkWords = string.split(" ");
                string = "";

                if (checkWords.length != 0) {
                    
                    for (String checkWord : checkWords) {
                        
                        if (checkWord.length() >= 3) {
                            
                            String word;
                            word = checkWord;
                            dataStructure.add(word, lineNum);
                            
                        }
                        
                    }

                }
            }
            
            lineNum++;
            
        }
        
        return dataStructure.showAll();
        
    }
    
    /**
	    * Creates a file that holds the concordance  
	    * 
	    * @param input the File to read from
	    * @param output the File to write to
	    *  
	    * Following is an example:
	    * 
		* about: 24, 210
		* abuse: 96
		* account: 79
		* acknowledged: 10
		* 
	    * @return true if the concordance file was created successfully.
	    * @throws FileNotFoundException if file not found
	    */

    @Override
    public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
        
        int lineNum = 0; 
        String word;
        String lineString;  
        Scanner lineScanner;
        
        Scanner fileInput = new Scanner(input); //Scans the input file 

        while(fileInput.hasNextLine()) {
            
            lineString = fileInput.nextLine(); 
            lineString = lineString.replaceAll("[^a-zA-Z0-9'\\s]+"," "); /* This code strips each line
                                                                         of any punctuation that is not an apostrophe */
            lineScanner = new Scanner(lineString);
            lineNum++;
            
            while(lineScanner.hasNext()) {
                    
                word = lineScanner.next();

                if ((word.length() >= 3) && (!word.equalsIgnoreCase("the")) && (!word.equalsIgnoreCase("and")))
                    dataStructure.add(word.toLowerCase(), lineNum);
                    
      
            }
            
        }

        try (PrintWriter out = new PrintWriter(output)) {
            
            ArrayList<String> words = dataStructure.showAll(); 
            
            for (Iterator<String> it = words.iterator(); it.hasNext();) {
                
                String x = it.next();
                out.print(x);
                
            }
            
        }
        
        return true;
            
    }
    
}
    
