package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {
    private List<String> prunedNodes = new ArrayList<>();
    private String bestMove;

    @Override
    public void execute(Node node) {
        int result = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Result: " + result);
        System.out.println("Best Move for MAX : " + bestMove);
        System.out.println("Pruned nodes: " + prunedNodes);
    }

    public int maxValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int v = Integer.MIN_VALUE;
        List<Node> successors = node.getChildren();
        Collections.sort(successors, Node.LabelComparator);

        for (Node successor : successors) {
            int minValueResult = minValue(successor, alpha, beta);
            if (v < minValueResult) {
                v = minValueResult;
                bestMove = successor.getLabel();
            }
            if (v >= beta) {
                prunedNodes.add(successor.getLabel());
                return v;
            }
            alpha = Math.max(alpha, v);
        }
        return v;
    }

    public int minValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int v = Integer.MAX_VALUE;
        List<Node> successors = node.getChildren();
        Collections.sort(successors, Node.LabelComparator);

        for (Node successor : successors) {
            int maxValueResult = maxValue(successor, alpha, beta);
            if (v > maxValueResult) {
                v = maxValueResult;
                bestMove = successor.getLabel();
            }
            if (v <= alpha) {
                prunedNodes.add(successor.getLabel());
                return v;
            }
            beta = Math.min(beta, v);
        }
        return v;
    }
}
