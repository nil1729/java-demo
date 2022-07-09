public class Main {
    public static void main(String[] args) {
        calculateScore(true, 800, 5, 100);
        calculateScore(true, 10000, 8, 200);
        calculateScore();
    }

    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
        }
    }

    /*
     *
     * Method Overloading
     *
     */
    public static void calculateScore() {
        System.out.println("No player name, no player score.");
    }

}
