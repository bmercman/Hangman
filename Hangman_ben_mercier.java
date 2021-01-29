package hangman_ben_mercier;

import java.util.Scanner;

/**
 *
 * @author Ben Mercier
 */
public class Hangman_ben_mercier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Scanners
        Scanner keyboard = new Scanner(System.in);

        // Variables that do not need to be in main game
        char playAgain = 'y';
        int numGuess;

        // If player wants to play again variables reset and game starts
        while (playAgain == 'y') {
            // Title
            System.out.println("                                     WELCOME TO");
            System.out.println(" _      _   __--__   ____     _    _________    ___           ___   __--__   ____     _");
            System.out.println("| |    | | |  __  | |    |   | |  | ________|  |   |         |   | |  __  | |    |   | |");
            System.out.println("| |____| | | |  | | |  ^  |  | | | |           | |  |       |    | | |  | | |  ^  |  | |");
            System.out.println("|  ____  | | |__| | | | |  | | | | |  ________ | | | |     | | | | | |__| | | | |  | | |");
            System.out.println("| |    | | |  __  | | |  |  || | | | |______ | | |  | |   | |  | | |  __  | | |  |  || |");
            System.out.println("| |    | | | |  | | | |   |  | | | |_______| | | |   | | | |   | | | |  | | | |   |  | |");
            System.out.println("|_|    |_| |_|  |_| |_|    |___| |__________|  |_|    |___|    |_| |_|  |_| |_|    |___|");

            // Game Variables that need to be reset
            String secretWord;
            String playerGuess;
            int dashesLeft;
            String dashes = "";
            int index;
            numGuess = 8;
            boolean correctLetter;
            // alphabet variables
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            // Hangman figure variables
            String top = "";
            String rowOne = "";
            String rowTwo = "";
            String rowThree = "";
            String rowFour = "";
            String side = "|";
            String noose = "  | ";
            String head = "  o";
            String body = "  |";
            String leftArm = " /|";
            String rightArm = " /|\\";
            String leftLeg = " /";
            String legs = " / \\";

            // Displays game instructions
            System.out.println("");
            System.out.println("The object of Hangman: Player 1 enters a secret word.");
            System.out.println("Player 2 has 8 attempts to guess the secret word.");
            System.out.println("");
            // Secret word is assigned
            System.out.print("Enter the secret word: ");
            secretWord = keyboard.nextLine();

            // Replaces Letter with Dashes
            for (index = 0; index < secretWord.length(); index++) {
                dashes = dashes + "-";
            }
            // Main Block: Request input for players guess
            do {
                System.out.println("");
                // displays dashed word
                System.out.println("Word: " + dashes);
                System.out.println("");
                // Displays number of guesses
                System.out.println("Remaining Guesses: " + numGuess);
                // Hangman Figure display
                System.out.println(top);
                System.out.println(side + rowOne);
                System.out.println(side + rowTwo);
                System.out.println(side + rowThree);
                System.out.println(side + rowFour);
                System.out.println("|_______");
                // Displays alphabet
                System.out.println("Guess a Letter: " + alphabet);
                // Player guess input
                playerGuess = keyboard.nextLine();
                
                //Letter searching variables
                int letterPos = -1;
                correctLetter = false;

                do {

                    // Searches the secretWord for all occurences of the letter
                    letterPos = secretWord.indexOf(playerGuess, letterPos + 1);
                    // An occurence has been found
                    if (letterPos >= 0) {
                        correctLetter = true;
                        dashes = dashes.substring(0, letterPos) + playerGuess
                                + dashes.substring(letterPos + 1);

                    }

                    // Letter search conditions
                } while (letterPos >= 0);
                
                // Alphabet slashes
                letterPos = alphabet.indexOf(playerGuess);
                
                if (letterPos >= 0) {
                    alphabet = alphabet.substring(0, letterPos) + "/"
                                + alphabet.substring(letterPos + 1);
                }

                if (correctLetter == false) { // An occurence has not been found

                    // hangman figure
                    if (numGuess == 8) {
                        top = "____";
                    } else if (numGuess == 7) {
                        rowOne = noose;
                    } else if (numGuess == 6) {
                        rowTwo = head;
                    } else if (numGuess == 5) {
                        rowThree = body;
                    } else if (numGuess == 4) {
                        rowThree = leftArm;
                    } else if (numGuess == 3) {
                        rowThree = rightArm;
                    } else if (numGuess == 2) {
                        rowFour = leftLeg;
                    } else {
                        rowFour = legs;
                    }
                    numGuess--;
                }

                // Diplays the New dash word
                dashesLeft = dashes.indexOf("-");
                // Main game conditions
            } while (dashesLeft != -1 && numGuess != 0);
            // Game over message, you win message
            if (numGuess == 0) {
                System.out.println("Game Over: HANGMAN!");
                System.out.println("");
                 System.out.println("Guesses Left: " + numGuess);
            } else {
                System.out.println("Congradulations you Win");
                System.out.println("");
                 System.out.println("Guesses Left: " + numGuess);
            }

            // Ask if player wants to play again
            System.out.println("Do you want to play again? 'y' or 'n'");
             System.out.println("");
            System.out.print("Entry: ");
            playAgain = keyboard.nextLine().charAt(0);
            // PlayAgain validation
            switch (playAgain) {
                case 'y':
                    System.out.print("New Game: ");
                    break;
                case 'n':
                     System.out.println("");
                    System.out.println("Thanks for Playing");
                    break;
                default:
                    System.out.println("Invalid Entry: please enter valid character");
                    System.out.println("");
                    System.out.println("Do you want to play again? 'y' or 'n'");
                    System.out.println("");
                    System.out.print("Entry: ");
                    playAgain = keyboard.nextLine().charAt(0);
                    break;
            }

        }

    }

}
