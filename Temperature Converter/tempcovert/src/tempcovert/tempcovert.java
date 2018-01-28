package tempcovert;

/*
// Program:temperature conversion
// Written by:Emmanuel Rosario
// Description:it will convert from  fahrenheit,celsius and kelvin to whichever it select
// Challenges: radio button selected by default
// Time Spent: 30 min
// Given Input:               Expected Output:
// --------------------          -------------------------
// Fahrenheit 10 to Celsius = -12.22
   Celsius 10 to Kelvin = 283.15
   Kelvin 10 to  Fahrenheit = -441.67
// Date:                   By:               Action:
// ---------------------------------------------------
// 3/27/15              Emmanuel            create
// 3/12/15              Emmanuel            add Comment
 */

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class tempcovert extends JFrame {
    
//jpanel
JPanel p1, p2, p3, p4;//panel
//label
JLabel l1 = new JLabel("Enter Numeric Temperature");//prompt
JLabel lfrom = new JLabel("Convert from:");//label from
JLabel lto = new JLabel("Convert to:");//label to
JLabel l4 = new JLabel("Comparable Temperature is:");// label before result
//textfield
JTextField num  = new JTextField(20);//user num
JTextField rnum = new JTextField(20);//result
//radiobutton convert from
JRadioButton ff = new JRadioButton("Fahrenheit",true);//default
JRadioButton cf = new JRadioButton("Celsius");
JRadioButton kf = new JRadioButton("Kelvin");
//radiobutton convert to
JRadioButton ft = new JRadioButton("Fahrenheit");
JRadioButton ct = new JRadioButton("Celsius",true);// default
JRadioButton kt = new JRadioButton("Kelvin");
calc calchander = new calc();
  
//gui
public tempcovert (){
     super( "Temperature Conversion" );// frame title
   //panel first three sets
     p1 = new JPanel();
    p1.setLayout(new GridLayout(3, 1));
    p1.add(l1);
    p1.add(num);
    p1.add(lfrom);
    add(p1);
    //add ActionListener
    num.addActionListener(calchander);
    
    //buttongroup from
    ButtonGroup radioFrom = new ButtonGroup();
    radioFrom.add(ff);
    radioFrom.add(cf);
    radioFrom.add(kf);
    
    //panel2 radiobutton from
    p2 = new JPanel();
    p2. setLayout(new GridLayout(1, 3));
    p2.add(ff);
    p2.add(cf);
    p2.add(kf);
    add(p2);
    //add ActionListener
    ff.addActionListener(calchander);
    cf.addActionListener(calchander);
    kf.addActionListener(calchander);

    //button group to
    ButtonGroup radioTo = new ButtonGroup();
    radioTo.add(ft);
    radioTo.add(ct);
    radioTo.add(kt);
    
   //panel3 radiobutton to
    p3 = new JPanel();
    p3. setLayout(new GridLayout(1, 3));
    p3.add(ft);
    p3.add(ct);
    p3.add(kt);
    add(p3);
    //add ActionListener
   ft.addActionListener(calchander);
   ct.addActionListener(calchander);
   kt.addActionListener(calchander);
    p4 = new JPanel();
    p4.setLayout(new GridLayout(2, 1));
    p4.add(l4);
    p4.add(rnum);
    add(p4);
    
    //display result
    rnum.setEditable( false );
    
    //add container
 Container container = getContentPane();
 container.setLayout(new GridLayout(5,1));
 container.add(p1);
 container.add(p2);
 container.add(lto);
 container.add(p3);
 container.add(p4);

 
}   
 public static void main(String[] args) {
        tempcovert frame = new tempcovert();
        frame.pack();
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
 class calc implements ActionListener{
     
          @Override
          public void actionPerformed(ActionEvent e) {
     
              double tempc;//holds the result
      try{
          
// fahrenheit to fahrenheit
 if ( ff.isSelected() && ft.isSelected() ) {
 tempc = Double.parseDouble(num.getText()) ;
 rnum.setText( String.format("%.2f",tempc) );
 }
 
// fahrenheit to celcius
 else if ( ff.isSelected() && ct.isSelected() ) {
 tempc = ( 5.0 / 9.0 * ( Double.parseDouble(num.getText()) - 32 ) );
 rnum.setText( String.format("%.2f",tempc) );
 }
 
 // fahrenheit to kelvin
 else if ( ff.isSelected() && kt.isSelected() ) {
 tempc = ( 5.0 / 9.0 * ( Double.parseDouble(num.getText()) - 32 ) + 273.15 );
 rnum.setText( String.format("%.2f",tempc) );
 }
 
// celcius to celsius
 else if ( cf.isSelected() && ct.isSelected() ) {
 tempc = Double.parseDouble(num.getText()) ;
 rnum.setText( String.format("%.2f",tempc) );
 }
 
 // celcius to fahrenheit
 else if ( cf.isSelected() && ft.isSelected() ) {
tempc =  ( 9.0 / 5.0 * Double.parseDouble(num.getText()) + 32 );
 rnum.setText( String.format("%.2f",tempc) );
 }
 
// celcius to kelvin
 else if ( cf.isSelected() && kt.isSelected() ) {
 tempc = Double.parseDouble(num.getText()) + 273.15;
rnum.setText( String.format("%.2f",tempc) );
 }
 
 // kelvin to kelvin
 if ( kf.isSelected() && kt.isSelected() ) {
 tempc = Double.parseDouble(num.getText()) ;
 rnum.setText( String.format("%.2f",tempc) );
 }
 
 // kelvin to celcius
 else if ( kf.isSelected() && ct.isSelected() ) {
 tempc = Double.parseDouble(num.getText()) - 273.15;
rnum.setText( String.format("%.2f",tempc) );
 }

 // kelvin to fahrenheit
 else if ( kf.isSelected() && ft.isSelected() ) {
 tempc = ( 9.0 / 5.0 * ( Double.parseDouble(num.getText()) - 273.15 ) + 32 );
 rnum.setText( String.format("%.2f",tempc) );
 }
 
 } // end method actionPerformed
      catch(NumberFormatException ex){
      JOptionPane.showMessageDialog(
        null, "Error. Unable to convert " + num.getText()
                + ".  Please only try to enter numbers." ); }
        }    
          
  }
 
 }     

