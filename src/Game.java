import java.util.ArrayList;
import java.util.Random;

/**
 * This class will display the game of this assignment It will be called through
 * the Main class as usual Here is the construct of it
 */

public class Game {

	// Objects
	private String word;
	private Lexicon lexicon;
	private Random ran = new Random();
	private ArrayList<Character> array = new ArrayList<>();
	private boolean beforeTries = true;
	private int guesses = 8;
	private ArrayList<Character> alreadyChosen = new ArrayList<>();

	// This method is going to choose a random word for the game
	public void chooseRandomWord() {

		lexicon = new Lexicon();

		int indexOfWord = ran.nextInt(49) + 1;
		word = lexicon.getWord(indexOfWord);

	}

	public void mainGame(Menu menu) {

		char myLetter = ' '; // The letter I choose
		boolean sendMessage = false;
		boolean exists = false;
		boolean chosen = false;

		if (beforeTries == true) {

			for (int i = 0; i < word.length(); i++) {
				array.add('-');
			}

		} else {

			// The letter I guessed
			myLetter = menu.getMyLetter();

			// Loop on every single letter of the word I try to find
			for (int i = 0; i < word.length(); i++) {

				// See if the letter I typed is the same as the one from the word i try to find
				if (myLetter == word.charAt(i)) {

					exists = true; // becomes true whenever the chosen letter exists in the word

					// Exists so the word stays as it is in case of typing again a word that exists
					// but is already typed
					// The result is exactly the same even without this if statement
					// The reason I prefer to use this, is the complexity of the algorithm
					if (myLetter != array.get(i)) {

						array.add(i, myLetter);
						array.remove(i + 1);

						// This if statement is used to make sure that the message will be printed once
						// even if the specific letter exists more than once
						if (sendMessage == false) {
							System.out.println("You are CORRECT");
							sendMessage = true;
						}

					}
				}

			}

			for (char ch : alreadyChosen) {

				if (ch == myLetter) {
					System.out.println("You already chose that letter.");
					chosen = true;
					break;
				}
			}

			if (exists == false && chosen == false) {
				System.out.println("There is no " + myLetter + "'s in the word");
				guesses--;
			}
			alreadyChosen.add(myLetter);// Add the letter to the array with the chosen ones
		}

		beforeTries = false; // It becomes false as soon as the first call of the method is done

	}

	// Method to convert array's way to print into the one we need
	public String writeArray() {

		String output = "";

		for (Character ch : array) {

			output += ch;

		}

		return output;
	}

	public void setAlreadyChosen(ArrayList<Character> alreadyChosen) {
		this.alreadyChosen = alreadyChosen;
	}

	public void setGuesses(int guesses) {
		this.guesses = guesses;
	}

	public int getGuesses() {
		return guesses;
	}

	public String getWord() {
		return word;
	}

	public ArrayList<Character> getArray() {

		return array;
	}

	// Return everything needed to their original form
	public void clearAll() {
		alreadyChosen.clear();// There are no more already used letters
		beforeTries = true;// This is going to be the first try of the new game
		array.clear();// The array with our word is empty (it will be filled later)
	}

}
