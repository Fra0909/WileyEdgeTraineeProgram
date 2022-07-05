import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int playAgain = 0;
        String[] moves = {"Rock", "Paper", "Scissors"};

        do {
            System.out.println("Welcome to Rock Paper Scissors, please enter the number of rounds (1-10)");
            Scanner numberOfRoundsScanner = new Scanner(System.in);
            int numberOfRounds = numberOfRoundsScanner.nextInt();

            if (numberOfRounds < 1 || numberOfRounds > 10) {
                System.out.println("The number you entered is invalid.");
                return;
            }
            //Exiting the program if the number entered is invalid.

            int roundsWon = 0, roundsLost = 0, ties = 0;
            Scanner moveScanner = new Scanner(System.in);
            Random random = new Random();

            for (int i = 0; i < numberOfRounds; i++) {
                System.out.println("Choose your move. (1 Rock, 2 Paper, 3 Scissors)");

                int playerMove = moveScanner.nextInt();

                int computerMove = random.nextInt(3) + 1;
                System.out.println("Your move: " + moves[playerMove-1] +"\nComputer move: " + moves[computerMove-1]);
                //Printing the moves of the current round.

                if (playerMove == computerMove) {
                    ties++;
                    System.out.println("It's a tie!");
                } else if (playerWins(playerMove, computerMove)) {
                    roundsWon++;
                    System.out.println("Player wins the round.");
                } else {
                    roundsLost++;
                    System.out.println("Computer wins the round");
                }
                //Checking who won the round using the method "playerWins" that will compare the player move
                //to every possible outcome and establish if they won the round or not.


            }
            System.out.println("Player wins: " + roundsWon);
            System.out.println("Computer wins: " + roundsLost);
            System.out.println("Ties: " + ties);
            if (roundsWon == roundsLost) {
                System.out.println("It's a tie!");
            } else if (roundsWon > roundsLost) {
                System.out.println("Player is the overall winner.");
            } else {
                System.out.println("Computer is the overall winner.");
            }
            //After N rounds have been played the program will establish who is the overall winner and print it.

            System.out.println("Do you want to play again? \n1 yes / 0 no.");
            Scanner playAgainScanner = new Scanner(System.in);
            int playAgainInput = playAgainScanner.nextInt();
            if (playAgainInput == 1) {
                playAgain = 1;
            } else {
                System.out.println("Thanks for playing!");

            }
            //If the user wants to play again they can do so by typing "1". If they type anything else
            //the program will print "Thanks for playing" and stop running.

        }
        while (playAgain == 1);
    }

    static boolean playerWins(int playerMove, int computerMove) {
        if (playerMove == 1) {
            return computerMove == 3;
        } else if (playerMove == 2) {
            return computerMove == 1;
        } else if (playerMove == 3) {
            return computerMove == 2;
        }
        return false;
    }
    //This method compares the player's move with the computer's and works out who is the winner between
    //the two.
}
