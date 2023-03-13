/* This is the blackjack game, the blackjack method it will create the stack,
create the arraylists
pop the stacks into the arraylists, tell the user their hand cards and hand value and
compute who is winning the game, when the dealer should draw.

the playerCard and DealerCard methods retrieve the dealerTotal and playerTotal,
these values are the hand totals will be used in the blackjack method to
figure out who won
 */
import java.util.*;
public class BlackJack extends DeckOfCards {
    public static int playerTotal;
    public static int dealerTotal;
    public static int dealerHiddenTotal;

    public static void blackJack() { //plays the game of blackjack
        boolean b = false;
        boolean q = false;
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards to random order
        Stack<Card> s = new Stack<>();
        String choice = "";
        Scanner scan = new Scanner(System.in);

        for (Card str : myDeckOfCards.deck) {
            s.push(str);
        }
        ArrayList<Card> player = new ArrayList<>();
        ArrayList<Card> dealer = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Card x = s.pop();
            Card y = s.pop();
            player.add(x);
            dealer.add(y);

        }

        playerCard(player);
        dealerCardHidden(dealer);
        System.out.println("Your Hand: \n" + player);
        System.out.println("Your Hand Total: " + playerTotal);
        System.out.println("Dealers Hand: \n" + dealer.get(0) + " | Hidden Card |");
        System.out.println("Dealers Hand Total: " + dealerHiddenTotal + " + ?");

        //aces are high, this automatically busts the users hand if they draw two aces
        if (playerTotal > 21) {
            System.out.println("Player Busts!");
            System.out.println("The Dealer Reveals His Hand");
            dealerCard(dealer);
            System.out.println("Dealer Hand: " + dealer);
            System.out.println("Dealer Total: " + dealerTotal);
            System.out.println("Dealer Wins!");
            dealerTotal = 0;
            playerTotal = 0;
            dealerHiddenTotal = 0;
        }

        // if user draws a blackjack on the first draw, this causes the dealer to
        // reveal his hidden card
        if (playerTotal == 21) {
            System.out.println("BlackJack!");
            System.out.println("The Dealer Reveals His Hand");
            dealerCard(dealer);
            System.out.println("Dealer Hand: " + dealer);
            System.out.println("Dealer Total: " + dealerTotal);

            while (!q) { // this causes the dealer to draw until he reaches numbers 17-21,
                // or until he matches the players blackjack or busts. This
                // while loop occurs when player draws blackjack first try
                while (17 > dealerTotal) {
                    System.out.println("The Dealer Hits");
                    Card y = s.pop();
                    dealer.add(y);
                    dealerCard(dealer);
                    System.out.println("Dealer Hand: " + dealer);
                    System.out.println("Dealer Total: " + dealerTotal);
                }
                if (playerTotal == dealerTotal) {
                    dealerTotal = 0;
                    playerTotal = 0;
                    dealerHiddenTotal = 0;
                    System.out.println("Dealer Draws a BlackJack!");
                    System.out.println("Tie!");
                    q = !q;
                } else if (21 < dealerTotal) {
                    dealerTotal = 0;
                    playerTotal = 0;
                   dealerHiddenTotal = 0;
                    System.out.println("Dealer Busts!");
                    System.out.println("Player wins!");
                    q = !q;
                } else if (dealerTotal == 17 || dealerTotal == 18 || dealerTotal == 19 ||
                        dealerTotal == 20) {
                   dealerTotal = 0;
                    playerTotal = 0;
                    dealerHiddenTotal = 0;
                    System.out.println("Dealer Can't Hit No More");
                    System.out.println("Player Wins!");
                    q = !q;
                }
            }
        } else {
            System.out.println("Would you like to hit or stay?");

            while (!b) {
                choice = scan.nextLine(); //asks user to hit or stay
                if (choice.equalsIgnoreCase("hit") ||
                        choice.equalsIgnoreCase("h")) {
                    // player draws card
                    Card x = s.pop();
                    player.add(x);
                    playerCard(player);
                    System.out.println("Your Hand: \n" + player);
                    System.out.println("Your Hand Total: " + playerTotal);

                }
                if (playerTotal == 21) { // if player draws = 21, player wins, but not until dealer
                    //draws until bust, tie, or any number between 17-20
                    System.out.println("BlackJack!");
                    System.out.println("The Dealer Reveals His Hand");
                    dealerCard(dealer);
                    System.out.println("Dealer Hand: " + dealer);
                    System.out.println("Dealer Total: " + dealerTotal);

                    while (17 > dealerTotal) {
                        System.out.println("The Dealer Hits");
                        Card y = s.pop();
                        dealer.add(y);
                        dealerCard(dealer);
                        System.out.println("Dealer Hand: " + dealer);
                        System.out.println("Dealer Total: " + dealerTotal);
                    }
                    if (playerTotal == dealerTotal) {
                        System.out.println("Dealer Draws a BlackJack!");
                        System.out.println("Tie!");
                        dealerTotal = 0;
                        playerTotal = 0;
                        dealerHiddenTotal = 0;
                    } else if (21 < dealerTotal) {
                        System.out.println("Dealer Busts!");
                        System.out.println("Player wins!");
                        dealerTotal = 0;
                        playerTotal = 0;
                        dealerHiddenTotal = 0;
                    } else if (dealerTotal == 17 || dealerTotal == 18 || dealerTotal == 19 ||
                    dealerTotal == 20) {
                    System.out.println("Dealer Can't Hit No More!");
                    System.out.println("Player Wins!");
                        dealerTotal = 0;
                        playerTotal = 0;
                        dealerHiddenTotal = 0;
                    b = !b;
                    }
                }
                // if players hand is still less than 21, ask to draw or stay
                if (playerTotal < 21) {
                    System.out.println("Would you like to hit or stay?");

                }
                if (playerTotal > 21) { // if player draws above 21 bust and reveal dealers hand
                    System.out.println("Bust!");
                    System.out.println("The Dealer Reveals His Winning Hand");
                    dealerCard(dealer);
                    System.out.println("Dealer Hand: " + dealer);
                    System.out.println("Dealer Total: " + dealerTotal);
                    System.out.println("Dealer Wins!");
                    dealerTotal = 0;
                    playerTotal = 0;
                    dealerHiddenTotal = 0;
                    b = !b;

                }
                 // if users stays begin dealer draw
                if (choice.equalsIgnoreCase("s") ||
                        choice.equalsIgnoreCase("stay")) {
                    System.out.println("The Dealer Reveals His Hand");
                    dealerCard(dealer);
                    System.out.println("Dealer Hand: " + dealer);
                    System.out.println("Dealer Total: " + dealerTotal);

                    if (playerTotal < dealerTotal) { // if dealer hand is greater, dealer wins
                        System.out.println("Dealer Wins!");
                        //dealerTotal = 0;
                        //playerTotal = 0;
                        //dealerHiddenTotal = 0;
                        b = !b;
                        if (dealerTotal == 21) { // if dealer draws
                            System.out.println("Dealer Draws a BlackJack!");
                            if (dealerTotal == playerTotal) ;
                            System.out.println("Both Dealer and Player Have BlackJacks! Tie!");
                            //dealerTotal = 0;
                            //playerTotal = 0;
                            //dealerHiddenTotal = 0;
                            b = !b;
                        }


                } else if (playerTotal >= dealerTotal) {
                        while (17 > dealerTotal) { //dealer draw until over 17
                            System.out.println("The Dealer Hits");
                            Card y = s.pop();
                            dealer.add(y);
                            dealerCard(dealer);
                            System.out.println("Dealer Hand: " + dealer);
                            System.out.println("Dealer Total: " + dealerTotal);
                        }
                        if (playerTotal == dealerTotal) { // tie game if both draw blackjack
                            System.out.println("Tie!");
                            b = !b;
                            //dealerTotal = 0;
                            //playerTotal = 0;
                            //dealerHiddenTotal = 0;
                        } else if (21 < dealerTotal) { // dealer bust
                            System.out.println("Dealer Busts!");
                            System.out.println("Player wins!");
                            b = !b;
                            //dealerTotal = 0;
                            //playerTotal = 0;
                            //dealerHiddenTotal = 0;
                        } else if (dealerTotal == 17 || dealerTotal == 18 || dealerTotal == 19 ||
                                dealerTotal == 20) { // cant draw anymore
                            System.out.println("Dealer Can't Hit No More");
                            if (dealerTotal < 21 && dealerTotal < playerTotal) {
                                System.out.println("Player Wins!");
                            b = !b;
                               // dealerTotal = 0;
                               // playerTotal = 0;
                               // dealerHiddenTotal = 0;
                        } else if (dealerTotal < 21 && dealerTotal > playerTotal) {
                                System.out.println("Dealer Wins!");
                                b = !b;
                                //dealerTotal = 0;
                                //playerTotal = 0;
                                //dealerHiddenTotal = 0;
                            }

                        } else if (dealerTotal == 21 && playerTotal != 21) { // if dealer
                            System.out.println("Dealer Hits A BlackJack!");
                            System.out.println("Dealer Wins");
                            //dealerTotal = 0;
                           // playerTotal = 0;
                           dealerHiddenTotal = 0;
                            b = !b;
                        } // end of if else
                    } // end of if
                } // end of if

            } // end of while loop
        } //end of else
    } // end of blackjack

    public static int playerCard(ArrayList<Card> player) { //gets card values from Card class
        playerTotal = 0;
        for (int i = 0; i < player.size(); i++) {
            BlackJack.playerTotal += player.get(i).getValue();
        } // end of for loop
        return (BlackJack.playerTotal);
    } //end of playerCard

    // gets dealers hidden card value from card class
    public static int dealerCardHidden(ArrayList<Card> dealer) {
        for (int i = 0; i < dealer.size()-1; i++) {
            BlackJack.dealerHiddenTotal += dealer.get(i).getValue();
        } //end of for loop
        return (BlackJack.dealerHiddenTotal);
    } //end of dealCardHidden

    //gets dealer cards when dealer reveals hand
    public static int dealerCard(ArrayList<Card> dealer) {
        dealerTotal = 0;
        for (int i = 0; i < dealer.size(); i++) {
            BlackJack.dealerTotal += dealer.get(i).getValue();
        } //end of for loop
        return (BlackJack.dealerTotal);
    } // end of dealerCard

} //end of class







