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
 * If this particle goes beyond the boundaries of the screen, it wraps around onto the other side of the screen.
 * 
 * @author Michael J. Reyes
 *
 */
public class ControllableParticle extends Particle
{
	private int upButton, downButton, leftButton, rightButton;
	private Game game;
	
	public ControllableParticle(Game game, double xPos, double yPos, Color particleColor, double particleDiameter, int upButton, int downButton, int leftButton, int rightButton)
	{
		super(xPos, yPos, 0, 0, 0, 0, particleColor, particleDiameter);
		this.upButton = upButton;
		this.downButton = downButton;
		this.leftButton = leftButton;
		this.rightButton = rightButton;
		this.game = game;
	}
	
	public void update()
	{
		super.update();
		checkBounds();
	}
	
	public void checkBounds()
	{
		if(this.position.getxPos() > game.getWidth())
		{
			this.position.setxPos(0);
		}
		if(this.position.getxPos() < 0)
		{
			this.position.setxPos(game.getWidth());
		}
		if(this.position.getyPos() > game.getHeight())
		{
			this.position.setyPos(0);
		}
		if(this.position.getyPos() < 0)
		{
			this.position.setyPos(game.getHeight());
		}
	}

	public void keyPressed(int keyCode) {
		if(keyCode == upButton)
		{
			this.acceleration.setyPos(-0.1);
		}
		if(keyCode == downButton)
		{
			this.acceleration.setyPos(0.1);
		}
		if(keyCode == leftButton)
		{
			this.acceleration.setxPos(-0.1);
		}
		if(keyCode == rightButton)
		{
			this.acceleration.setxPos(0.1);
		}
	}

	public void keyReleased(int keyCode) {
		if(keyCode == upButton)
		{
			this.acceleration.setyPos(0);
		}
		if(keyCode == downButton)
		{
			this.acceleration.setyPos(0);
		}
		if(keyCode == leftButton)
		{
			this.acceleration.setxPos(0);
		}
		if(keyCode == rightButton)
		{
			this.acceleration.setxPos(0);
		}
	}
	
}
