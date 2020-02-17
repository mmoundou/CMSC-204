/**
 * Queue class implements QueueInterface
 * 
 * @author Matthieu Eric Moundou
 * @param <T> represents a generic type 
 * 
 */


class Queue<T> implements QueueInterface<T> {
    
    @SuppressWarnings("unchecked")
    private T[] queueArray = (T[])new Object[10];
    private int frontIndex; 
    private int backIndex; 
    private int numEntries; 
    private final int MAX_CAPACITY = 1000;
    private boolean integrityOK = true; 
    
     /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
    
    public Queue(int initialCapacity) {
        @SuppressWarnings("unchecked") 
        T[] tempQueue = (T[]) new Object[initialCapacity + 1];
        queueArray = tempQueue; 
        frontIndex = 0; 
        backIndex = initialCapacity;   
    }

    @Override
    public void enqueue(T newEntry) {

      if(isFull())
          throw new FullQueueException(); 
      backIndex = (backIndex + 1) % queueArray.length;
      queueArray[backIndex] = newEntry; 
   
  }
  
  private boolean isFull() {
      
      return frontIndex == ((backIndex + 2) % queueArray.length); 
      
  }
  
  /** Removes and returns the entry at the front of this queue.
      @return  The object at the front of the queue. 
      @throws  EmptyQueueException if the queue is empty before the operation. */
    @Override
  public T dequeue() {
      
      if(isEmpty())
          throw new RuntimeException(); 
      else {
          T front = queueArray[frontIndex]; 
          queueArray[frontIndex] = null; 
          frontIndex = (frontIndex + 1) % queueArray.length;
          return front; 
      }
      
  }
  
  /**  Retrieves the entry at the front of this queue.
      @return  The object at the front of the queue.
      @throws  EmptyQueueException if the queue is empty. */
    @Override
  public T getFront() {
      
      T temp = queueArray[frontIndex]; 
      
      return temp; 
      
  }
  
  /** Detects whether this queue is empty.
      @return  True if the queue is empty, or false otherwise. */
    @Override
  public boolean isEmpty() {

      return frontIndex == ((backIndex + 1) % queueArray.length); 
      
  }
  
  /** Removes all entries from this queue. */
    @Override
    public void clear() {
      
      int index = 0; 
      
      while(index < queueArray.length) {
          
          queueArray[index] = null; 
          index = (index + 1) % queueArray.length;

      }
      
    }
    
}
