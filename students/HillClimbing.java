package students;

import java.util.List;

public class HillClimbing {
    public static int solve(Puzzle problem) {
        Node currentState = problem.getInitialState();
        int moves = 0;

        while (!currentState.equals(problem.getGoalState())) {
            List<Node> successors = problem.getSuccessors(currentState);
            Node bestSuccessor = currentState;
            int bestH = currentState.getH();

            for (Node successor : successors) {
                int h = problem.computeH2(successor); // Sử dụng h2 làm heuristic

                if (h < bestH) {
                    bestH = h;
                    bestSuccessor = successor;
                }
            }

            if (bestSuccessor.equals(currentState)) {
                // Không có bước di chuyển tiếp theo
                return -1;
            }

            currentState = bestSuccessor;
            moves++;
        }

        return moves;
    }
}
