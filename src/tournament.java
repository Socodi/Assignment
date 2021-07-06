import java.util.ArrayList;

public class tournament {
    player winner;
    String resultText = "";
    ArrayList<player> nextPlayers;

    public tournamentResult runTournament(ArrayList<player> players) {
        // Create manipulative list
        nextPlayers = players;

        // While more than one player
        while (nextPlayers.size() > 1) {
            // Create a round
            round round = new round(players);

            // Run the round and get the results of the round
            ArrayList<roundResult> results = round.runRound(nextPlayers);

            // Empty new list, to create fresh for next round
            nextPlayers.clear();

            // for each result object, create one big string for user, and add winner to next rounds players
            for (roundResult result : results) {
                resultText += result.getResultText();

                nextPlayers.add(result.getResultPlayer());
            }
        }

        // Return the built string, and the overall winner.
        return new tournamentResult(nextPlayers.get(0), resultText);
    }
}
