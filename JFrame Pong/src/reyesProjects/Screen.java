/*
 * File name: Screen.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: May 15, 2017
 */
package reyesProjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Screen extends JPanel implements ActionListener, KeyListener
{
	private Pong game;
	private Ball ball;
	private Paddle player1;
	private Paddle player2;
	private int scorePlayer1;
	private int scorePlayer2;
	
	public Screen(Pong game)
	{
		setBackground(Color.BLACK);
		this.game = game;
		ball = new Ball(game);
		player1 = new Paddle(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 36);
		player2 = new Paddle(game, KeyEvent.VK_W, KeyEvent.VK_S, 20);
		Timer timer = new Timer(5, this);
        timer.start();
		addKeyListener(this);
		setFocusable(true);
	}
	
	public Paddle getPlayer(int playerNum) //Allows access to the player objects
	{
		if(playerNum == 1)
		{
			return player1;
		}
		else 
		{
			return player2;
		}
	}
	
	public void increaseScore(int playerNum) //Increases score based on player number chosen
	{
		if(playerNum == 1)
		{
			scorePlayer1++;
		}
		else
		{
			scorePlayer2++;
		}
	}
	
	public int getScore(int playerNum) //Returns score based on player number chosen
	{
		if(playerNum == 1)
		{
			return scorePlayer1;
		}
		else
		{
			return scorePlayer2;
		}
	}
	
	public void update()
	{
		ball.Update();
		player1.update();
		player2.update();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		update();
		repaint();
	}
		
	public void keyPressed(KeyEvent e)
	{
		player1.keyPressed(e.getKeyCode());
		player2.keyPressed(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e)
	{
		player1.keyReleased(e.getKeyCode());
		player2.keyReleased(e.getKeyCode());
	}

	public void keyTyped(KeyEvent e)
	{
		;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawString(game.getScreen().getScore(1) + " : " + 
				game.getScreen().getScore(2), game.getWidth()/2, 10); //Places scores at top.
		ball.paint(g);
		player1.paint(g);
		player2.paint(g);
	}
}
