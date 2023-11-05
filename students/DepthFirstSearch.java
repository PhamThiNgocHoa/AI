package students;

import java.util.*;

public class DepthFirstSearch {
    public static int solve(Puzzle problem) {
        Stack<Node> stack = new Stack<>();
        Set<Node> explored = new HashSet<>();

        Node initialState = problem.getInitialState();
        stack.push(initialState);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();

            if (currentNode.equals(problem.getGoalState())) {
                return currentNode.getG(); // Số bước di chuyển
            }

            explored.add(currentNode);

            List<Node> successors = problem.getSuccessors(currentNode);

            for (Node successor : successors) {
                if (!explored.contains(successor) && !stack.contains(successor)) {
                    stack.push(successor);
                }
            }
        }

        return -1; // Không tìm thấy giải pháp
    }
}