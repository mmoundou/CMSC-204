/**
  @author Matthieu Eric Moundou
 */
public class GradeBook
{
   private double[] scores;
   private int scoresSize;

   /**
      Constructs a gradebook with no scores and a given capacity.
     * @param capacity
      @capacity the maximum number of scores in this gradebook
   */
   public GradeBook(int capacity)
   {
      scores = new double[capacity];
      scoresSize = 0;
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;      
   }
   
   /**
    * Return scoresSize
     * @return the size of our array as an integer value
    */
   
   public int getScoreSize() {
       return scoresSize; 
   }
   
   /**
    * Return a string of our scores separated by commas
     * @return a String values representing the scores stored in our array
    */
   @Override
   public String toString() {
	   
	   String scoresListed = "";
	   
	   for(int num = 0; num < scores.length;num ++ ) 
	   {
	   scoresListed += scores [num] + " ";
	   }
	return scoresListed;
	   
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }
      
   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
      if (scoresSize == 0) 
          return 0;
      double smallest = scores[0];
      for (int i = 1; i < scoresSize; i++)
      {
         if (scores[i] < smallest)
         {
            smallest = scores[i];
         }
      }
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if 
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore() 
   {
       switch (scoresSize) {
           case 0:
               return 0;
           case 1:
               return scores[0];
           default:
               return sum() - minimum();
       }
   }
}
