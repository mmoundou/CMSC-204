/**
 * 
 * VolunteerLine uses a Queue of Volunteers to simulate queuing and dequeuing volunteers to and from the 
 * VolunteerLine.
 * 
 */
public class VolunteerLine implements VolunteerLineInterface {
    
    private MyQueue queue; 
    
    /**
     * VolunteerLine() creates a VolunteerLine object whose capacity is determined
     * by the internal queue's default size
     * 
     */
    
    public VolunteerLine() {
        
        queue = new MyQueue<Volunteer>(); 
    }
    
    /**
     * VolunterLine(int size) creates a VolunerLine object whose capacity is determined
     * by the integer parameter "size"
     * 
     * @param size
     */
    
    public VolunteerLine(int size) {
        
        queue = new MyQueue<Volunteer>(size);
        
    }
    
    /**
    * adds a new Volunteer to the volunteer line Queue
    * @param v A Volunteer object
    * @return true if volunteer is queued successfully
    * @throws VolunteerException("Volunteer Queue is full") is queue is full
    */
    
    public boolean  addNewVolunteer(Volunteer v) throws VolunteerException {
        
        boolean wasAdded; 
        
        try {
            queue.enqueue(v);
            wasAdded = true; 
            return wasAdded; 
        }
        catch(IllegalStateException e) {
            throw new VolunteerException("Volunteer Queue is full");
        }
        
    }
	 
    /**
    * removes volunteer from the volunteer queue line
    * @return Volunteer Object
    * @throws VolunteerException("Volunteer queue is empty") if queue is empty
    */
    
    public  Volunteer volunteerTurn () throws VolunteerException { 
        
        try {
            return (Volunteer) queue.dequeue();       
        }
        
        catch(Exception e) {
            throw new VolunteerException("Volunteer queue is empty");
        }
        
    }
 	  
    /**
    * checks if there are volunteers in line 
    * @return true if volunteer line is empty, true otherwise
    */
    
    public boolean volunteerLineEmpty() {
        
        return queue.isEmpty();
        
    }

    /**
    * Returns an array of the Volunteers in the queue.  
    * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
    * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
    * But since the individual elements of the array are still Volunteers, we can copy them one 
    * by one into a new array	of type Volunteer and cast each one to Volunteer. 
    * So create a new array of Volunteers of the same length as temp, run a for-loop that casts each element 
    * of temp to Volunteer and copies it to the corresponding position in the new array.  Then return the new array.
    * @return an array of the Volunteers in the queue
    */
    
    public Volunteer[] toArrayVolunteer() {
        Volunteer[] queueToArray = (Volunteer []) queue.toArray();
        Volunteer[] temp = new Volunteer[queueToArray.length]; 
        
        for(int index = 0; index < queueToArray.length; index++)
            temp[index] = (Volunteer) queueToArray[index]; 
        
        return temp; 
        
    }
    
}
