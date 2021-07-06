import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class round {
    private ArrayList<player> players;

    public round(ArrayList<player> players) { this.players = players; }

    public ArrayList<player> getPlayers() { return players; }

    public void setPlayers(ArrayList<player> players) { this.players = players; }

    public ArrayList<roundResult> runRound(ArrayList<player> players) {
        ArrayList<List<player>> lists = splitPlayers(players);
        String results = "";
        ArrayList<roundResult> resultsToReturn = new ArrayList<>();

        for (List<player> list : lists) {
            match match = new match();
            results = "";

            int winner = match.decideWinner(list);

            String playerOne = list.get(0).getFirstName() + " " + list.get(0).getLastName();
            String playerTwo = list.get(1).getFirstName() + " " + list.get(1).getLastName();

            // Should only return 1 or 2
            if (winner == 0) {
                System.out.println("Something has gone horribly wrong.");
            }
            else if (winner == 1) {
                results += playerOne + " has won, and beaten " + playerTwo + "\n";
            }
            else if (winner == 2 ) {
                results += playerTwo + " has won, and beaten " + playerOne + "\n";
            }

            // Create result object, to hold text needed for user, and player for next round.
            roundResult result = new roundResult(results, list.get(winner - 1));

            // Add to list to return
            resultsToReturn.add(result);
        }

        return resultsToReturn;
    }

    // Split the list of players into sub lists of size 2 (create pairs to run matches with)
    public ArrayList<List<player>> splitPlayers(ArrayList<player> players) {
        ArrayList<List<player>> matchLists = new ArrayList<>();

        int size = 2;

        for (int start = 0; start < players.size(); start += size) {
            int end = Math.min(start + size, players.size());
            List<player> subList = players.subList(start, end);
            System.out.println(subList);

            matchLists.add(subList);
        }

        return matchLists;
    }
}
