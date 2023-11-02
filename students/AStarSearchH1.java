package students;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchH1 implements IPuzzleAlgo {
    public Node execute(Puzzle problem) {
        Node initialState = problem.getInitialState();
        Node goalState = problem.getGoalState();

        if (initialState.equals(goalState)) {
            return initialState; // Already in the goal state
        }

        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
        HashSet<Node> explored = new HashSet<>();

        initialState.setG(0);
        initialState.setH(problem.computeH1(initialState)); // Use h1 as the heuristic
        frontier.add(initialState);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();

            if (currentNode.equals(goalState)) {
                return currentNode; // Goal state found
            }

            explored.add(currentNode);

            List<Node> successors = problem.getSuccessors(currentNode);

            for (Node successor : successors) {
                int tentativeG = currentNode.getG() + 1;

                if (explored.contains(successor)) {
                    continue; // Skip already explored nodes
                }

                if (!frontier.contains(successor) || tentativeG < successor.getG()) {
                    successor.setG(tentativeG);
                    successor.setH(problem.computeH1(successor)); // Use h1 as the heuristic
                    successor.setF(successor.getG() + successor.getH());

                    if (!frontier.contains(successor)) {
                        frontier.add(successor);
                    }
                }
            }
        }

        return null; // No solution found
    }
}


