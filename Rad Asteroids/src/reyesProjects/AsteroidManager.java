/*
 * File name: AsteroidManager.java
 *
 * Programmer: Michael J. Reyes
 *
 * Date: May 26, 2019
 * Time: 10:14:11 PM
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class handles all the setup and operations for the Asteroids in my RadAsteroids game. It creates all the asteroid 
 * objects, checks if any of the asteroids are bumping into each other, and paints them.
 * 
 * @author Michael J. Reyes
 *
 */
public class AsteroidManager {
	
	private RadAsteroidsGame game;
	private int startingNumAsteroids;
	private int maxNumAsteroids;
	
	private int startingLevel;
	
	private Asteroid[] asteroids;
	
	public AsteroidManager(RadAsteroidsGame game, int startingNumAsteroids, int startingLevel)
	{
		this.game = game;
		this.maxNumAsteroids = startingNumAsteroids * 4;
		this.startingLevel = startingLevel;
		
		
		asteroids = new Asteroid[maxNumAsteroids];
		for(int i = 0; i < startingNumAsteroids; i++)
		{
			//spawn asteroids at random places around edge of map, going in random directions
			asteroids[i] = new Asteroid(game, 0, (Math.random()*(game.getHeight()-20)+20), 3, (Math.random()*360), 0, 0, Color.WHITE, 10, startingLevel);
		}
	}
	
	public void update()
	{
		for(int i = 0; i < asteroids.length; i++)
		{
			Asteroid currentAsteroid = asteroids[i];
			if(currentAsteroid!=null)
			{
				currentAsteroid.update();
				for(int j = 0; j < asteroids.length && asteroids[j]!=currentAsteroid; j++)
				{
					currentAsteroid.checkIfHitAsteroid(asteroids[j]);
				}
			}
		}
	}
	
	public RadAsteroidsGame getGame() {
		return game;
	}

	public void setGame(RadAsteroidsGame game) {
		this.game = game;
	}

	public int getStartingNumAsteroids() {
		return startingNumAsteroids;
	}

	public void setStartingNumAsteroids(int startingNumAsteroids) {
		this.startingNumAsteroids = startingNumAsteroids;
	}

	public int getMaxNumAsteroids() {
		return maxNumAsteroids;
	}

	public void setMaxNumAsteroids(int maxNumAsteroids) {
		this.maxNumAsteroids = maxNumAsteroids;
	}

	public int getStartingLevel() {
		return startingLevel;
	}

	public void setStartingLevel(int startingLevel) {
		this.startingLevel = startingLevel;
	}

	public Asteroid[] getAsteroids() {
		return asteroids;
	}

	public void setAsteroids(Asteroid[] asteroids) {
		this.asteroids = asteroids;
	}

	public void paint(Graphics g)
	{
		for(int i = 0; i < asteroids.length; i++)
		{
			Asteroid currentAsteroid = asteroids[i];
			if(currentAsteroid!=null)
			{
				asteroids[i].paint(g);
			}
		}
	}
	
}
