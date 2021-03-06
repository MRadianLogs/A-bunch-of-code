/*
 * File name: EngineScreen.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Sep 29, 2018
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class EngineScreen extends JPanel implements ActionListener
{
	private EngineMain main;
	Ball ball;
	Vector accel;
	
	public EngineScreen(EngineMain main)
	{
		this.main = main;
		setBackground(Color.GRAY);
		//Instantiate objects here:
		ball = new Ball(main,main.getWidth()/2,main.getHeight()/2, -Math.PI/4, 5, -.05); //Note the unit circle angles are upside down! Just like coordinate plane
		
		Timer timer = new Timer(5,this);
		timer.start();
		
		setFocusable(true);
	}
	
	public EngineMain getMain()
	{
		return main;
	}
	
	public Ball getBall()
	{
		return ball;
	}
	
	/*
	public Vector[] getVector()
	{
		Vector[] vectorList = new Vector[1];
		vectorList[0] = position;
		return vectorList;
	}
	*/
	
	public void update()
	{
		ball.update();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		update();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.RED);
		ball.paint(g);
		
	}
	
	public static void main(String[] args, EngineMain main)
	{
		EngineScreen mainScreen = new EngineScreen(main);
		System.out.println(mainScreen.getBall().getPosition().getxPos());
		System.out.println(mainScreen.getBall().getPosition().getyPos());
		System.out.println(mainScreen.getBall().getPosition().getAngle());
		System.out.println(mainScreen.getBall().getPosition().getLength());
	}
	
}
