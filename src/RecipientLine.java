
/**
 * RecipientLine uses a Queue of Recipients to simulate queuing and dequeuing Recipients
 * to and from the RecipientLine
 * 
 * @author Matthieu Eric Moundou
 * 
 */

public class RecipientLine {
    
    private MyQueue recipientLineQueue; 
    
    /**
     * RecipientLine() creates a recipientLine object whose capacity is determined by 
     * the internal queue's default size 
     * 
     */
    
    public RecipientLine() {
        recipientLineQueue = new MyQueue<Recipient>();     
    }
    
    /**
     * RecipientLine(int size) creates a RecipientLine object whose capacity is
     * determined by the integer parameter "size"
     * 
     */
     
    public RecipientLine(int size) {
        recipientLineQueue = new MyQueue<>(size); 
    }

    /**
     * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
     * @param rc a Recipient
     *return true if recipient is queued successfully
     * @return 
     * @throws RecipientException("The Recipent Queue is Full") if queue is full
     */
    
    public boolean addNewRecipient(Recipient rc) throws RecipientException {
        
        boolean wasAdded; 
        
        try {
            recipientLineQueue.enqueue(rc);
            wasAdded = true; 
            return wasAdded; 
        }
        catch(IllegalStateException e) {
            throw new RecipientException("The Recipient Queue is Full"); 
        }
        
    }
	 
    /**
     * When it is the recipient turn, recipient will be dequeued from the recipient line
     * @return a Recipient object
     * @throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
     */
	
    public  Recipient recipientTurn ()  throws RecipientException {
        
        Recipient temp; 
        
        try {
            temp = (Recipient) recipientLineQueue.dequeue();
            return temp; 
        }
        catch(Exception e) {
            throw new RecipientException("The Recipient Queue is empty"); 
        }
        
    }
	
    /**
     * check if Recipient  queue line is empty
     * @return true if queue is empty, false otherwise
     */
    
    public  boolean recipientLineEmpty() {
        
        return recipientLineQueue.isEmpty(); 
        
    }
	 
    /**
     * Returns an array of the Recipients in the queue.  
     * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
     * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
     * But since the individual elements of the array are still Recipients, we can copy them one 
     * by one into a new array	of type Recipient and cast each one to Recipient. 
     * So create a new array of Recipients of the same length as temp, run a for-loop that casts each element 
     * of temp to Recipient and copies it to the corresponding position in the new array.  Then return the new array.
     * @return an array of the Recipients in the queue
     */
    
    public Recipient[] toArrayRecipient() {
        
        Recipient[] RecipientlineQueueToArray = (Recipient[]) recipientLineQueue.toArray();
        Recipient[] temp = new Recipient[RecipientlineQueueToArray.length]; 
        
        for(int index = 0; index < RecipientlineQueueToArray.length; index++) 
            temp[index] = (Recipient) RecipientlineQueueToArray[index]; 
        
        return temp;
        
    }
    
}
