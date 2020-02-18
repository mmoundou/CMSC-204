/**
 * MyQueue<T> implements QueueInterface<T>
 * 
 * @param <T> data type
 * 
 * @author Matthieu Eric Moundou
 * 
 */

import java.util.Arrays;

public class MyQueue<T> implements QueueInterface<T> {
    
    private T[] array;
    private int numEntries; 
    private final int MAX_CAPACITY = 10;
    private static final int DEFAULT_CAPACITY = 10;
    private boolean integrityOK = false;
    private int frontIndex; 
    
    /**
     * MyQueue() creates a MyQueue object whose capacity is determined 
     * by the integer variable DEFAULT_CAPACITY
     * 
     */
    
    public MyQueue() { 
        this(DEFAULT_CAPACITY);  
    }
    
    /**
     * MyQueue(int capacity) creates a MyQueue object whose capacity is determined
     * by the integer parameter capacity
     * 
     * @param capacity
     */
    
    public MyQueue(int capacity) {
        
        if(capacity <= MAX_CAPACITY) {
            
            @SuppressWarnings("unchecked")
            T[] temp = (T[]) new Object[capacity]; 
            array = temp; 
            numEntries = 0;
            frontIndex = 0; 
            integrityOK = true;
            
        }
        else if(capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempted to create a Queue" +
                        "whose capacity excees the maximum capacity" + 
                    MAX_CAPACITY); 
        else
            throw new SecurityException("Queue is corrupt"); 
        
    }
    
    /**
     * Adds an element to the end of the Queue
     * @param newEntry the element to add to the end of the Queue
     * @return true if the add was successful, false if not
     */
    
    @Override
    public boolean enqueue(T newEntry) {
        
        int index; 
        checkIntegrity();
        
        if(!isFull()) {
            index = numEntries; 
            array[index] = newEntry; 
            numEntries++; 
        }
        else
            throw new IllegalStateException("Attempted to create a bag" +
                        "whose capacity excees the maximum capacity" + 
                    MAX_CAPACITY); 
        
        return false; 
        
    }
    
    /**
     * checkIntegrity() checks for a corrupt MyQueue object: if boolean variable
     * integrityOK evaluates to false, an exception is thrown.
     * 
     */
    
    private void checkIntegrity() {
        
        if(!integrityOK)
            throw new SecurityException("Queue is corrupt");  
        
    }
    
    /**
     * isFull() helps determine whether MyQueue object is full
     * 
     */
    
    @Override
    public boolean isFull() {
        return numEntries == array.length;
    }
    
    /**
     * Deletes and returns the element at the front of the Queue
     * @return the element at the front of the Queue
     */
    
    @Override
    public T dequeue() { 
       
        T temp = null; 
        
        try {
            ensureIsNotEmpty();
            temp = array[frontIndex]; 
            array[frontIndex] = null; 
            frontIndex++;
            numEntries--;
        }
        catch(Exception e) {
            //We might also have to return null here, to signal that dequeue couldn't peform as expected
        }
        
        return temp; 
        
    }
    
    /**
     * Determines of the Queue is empty
     * @return
     * */
    
    @Override
    public boolean isEmpty() {
        
        return numEntries == 0;  
        
    }
    
    /**
     * ensureIsNotEmpty checks whether dequeue is called on an empty
     * MyQueue object and throws an exception if that's the case
     * 
     */
    
    private void ensureIsNotEmpty() throws Exception {
        
        if(isEmpty())
            throw new Exception("Attempted dequeue on an empty queue");
        
    }

    /**
     * Number of elements in the Queue
     * @return the number of elements in the Queue
     */
    
    @Override
    public int size() {
        
        int temp = numEntries; 
        
        return temp;
        
    }
	
    /**
     * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
     * @return an array of the Object elements in the Queue
     */
	 
    @Override
    public T[] toArray() {
        
        T[] temp = Arrays.copyOf(array, numEntries);
        
        return temp; 
        
    }
	   
}
