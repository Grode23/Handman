import java.io.FileNotFoundException;
import java.util.Formatter;

public class HighScore {

	
	//Create a new file with all the high scores from the game
	public void createHighScoreFile() {

		try {
			Formatter form = new Formatter("High Scores");
		} catch (FileNotFoundException e) {
			System.out.println("Error with high score file.");
		}

	}
	
	
	//The score is the sum up of all the left guesses a player has, until they fail
	public void addToCurrentScore() {
		
		
		
	}
	
	
	
	
	//Put the new high score, if it's really a high score 
	//The top 10 high scores will be saved
	public void newHighScore() {
		
		
		
		
		
		
	}

}
