/**
 * This generic double-linked list relies on a head (reference to first element of the list) 
 * and tail (reference to the last element of the list). Both are set to null when the list is empty. 
 * Both point to the same element when there is only one element in the list. 
 * A node structure has only three fields: data and the prev and next references. 
 * The class must only define the following entities: an inner class Node, 
 * an inner class that implements ListIterator (for the iterator method), 
 * head and tail references and an integer representing the list size. 
 * However only the hasNext(), next(), hasPrevious() and previous() methods of ListIterator need to be implemented, 
 * all other methods can throw the UnsupportedOperationException:
 * public void remove() throws UnsupportedOperationException{
 * throw new UnsupportedOperationException();}
 * All the entities are defined as protected so they can be accessed by the subclasses.
 * 
 * @author Matthieu Eric Moundou
 * 
 */

import java.util.*; 

public class BasicDoubleLinkedList<T> {
    
    private Node topNode;
    private Node tail; 
    private int numEntries; 
    private boolean integrityOK; 
    
    /**
     * public BasicDoubleLinkedList() creates a BasicDoubleLinkedList object
     * and initializes the data fields to java's default values
     * 
     */
    
    public BasicDoubleLinkedList() {
        
        topNode = tail = null;
        numEntries = 0; 
        integrityOK = true; 
        
    }
    
    /**
     * Adds an element to the end of the list. Do not use iterators to implement this method.
     * @param data specifies the data to be inserted in the newly allocated Node object
     * @return a reference to the current Node object
     * 
     */
    
    public BasicDoubleLinkedList<T> addToEnd(T data) {

        checkIntegrity(); 
        add(data); 
        
        Node newNode = new Node(data); 
        tail.next = newNode; 
        newNode.previous = tail;
        tail = newNode; 
        numEntries++; 

        return this; 
        
    }
    
    /**
     * Adds element to the front of the list. Do not use iterators to implement this method.
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     * 
     */
    
    public BasicDoubleLinkedList<T> addToFront(T data) {
        
        checkIntegrity();
        add(data); 
        
        Node newNode = new Node(data); 
        topNode.previous = newNode; 
        newNode.next = topNode; 
        topNode = newNode; 
        numEntries++;
        
        return this; 

    }
    
    /**
     * Adds an element to our list in such a way that the top node and the last
     * both reference the same element
     * @param - data represents the data to be added to our Node object
     * 
     */
    
    private void add(T data) {
        
        if(numEntries == 0) {
            
            Node newNode = new Node(data); 
            topNode = tail = newNode; 
            numEntries++; 
            
        }
        
    }
    
    /**
     * Returns but does not remove the first element from the list. 
     * If there are no elements the method returns null. 
     * Do not implement this method using iterators.
     * @return - the data element or null
     * 
     */
    
    public T getFirst() {
        
        T temp = topNode.data; 
        
        return temp; 
    }
    
    /**
     * Returns but does not remove the last element from the list. 
     * If there are no elements the method returns null. 
     * Do not implement this method using iterators.
     * @return - the data element or null
     * 
     */
    
    public T getLast() {
        
        T temp = tail.data; 
        
        return temp;    
    }
    
    /**
     * Notice you must not traverse the list to compute the size. 
     * This method just returns the value of the instance variable you use to keep track of size.
     * @return - the size of the linked list
     * 
     */
    
    public int getSize() {
        
        int temp = numEntries; 
        
        return temp; 
        
    }
    
    /**
     * This method must be implemented using an inner class that implements ListIterator 
     * and defines the methods of hasNext(), next(), hasPrevious() and previous(). 
     * Remember that we should be able to call the hasNext() method as many times 
     * as we want without changing what is considered the next element.
     * Specified by: iterator in interface java.lang.Iterable<T>
     * @return 
     * @throws:
     *  java.util.NoSuchElementException - Your next() method should throw NoSuchElementException 
     *      if there are no more elements (at the end of the list and calling next() 
     *      or at the beginning of the list and calling previous()).
     *  java.lang.UnsupportedOperationException - You don't need to implement the ListIterator's 
     *      remove(), add(), nextIndex() and previousIndex() and set() methods, throw UnsupportedOperationException if called.
     */
    
    public java.util.ListIterator<T> iterator() {
        
        OurListIterator iterator = new OurListIterator(); 
        
        return null; 
    }
    
    /**
     * Removes the first instance of the targetData from the list. 
     * Notice that you must remove the elements by performing a single traversal over the list. 
     * You may not use any of the other retrieval methods associated with the class in order to complete the removal process. 
     * You must use the provided comparator (do not use equals) to find those elements that match the target. 
     * Do not implement this method using iterators.
     * @param comparator - the comparator to determine equality of data elements
     * @param targetData - the data element to be removed
     * @return - data element or null
     * 
     */
    
    public BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) {
        
        Node temp = topNode; 
        
        checkIntegrity();
        
        while(!(temp == null)) {
            
            if(comparator.compare(temp.data, targetData) == 0) {  
                temp.data = null; 
                break;    
            }
            
            temp = temp.next; 
            
        }

        return this;  
    }
    
    /**
     * Removes and returns the first element from the list. 
     * If there are no elements the method returns null. 
     * Do not implement this method using iterators.
     * @return - data element or null
     */
    
    public T retriveFirstElement() {
        
        return (T) new Object(); 
    }
    
    /**
     * Removes and returns the last element from the list. 
     * If there are no elements the method returns null. 
     * Do not implement implement this method using iterators.
     * @return - data element or null
     * 
     */
    
    public T retriveLastElement() {
        return (T) new Object(); 
    }
    
    /**
     * Returns an arraylist of the items in the list from head of list to tail of list
     * @return - an arraylist of the items in the list
     * 
     */
    
    java.util.ArrayList<T> toArrayList() {
        return new ArrayList<T>(); 
    }
    
    private void checkIntegrity() {
        
        if(!integrityOK)
            throw new IllegalStateException("Corrupt List");
        
    }
    
    private boolean isEmpty() {
        
        return numEntries == 0; 
        
    }
   
	private class OurListIterator implements ListIterator<T> {
            
		private Node currentNode;
                private Node interimNode;
                
                public OurListIterator() {
                    
                    currentNode = topNode; 
                    
                }

		/**
                 * boolean hasNext() returns true if this list iterator has 
                 *      more elements when traversing the list in the forward direction. 
                 * (In other words, returns true if next() would return an element rather than throwing an exception.)
                 * Specified by: hasNext in interface Iterator<E>
                 * @return - true if the list iterator has more elements when traversing the list in the forward direction
                 * 
		 */
                
                @Override
		public boolean hasNext() {
                    
			return currentNode.next != null;
                        
		}

		/**
                 * Returns the next element in the list and advances the cursor position. 
                 * This method may be called repeatedly to iterate through the list, 
                 *      or intermixed with calls to previous() to go back and forth. 
                 * (Note that alternating calls to next and previous will return the same element repeatedly.)
                 * @return - the next element in the list
                 * @throws - NoSuchElementException - if the iteration has no next element
                 * 
		 */
                
                @Override
		public T next() {
                    
			if (!hasNext()){
                            
				throw new NoSuchElementException();
                                
			} 
                        else { 
                            
                            interimNode = currentNode.next; 
                            currentNode = interimNode; 
                            
                            return interimNode.getData(); 
		
			}
                        
		}

		@Override
		public T previous() {
                    
			if (!hasPrevious()) {
                            
				throw new NoSuchElementException();
                                
			} 
                        else {
                            
                            interimNode = currentNode.previous; 
                            currentNode = interimNode; 
                            
                            return interimNode.getData(); 
                            

			}
		}

		@Override
		public boolean hasPrevious() {
                    
			return currentNode.previous != null;
                        
		}

                @Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException();
		}		

		@Override
		public int nextIndex() throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
                
	}


	
    private class Node {
        
        T data; 
        Node previous, next; 
        
        protected Node() {
            this(null); 
        }
        
        protected Node(T data) {
            
            this.data = data; 
            
        } 
        
        public T getData() {
            
            T temp = data; 
            
            return temp;
            
        }
        
        public void setData(T data) {
            
            this.data = data; 
            
        }
        
        public void setPrevious(Node node) {
            
            previous = node;
            
        }
        public Node getPrevious() {
            
            Node temp = previous; 
            
            return temp; 
            
        }
        
        public void setNext(Node node) {
            
            next = node; 
            
        }
        
        public Node getNext() {
            
            Node temp = next; 
            
            return temp; 
            
        }
        
    }
  
}