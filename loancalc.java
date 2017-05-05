/* 
   Car Loan Calculator
  
*/

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class CarLoan extends Applet implements ActionListener
{
	// Gui widgets
	TextField cashText, costText, lengthText, yRateText, taxText;
	Button goButton;
	TextArea outText;
	
	// program variables
	float cost, cash, yRate, taxRate;
	int term;
	float tax, amount, downPayment, M, monthlyPayment, totalCost;
	
	public void init() {
		makeGui();
	} // init
	
	private void compute() {
		// compute sales tax (set salesString+tax)
		tax = cost * taxRate/100;
		
		// compute downpayment (downString)
		downPayment = cash - tax;
		
		// compute amount financed (amountString)
		amount = cost - downPayment;
	
		// compute monthly interest rate
		M = yRate/12/100;
		
		// compute monthly payment (monthlyString)
		monthlyPayment = (float) ((amount * M)/(1 - Math.exp(-term*Math.log(1+M))));
		
		// compute total cost (totalString)
		totalCost = tax + downPayment + term * monthlyPayment;
		
	} // compute
	
	public void paint( Graphics g ) {
		outText.appendText("Cost = $" + cost + "\n");
		outText.appendText("Cash = $" + cash + "\n");
		outText.appendText("Loan term (months)" + term + "\n");
		outText.appendText("Yearly rate (%) " + yRate + "\n");
		outText.appendText("Sales Tax (%) " + taxRate + "\n");
		
		// Output results
		outText.appendText("Sales Tax = $" + tax + "\n");
		outText.appendText("Down Payment = $" + downPayment + "\n");
		outText.appendText("Amount Financed = $" + amount + "\n");
		outText.appendText("Monthly Payment = $" + monthlyPayment + "\n");
		outText.appendText("Total Cost of car = $" + totalCost + "\n\n\n\n");
	} // paint
	
	private float readValue(TextField t) {
		String s;
		Float f;
		
		// get string from text field
		s = t.getText();
		
		// convert it to Float object
		f = new Float(s);
		
		// convert it to float value
		return f.floatValue();
		
	} // readValue
	
	private void processInput() { // reads float values from text fields
		cost = readValue(costText);
		cash = readValue(cashText);
		term = (int) readValue(lengthText);
		yRate = readValue(yRateText);
		taxRate = readValue(taxText);
	} // processInput
	
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == goButton) {
			processInput();
			compute();
			repaint();
		}
	} // actionPerformed
	
	private void makeGui() {
		Panel allPanel;
		
		// applet layout
			setLayout(new BorderLayout());
			
		// panel to hold all input elements
		allPanel = new Panel();
		allPanel.setLayout(new GridLayout(6,1));
		
		// cost
			costText = new TextField(10);
			makeWidget("Cost of car", costText, allPanel);
			
		// cash
			cashText = new TextField(10);
			makeWidget("Cash in hand", cashText, allPanel);
		
		// length
			lengthText = new TextField(10);
			makeWidget("Length of loan (months)", lengthText, allPanel);
		
		// yearly rate
			yRateText = new TextField(10);
			makeWidget("Yearly Interest Rate (%)", yRateText, allPanel);
		
		// sales tax
			taxText = new TextField(10);
			makeWidget("Sales Tax Rate (%)", taxText, allPanel);
			
		// go button
		goButton = new Button("Calculate");
		Panel bP = new Panel();
		bP.add(goButton);
		allPanel.add(bP);
		goButton.addActionListener(this);
		
		// add all panel to applet
		
		add("West", allPanel);
		
		// Output area
		outText = new TextArea("Output\n\n", 20, 40, TextArea.SCROLLBARS_BOTH);
		outText.setBackground(new Color(255, 153, 0));
		add("Center", outText);
		
	} // makeGui
	
	private void makeWidget(String lstring, TextField text, Panel all) {
		Label l;
		Panel p = new Panel();
		
		l = new Label(lstring);
		//text = new TextField(10);
		p.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p.add(l);
		p.add(text);
		all.add(p);
	
	} // makeWigdet
} // carloan

