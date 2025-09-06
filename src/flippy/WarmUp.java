package flippy;

import java.util.Arrays;

public class WarmUp {
	
	/**
	 * Counts how many cards are hearts
	 * 
	 * @param cards an array of cards
	 * @return heartCounter: the number of cards that are hearts
	 */
	public static int countHearts(Card[] cards ){
		
		//creates variable to keep track of hearts
		int heartCounter = 0;

		//cycles through every card in the array of Cards
		for (Card card : cards) {
			if (card.getSuit().equals("hearts")) { //cheks if suit is hearts
				heartCounter += 1;//adds to the counter
			}
		}

		return heartCounter; //returns heart card total
	}
	
	/**
	 * Adds the elements of two arrays of the same length.  The function assumes that 
	 * the arrays are of the same length
	 * 
	 * @param array1 an array of doubles of a fixed length
	 * @param array2 an array of doubles of fixed length that is the same length as array1
	 * @return sumArray: a new array that is the element-wise sum of the input arrays 
	 */
	public static double[] addArraysSameLength(double[] array1, double[] array2){
		double[] sumArray = new double[array1.length]; //initializes new array of doubles

		for(int i = 0; i < array1.length; i++) { //cycles through indices of arrays
			sumArray[i] = array1[i] + array2[i]; //sets index with the new sum value of both arrays
		}
		return sumArray; //returns new array
	}
	
		

	/**
	 * Takes an array of Strings as a parameter and reverses the order of the array.
	 * 
	 * @param array1 an array of strings
	 * @return array1: a mutation of the original array of strings provided in parameter
	 */

	public static String[] reverseArray(String[] array1) {
		
		String holder = ""; //creating a variable to hold ont to temporary value being change
		int i = 0; //first pointer to start at (beginning of array)
		int x = array1.length-1; //second pointer to start at (end of array)

		while (i < x) { //checking if two pointers have crossed each other
			holder = array1[i].toString(); //sets holder to the string currently held at this index
			array1[i] = array1[x]; //swaps content held at indexes
			array1[x] = holder; // swaps second pointer index with original content of first pointer
			i++; //increments value
			x--; //decrements value
		}

		return array1; //returns modified array

	}

	public static void main(String[] args){
		//TESTING reverseArray
		String[] words = {"I", "love", "my", "CS", "classes", "!"}; //even length
		
		System.out.println("Before: " + Arrays.toString(words));
		reverseArray(words);
		System.out.println("After: " + Arrays.toString(words));

		String[] wordsOdd = {"I", "love", "my", "CS", "classes"}; //odd length
		
		System.out.println("Before: " + Arrays.toString(wordsOdd));
		reverseArray(wordsOdd);
		System.out.println("After: " + Arrays.toString(wordsOdd));

		//TESTING COUNTHEARTS
		Card[] cards = new Card[4];
        cards[0] = new Card(1, "clubs");
        cards[1] = new Card(1, "hearts");
        cards[2] = new Card(3, "hearts");
        cards[3] = new Card(2, "diamonds");
        System.out.println(countHearts(cards));

		//TESTING addArraysSameLength
		double[] array1 = {1, 2, 3, 4, 5};
    	double[] answer = addArraysSameLength(array1, array1);
      	System.out.println(Arrays.toString(answer));
	}
}
