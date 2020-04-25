
/**
 * A car Object that will appear on the screen
 * 
 * @author Matthieu Eric Moundou
 * 
 */

import java.awt.geom.Point2D;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Rectangle;



class Car {
    
   private int x;
   private int y;
   JComponent component;

   /**
      public Car constructs a car with specified top left corner.
      @param x - specifies the x coordinate of the top left corner
      @param y  - specifies the y coordinate of the top left corner
   */
   
   public Car(int x, int y, JComponent component)
   {
       
      this.x = x;
      this.y = y;
      this.component = component;
      
   }

   /**
      draw Draws the car given the parameter g2
      @param g2
   */
   
   public void draw(Graphics2D g2, int x, int y) {
       
       try {
           
           Rectangle body = new Rectangle(x, y + 10, 60, 10);    
           Ellipse2D.Double frontTire = new Ellipse2D.Double(x + 10, y + 20, 10, 10);
           Ellipse2D.Double rearTire = new Ellipse2D.Double(x + 40, y + 20, 10, 10);
           Point2D.Double r1 = new Point2D.Double(x + 10, y + 10);
           Point2D.Double r2 = new Point2D.Double(x + 20, y);
           Point2D.Double r3 = new Point2D.Double(x + 40, y);
           Point2D.Double r4 = new Point2D.Double(x + 50, y + 10);
           Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
           Line2D.Double roofTop = new Line2D.Double(r2, r3);
           Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
           g2.draw(body);
           g2.draw(frontTire);
           g2.draw(rearTire);
           g2.draw(frontWindshield);    
           g2.draw(roofTop);    
           g2.draw(rearWindshield);
           
       }
     
       finally {}
       
   }
   
}