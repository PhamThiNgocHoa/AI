package students;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarSearchH2 {
    public static int solve(Puzzle problem) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
        Set<Node> explored = new HashSet<>();

        Node initialState = problem.getInitialState();
        frontier.add(initialState);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();

            if (currentNode.equals(problem.getGoalState())) {
                return currentNode.getG(); // Số bước di chuyển
            }

            explored.add(currentNode);

            List<Node> successors = problem.getSuccessors(currentNode);

            for (Node successor : successors) {
                if (!explored.contains(successor) && !frontier.contains(successor)) {
                    frontier.add(successor);
                }
            }
        }

        return -1; // Không tìm thấy giải pháp
    }
}
