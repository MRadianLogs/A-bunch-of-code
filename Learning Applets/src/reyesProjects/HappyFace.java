/*
 * File name: HappyFace.java
 *
 * Programmer: Michael Reyes
 *
 * Date Started: Mar 24, 2017
 */
package reyesProjects;

//This line says that this applet uses the class Graphics from the AWT library(package). 
import java.awt.Graphics;

//This line says this applet - like all applets - uses the class JApplet that is in the Swing library(package). 
import javax.swing.JApplet;


/**
 * This is an applet that creates a smiley face. It has notes on applets and some methods used such as drawOval() and drawArc().
 * This is my first applet program created 3/24/17 by reading the Java IT textbook, An Introduction to Problem Solving and Programming 
 * by Walter Savitch.
 *
 * @author Michael Jesus Reyes
 *
 */
// The "extends JApplet" indicates that we are defining an applet, as opposed to some other kind of class. It uses 
// inheritance to create the HappyFace based upon an existing class JApplet.
public class HappyFace extends JApplet
{
	//An applet's paint method draws its graphics!
	
	//This paint method specifies what graphics are drawn in the applet. The paint method is invoked automatically when the applet is run. 
	public void paint(Graphics canvas)
	{
		//This line tells Java to apply the default drawing operations to this applet. If left out, the window may not be drawn correctly.
		super.paint(canvas);
		
		//This line draws the circle of the face. The first two numbers are the coordinates on the applet plane. The method drawOval() draws 
		//ovals. The last two numbers give the width and height of the oval.
		canvas.drawOval(100, 50, 200, 200);
		
		//To make a circle, make the width and height of the oval the same! The units are pixels!
		//The coordinate plane of applets/Java/computer starts in the top left! Increasing y means going down!
		
		//These method invocations draw the eyes of the face. The fillOval() method draws in an oval that is filled in. 
		canvas.fillOval(155, 100, 10, 20);
		canvas.fillOval(230, 100, 10, 20);
		
		//This method draws the mouth. The first two numbers give the position of the invisible rectangle (see book for reference). The next 
		//two numbers are the width and height of the rectangle. The last two numbers specify the portion of this invisible oval that is 
		//visible, the first specifying a start angle in degrees and the last specifies how many degrees of the oval's arc will be made visible.
		//See page 36 in text book for helpful diagrams.
		canvas.drawArc(150, 160, 100, 50, 180, 180);
	}
}
