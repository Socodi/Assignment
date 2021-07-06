public class tournamentResult {
    player winner;
    String resultText;

    public player getWinner() {
        return winner;
    }

    public String getResultText() {
        return resultText;
    }

    public tournamentResult(player winner, String resultText) {
        this.winner = winner;
        this.resultText = resultText;
    }
}
