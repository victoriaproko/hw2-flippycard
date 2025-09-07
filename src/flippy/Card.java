package flippy;

/**
 * A card class representing a standard playing card with
 * numbers 2-10, Jack, Queen, King, Ace and four suits.
 * 
 *
 */
public class Card {
	// min/max for the card number range
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 13;

	private int number;
	private String suit;
	private boolean faceUp = false; // whether the card is face up

	/**
	 * Create a new card with number and suit.  If the a valid
	 * suit/number is not input, the card defaults to 1 of hearts.
	 * 
	 * @param number the card number
	 * @param suit the card suit
	 */
	public Card(int number, String suit){
		this.number = number;
		this.suit = suit.toLowerCase();

		if( !isValidSuit(suit) ){
			System.out.println(suit + "Is not a valid suit!");
			System.out.println("Must be one of: clubs, diamonds, hearts or spades");
			System.out.println("Defaulting to hearts");
			this.suit = "hearts";
		}

		if( !isValidNumber(number) ){
			System.out.println(number + "Is not a valid number!");
			System.out.println("Must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
			System.out.println("Defaulting to 1");
			this.number = 1;
		}		
	}

	/** 
	 * @return the card's suit
	 */
	public String getSuit(){
		return suit;
	}

	/**
	 * Returns the cards number, changing Jack, Queen, King, Ace
	 * appropriately.
	 * 
	 * @return the cards number
	 */
	public String getNumber(){
		if( number == 1 ){
			return "Ace";
		}else if( number >= 2 && number <= 10 ){
			return Integer.toString(number);
		}else if( number == 11 ){
			return "Jack";
		}else if( number == 12 ){
			return "Queen";
		}else{
			return "King";
		}
	}
	
	/**
	 * @return whether or no the card is face up
	 */
	public boolean isFaceUp(){
		return faceUp;
	}
	
	/**
	 * Flip the card over.  If the card is face down it becomes
	 * face up and vice versa.
	 */
	public void flip(){
		faceUp = !faceUp;
	}
	
	/**
	 * The cards number followed by the suit
	 */
	public String toString(){
		return getNumber() + " of " + getSuit();
	}
	
	/**
	 * Make it an Ace!
	 */
	public void cheat(){
		number = 1; // ACE!
	}

	/**
	 * Check to make sure the card number is valid
	 * 
	 * @param num potential card number
	 * @return whether the card number is valid
	 */
	private boolean isValidNumber(int num){
		return num >= MIN_NUMBER && num <= MAX_NUMBER;
	}

	/**
	 * Check to make sure the suit is valid
	 * 
	 * @param s potential suit
	 * @return whether the suit is valid
	 */
	private boolean isValidSuit(String s){
		return s.equals("spades") ||
				s.equals("hearts") ||
				s.equals("clubs") ||
				s.equals("diamonds");
	}
	
	/**
	 * The value of this card for the flippy card game.
	 * Numbers have their number as the value, Ace is 11,
	 * and Jack, Queen, and King are 10.
	 * 
	 * @return the flippy card value
	 */
	public int getFlippyCardValue(){
		if (number == 1) { ///if the number is 1, its an ace and should return the value of 11 in the game
			if (suit == "hearts" || suit == "diamonds") { //checking suit, adding accordingly depending on whether its a black or red cad
				return 11;
			}
			else {
				return -11;
			}
			
		}
		else if (number >= 11 && number <= 13) { // if the numbers are 11-13, they're face cards and return the value of 10 in the game
			if 	(suit == "hearts" || suit == "diamonds") {//checking suit, adding accordingly depending on whether its a black or red cad
				return 10;
			}
			else {
				return -10;
			}
		}
		else { //otherwise, all other numbers return their own value in the game
			if 	(suit == "hearts" || suit == "diamonds") {//checking suit, adding accordingly depending on whether its a black or red cad
				return number;
			}
			else {
				return -number;
			}
			
		}

	}
	
	/**
	 * Whether the suit is red or not.
	 * 
	 * @return whether or not the card is red
	 */
	public boolean isRedCard(){
		
		if (suit == "hearts" || suit == "diamonds") { //returns true if the suit is either of the two red suits
			return true;
		}
		
		return false; //false otherwise
	}

	public static void main (String[] args) {

		//TESTING getFlippyCardValue
		Card card1 = new Card(1, "hearts");
		System.out.println(card1.getFlippyCardValue());

		Card card2 = new Card(5, "spades");
		System.out.println(card2.getFlippyCardValue());

		Card card3 = new Card(11, "clubs");
		System.out.println(card3.getFlippyCardValue());

		Card card4 = new Card(12, "diamonds");
		System.out.println(card4.getFlippyCardValue());

		Card card5 = new Card(13, "hearts");
		System.out.println(card5.getFlippyCardValue());

		//TESTING isRedCard
		System.out.println(card1.isRedCard());
		System.out.println(card2.isRedCard());
		System.out.println(card3.isRedCard());
		System.out.println(card4.isRedCard());
		System.out.println(card5.isRedCard());
	}
 
}