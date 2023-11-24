package game_alphabeta_student;

import java.util.Collections;

public class MiniMaxSearchAlgo implements ISearchAlgo {
    private Node bestMoveNode;

    @Override
    public void execute(Node node) {
        bestMoveNode = null; // Reset bestMoveNode
        int result = maxValue(node);
        System.out.println("MiniMax Result: " + result);
        if (bestMoveNode != null) {
            System.out.println("Best Move: " + bestMoveNode.getLabel());
        }
    }

    private int maxValue(Node node) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int maxEval = Integer.MIN_VALUE;
        Collections.sort(node.getChildren(), Node.LabelComparator);

        for (Node child : node.getChildren()) {
            int eval = minValue(child);
            if (eval > maxEval) {
                maxEval = eval;
                bestMoveNode = child; // Update best move
            }
        }
        return maxEval;
    }

    private int minValue(Node node) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int minEval = Integer.MAX_VALUE;
        Collections.sort(node.getChildren(), Node.LabelComparator);

        for (Node child : node.getChildren()) {
            int eval = maxValue(child);
            if (eval < minEval) {
                minEval = eval;
                bestMoveNode = child; // Update best move
            }
        }
        return minEval;
    }
}

