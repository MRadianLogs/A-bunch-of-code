/*
 * File name: ControllableParticle.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 13, 2019
 * Time: 9:27:57 PM
 */
package reyesProjects;

import java.awt.Color;

/**
 * This class represents a specialized particle that can be controlled by the user and can be moved in all 4 directions. 
 * 
 * @author Michael J. Reyes
 *
 */
public class ControllableParticle extends Particle
{
	private int upButton, downButton, leftButton, rightButton;
	
	public ControllableParticle(double xPos, double yPos, Color particleColor, double particleDiameter, int upButton, int downButton, int leftButton, int rightButton)
	{
		super(xPos, yPos, 0, 0, 0, 0, particleColor, particleDiameter);
		this.upButton = upButton;
		this.downButton = downButton;
		this.leftButton = leftButton;
		this.rightButton = rightButton;
	}
	
	public int getUpButton() {
		return upButton;
	}

	public void setUpButton(int upButton) {
		this.upButton = upButton;
	}

	public int getDownButton() {
		return downButton;
	}

	public void setDownButton(int downButton) {
		this.downButton = downButton;
	}

	public int getLeftButton() {
		return leftButton;
	}

	public void setLeftButton(int leftButton) {
		this.leftButton = leftButton;
	}

	public int getRightButton() {
		return rightButton;
	}

	public void setRightButton(int rightButton) {
		this.rightButton = rightButton;
	}

	public void update()
	{
		super.update();
	}

	public void keyPressed(int keyCode) {
		if(keyCode == upButton)
		{
			getAcceleration().setyPos(-0.1);
		}
		if(keyCode == downButton)
		{
			getAcceleration().setyPos(0.1);
		}
		if(keyCode == leftButton)
		{
			getAcceleration().setxPos(-0.1);
		}
		if(keyCode == rightButton)
		{
			getAcceleration().setxPos(0.1);
		}
	}

	public void keyReleased(int keyCode) {
		if(keyCode == upButton)
		{
			getAcceleration().setyPos(0);
		}
		if(keyCode == downButton)
		{
			getAcceleration().setyPos(0);
		}
		if(keyCode == leftButton)
		{
			getAcceleration().setxPos(0);
		}
		if(keyCode == rightButton)
		{
			getAcceleration().setxPos(0);
		}
	}
	
}
