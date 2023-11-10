package student;

public class TestSimulatedAnnealing {
    public static void main(String[] args) {
        // Create an initial state with queens placed on the board
        Node initialState = new Node();
        initialState.generateBoard(); // Đặt các queen ban đầu lên bảng
        System.out.println("Initial State:");
        initialState.displayBoard();

        // Define the SA schedule (temperature schedule)
        // You may need to adjust these parameters based on your problem and preferences
        double initialTemperature = 100.0;
        double coolingRate = 0.01;

        // Apply SA algorithm
        Node result = initialState.simulatedAnnealing(initialTemperature, coolingRate);

        // Display the result
        System.out.println("\nFinal State:");
        result.displayBoard();
        System.out.println("\nSteps Climbed: " + result.getStepClimbed());
    }
}
