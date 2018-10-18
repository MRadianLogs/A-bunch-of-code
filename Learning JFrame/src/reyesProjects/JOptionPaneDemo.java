/*
 * File name: JOptionPaneDemo.java
 *
 * Programmer: Michael Reyes
 * 
 * Date: Apr 7, 2017
 */
package reyesProjects;

import javax.swing.JOptionPane;

/**
 * This program is me practicing using pop-up boxes, known as JOptionPanes in JFrame, in order to accept user 
 * input. This program accepts a number of apples and oranges as inputs, and calculates the total number of 
 * fruits from the numbers the user inputs.
 *
 * @author Michael Jesus Reyes
 *
 */
public class JOptionPaneDemo
{
	public static void main(String[] args)
	{
		String appleString = 
				JOptionPane.showInputDialog("Enter number of apples:");
		int appleCount = Integer.parseInt(appleString);
		
		String orangeString = 
				JOptionPane.showInputDialog("Enter number of oranges:");
		int orangeCount = Integer.parseInt(orangeString);
		
		int totalFruitCount = appleCount + orangeCount;
		
		JOptionPane.showMessageDialog(null, "The total number of fruits = " + totalFruitCount);
		
		System.exit(0);
	}
}
