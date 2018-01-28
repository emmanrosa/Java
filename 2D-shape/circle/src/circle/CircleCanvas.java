package circle;

// class to display circle and calculate circle's dimensions
import javax.swing.*;
import java.awt.*;
public class CircleCanvas extends JPanel {
   private int radius;

   // generate random radius and set panel size
   public CircleCanvas()
   {radius = 15;
   }
   public CircleCanvas(int radius)
   {
      this.radius = radius;

   }

   // draw circle
   public void paintComponent( Graphics g )
   {
	   super.paintComponent(g);
           g.setColor(Color.RED);
      g.fillOval( 20, 20, 2 * radius, 2 * radius );
   }

   // get diameter of circle
   public int getDiameter()
   {
      return ( 2 * radius );
   }

   // get circumference of circle
   public double getCircumference()
   {
      return ( 2 * Math.PI * radius );
   }

   // get area of circle
   public double getArea()
   {
      return ( Math.PI * radius * radius );
   }

   // get radius of circle
   public int getRadius()
   {
      return radius;
   }

   // set radius of circle
   public void setRadius( int r )
   {
      radius = r;
   }

}  // end class CircleCanvas
