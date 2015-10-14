/*************************************************************************
    > File Name: Card.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Tue Oct 13 20:40:22 2015
 ************************************************************************/

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {

		CardDeck cardDeck = new CardDeck();

		for(int i=0; i<cardDeck.deckOfCards.size(); i++) {
			cardDeck.printCard(cardDeck.deckOfCards.get(i));
		}

		//System.out.println(cardDeck.deckOfCards.size());
	}
}

class CardDeck {

	static final char RED = 'R';
	static final char BLACK = 'B';

	static final int ACE = 1;
	static final int TWO = 2;
	static final int THREE = 3;
	static final int FOUR = 4;
	static final int FIVE = 5;
	static final int SIX = 6;
	static final int SEVEN = 7;
	static final int EIGHT = 8;
	static final int NIGHT = 9;
	static final int TEN = 10;
	static final int JACK = 11;
	static final int QUEEN = 12;
	static final int KING = 13;
	static final int JOKER1 = 14;
	static final int JOKER2 = 15;

	static final int JOKER = 0;
	static final int HEART = 1;
	static final int SPADE = 2;
	static final int CLUB = 3;
	static final int DIAMOND = 4;

	public static final int MAX_NUM_OF_CARDS = 54;

	public LinkedList<Card> deckOfCards = new LinkedList<Card>();

	private LinkedList<Card> usedCards = new LinkedList<Card>();
	public LinkedList<Card> cardsAtHand = new LinkedList<Card>(); 

	CardDeck() {
		//Initialize a deck of cards, which contains exactly 54 unique cards

		for( int i=1; i<=4; i++ ) {
			for( int j=1; j<=13; j++ ) {
				deckOfCards.offer(createCard(i, j));
			}
		}

		deckOfCards.offer(createCard(JOKER, JOKER1));
		deckOfCards.offer(createCard(JOKER, JOKER2));

		shuffle();
	}

	boolean isWin() {
		return false;
	}

	int score() {
		//count the score of cards at hand
		return 0;
	}

	//shuffle the cards
	public void shuffle() {

	}

	private Card createCard( int type, int val ) {
		Card card = null;
		try{
			switch( type ) {
				case HEART:
					card = new HeartCard(val);
					break;
				case SPADE:
					card = new SpadeCard(val);
					break;
				case CLUB:
					card = new ClubCard(val);
					break;
				case DIAMOND:
					card = new DiamondCard(val);
					break;
				case JOKER:
					card = (val==JOKER1) ? new Joker1() : new Joker2();
					break;
				default:
					throw new Exception("Invalid Card Type");
			}
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return card;	
	}

	public void printCard( Card card ) {
		
		switch(card.getClass().getName()) {
			case "HeartCard":
				System.out.println( "[Card] Type: " + "HEART" + "   Value: " + card.val);
				break;
			case "SpadeCard":
				System.out.println( "[Card] Type: " + "SPADE" + "   Value: " + card.val);
				break;
			case "ClubCard":
				System.out.println( "[Card] Type: " + "CLUB" + "   Value: " + card.val);
				break;
			case "DiamondCard":
				System.out.println( "[Card] Type: " + "DIAMOND" + "   Value: " + card.val);
				break;
			case "Joker1":
				System.out.println( "[Card] Type: " + "JOKER 1" );
				break;
			case "Joker2":
				System.out.println( "[Card] Type: " + "JOKER 2" );
				break;
			default:
				break;
		}
	}
	
}

abstract class Card {
	int val;

	Card() {
		val = CardDeck.ACE;
	}

	Card(int i) {
		val = i;
	}
}

abstract class RedCard extends Card {
	final char color = CardDeck.RED;

	RedCard() {
		super();
	}

	RedCard(int i) {
		super(i);
	}
}

abstract class BlackCard extends Card {
	final char color = CardDeck.BLACK;

	BlackCard() {
		super();
	}

	BlackCard(int i) {
		super(i);
	}
}

class HeartCard extends RedCard {
	final int type = CardDeck.HEART;
	
	HeartCard() {
		super();
	}

	HeartCard(int i) {
		super(i);
	}


}

class DiamondCard extends RedCard {
	final int type = CardDeck.DIAMOND;
	
	DiamondCard() {
		super();
	}

	DiamondCard(int i) {
		super(i);
	}
}

class SpadeCard extends BlackCard {
	final int type = CardDeck.SPADE;
	
	SpadeCard() {
		super();
	}

	SpadeCard(int i) {
		super(i);
	}
}

class ClubCard extends RedCard {
	final int type = CardDeck.CLUB;
	
	ClubCard() {
		super();
	}

	ClubCard(int i) {
		super(i);
	}
}

class Joker1 extends RedCard {
	Joker1() {
		super(CardDeck.JOKER1);
	}
}

class Joker2 extends BlackCard {
	Joker2() {
		super(CardDeck.JOKER2);
	}
}