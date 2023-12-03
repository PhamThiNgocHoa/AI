package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
	    List<Node> successors = new ArrayList<>();

	    for (int i = 0; i < data.size(); i++) {
	        for (int j = i + 1; j < data.size(); j++) {
	            int pile1 = data.get(i);
	            int pile2 = data.get(j);

	            if (canDivide(pile1, pile2)) {
	                List<Integer> childData = new ArrayList<>(data);
	                childData.remove(j);
	                childData.set(i, pile1 + pile2);

	                Node childNode = new Node();
	                childNode.addAll(childData);

	                if (!successors.contains(childNode)) {
	                    successors.add(childNode);
	                }
	            }
	        }
	    }
	    return successors;
	}


	public boolean isTerminal() {
	    for (int i = 0; i < data.size(); i++) {
	        for (int j = i + 1; j < data.size(); j++) {
	            if (canDivide(data.get(i), data.get(j))) {
	                return false; // If any pair of piles can be divided, the node is not terminal
	            }
	        }
	    }
	    return true; // If no pair of piles can be divided, the node is terminal
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

	// Helper method to check if two piles can be divided
	private boolean canDivide(int pile1, int pile2) {
	    return pile1 != pile2;
	}
	
	
	  public void execute(Node node) {
	        int[] result = maxValue(node);
	        int v = result[0];
	        int bestMoveIndex = result[1];

	        System.out.println("Optimal value at the root node: " + v);
	        System.out.println("Best move for MIN player: " + node.getSuccessors().get(bestMoveIndex));
	    }

	    // Returns an array where result[0] is the value and result[1] is the index of the best move
	    public int[] maxValue(Node node) {
	        if (node.isTerminal()) {
	            return new int[]{0, -1}; // Assign utility value for terminal state (MIN wins)
	        }

	        int v = Integer.MIN_VALUE;
	        int bestMoveIndex = -1;

	        for (int i = 0; i < node.getSuccessors().size(); i++) {
	            int[] result = minValue(node.getSuccessors().get(i));
	            int minValue = result[0];

	            if (minValue > v) {
	                v = minValue;
	                bestMoveIndex = i;
	            }
	        }

	        return new int[]{v, bestMoveIndex};
	    }

	    public int[] minValue(Node node) {
	        if (node.isTerminal()) {
	            return new int[]{1, -1}; // Assign utility value for terminal state (MAX wins)
	        }

	        int v = Integer.MAX_VALUE;
	        int bestMoveIndex = -1;

	        for (int i = 0; i < node.getSuccessors().size(); i++) {
	            int[] result = maxValue(node.getSuccessors().get(i));
	            int maxValue = result[0];

	            if (maxValue < v) {
	                v = maxValue;
	                bestMoveIndex = i;
	            }
	        }

	        return new int[]{v, bestMoveIndex};
	    }
}
