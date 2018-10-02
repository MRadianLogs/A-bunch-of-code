/*
 * File name: ArtCanvas.java
 *
 * Programmer: Michael Reyes
 *
 * Date: Mar 24, 2017
 */
package reyesProjects;

import java.awt.Graphics;

import javax.swing.JApplet;

/**
 *  This is just a simple "canvas" where I can mess about with my new-found applet knowledge.
 *
 * @author Michael Jesus Reyes
 *
 */
public class ArtCanvas extends JApplet
{
	
	public void paint(Graphics canvas)
	{
		this.setSize(1920, 1080);
		super.paint(canvas);
		
		//Ummm.
		canvas.drawOval(100, 150, 150, 150);
		canvas.drawOval(250, 150, 150, 150);
		canvas.fillOval(125, 225, 50, 50); // Hey don't judge.
		canvas.fillOval(300, 200, 50, 50);
		
		//Snowman!
		canvas.drawOval(50, 50, 50, 50);
		canvas.drawOval(38, 100, 75, 75);
		canvas.fillOval(62, 65, 10, 10);
		canvas.fillOval(78, 65, 10, 10);
		canvas.fillOval(70, 115, 10, 10);
		canvas.fillOval(70, 135, 10, 10);
		canvas.drawLine(50, 110, 18, 75);
		canvas.drawLine(105, 110, 125, 150);
		canvas.drawArc(60, 75, 30, 15, 180, 180);
		
		canvas.drawArc(200, 500, 100, 100, 90, -90);
				
		//
		//canvas.drawLine(250, 500, 500, 500);
	}
}
