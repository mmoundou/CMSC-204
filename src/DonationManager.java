/**
 * DonationManager simulates the operation of adding a new package to the container stack, adding a new volunteer to the
 * volunteer line, adding a new recipient to the recipient line and donating a package from the container by the volunteer to the recipient.
 * 
 * @author Matthieu Eric Moundou
 * 
 */
public class DonationManager {
    
    private Container container;
    private VolunteerLine volunteerLine; 
    private RecipientLine recipientLine;
    
    public DonationManager() {
    
        container = new Container();
        volunteerLine = new VolunteerLine(); 
        recipientLine = new RecipientLine(); 
        
    }
        /**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
         * @return 
	 * @throws ContainerException if container is full
	 */
    
	public boolean managerLoadContainer(DonationPackage dPackage) throws  ContainerException {
            
            boolean wasLoaded; 
            
            container.loadContainer(dPackage);
            wasLoaded = true; 

            return wasLoaded;
            
        }
	 
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
        
	public  boolean  managerQueueVolunteer(Volunteer  v) throws  VolunteerException {
            
            boolean wasAdded; 
            
            try {
                volunteerLine.addNewVolunteer(v);
                wasAdded = true; 
                return wasAdded; 
            } 
            catch(VolunteerException e) {
                throw new VolunteerException("Volunteer Line is full"); 
            }
    
        }
	 
	/**
	 * adds a new Recipient to the queue of the Recipient line
         * @param r
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throws RecipientException("Recipient Line is full") if the Recipient line is full
	 */
        
	public boolean managerQueueRecipient(Recipient r) throws  RecipientException {
            
            boolean wasAdded;
            
            try {
                recipientLine.addNewRecipient(r);
                wasAdded = true; 
                return wasAdded; 
            }
            catch(IllegalStateException e) {
                throw new RecipientException("Recipient Line is full"); 
            }
            
        }


	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
         * @return 
	 * @throws VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throws ContainerExcpetion("Contain is empty") if the container is empty
	 * @throws RecipientException("Recipient Queue is empty") if there are no recipients
	 * 
	 */
        
	public  int donatePackage() throws VolunteerException, ContainerException, RecipientException {
            return -1;
        }
	
	/**
	 * Returns an array of DonationPackages
	 * @return an array of Donation Packages
	 */
        
	public DonationPackage[] managerArrayPackage() {
            
            DonationPackage[] temp = container.toArrayPackage();
            
            return temp;
            
        }
	
	/**
	 * Returns an array of Volunteers
	 * @return an array of Volunteers
	 */
        
	public Volunteer[] managerArrayVolunteer() {
            Volunteer[] temp = volunteerLine.toArrayVolunteer();
            
            return temp;    
        }
	
	/**
	 * Returns an array of Recipients
	 * @return an array of Recipients
	 */
        
	public Recipient[] managerArrayRecipient() {
            
            Recipient[] temp = recipientLine.toArrayRecipient();
            
            return temp;
            
        }
    
}
