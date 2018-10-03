/*
 * File name: Person.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Jul 9, 2017
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.Timer;

/**
 *  This class is one of my first game mechanic classes where I experimented with drawing shapes and applying person/warrior like mechanics
 *  to the shapes, such as health, attacking, and such.
 *
 * @author Michael Jesus Reyes
 *
 */
public class Person
{
	private double xPos, yPos;
	private double xAccel = 0, yAccel = 0;
	private double speed = 5;
	private double gravity = .5;
	private double maxYAccel = 7;
	private int WIDTH = 20;
	private int HEIGHT = 20;
	private Color COLOR;
	private double health = 100;
	private boolean facingRight;
	private boolean attacking = false;
	private boolean dead = false;
	private Timer attackCooldown;
	
	private Game game;
	private int  down, jump, left, right;
	
	public Person(Game game, int down, int jump, int left, int right, Color color, int size)
	{
		this.game = game;
		xPos = 10;
		yPos = game.getHeight()-HEIGHT;
		this.down = down;
		this.jump = jump;
		this.left = left;
		this.right = right;
		this.COLOR = color;
		this.WIDTH = size;
		this.HEIGHT = size;
		//attackCooldown = new Timer(5, this); 
	}
	
	public double getXPos()
	{
		return xPos;
	}
	
	public double getYPos()
	{
		return yPos;
	}
	
	public double getSize()
	{
		return WIDTH; //size
	}
	
	public double getHealth()
	{
		return health;
	}
	
	public Color getColor()
	{
		return COLOR;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)xPos, (int)yPos, WIDTH, HEIGHT);
	}
	
	public boolean getDead()
	{
		return dead;
	}
	
	public boolean checkAttacking()
	{
		return attacking;
	}
	
	public void update()
	{
		xPos += xAccel;
		yPos += yAccel;
		checkFloorBounds();
		checkWallBounds();
		gravity();
		checkHit();
		die();
	}
	
	private void checkFloorBounds()
	{
		if(yPos >= game.getHeight() - HEIGHT*2) //-(HEIGHT*3)
		{
			yPos = game.getHeight() - HEIGHT*2;
		}
	}
	
	private void checkWallBounds()
	{
		if(xPos+WIDTH < 0) //If person goes passed LEFT
		{
			xPos = game.getWidth();
		}
		else if(xPos > game.getWidth()) //If person goes passed RIGHT
		{
			xPos = 0-WIDTH;
		}
	}

	private void die()
	{
		if(health <= 0)
		{
			dead = true;
			xPos = -50; //Person goes to sky
			yPos = -50;
		}
	}
	
	private Rectangle attack()
	{
		if(facingRight == true)
		{
			return new Rectangle((int)xPos+WIDTH, (int)yPos, WIDTH, HEIGHT);
		}
		else
		{
			return new Rectangle((int)xPos-WIDTH, (int)yPos, WIDTH, HEIGHT);
		}
	}
	
	private void checkHit()
	{
		if(game.getScreen().getPerson(2).checkAttacking() == true && game.getScreen().getPerson(2).attack().intersects(getBounds()))
		{
			health -= 1;
			System.out.println(COLOR + "'s health: " + health);
		}
		if(game.getScreen().getPerson(1).checkAttacking() == true && game.getScreen().getPerson(1).attack().intersects(getBounds()))
		{
			health -= 1;
			System.out.println(COLOR + "'s health: " + health);
		}
		
		if(facingRight == true && game.getScreen().getPerson(1).checkAttacking() == true && game.getScreen().getPerson(1).attack().intersects(game.getScreen().getPerson(2).attack()) && game.getScreen().getPerson(2).checkAttacking() == true)
		{
			xPos -= 10;
		}
		if(facingRight == true && game.getScreen().getPerson(2).checkAttacking() == true && game.getScreen().getPerson(2).attack().intersects(game.getScreen().getPerson(1).attack()) && game.getScreen().getPerson(1).checkAttacking() == true)
		{
			xPos -= 10;
		}
		if(facingRight == false && game.getScreen().getPerson(1).checkAttacking() == true && game.getScreen().getPerson(1).attack().intersects(game.getScreen().getPerson(2).attack()) && game.getScreen().getPerson(2).checkAttacking() == true)
		{
			xPos += 10;
		}
		if(facingRight == false && game.getScreen().getPerson(2).checkAttacking() == true && game.getScreen().getPerson(2).attack().intersects(game.getScreen().getPerson(1).attack()) && game.getScreen().getPerson(1).checkAttacking() == true)
		{
			xPos += 10;
		}
	}
	
	private void jump()
	{
		yAccel -= 20;
		if(yAccel > maxYAccel)
		{
			yAccel = maxYAccel;
		}
	}
	
	private void gravity()
	{
		yAccel += gravity;
		if(yAccel > maxYAccel)
		{
			yAccel = maxYAccel;
		}
	}
	
	public void keyReleased(int keycode)
	{
		if(keycode == left || keycode == right)
		{
			xAccel = 0;
		}
		if(keycode == down)
		{
			attacking = false;
		}
	}
	
	public void keyPressed(int keycode)
	{
		if(keycode == left && dead == false)
		{
			xAccel = -speed;
			facingRight = false;
		}
		if(keycode == right && dead == false)
		{
			xAccel = speed;
			facingRight = true;
		}
		if(keycode == jump && yPos ==  game.getHeight()-HEIGHT*2 && dead == false)
		{
			jump();
		}
		if(keycode == down)
		{
			if(dead == false)
			{
				attack();
				attacking = true;
//				try
//				{
//					//attackCooldown.wait(500);  //I was working on an attack cooldown here involving timers.
//				}
//				catch (NullPointerException | InterruptedException e)
//				{
//					// TODO Auto-generated catch block
//					//e.printStackTrace();
//				}
			}
		}
	}
	
	private void paintAttack(Graphics g)
	{
		g.setColor(Color.WHITE);
		if(facingRight == true && attacking == true)
		{
			g.drawRect((int)xPos+WIDTH, (int)yPos, WIDTH, HEIGHT);
		}
		else if(facingRight == false && attacking == true)
		{
			g.drawRect((int)xPos-WIDTH, (int)yPos, WIDTH, HEIGHT);
		}
	}
	
	private void paintFace(Graphics g)
	{
		if(facingRight == true)
		{
			g.drawLine((int)xPos+HEIGHT/2, (int)yPos+HEIGHT/2, (int)xPos+WIDTH, (int)yPos+HEIGHT/2);
		}
		else if(facingRight == false)
		{
			g.drawLine((int)xPos, (int)yPos+HEIGHT/2, (int)xPos+WIDTH/2, (int)yPos+HEIGHT/2);
		}
	}
	
	private void paintDeath(Graphics g)
	{
		if(dead == true)
		{
			g.setColor(Color.BLACK);
			g.fillRect((int)xPos, (int)yPos, WIDTH, HEIGHT);
		}
	}
	
	private void paintHealth(Graphics g)
	{
		g.setColor(getColor());
		g.drawRect((int)getXPos()-25, (int)getYPos()-25, 100, 20);
		g.fillRect((int)getXPos()-25, (int)getYPos()-25, (int) getHealth(), 20);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(COLOR);
		g.fillRect((int)xPos, (int)yPos, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		paintFace(g);
		paintAttack(g);
		paintDeath(g);
		paintHealth(g);
	}
}
