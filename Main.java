// This class will introduce the rules of blackjack, ask the user to play,
// run the blackjack method from the blackjack class, and then ask the user
// if they want to play again or not

import java.util.Scanner;

public class Main extends BlackJack {

    public static void main(String args[]) { //main methody

        boolean p = false;
        String playAgain = "";
        String play = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to a game of BlackJack.");
        System.out.println("Would you like to hear the rules?");
        play = scan.nextLine();

        if  (!play.equalsIgnoreCase("n") && !play.equalsIgnoreCase("No")
                && !play.equalsIgnoreCase("Nope")) {
            System.out.println("https://www.blackjackapprenticeship.com/how-to-play-blackjack/");
            System.out.println("Now that you've heard the rules, " +
                    "would you like to play a game?");
            play = scan.nextLine();
            if (!play.equalsIgnoreCase("n") &&
                    !play.equalsIgnoreCase("No")
                    && !play.equalsIgnoreCase("Nope")) {
                blackJack();
            } else {
                System.out.println("Stop wasting my time, come back when you want to " +
                        "stop messing around");
            } // end of if else statement

                while (!p) {
                    System.out.println("Would you like to play again?");
                    playAgain = scan.nextLine();
                    if (playAgain.equalsIgnoreCase("yes") ||
                            playAgain.equalsIgnoreCase("y")
                            || playAgain.equalsIgnoreCase("yeah")) {
                        blackJack();
                    } else if (playAgain.equalsIgnoreCase("No") ||
                            playAgain.equalsIgnoreCase("n")
                            || playAgain.equalsIgnoreCase("nope") ) {
                    System.out.println("Thanks for playing!");
                    p = !p;
                } else {
                        System.out.println("Please Try Again.");
                    } // end of else
                } // end of while
        } // end of if
    } // end of main
} //end of class
