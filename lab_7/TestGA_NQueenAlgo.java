package lab_7;
public class TestGA_NQueenAlgo {
    public static void main(String[] args) {
        GA_NQueenAlgo geneticAlgorithm = new GA_NQueenAlgo();

        // Initialize the population
        geneticAlgorithm.initPopulation();

        // Execute the genetic algorithm
        Node solution = geneticAlgorithm.execute();

        // Display the solution
        System.out.println("Solution found:");
        solution.displayBoard();
        System.out.println("Number of attacking pairs: " + solution.getH());
    }
}
