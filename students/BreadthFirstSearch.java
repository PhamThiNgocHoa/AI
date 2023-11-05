package students;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
    public static int solve(Puzzle problem) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> explored = new HashSet<>();

        Node initialState = problem.getInitialState();
        queue.offer(initialState);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.equals(problem.getGoalState())) {
                return currentNode.getG(); // Số bước di chuyển
            }

            explored.add(currentNode);

            List<Node> successors = problem.getSuccessors(currentNode);

            for (Node successor : successors) {
                if (!explored.contains(successor) && !queue.contains(successor)) {
                    queue.offer(successor);
                }
            }
        }

        return -1; // Không tìm thấy giải pháp
    }
}

