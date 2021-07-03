import java.util.ArrayList;

public class match {
    ArrayList<player> players;

    public match(ArrayList<player> players) {
        this.players = players;
    }

    public void decideWinner(ArrayList<player> players) {
        // Create a separate NAMED object of each player.
        player playerOne = new player(players.get(1).getId(), players.get(1).getFirstName(), players.get(1).getLastName(), players.get(1).getScore());
        player playerTwo = new player(players.get(2).getId(), players.get(2).getFirstName(), players.get(2).getLastName(), players.get(2).getScore());

        // What did each player score this match? Out of 3
        int playerOneScore = playerOne.genScore();
        int playerTwoScore = playerTwo.genScore();

        // Player 1 came out on top
        if (playerOneScore > playerTwoScore) {
            System.out.println("Player 1 wins.");
        }
        // Player 2 came out on top
        else if (playerOneScore < playerTwoScore) {
            System.out.println("Player 2 wins.");
        }
        else if (playerOneScore == playerTwoScore) {
            // Scores are the same, we need to tiebreak
            int result = tieBreak();

            //Player one wins?
            if (result == 1) {
                System.out.println("Player 1 wins.");
            }
            //Player two wins?
            else if (result == 2) {
                System.out.println("Player 2 wins.");
            }
        }
    }

    public int tieBreak() {
        // Generate 1 or 2
        // If less than 0.5 then 1, otherwise 2
        int temp = (Math.random() <= 0.5) ? 1 : 2;;

        return temp;
    }

}
