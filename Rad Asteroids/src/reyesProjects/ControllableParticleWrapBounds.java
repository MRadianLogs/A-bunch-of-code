/*
 * File name: ControllableParticleWrapBounds.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 14, 2019
 * Time: 7:54:35 PM
 */
package reyesProjects;

import java.awt.Color;

/**
 * This class represents a controllable particle that has wrappable boundaries. If this particle goes beyond the 
 * boundaries of the screen, it wraps around onto the other side of the screen.
 * 
 * @author Michael J. Reyes
 *
 */
public class ControllableParticleWrapBounds extends ControllableParticle
{
	private RadAsteroidsGame game;

	public ControllableParticleWrapBounds(RadAsteroidsGame game, double xPos, double yPos, Color particleColor, double particleDiameter, int upButton, int downButton, int leftButton, int rightButton) 
	{
		super(xPos, yPos, particleColor, particleDiameter, upButton, downButton, leftButton, rightButton);
		this.game = game;
	}
	
	public void update()
	{
		super.update();
		checkBounds();
	}
	
	public void checkBounds() //TODO Need to make bounds more accurate by taking in account the size of the object.
	{
		if(getPosition().getxPos() > game.getWidth())
		{
			getPosition().setxPos(0);
		}
		if(getPosition().getxPos() < 0)
		{
			getPosition().setxPos(game.getWidth());
		}
		if(getPosition().getyPos() > game.getHeight())
		{
			getPosition().setyPos(0);
		}
		if(getPosition().getyPos() < 0)
		{
			getPosition().setyPos(game.getHeight());
		}
	}
	
}
