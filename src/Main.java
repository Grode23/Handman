import java.io.IOException;

/**
 * 
 * The main class Used as a "controller" to the entire program
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {

		// Objects
		Game game = new Game();
		Menu menu = new Menu();
		boolean firstTime;
		char choice;
		
		
		choice = menu.mainMenu();//The choice I made in the main menu (play or not)
		
		
		while(choice == 's' || choice == 'S') {
		
			// Choose a word
			game.chooseRandomWord();
	
  
			firstTime = true;//This is the first time this game runs
			
			//Clear everything up so they can be used with the next word
			if(firstTime == true) {
				game.setGuesses(8);
				menu.setDone(false);
				game.clearAll();
			}
			
			while (game.getGuesses() != 0 && menu.isDone() == false) {
	
				//Runs only the first time of any game
				if(firstTime == true) {
					game.mainGame(menu);//The random word is appeared as dashes to the user	
					firstTime = false;//No longer the first time
				}
				// First menu appeared
				menu.seeWordMenu(game);
				
		
				// I make a guess (obviously)
				menu.makeAGuess();
	
				//Main event of the game
				game.mainGame(menu);
				
				
				//Message for the end of game (if needed)
				menu.endOfGame(game);
				
			}
			
			System.out.println();//You know what it is :p
			
			choice = menu.mainMenu(); //Make a choice for the next loop
		}
	}

}
