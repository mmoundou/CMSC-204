/**
 * CarQueue holds the queue for our Car objects
 * @author Matthieu Eric Moundou
 * 
 */

import java.util.PriorityQueue;
import java.util.Random;

public class CarQueue {

  
   Random num = new Random();
   PriorityQueue<Integer> q = new PriorityQueue<>();
   private int exit;
  
   public CarQueue(){
  
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));
       q.add(num.nextInt(4));

   }
  
   public void addToQueue() {
  
       class ARunnable implements Runnable
          {
          
             public void run() {
              
                try
                {
                   q.add(num.nextInt(4));
                   q.add(num.nextInt(4));
                   q.add(num.nextInt(4));
                   q.add(num.nextInt(4));
                   q.add(num.nextInt(4));
                   q.add(num.nextInt(4));
                   q.add(num.nextInt(4));
                  
                  
                }
                finally
                {}
             }
          }
       Runnable r = new ARunnable();
       Thread t = new Thread(r);
       
          t.start();  
   }

   public int deleteQueue() {
      
       class ARunnable implements Runnable
          {
          
          
             public void run()
             {

               try {
                       Thread.sleep(2000);
                   } catch (InterruptedException e) {
                      
                   }
                  
              
                try
                {
                   if(q.size() < 20){
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                       q.add(num.nextInt(4));
                  
                   }
                  
                   else if (!q.isEmpty()){
                   exit = q.remove();
                   }
                  
                  
                }
                finally
                {
                  
                }
             }
           
          }
       Runnable r = new ARunnable();
       Thread t = new Thread(r);
       
          t.start();
        
  
          return exit;
      
   }

}