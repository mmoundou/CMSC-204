
/**
 * Container uses a Stack of DonationPackage to simulate stacking and removing DonationPackages
 * to and from a container object.
 * 
 * @author Matthieu Eric Moundou
 * 
 */

public class Container {
    
    
    private MyStack<DonationPackage> packageStack;
    
    
    /**
     * Container() creates a Container object whose size is the internal stack's
     * default size
     */
    
    public Container() {
        packageStack = new MyStack<>(); 
    }
    
    /**
     * Container(int size) creates a container object whose capacity is specified
     * by the integer parameter size
     * @param size is an integer value representing the Containers size
     */
    
    public Container(int size) {
        packageStack = new MyStack<>(size); 
    }
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * Return true if the package is stacked, false if the container is full
         * @return 
	 * @throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
            boolean wasLoaded; 
            try {
                packageStack.push(dPackage); 
                wasLoaded = true;
                return wasLoaded; 
            }
            catch(IllegalStateException e) {
                throw new ContainerException("The Container is Full"); 
            }
        }
	 
	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	public DonationPackage removePackageFromContainer() throws ContainerException {
            DonationPackage temp; 
            try {
                temp = packageStack.pop();
                return temp; 
            }
            catch(Exception e) {
                throw new ContainerException("The Container is Empty"); 
            }
        }

	/**
	 * Returns an array of the DonationPackages in the stack.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic stack returns is an array of 
	 * type Object , i.e., Object[] temp. But since the individual elements of the array are still DonationPackages,
	 * we can copy them one by one into a new array	of type DonationPackage and cast each one to DonationPackage. 
	 * So create a new array of DonationPackages of the same length as temp, run a for-loop that casts each element 
	 * of temp to DonationPackage, and copies it to the corresponding position in the new array.  Then return the new array.
	 * 
	 * @return an array of the DonationPackages in the stack
	 */
	public DonationPackage[] toArrayPackage() {
            
            DonationPackage[] stackToArray = packageStack.toArray(); 
            DonationPackage[] temp = new DonationPackage[packageStack.size()];
            
            for(int index = 0; index < stackToArray.length; index++)
                temp[index] = (DonationPackage) stackToArray[index];  

            return temp; 
        }
    
}
