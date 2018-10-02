/*
 * File name: Deck.java
 *
 * Programmer: Michael Jesus Reyes
 *
 * Date: Aug 2, 2018
 */
package reyesProjects;

import java.util.ArrayList;

/**
 * <Insert C;ass Description Here>
 *
 * @author Michael Jesus Reyes
 *
 */
public class Deck
{
	private ArrayList<Card> cards;
	
	public Card getCard(int cardNumber)
	{
		return cards.get(cardNumber);
	}
	
	public void addCardToDeck(Card specCard)
	{
		cards.add(specCard);
	}
	
	public void transferCardFromDeck(int cardNumber, Deck newDeck)
	{
		
	}
}
