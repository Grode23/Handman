import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private Scanner sc;
	private char myLetter;
	private boolean done;
	private String tempObjForLetter = "";

	public char getMyLetter() {
		return myLetter;
	}

	// This will appear whenever a game is done
	public char mainMenu() {

		char choice;
		sc = new Scanner(System.in);

		do {
			System.out.println("MAIN MENU");
			System.out.println("-Start a new game(S)");
			System.out.println("-Exit(E)");
			System.out.print("Please enter your choice: ");
			choice = sc.next().charAt(0);

			if (choice != 'S' && choice != 'E' && choice != 's' && choice != 'e') {
				System.out.println("Wrong answer.");
				System.out.println("Try again.");
			}
		} while (choice != 'S' && choice != 'E' && choice != 's' && choice != 'e');

		return choice;

	}

	// See the rest of the word or the entire word if no letters were found
	// and how many guess are left
	public void seeWordMenu(Game game) {

		System.out.print("The random word is now: " + game.writeArray() + "\n");
		System.out.println("You have " + game.getGuesses() + " guesses left");

	}

	// A method to guess a letter
	public void makeAGuess() {

		sc = new Scanner(System.in);

		// In case of an answer with many letters, only the first one will be considered
		do {
			
			System.out.print("Your guess: ");
			noCharacter();	//Get an object with at least one character

		} while ((isLong(tempObjForLetter)) || (isNumeric(myLetter)));

		// Convert the answer to a capital letter
		myLetter = Character.toUpperCase(myLetter);

	}

	//Get an object with at least one character
	public void noCharacter() {
		
		
		// tempObjForLetter is used to be sure that the input is strictly ONE character
		// When this checking is done, I keep using the char Object
		while(true) {
			
			try {
				tempObjForLetter = sc.nextLine();
				myLetter = tempObjForLetter.charAt(0);
				break;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Enter at least one character.");
				System.out.print("Your guess: ");
			}


								
		}
		
	}

	// Return true if the string is a number
	public boolean isNumeric(char chr) {
		if (chr >= '0' && chr <= '9') {
			System.out.println("Make sure your character is a letter");
			return true;
		}
		return false;
	}

	// Returns true if the string is longer than one character
	public boolean isLong(String str) {
		if (str.length() > 1) {
			System.out.println("Please write only one character.");
			return true;
		}
		return false;
	}

	public void endOfGame(Game game) {

		done = true;
		int wordLength = game.getWord().length();// Length of the random word
		ArrayList<Character> array = game.getArray();// The array from Game class (used for the letters I already found)

		if (game.getGuesses() == 0) {
			System.out.println("You failed!");
			System.out.println("The random word was: " + game.getWord());
		}

		for (int i = 0; i < wordLength; i++) {
			if (array.get(i) == '-') {
				done = false;
			}
		}

		if (done == true) {
			System.out.println("Congratulations! You guessed the word " + game.getWord());
		}

	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public boolean isDone() {
		return done;
	}

}
