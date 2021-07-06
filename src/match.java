import java.util.ArrayList;
import java.util.List;

public class match {
    public int decideWinner(List<player> players) {
        // Create a separate NAMED object of each player.
        player playerOne = new player(players.get(0).getId(), players.get(0).getFirstName(), players.get(0).getLastName(), players.get(0).getScore());
        player playerTwo = new player(players.get(1).getId(), players.get(1).getFirstName(), players.get(1).getLastName(), players.get(1).getScore());

        // What did each player score this match? Out of 3
        int playerOneScore = playerOne.genScore();
        int playerTwoScore = playerTwo.genScore();

        int winner = 0;

        // Player 1 came out on top
        if (playerOneScore > playerTwoScore) {
            System.out.println("Player 1 wins: " + playerOneScore + "-" + playerTwoScore);
            winner = 1;
        }
        // Player 2 came out on top
        else if (playerOneScore < playerTwoScore) {
            System.out.println("Player 2 wins: " + playerTwoScore + "-" + playerOneScore);
            winner = 2;
        }
        else if (playerOneScore == playerTwoScore) {
            // Scores are the same, we need to tiebreak
            int result = tieBreak();

            //Player one wins?
            if (result == 1) {
                System.out.println("Player 1 wins: " + playerOneScore + "-" + playerTwoScore + ", with a tiebreak.");
                winner = 1;
            }
            //Player two wins?
            else if (result == 2) {
                System.out.println("Player 2 wins: " + playerTwoScore + "-" + playerOneScore + ", with a tiebreak.");
                winner = 2;
            }
        }

        // Return who one, 1 or 2 (int)
        return winner;
    }

    // Generate 1 or 2 to decide winner in case of tiebreak
    public int tieBreak() {
        // Generate 1 or 2
        // If less than 0.5 then 1, otherwise 2
        int temp = (Math.random() <= 0.5) ? 1 : 2;;

        return temp;
    }

}
