package student;

public class TestHillClimbingSearchNQueen {
    public static void main(String[] args) {
        // Test Hill Climbing
        testHillClimbing();

        // Test Hill Climbing with Random Restart
        testHillClimbingWithRandomRestart();
    }

    private static void testHillClimbing() {
        Node initialState = new Node();
        HillClimbingSearchNQueen hillClimbingSearch = new HillClimbingSearchNQueen();
        Node result = hillClimbingSearch.execute(initialState);

        System.out.println("Hill Climbing Result:");
        result.displayBoard();
        System.out.println("Steps climbed: " + hillClimbingSearch.getStepClimbed());
    }

    private static void testHillClimbingWithRandomRestart() {
        Node initialState = new Node();
        HillClimbingSearchNQueen hillClimbingSearch = new HillClimbingSearchNQueen();
        Node result = hillClimbingSearch.executeHillClimbingWithRandomRestart(initialState);

        System.out.println("Hill Climbing with Random Restart Result:");
        result.displayBoard();
        System.out.println("Steps climbed after random restart: " + hillClimbingSearch.getStepClimbedAfterRandomRestart());
        System.out.println("Random restarts: " + hillClimbingSearch.getRandomRestarts());
    }
}
