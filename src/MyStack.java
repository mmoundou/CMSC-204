/**
 * MyStack<T> implements StackInterface<T>
 * 
 * @param <T> data type
 * 
 * @author Matthieu Eric Moundou
 * 
 */

import java.util.Arrays; 

public class MyStack<T> implements StackInterface<T> {
    
    
    private T[] array;
    private int numEntries;
    private static final int DEFAULT_CAPACITY = 10; 
    private final int MAX_CAPACITY = 10; 
    private boolean integrityOK = false;
    private int topIndex;
    
    
    /**
     * MyStack() creates a MyStack object whose capacity is determined by
     * DEFAULT_CAPACITY
     * 
     */
    
    public MyStack () {
        this(DEFAULT_CAPACITY); 
    }
    
    /**
     * MyStack(int capacity) creates a MyStack object whose capacity is determined
     * by the integer parameter capacity
     * 
     * @param capacity determines the size of MyStack
     * 
     */
    
    public MyStack(int capacity) {
        
        if(capacity <= MAX_CAPACITY) {
            
            @SuppressWarnings("unchecked")
            T[] temp = (T[]) new Object[capacity]; 
            array = temp; 
            numEntries = 0;
            topIndex = array.length; 
            integrityOK = true; 
            
        }
        else if(capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempted to create a Stack" +
                        "whose capacity excees the maximum capacity" + 
                    MAX_CAPACITY); 
        else
            throw new SecurityException("Queue is corrupt");
        
    }
	
    /**
    * Determines if Stack is empty
    * @return true if Stack is empty, false if not
    */
    
    @Override
    public boolean isEmpty() {
        return numEntries == 0; 
    }

    /**
    * Determines if Stack is full
    * @return true if Stack is full, false if not
    */
    
    @Override
    public boolean isFull() {
        return topIndex == 0; 
    }
	
    /**
    * Deletes and returns the element at the top of the Stack
    * @return the element at the top of the Stack
    */
    
    @Override
    public T pop() {
        
        T temp = null; 
        
        try {
            
            ensureIsNotEmpty();
            temp = array[topIndex]; 
            array[topIndex] = null; 
            topIndex++; 
        }
        catch(Exception e) {
            //We might have to return null values to signal that pop couldn't perform as expected 
        }
        return temp; 
        
    }

    /**
    * Number of elements in the Stack
    * @return the number of elements in the Stack
    */
    
    @Override
    public int size() {
        
        return numEntries; 
        
    }
	
    /**
    * Adds an element to the top of the Stack
    * @param e the element to add to the top of the Stack
    * @return true if the add was successful, false if not
    */
    
    @Override
    public boolean push(T e) {
        
        boolean isSuccessful;
        checkIntegrity();
        
        if(!isFull()) {
            
            array[topIndex] = e; 
            numEntries++; 
            topIndex--; 
            isSuccessful = true;
            
            return isSuccessful; 
            
        }
        else
            throw new IllegalStateException("Attempted to create a Stack" +
                        "whose capacity excees the maximum capacity" + 
                    MAX_CAPACITY);
        
    }
    
    /**
     * checkIntegrity checks that our MyStack object is not corrupt, and throws
     * a SecurityException if it is
     * 
     */
    
    private void checkIntegrity() {
        
        if(!integrityOK)
            throw new SecurityException("Stack is corrupt");  
        
    }
    
    /**
     * ensureIsNotEmpty() checks that MyStack is not empty before attempting
     * to invoke pop() and throws Exception if it's not 
     * 
     */
    
    private void ensureIsNotEmpty() throws Exception {
        
        if(isEmpty())
            throw new Exception("Attempted pop on an empty Stack");
        
    }
    
    /**
    * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
    * @return an array of the Objects in the Stack
    */
    
    @Override
    public T[] toArray() {
        
        T[] temp = Arrays.copyOf(array, numEntries);
        
        return temp; 
        
    }
    
}
