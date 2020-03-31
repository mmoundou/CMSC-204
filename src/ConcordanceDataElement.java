
/**
 * 
 * ConcordanceDataElement implements Comparable<ConcordanceDataElement> and consists of a String (the word) 
 * and a reference to a LinkedList<Integer> (list of line numbers where word occurs). 
 * 
 * @author Matthieu Eric Moundou
 * 
 */



import java.util.*; 



public class ConcordanceDataElement implements Comparable<ConcordanceDataElement> {
 
    private LinkedList<Integer> pageNumList = new LinkedList<>();
    private String word;     
    
    /**
     * 
     * Parameterized constructor that takes a String argument representing the 
     * word to be added to the concordance table. 
     * @param word - String argument representing the word to be added to the 
     * concordance table.
     * 
     */
    
    public ConcordanceDataElement(String word) {
    
        this.word = word; 
        
    }
    
    
    
    /**
     * Add a line number to the linked list if the number doesn't exist in the list
     * 
     * @param lineNum represents the line number 
     * 
     */
    
    public void addPage(int lineNum) {
        
        boolean contains = false; 

        for(int i : pageNumList) {
            
            if(i == lineNum) {
                
                contains = true; 
                break;
                
            }
            
        }
        
        if(contains == false)
            pageNumList.add(lineNum);
   
    }
    
    /**
     * 
     * @param arg0 - represents the concordance data element to be compared to.
     * @return an integer value representing the result of the comparison: 
     * It will return -1 if our data element is lesser than the parameter concordance element,
     * 0 if the two data elements are equal, and 1 if our data element is greater than the parameter
     * concordance data element.
     * 
     */
    
    @Override
    public int compareTo(ConcordanceDataElement arg0) {
 
        return word.compareTo(arg0.word);
        
    }
    
    
    
    /**
     * Returns the linked list of integers that represent the line numbers
     * 
     * @return a reference of the linked list of page numbers
     * 
     */
    
    public LinkedList<Integer> getList() {
        
        LinkedList<Integer> temp = pageNumList;
        
        return temp; 
        
    }
    
    
    
    /**
     * Return the word portion of the Concordance Data Element
     * @return the word of the concordance
     * 
     */
    
    protected String getWord() {
        
        String temp = word;
        
        return temp; 
        
    }

    
   
    /**
     * Returns the hashCode. You may use the String class hashCode method
     * 
     */
    
    @Override
    public int hashCode() {
        
        return Math.abs(word.hashCode());
        
    }
     
    /** 
     * Returns the word followed by page numbers Returns a string in the following format: 
     *      word: page num, page num Example: after: 2,8,15
     * 
     */
    
    @Override
    public String toString() {
        
        String temp = word + ": ";  

        temp = pageNumList.stream().map((i) -> i + ", ").reduce(temp, String :: concat);  
        
        return temp.substring(0, temp.length() - 2) + "\n";
        
    }

    
}
