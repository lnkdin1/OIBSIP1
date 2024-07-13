import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        final int MAX_ATTEMPTS = 5;  // Limiting the number of attempts
        final int MAX_NUMBER = 100;  // Maximum number for random generation
        
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_NUMBER) + 1; // Generate random number between 1 and 100
        
        int attempts = 0;
        int score = 0;
        
        boolean guessedCorrectly = false;
        
        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            int guessedNumber = getUserGuess();
            attempts++;
            
            if (guessedNumber == randomNumber) {
                guessedCorrectly = true;
                score += 10;  // Increment score for correct guess
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.\nYour score: " + score);
            } else if (guessedNumber < randomNumber) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
            }
        }
        
        if (!guessedCorrectly) {
            JOptionPane.showMessageDialog(null, "Sorry, you did not guess the number. The number was: " + randomNumber + "\nBetter luck next time!");
        }
    }
    
    // Helper method to get user input
    public static int getUserGuess() {
        String userInput = JOptionPane.showInputDialog("Guess the number between 1 and 100:");
        int userGuess = Integer.parseInt(userInput);
        return userGuess;
    }
}



