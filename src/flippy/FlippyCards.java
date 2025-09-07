package flippy;

import java.util.Random;


/**
 * Keeps track of the cards and and answers questions
 * for the flippy card game. 
 * 
 * Red cards (hearts and diamonds) award positive points, while black cards 
 * (clubs and spades) award negative points.  Cards 2-10 have points worth 
 * their face value, Jack, Queen and King 10 and Ace 11.
 * 
 * @author Victoria Prokopenko
 *
 */
public class FlippyCards {
	private Card[] cards; // the cards for the game

	/**
	 * Create a new flippy card game state, which consists of the
	 * numCards cards for the game.
	 * 
	 * @param numCards number of cards in the game
	 */
	public FlippyCards(int numCards){
		//basically, there will be 5 new cards (or however many chosen), randomized, facing down 
		cards = new Card[numCards]; // initializing cards array
		Random random = new Random(); // creating  an instance of the Random class:

		int bound = 13; //total card possibilities
		String[] suits = {"clubs", "diamonds", "hearts", "spades"}; //total suits possibiliies

		for (int i = 0; i < numCards; i++) { //for however many numCards the game will be played with, creating a new random card for each
			int randomCard = random.nextInt(bound) + 1; //generating random card within bound
			int randomIndex = random.nextInt(suits.length); //choosing random index of suits
			String randomSuit = suits[randomIndex]; //choosing suit at randomized index

			cards[i] = new Card(randomCard, randomSuit); //adding new card to the array of random number and suit

		}
	}

	/**
	 * Returns the flippy card at the given index 
	 * 
	 * @return the flippy card at the given index
	 */
	public Card getCard(int index) {
		return cards[index]; 
	}
	
	/**
	 * Flip the card over at this index.  Card indices
	 * start at 0 and go up the cards.length-1
	 * 
	 * @param cardIndex the index of the card to flip over
	 */
	public void flipCard(int cardIndex) {
		//TODO: Fill in good stuff here!
	}

	/**
	 * Calculate the best possible score for the
	 * current cards.
	 * 
	 * @return the optimal score
	 */
	public int calculateOptimalScore(){
		//TODO: Fill in good stuff here!
		return 0;
	}


	/**
	 * Calculate the flippy card score for the cards that are
	 * face up.  
	 * 
	 * @return the flippy card score for faceup cards
	 */
	public int faceUpTotal(){
		//TODO: Fill in good stuff here!
		return 0;
	}

	/**
	 * Calculate the flippy card score for the cards that are
	 * face down.  
	 * 
	 * @return the flippy card score for facedown cards
	 */
	public int faceDownTotal(){
		//TODO: Fill in good stuff here!
		return 0;
	}


	//TODO: Add a toString method here!


	public static void main(String[] args) {
		FlippyCards flippyCards = new FlippyCards(5);

		System.out.println(flippyCards.getCard(0));
		System.out.println(flippyCards.getCard(1));
		System.out.println(flippyCards.getCard(2));
		System.out.println(flippyCards.getCard(3));
		System.out.println(flippyCards.getCard(4));
		
	}
}
