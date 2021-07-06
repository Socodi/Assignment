import java.util.List;

public class roundResult {
    String resultText;
    player resultPlayer;

    public String getResultText() {
        return resultText;
    }

    public player getResultPlayer() {
        return resultPlayer;
    }

    public roundResult(String resultText, player resultPlayer) {
        this.resultText = resultText;
        this.resultPlayer = resultPlayer;
    }
}
