/**
 * CarPanel 
 * @author Matthieu Eric Moundou
 * 
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

class CarPanel extends JComponent {
   private Car car;
   private int x;
   private int y;
   private int delay;
   private CarQueue carQueue;
   private int direction;
  
   public CarPanel(int x, int y, int delay, CarQueue queue)
   {
       this.delay = delay;
       this.x=x;
       this.y=y;
       car = new Car(this.x, this.y, this);
       carQueue = queue;
   }
   
   public void startAnimation() {
        class AnimationRunnable implements Runnable
          {
             public void run()
             {
                try
                {
                   int counter = 0;
                   
                   while(counter <100)
                   {
                  
                       direction = carQueue.deleteQueue();
                     
                       if(direction == 0){
                           
                           if(!(y < 0 && y >300)){
                               y += 10;
                           }
                      
                         
                       }
                       if (direction == 1){
                           //down
                      
                           if(!(y > 300 && y < 0)){
                               y -= 10;
                           }
                      
                       }
                       if (direction == 2){
                         
                         
                           if((x >0)){
                               x -= 10;
                           }
                         
                      
                       }
                       if (direction == 3){
                           
                           if( x < 180){
                               x += 20;
                           }
                      
                       }
                       repaint();
                       Thread.sleep(delay * 100);
                       
                       counter++;
 
                   }
                }
                
                catch (InterruptedException exception)
                {
                  
                   carQueue.addToQueue();
                  
                }
                finally
                {}
             }
          }
        
          Runnable r = new AnimationRunnable();
          Thread t = new Thread(r);
          t.start();
       }
  
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      car.draw(g2 , x , y);  
   }
}