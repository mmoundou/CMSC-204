
/** MorseCodeConverter takes translate a morse expression into English
    @author Matthieu Eric Moundou
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MorseCodeConverter {
   
   private static MorseCodeTree ourMorseCodeTree = new MorseCodeTree();
  
  
   public MorseCodeConverter() {}

      
   /**
   *
   * Converts morse code into English expression
   * @param code - the morse code
   * @return a string representing the English translation
   * 
   */
   
   public static String convertToEnglish(String code)
   {
       String output = "";
       String[] word; 
       String[] letter; 
       
       word = code.split(" / ");
       
       for (String word1 : word) { 

           letter = word1.split(" ");
           
           for (String letter1 : letter) {

               output += ourMorseCodeTree.fetch(letter1); 
               
           }
           
           output += " ";
           
        }  

       output = output.trim();
      
       return output;
       
   }
  
  
  
   /**
   * 
   * Converts file morse code into English expression
   * @param codeFile - name of the File that contains Morse Code
   * @return the English expression from the morse code of the file
   * @throws java.io.FileNotFoundException if file wasn't found
   * 
   */
   
   public static String convertToEnglish(File codeFile) throws FileNotFoundException
   {
       String output = "";
       ArrayList<String> line = new ArrayList<>();
       String[] word; 
       String[] letter; 
      
       Scanner inputFile;
       inputFile = new Scanner(codeFile);
      
       while (inputFile.hasNext())
           line.add(inputFile.nextLine());
 
       inputFile.close();
       
       int i = 0;
       
       while(i < line.size()) {
           
           word = line.get(i).split(" / ");
          
           for (String word1 : word) {

               letter = word1.split(" ");
               
               for(String letter1 : letter) {

                   output += ourMorseCodeTree.fetch(letter1); 
                   
               }
               
               output += " ";
               
           }
           i++;
           
       }

       output = output.trim();
      
       return output;
   }

  
   /**
   * 
   * @return the data in the tree in LNR order separated by a space.
   * 
   */
   
   public static String printTree() {
       
       ArrayList<String> treeData;
      
       treeData = ourMorseCodeTree.toArrayList();
      
       String print = "";
      
       for(int i = 0; i < treeData.size(); i ++) {
           
           print += treeData.get(i) + " "; 
           
       }
      
       return print;
       
   }
   
}