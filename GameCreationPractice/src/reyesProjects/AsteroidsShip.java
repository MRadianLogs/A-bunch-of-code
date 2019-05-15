/*
 * File name: AsteroidsShip.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 14, 2019
 * Time: 8:08:27 PM
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This class represents the ship from the famous arcade game Asteroids. This particle will rotate left and right and 
 * only move in the forward direction. If the down button is pressed, it will shoot.
 * 
 * @author Michael J. Reyes
 *
 */
public class AsteroidsShip extends ControllableParticleWrapBounds 
{
	private double angleFacing;
	private boolean thrusting, turningLeft, turningRight, shooting;
	
	public AsteroidsShip(Game game, double xPos, double yPos, Color particleColor, double particleDiameter, int upButton, int downButton, int leftButton, int rightButton) 
	{
		super(game, xPos, yPos, particleColor, particleDiameter, upButton, downButton, leftButton, rightButton);
		angleFacing = 0;
		thrusting = false;
		turningLeft = false;
		turningRight = false;
		shooting = false;
	}
	
	public void update()
	{
		super.update();
		checkInputs();
	}
	
	public void checkInputs()
	{
		if(turningLeft == true)
		{
			angleFacing -= 0.05;
		}
		if(turningRight == true)
		{
			angleFacing += 0.05;
		}
		
		getAcceleration().setAngle(angleFacing);
		if(thrusting == true)
		{
			getAcceleration().setLength(0.1);
		}
		else
		{
			getAcceleration().setLength(0);
		}
		if(shooting == true)
		{
			//TODO Make it shoot particles!
		}
	}
	
	public void keyPressed(int keyCode) {
		if(keyCode == getUpButton())
		{
			thrusting = true;
		}
		if(keyCode == getDownButton())
		{
			shooting = true;
		}
		if(keyCode == getLeftButton())
		{
			turningLeft = true;
		}
		if(keyCode == getRightButton())
		{
			turningRight = true;
		}
	}

	public void keyReleased(int keyCode) {
		if(keyCode == getUpButton())
		{
			thrusting = false;
		}
		if(keyCode == getDownButton())
		{
			shooting = false;
		}
		if(keyCode == getLeftButton())
		{
			turningLeft = false;
		}
		if(keyCode == getRightButton())
		{
			turningRight = false;
		}
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2D = (Graphics2D) g;
		
		//Since I drew the ship with the wrong starting angle, I needed to correct the angle by adding 90 radians.
		//I also drew the ship so that it rotates around the point of the ship. I could do with fixing this so that it rotates around the center of the ship. TODO
		g2D.rotate(angleFacing+Math.toRadians(90), getPosition().getxPos(), getPosition().getyPos());
		
		g2D.setColor(getParticleColor());
		g2D.drawLine((int)(getPosition().getxPos()-(getParticleDiameter()/2)), (int)(getPosition().getyPos()+getParticleDiameter()), (int)(getPosition().getxPos()), (int)(getPosition().getyPos()));
		g2D.drawLine((int)(getPosition().getxPos()+(getParticleDiameter()/2)), (int)(getPosition().getyPos()+getParticleDiameter()), (int)(getPosition().getxPos()), (int)(getPosition().getyPos()));
		g2D.drawLine((int)(getPosition().getxPos()-(getParticleDiameter()/2)), (int)(getPosition().getyPos()+getParticleDiameter()), (int)(getPosition().getxPos()+(getParticleDiameter()/2)), (int)(getPosition().getyPos()+getParticleDiameter()));
		
		if(thrusting == true)
		{
			g2D.setColor(Color.RED);
			g2D.drawLine((int)(getPosition().getxPos()), (int)(getPosition().getyPos()+getParticleDiameter()), (int)(getPosition().getxPos()), (int)(getPosition().getyPos()+getParticleDiameter()+getParticleDiameter()/2));
		}
		
		//g2D.rotate(angleFacing, getPosition().getxPos(), getPosition().getyPos());
		
	}

}
