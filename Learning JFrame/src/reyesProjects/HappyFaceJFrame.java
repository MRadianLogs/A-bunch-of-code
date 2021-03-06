/*
 * File name: HappyFaceJFrame.java
 *
 * Programmer: Michael Reyes
 *
 * Date: Apr 7, 2017
 */
package reyesProjects;

import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * This is the HappyFaceJFrame class. It is simply taking the Applet example from the book and converting it to a JFrame application. 
 * It also incorporates official/organized/efficient style rules.
 *
 * @author Michael Jesus Reyes
 *
 */
// To use JFrame, we extend JFrame instead of JApplet!
public class HappyFaceJFrame extends JFrame
{
	//These are the style rules being incorporated into the code!
	//This helps organize the application, and makes changing the code much easier. This will be useful in game development!
	public static final int FACE_DIAMETER = 200;
	public static final int X_FACE = 100;
	public static final int Y_FACE = 50;
	
	public static final int EYE_WIDTH = 10;
	public static final int EYE_HEIGHT = 20;
	public static final int X_RIGHT_EYE = 155;
	public static final int Y_RIGHT_EYE = 100;
	public static final int X_LEFT_EYE = 230;
	public static final int Y_LEFT_EYE = Y_RIGHT_EYE;
	
	public static final int MOUTH_WIDTH = 100;
	public static final int MOUTH_HEIGHT = 50;
	public static final int X_MOUTH = 150;
	public static final int Y_MOUTH = 160;
	public static final int MOUTH_START_ANGLE = 180;
	public static final int MOUTH_DEGREES_SHOWN = 180;
	
	//These methods stay the same as an Applet because they stem from Graphics, not JApplet!
	public void paint(Graphics canvas)
	{
		super.paint(canvas);
		//Draw face outline:
		canvas.drawOval(X_FACE, Y_FACE, FACE_DIAMETER, FACE_DIAMETER);
		//Draw eyes:
		canvas.fillOval(X_RIGHT_EYE, Y_RIGHT_EYE, EYE_WIDTH, EYE_HEIGHT);
		canvas.fillOval(X_LEFT_EYE, Y_LEFT_EYE, EYE_WIDTH, EYE_HEIGHT);
		//Draw mouth:
		canvas.drawArc(X_MOUTH, Y_MOUTH, MOUTH_WIDTH, MOUTH_HEIGHT, MOUTH_START_ANGLE, MOUTH_DEGREES_SHOWN);
	}
	
	public HappyFaceJFrame()
	{
		//Changes the size of the application window.
		setSize(600,400);
		//Makes it so the program stops when the x is clicked.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public static void main(String[] args)
	{
		HappyFaceJFrame guiWindow = new HappyFaceJFrame();
		//I didn't learn this yet, but I guess you just have to make sure the window is visible when you make it. I think this will be useful in games, though!
		guiWindow.setVisible(true);	
	}
}
