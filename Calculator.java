

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/** 
 * This class represents the GUI for the Calculator app. It is implemented as a
 * subclass of JPanel and therefore inherits all of JPanel's methods.
 */
public class Calculator extends JPanel implements ActionListener {

    // a button used for the initial example
    private JButton button1, button2;
    
    //cal buttons
    JButton add, subtract, multiply, divide, power, factorial;
    JButton n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
    JButton equals, backspace, clear;
    JButton RPN;
    JButton point;
 
    public static int isRPN=0;
    

    /**
     * Constructs a Calculator object
     */
    public Calculator() {

	// set the layout manager for the Calculator application using one of
	// the methods inherited from the JPanel class.
	this.setLayout(new FlowLayout());
	
	
	//text area
    final JTextArea tArea=new JTextArea(1,20);
    

	//cal buttons initialization
	this.add=new JButton("+");
	this.subtract=new JButton("-");
	this.multiply=new JButton("*");
	this.divide=new JButton("/");
	this.power=new JButton("^");
	this.factorial=new JButton("!");
	
	this.n0=new JButton("0");
	this.n1=new JButton("1");
	this.n2=new JButton("2");
	this.n3=new JButton("3");
	this.n4=new JButton("4");
	this.n5=new JButton("5");
	this.n6=new JButton("6");
	this.n7=new JButton("7");
	this.n8=new JButton("8");
	this.n9=new JButton("9");
	
	this.equals=new JButton("=");
	this.backspace=new JButton("<");
	this.clear=new JButton("Clear");
	this.RPN=new JButton("Convert to RPN");
	this.point=new JButton(".");

	//adds functionality to cal buttons
	this.add.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append(" + ");
		}
	});
	
	this.subtract.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append(" - ");
		}
	});
	
	this.multiply.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append(" * ");
		}
	});
	
	this.divide.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append(" / ");
		}
	});
	
	
	this.power.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append(" ^ ");
		}
	});
	
	this.factorial.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append(" ! ");
		}
	});
	
	this.n0.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("0");
		}
	});
	
	this.n1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("1");
		}
	});
	this.n2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("2");
		}
	});
	this.n3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("3");
		}
	});
	this.n4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("4");
		}
	});
	this.n5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("5");
		}
	});
	this.n6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("6");
		}
	});
	this.n7.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("7");
		}
	});this.n8.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("8");
		}
	});
	this.n9.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append("9");
		}
	});
	
	this.point.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			tArea.append(".");
		}
	});
	
	this.backspace.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//gets the string from the text area
			String temp=tArea.getText();
			//removes the last input by shortening it
			String temp2=temp.substring(0, temp.length()-1);
			//replaces the text area with the new string
			tArea.replaceRange(temp2, 0, temp.length());
		}
	});
	
	this.clear.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//gets the string from the text area--this code might not be needed
			String temp=tArea.getText();
			//replaces the text area with an empty string
			tArea.replaceRange("", 0, temp.length());
			isRPN=0; //resets to infix if it was converted to RPN
		}
	});
	
	this.RPN.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//gets a string from the text area
			String temp=tArea.getText();
			//splits the string into an array
			String infix[]=temp.split(" ");
			//converts string array into postfix
			String postfix[]=ReversePolishNotation.infixToPostfix(infix);
			//puts the array back to a String to be outputted to text area
			String temp2="";
			for(int i=0; i<postfix.length; i++)
			{
				temp2=temp2+postfix[i]+" ";
				//System.out.println(temp2);
			}
			tArea.replaceRange(temp2, 0, temp.length());
			//tells the equal button that this is already in RPN
			isRPN=1;
		}
	});
	
	this.equals.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//gets a string from the text area
		String temp=tArea.getText();
		//splits the string to an array
		String infix[]=temp.split(" ");
			
			Math basicMath=new BasicMath();	
		
		double answer = -999999999;
		
		//checks to see if it is in RPN
		if(isRPN==1){
				
					try {
						answer=ReversePolishNotation.evaluate(basicMath, infix);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (ArithmeticException e1) {
						e1.printStackTrace();
					} catch (DomainException e1) {
						e1.printStackTrace();
					}
				
		}
		else{
			
			String postfix[]=ReversePolishNotation.infixToPostfix(infix);
		
			
				try {
					answer = ReversePolishNotation.evaluate(basicMath, postfix);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (ArithmeticException e1) {
					e1.printStackTrace();
				} catch (DomainException e1) {
					e1.printStackTrace();
				}
			
		}
			
			//turns the double into a string
			String temp2=Double.toString(answer);
			//replaces text area with the answer
			tArea.replaceRange(temp2,0,temp.length());
			isRPN=0; //resets to infix
		}
	});
	
	//add text area
	add(tArea);
	
	//add cal buttons
	add(this.add);
	add(this.subtract);
	add(this.multiply);
	add(this.divide);
	add(this.power);
	add(this.factorial);
	
	add(this.n0);
	add(this.n1);
	add(this.n2);
	add(this.n3);
	add(this.n4);
	add(this.n5);
	add(this.n6);
	add(this.n7);
	add(this.n8);
	add(this.n9);
	
	add(this.point);
	
	add(this.equals);
	add(this.backspace);
	add(this.clear);
	add(this.RPN);
	
    } // Calculator
    
    

    /**
     * This method is used for actions that are shared by multiple components. 
     * It is declared in the abstract class ActionListener.
     *
     * <p>
     * In order to make this method handle an event for a component, you need
     * only pass the current instance of the Calculator class as the parameter
     * to component's <code>addActionListener</code> method. Here is an example
     * of how to make a JButton that is created inside an instance of the
     * <code>Calculator</code> class use this <code>actionPerformed</code> 
     * method when clicked:
     *
     * <code>button.addActionListener(this);</code>
     *
     * <p>
     * This works because the <code>Calculator</code> class implements the
     * <code>ActionListener</code> interface.
     *
     * @param e an action event that the application needs to react to.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

	// check to see if the event is from button 2
	if (e.getSource() == this.button2) {
	    this.button2.setText("Thanks!");
	} // if

    } // actionPerformed
    
    
    

    /**
     * Creates and shows the GUI
     */
    public static void createAndShowGUI() {

	// create and setup the window
	JFrame frame = new JFrame("Calculator");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// create an instance of the Calculator class and add it to the window
	Calculator calc = new Calculator();
	frame.add(calc);

	// show the window.
        
        frame.setSize(280, 270);
        frame.setVisible(true);

    } // createAndShowGUI

} // Calculator

