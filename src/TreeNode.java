

/**
 * TreeNode<T> represents the internal structure of the collection we'll use to 
 * convert English expressions into Morse and vice versa
 * @author Matthieu Eric Moundou
 * @param <T> 
 * 
 */

public class TreeNode<T> {
    
   protected T data;
   protected TreeNode<T> leftChild;  
   protected TreeNode<T> rightChild;
  
   
   /**
   * 
   * TreeNode creates a new TreeNode object
   * @param data - the data to be stored in the TreeNode
   * 
   */
   
   public TreeNode (T data)
   {  
       this.data = data;
       this.leftChild = null;
       this.rightChild = null;
       
   }
  
   /**
   *
   * @return - the data within the TreeNode object
   * 
   */
   
   public T getData() {
       
       T temp = data; 
       return temp;
       
   }
  
}