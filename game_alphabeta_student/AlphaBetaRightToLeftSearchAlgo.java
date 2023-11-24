package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo {
    private List<String> prunedNodes = new ArrayList<>();

    @Override
    public void execute(Node node) {
        int result = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Result: " + result);
        System.out.println("Pruned nodes: " + prunedNodes);
    }

    public int maxValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int v = Integer.MIN_VALUE;
        List<Node> successors = node.getChildren();
        Collections.sort(successors, Collections.reverseOrder(Node.LabelComparator));

        for (Node successor : successors) {
            int minValueResult = minValue(successor, alpha, beta);
            v = Math.max(v, minValueResult);
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
        Collections.sort(successors, Collections.reverseOrder(Node.LabelComparator));

        for (Node successor : successors) {
            int maxValueResult = maxValue(successor, alpha, beta);
            v = Math.min(v, maxValueResult);
            if (v <= alpha) {
                prunedNodes.add(successor.getLabel());
                return v;
            }
            beta = Math.min(beta, v);
        }
        return v;
    }
}
