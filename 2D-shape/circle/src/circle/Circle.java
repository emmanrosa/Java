package circle;

// Filename: Circle.java
// Program draws a circle with radius specified by slider
// value and displays the area, diameter and circumference.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;
import javax.swing.event.*;

public class Circle extends JFrame {
   private CircleCanvas theCanvas;
   private JTextArea display;
   private JPanel controlPanel;
   private JSlider radiusSlider;

   // set up GUI
   public Circle()
   {
      super( "Using slider to draw circle" );

      theCanvas = new CircleCanvas();
      display = new JTextArea( 5, 30 );

      radiusSlider = new JSlider( SwingConstants.HORIZONTAL,
                              10, 200, 15 );
      radiusSlider.setMajorTickSpacing( 10 );
      radiusSlider.setPaintTicks( true );
      radiusSlider.setPaintLabels( true );

      radiusSlider.addChangeListener(

         // anonymous inner class
         new ChangeListener() {

            // chang
            public void stateChanged( ChangeEvent e )
            {
               theCanvas.setRadius( radiusSlider.getValue() );
               display.setText( "Radius: " +
                  theCanvas.getRadius() + "\nDiameter: " +
                  theCanvas.getDiameter() + "\nArea: " +
                String.format("%.2f", theCanvas.getArea()) + "\nCircumference:"
                 + String.format("%.2f",theCanvas.getCircumference()));
               repaint();
            }

         }  // end anonymous inner class

      ); // end call to addChangeListener

      controlPanel = new JPanel();
      controlPanel.setLayout( new GridLayout( 2, 1 ) );
      controlPanel.add( display );
      controlPanel.add( radiusSlider );

     // Container container = getContentPane();
     setLayout( new BorderLayout() );
      add( theCanvas, BorderLayout.CENTER );
     add( controlPanel, BorderLayout.SOUTH );

      setSize( 600, 700 );
      show();

   }  // end constructor

   // execute application
   public static void main( String args[] )
   {
      Circle application = new Circle();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class Circle1
