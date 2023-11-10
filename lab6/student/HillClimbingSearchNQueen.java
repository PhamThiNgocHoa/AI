package student;

import java.util.List;

public class HillClimbingSearchNQueen {
    private int stepClimbed = 0;
    private int stepClimbedAfterRandomRestart = 0;
    private int randomRestarts = 0;
    public int getStepClimbed() {
        return stepClimbed;
    }
    
   

    public int getStepClimbedAfterRandomRestart() {
        return stepClimbedAfterRandomRestart;
    }

    public int getRandomRestarts() {
        return randomRestarts;
    }

    public Node execute(Node initialState) {
        Node current = new Node(initialState);
        while (true) {
            List<Node> neighbors = current.generateAllCandidates();
            Node neighbor = getHighestValuedSuccessor(neighbors);
            if (neighbor == null || neighbor.getH() <= current.getH()) {
                // No better neighbor or local maximum reached
                return current;
            }
            current = neighbor;
            stepClimbed++;
        }
    }

    public Node executeHillClimbingWithRandomRestart(Node initialState) {
        Node current = new Node(initialState);
        while (true) {
            Node result = execute(current);
            stepClimbedAfterRandomRestart += stepClimbed;
            stepClimbed = 0;
            randomRestarts++;

            if (result.getH() == 0) {
                // Solution found
                return result;
            }

            // Random Restart
            current.generateBoard();
        }
    }

    private Node getHighestValuedSuccessor(List<Node> neighbors) {
        Node highestValued = null;
        for (Node neighbor : neighbors) {
            if (highestValued == null || neighbor.getH() > highestValued.getH()) {
                highestValued = neighbor;
            }
        }
        return highestValued;
    }



	
}
