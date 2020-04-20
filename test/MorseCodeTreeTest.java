
/**
 * 
 * MorseCodeTreeTest test  
 * @author Matthieu Eric Moundou
 * 
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import java.util.*; 

public class MorseCodeTreeTest {
    
    LinkedConverterTreeInterface morseTree; 
    
        @Before
	public void setUp() throws Exception {
            morseTree = new MorseCodeTree(); 
	}

	@After
	public void tearDown() throws Exception {
            morseTree = null; 
	}

	@Test
        public void buildTree() {
     
            morseTree.buildTree();
            Assert.assertEquals("", morseTree.getRoot().getData()); 
            Assert.assertEquals("e", (String) morseTree.getRoot().leftChild.getData());
            Assert.assertEquals("t", (String) morseTree.getRoot().rightChild.getData());

        }

        
        @Test
        public void testSetRoot() {
        
            morseTree.setRoot(new TreeNode("dummy val"));
            Assert.assertEquals("dummy val", morseTree.getRoot().getData());
            
        }
        
        @Test
        public void testGetRoot() {
        
            Assert.assertEquals("", (String) morseTree.getRoot().getData());
        }
        
        @Test
        public void testFetch() {
            
            Assert.assertEquals(morseTree.fetch("..-"), "u");
            Assert.assertEquals(morseTree.fetch(".-."), "r");
            Assert.assertEquals(morseTree.fetch(".--"), "w");
            Assert.assertEquals(morseTree.fetch("-.."), "d");
            Assert.assertEquals(morseTree.fetch("-.-"), "k");
            Assert.assertEquals(morseTree.fetch("--."), "g");
            Assert.assertEquals(morseTree.fetch("---"), "o");
        
        }

    
  
}
