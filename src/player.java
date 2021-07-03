public class player {
    private int id;
    private String firstName;
    private String lastName;
    private int score;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public player(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = 0;
    }

    public player(int id, String firstName, String lastName, int score) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    // Generate a score between 0 and 3
    public int genScore() {
        int score = 0;

        double rawScore = Math.random() * 3;

        System.out.println("raw score: " + rawScore);

        score = (int)rawScore;

        System.out.println("whole score: " + score);

        return score;
    }
}
