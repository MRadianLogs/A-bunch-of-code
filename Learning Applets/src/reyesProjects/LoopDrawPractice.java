/*
 * File name: LoopDrawPractice.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: May 25, 2017
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

/**
 * This class is me practicing problem 26 in section 4.3 on page 251 of my textbook. It asks for the programmer to 
 * make six identical green circles using loops. I have done this.
 *
 * @author Michael Jesus Reyes
 *
 */
public class LoopDrawPractice extends JApplet
{
	public void paint(Graphics canvas)
	{
		for(int i = 0; i <= 5; i++)
		{
			canvas.setColor(Color.PINK);
			//Draw circle
			canvas.fillOval(50 + (i * 75), 50, 50, 50);
			
			canvas.setColor(Color.BLACK);
			//Draw outline
			canvas.drawOval(50 + (i * 75), 50, 50, 50);
		}
		canvas.drawString("Identical circles", 150, 25);
	}
}
