
/**
 * 
 * This is the Concordance Data Structure class, used with the Concordance Data Manager class.
 * 
 * @author Matthieu Eric Moundou
 * 
 */



import java.util.*; 



public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {
    
    private LinkedList<ConcordanceDataElement>[] hashTable; 
    private LinkedList<ConcordanceDataElement> hashList = new LinkedList<>();
    private int size; 
    private int num; /*The size of the table when the client of ConcordanceDataStructure
                            creates a ConcordanceDataStructure object */
    private double k; //4K + 3
    private final double LOAD_FACTOR  = 1.5; 
    private ConcordanceDataElement dataElementTest; 
    
    
    /** This constructor takes in an integer which represents the estimated number of words in the text. 
      * Determine the size of the table by using a loading factor of 1.5 and a 4K+3 prime. 
      * Example if you estimated 500 words, 500/1.5 = 333. The next 4K+3 prime over 333 is 347. 
      * So you would make the table a length of 347.
      * 
      * @param num indicates the tentative size of the hash table
      * 
      */
    
    public ConcordanceDataStructure(int num) {
        
        String kToString;
        this.num = (int)(num / LOAD_FACTOR); 
         
        for(; ;this.num++) {

            k = (this.num - 3) / 4.0;
            kToString = String.valueOf(k);  
            
            if(isPrime(this.num) && is4KPrime(kToString))
                break;

        }
        
        size = this.num; 
        hashTable = new LinkedList[size];

        for(int i = 0; i < hashTable.length; i++)
            hashTable[i] = hashList;
    
    }
    
    private boolean isPrime(int num) {
            
        if (num % 2 == 0) 
            return false;
        
        for(int i = 3; i * i <= num; i += 2) {
            
            if(num % i == 0)
                return false;
            
        }
        
        return true;
        
    }
    
    private boolean is4KPrime(String kToString) {
        
        return kToString.substring(kToString.indexOf(".") + 1).charAt(0) == '0';
    
    }
    
    
    /**
     * 
     * Parameterized constructor that takes in a String argument that will be testing, 
     * and an integer argument representing the estimated number of words in the text
     * @param test - a String argument used for testing purposes
     * @param size - an integer argument representing the estimated number of words
     * in the text. 
     *
     */
    
    public ConcordanceDataStructure(String test, int size) {

       this.size = size;
       hashTable = new LinkedList[this.size];
       
       for(int i = 0; i < hashTable.length; i++)
            hashTable[i] = hashList; 
         
    }
    
    
    
   /**
    * 
    * Use the hashcode of the ConcordanceDataElement to see if it is in the hashtable. 
    * If the word does not exist in the hashtable - Add the ConcordanceDataElement to the hashtable. 
    * Put the line number in the linked list If the word already exists in the hashtable 
    *   1. add the line number to the end of the linked list in the ConcordanceDataElement 
    *   (if the line number is not currently there).
    * @param term the string to add to the concordance
    * 
    */
    
    @Override
    public void add(String term, int lineNum) {
    
        boolean itContains = false;
        ConcordanceDataElement dataElement = new ConcordanceDataElement(term);
        int hashIndex = dataElement.hashCode() % size;
        LinkedList<ConcordanceDataElement> indexedList = hashTable[hashIndex];
        LinkedList<ConcordanceDataElement> tempList = new LinkedList<>();
        ListIterator<ConcordanceDataElement> listIterator = indexedList.listIterator();
        dataElement.addPage(lineNum);
    
        
    
        while(listIterator.hasNext()) {
        
            ConcordanceDataElement next = listIterator.next();
            tempList.add(next);
        
        }
    
        for(int i = 0; i < tempList.size(); i++) {
        
            if(dataElement.getWord().equals(tempList.get(i).getWord())) {
            
                itContains = true;
                tempList.get(i).addPage(lineNum);
                break;
            
            }
        
        }
    
        if(itContains == false)
            tempList.add(dataElement);
    
        hashTable[hashIndex] = tempList;
 
    }
    
    /**
     * 
     * Returns an ArrayList of the Linked list of page numbers for each word at this index [0] 
     * of the ArrayList holds the LinkedList of page numbers for the first word in the "bucket" (index) 
     * [1] of the ArrayList holds the LinkedList of page numbers for next word in the "bucket", etc. This is used for testing
     * 
     */
    
    @Override
    public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {
        
        ArrayList<LinkedList<Integer>> temp = new ArrayList<>(); 
        
        for(int j = 0; j < hashTable[index].size(); j++) 
            temp.add(hashTable[index].get(j).getList()); 

        return temp; 
        
    }
    
    
    
    /**
     * Returns the size of the ConcordanceDataStructure (number of indexes in the array)
     * @return  the size of the table
     * 
     */
    
    @Override
    public int getTableSize() {
        
        int temp = hashTable.length;
        
        return temp; 
        
    }
    
    
    
    /** 
     * 
     * Returns an ArrayList of the words at this index [0] of the ArrayList holds the first word in the "bucket" 
     * (index) [1] of the ArrayList holds the next word in the "bucket", etc. This is used for testing
     * 
     */
    
    @Override
    public ArrayList<String> getWords(int index) {
        
        ArrayList<String> temp = new ArrayList<>(); 
        
        for(int j = 0; j < hashTable[index].size(); j++)
            temp.add(hashTable[index].get(j).getWord()); 
        
        return temp; 
        
    }
    
    /**
     * 
     * Description copied from interface: ConcordanceDataStructureInterface
     * Display the words in Alphabetical Order followed by a :, followed by the line numbers in numerical order, 
     * followed by a newline here's an example: after: 129, 175 agree: 185 agreed: 37 all: 24, 93, 112, 175, 203 always: 90, 128
     * 
     */
    
    @Override
    public ArrayList<String> showAll() {
        
        ArrayList<String> arrayList = new ArrayList<>(); 
        
        for (LinkedList<ConcordanceDataElement> hashTable1 : hashTable) {
            
            for (int j = 0; j < hashTable1.size(); j++) 
                arrayList.add(hashTable1.get(j).toString());
            
        }
        
        Collections.sort(arrayList); 
        
        return arrayList;
        
    }
    
}
