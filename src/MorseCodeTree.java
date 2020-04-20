/**
 * MorseCodeTree is a class that builds a Tree contain Morse Code tokens
 * @author Matthieu Eric Moundou
 * 
 */

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    
    
   private TreeNode<String> root = null; 
   private String fetchedLetter; 
   

   public MorseCodeTree() {
       
       initializeTree(); /*Instead of calling buildTree() to build our tree object
                            we'll use the private method initializeTree to prevent 
                                any subclass of MorseCodeTree (our class)
                                    from overriding buildTree()
                         */
       
   }
  
  
   
   /**
   * addNode is a recursive method that adds element at the appropriate position in the tree.
   * @param root - the root of the tree 
   * @param code - the code
   * @param letter - the data 
   * 
   */

   @Override
   public void addNode(TreeNode<String> root, String code, String letter)
   {  
       
       if(code.length() == 1) {
           
           if (code.equals("."))
               root.leftChild = new TreeNode<>(letter);
           else
               root.rightChild = new TreeNode<>(letter);
  
        }
        else {  
           
           if(code.substring(0, 1).equals("."))
                addNode(root.leftChild, code.substring(1), letter);
           else 
                addNode(root.rightChild, code.substring(1), letter);
           
       }  
       
   }
  
   
   
   /**
    * 
    * insert adds an element to the appropriate position in the tree
    * @param code - code for the node to be added
    * @param letter - the letter for the new node to be added
    * @return - the reference to the MorseCodeTree object
    * 
    */
   
   @Override
   public MorseCodeTree insert(java.lang.String code, java.lang.String letter)
   {
       MorseCodeTree temp = this; 
       
       addNode(root, code, letter);
      
       return temp;  
       
   }
   

   /**
   * This method builds the MorseCodeTree by inserting the nodes of the tree level 
   * by level based on the code.
   * 
   */
   
   @Override
   public void buildTree(){
       
       initializeTree();
       
   }
        
     private void initializeTree() {
         
       root = new TreeNode<>("");
      
       
       insert(".", "e");
       insert("-", "t");
      
      
       insert("..", "i");
       insert(".-", "a");
       insert("-.", "n");
       insert("--", "m");
      
       
       insert("...", "s");
       insert("..-", "u");
       insert(".-.", "r");
       insert(".--", "w");
       insert("-..", "d");
       insert("-.-", "k");
       insert("--.", "g");
       insert("---", "o");

       
       insert("....", "h");
       insert("...-", "v");
       insert("..-.", "f");
       insert(".-..", "l");
       insert(".--.", "p");
       insert(".---", "j");
       insert("-...", "b");
       insert("-..-", "x");
       insert("-.-.", "c");
       insert("-.--", "y");
       insert("--..", "z");
       insert("--.-", "q"); 
       
   }
  
  
   /**
   * Returns a reference to the root
   * @return reference to root
   */
   
   @Override
   public TreeNode<String> getRoot()
   {
       
       TreeNode<String> temp = this.root;
       
       return temp;
  
   }

  
   /**
   * sets the root of the of the MorseCodeTree
   *
   * @param newNode a copy of newNode will be the new root
   */

   @Override
   public void setRoot(TreeNode<String> newNode) {
      
       root = newNode; 
       
   }

   
  
   /**
   * fetch returns the data in the tree based on the code
   * @param code - the code that describes the traversals within the tree
   * @return the string that corresponds to the code
   */
   
   @Override
   public String fetch(String code)
   {

       String temp = fetchNode(root, code);
      
       return temp;
       
   }


   /**
    * 
   * This is the recursive method that fetches the data of the TreeNode that corresponds with the code
   * @param root the root of the tree for this particular recursive instance of addNode
   * @param code the code for this particular recursive instance of fetchNode
   * @return the string (letter) corresponding to the code
   * 
   */
   
   @Override
   public String fetchNode(TreeNode<String> root, String code)
   {  
       
       if(code.length() == 1) {
           
           if (code.equals("."))
               fetchedLetter = root.leftChild.getData();
           else
               fetchedLetter = root.rightChild.getData();
       }
       else {  
           if(code.length() > 1) {
               
            if(code.substring(0, 1).equals("."))
                fetchNode(root.leftChild, code.substring(1));
            else
                fetchNode(root.rightChild, code.substring(1)); 

           }
           
       }
     
       return fetchedLetter; 
       
   }

  
   /**
    * 
   * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order. 
   * Used for testing to make sure tree is built correctly
   * @return an ArrayList of the items in the linked Tree
   * 
   */
   
   @Override
   public ArrayList<String> toArrayList() {
       
       ArrayList<String> temp = new ArrayList<>();

       LNRoutputTraversal(root, temp);      

       return temp;
       
   }

  
   /**
    * 
   * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
   *
   * @param root the root of the tree for this particular recursive instance
   * @param list the ArrayList that will hold the contents of the tree in LNR order
   * 
   */
   
   @Override
   public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
   {
       
       if(!(root == null)) {
           
           LNRoutputTraversal(root.leftChild, list);
           list.add(root.getData());
           LNRoutputTraversal(root.rightChild, list);
           
       }
       
   }
  
   /**
    * 
   * This operation is not supported for a LinkedConverterTree
   * @param data - data of node to be deleted
   * @return null
   * @throws UnsupportedOperationException
   * 
   */
   
   @Override
   public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
       
       return null;
       
   }

  
   /**
    * 
   * This operation is not supported for a LinkedConverterTree
   * @return null
   * @throws UnsupportedOperationException
   * 
   */
   
   @Override
   public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
       
       return null;
       
   }

}