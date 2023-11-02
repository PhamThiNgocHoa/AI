package students;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class PuzzleUtils {

	// distance between P1(x1, y1) and P2(x2, y2)
	public static int manhattanDistance(int[] current, int[] target) {
		return Math.abs(target[0] - current[0]) + Math.abs(target[1] - current[1]);
	}

	// Compare 2 nodes by heuristic values
	public static Comparator<Node> HeuristicComparatorByH = new Comparator<Node>() {

		@Override
		public int compare(Node a, Node b) {
			return a.getH() - b.getH();
		}
	};
	// Compare 2 nodes by F values
	public static Comparator<Node> HeuristicComparatorByF = new Comparator<Node>() {

		@Override
		public int compare(Node a, Node b) {
			return a.getF() - b.getF();
		}
	};
	
	public Node graphSearch(Puzzle problem) {
	    PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
	    Set<Node> explored = new HashSet<>();

	    Node initialState = problem.getInitialState();
	    frontier.add(initialState);

	    while (!frontier.isEmpty()) {
	        Node currentNode = frontier.poll(); // Choose a leaf node and remove it from the frontier

	        if (currentNode.equals(problem.getGoalState())) {
	            return currentNode; // Goal state found
	        }

	        explored.add(currentNode); // Add the node to the explored set

	        List<Node> successors = problem.getSuccessors(currentNode); // Expand the chosen node

	        for (Node successor : successors) {
	            if (!frontier.contains(successor) && !explored.contains(successor)) {
	                frontier.add(successor); // Add resulting nodes to the frontier if not in the frontier or explored set
	            }
	        }
	    }

	    return null; // No solution found
	}
	
	public class GreedyBestFirstSearchH1 implements IPuzzleAlgo {
	    public Node execute(Puzzle problem) {
	        Node initialState = problem.getInitialState();
	        Node goalState = problem.getGoalState();

	        if (initialState.equals(goalState)) {
	            return initialState; // Already in the goal state
	        }

	        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
	        HashSet<Node> explored = new HashSet<>();

	        frontier.add(initialState);

	        while (!frontier.isEmpty()) {
	            Node currentNode = frontier.poll();

	            if (currentNode.equals(goalState)) {
	                return currentNode; // Goal state found
	            }

	            explored.add(currentNode);

	            List<Node> successors = problem.getSuccessors(currentNode);

	            for (Node successor : successors) {
	                if (!explored.contains(successor) && !frontier.contains(successor)) {
	                    frontier.add(successor);
	                }
	            }
	        }

	        return null; // No solution found
	    }
	}


}
