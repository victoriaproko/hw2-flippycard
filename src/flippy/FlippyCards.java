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
	public Card[] cards; // the cards for the game


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
	 * @param int index index of card being retrieved
	 * 
	 * @return the flippy card at the given index
	 */
	public Card getCard(int index) {
		return cards[index]; //returns card at given index
	}
	
	/**
	 * Flip the card over at this index.  Card indices
	 * start at 0 and go up the cards.length-1
	 * 
	 * @param cardIndex the index of the card to flip over
	 */
	public void flipCard(int cardIndex) {
		cards[cardIndex].flip(); //flipping card at index

	}

	/**
	 * Calculate the best possible score for the
	 * current cards.
	 * 
	 * @return the optimal score
	 */
	public int calculateOptimalScore(){
		
		int optimalScore = 0; //intializing total red card value to 0

		for (Card card : cards) { //cycling through cards
			if (card.isRedCard()) { //checking if its a red card (bc optimal score would only account for red cards since they bear positive score values)
				optimalScore += card.getFlippyCardValue(); //adds the value of the card to the total red card value
			}
		}
		return optimalScore; //returns the optimal score
	}


	/**
	 * Calculate the flippy card score for the cards that are
	 * face up.  
	 * 
	 * @return the flippy card score for faceup cards
	 */
	public int faceUpTotal(){
		
		// int redCardsValue = 0; //intializing red card total values to 0
		// int blackCardsValue = 0; //initializing black card total values to 0
		int faceUpTotal = 0;
	
		for (Card card : cards) { //cycling through every card 
			if (card.isFaceUp()) { //checking if the card is faced up
				faceUpTotal += card.getFlippyCardValue(); //adding card value
			}
			
		}
		return faceUpTotal; //returning face up total
	}

	/**
	 * Calculate the flippy card score for the cards that are
	 * face down.  
	 * 
	 * @return the flippy card score for facedown cards
	 */
	public int faceDownTotal(){
		
		int hiddenTotal = 0; //initializing variable to track score of all the cards in the game
		int faceUpTotal = 0; //initializing variable to track score of face up cards only
	
		for (Card card : cards) { //cycling through every card 
				hiddenTotal += card.getFlippyCardValue(); //adding every card to the overall game total
				if (card.isFaceUp()) { //checking if the card is faced up, adding value to total for face up cards  
					faceUpTotal += card.getFlippyCardValue(); 
			}
				}
				return hiddenTotal - faceUpTotal; //returning difference to find face down cards total
			}




	//TODO: Add a toString method here!


	public static void main(String[] args) {

		//TESTING FlippyCards method
		FlippyCards flippyCards = new FlippyCards(5);

		//TESTING getCard method
		System.out.println(flippyCards.getCard(0));
		System.out.println(flippyCards.getCard(1));
		System.out.println(flippyCards.getCard(2));
		System.out.println(flippyCards.getCard(3));
		System.out.println(flippyCards.getCard(4));

		//TESTING flipCard method
		System.out.println(flippyCards.getCard(0).isFaceUp());
		flippyCards.getCard(0).flip();
		System.out.println(flippyCards.getCard(0).isFaceUp());

		//FLIPPING CARDS TO TEST faceUpTotal
		flippyCards.getCard(1).flip();
		flippyCards.getCard(2).flip();
		// flippyCards.getCard(3).flip();
		// flippyCards.getCard(4).flip();
		//TESTING faceUpTotal
		System.out.println("Face up total score: " + flippyCards.faceUpTotal());

		//TESTING calculateOptimalScore method
		System.out.println("Optimal score: " + flippyCards.calculateOptimalScore());

		//TESTING faceDownTotal
		System.out.println("Face down total score " + flippyCards.faceDownTotal());




		


	}
}
