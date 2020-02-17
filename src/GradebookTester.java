/**
  @author Matthieu Eric Moundou
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GradebookTester {

	private GradeBook gradebook1;
	private GradeBook gradebook2;
	
	@Before
	public void setUp()
	{
		gradebook1 = new GradeBook(5);
		gradebook1.addScore(50.0);
		gradebook1.addScore(75.0);

		gradebook2 = new GradeBook(5);
		gradebook2.addScore(10.0);
		gradebook2.addScore(30.0);
		
		
	}
	
	@After
	public void tearDown()
	{
		gradebook1 = null;
		gradebook2 = null;
	}

	/**
	 * Compare the total,when all the numbers are added.
	 * 
	 * */
	 @Test
	public void intestSum()
	{
		assertEquals(125.0, gradebook1.sum(), .0001);
		assertEquals(40.0, gradebook2.sum(), .0001);
	}
	
	/**
	 * Comapre the minimum of the numbers
	 * */
	@Test
	public void intestMinimum()
	{
		assertEquals(50.0, gradebook1.minimum(), .001);
		assertEquals(10.0, gradebook2.minimum(), .001);
	}
	
	/**
	 * Compare the results that are on the arrays to the ones that are going to be displayed
	 * */
	@Test
	public void inaddScoreTest()
	{
		assertTrue((gradebook1.toString()).equals("50.0 75.0 "));
		assertTrue((gradebook2.toString()).equals("10.0 30.0 "));
		
		assertEquals(2, gradebook1.getScoreSize(), 0.001);
		assertEquals(2, gradebook2.getScoreSize(), 0.001);
		
	}
	
	/**
	 * compare the maximun of the numbers
	 * */
	@Test 
	public void intestFinalScore()
	{
		assertEquals(75.0, gradebook1.finalScore(), .0001);
		assertEquals(30.0, gradebook2.finalScore(), .0001);
	}

}
