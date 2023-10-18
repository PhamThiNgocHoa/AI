package k21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeCostComparator());
        frontier.add(root);
        List<Node> explored = new ArrayList<>();

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            if (current.getLabel().equals(goal)) {
                return current; // Goal found
            }

            explored.add(current);

            for (Edge e : current.getChildren()) {
                Node endNode = e.getEnd();
                double newPathCost = current.getPathCost() + e.getWeight();

                if (!explored.contains(endNode) && !frontier.contains(endNode)) {
                    endNode.setPathCost(newPathCost);
                    endNode.setParent(current);
                    frontier.add(endNode);
                } else if (frontier.contains(endNode) && newPathCost < endNode.getPathCost()) {
                    // Update the path cost and parent if a better path is found
                    endNode.setPathCost(newPathCost);
                    endNode.setParent(current);
                }
            }
        }

        return null; // Goal not found
    }

    // Rest of your code

    private class NodeCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            // Compare nodes based on their path cost
            return Double.compare(node1.getPathCost(), node2.getPathCost());
        }
    }

	@Override
	public Node execute(Node root, String start, String goal) {
	    PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeCostComparator());

	    // Find the start node from the root node
	    Node startNode = findNode(root, start);

	    if (startNode == null) {
	        System.out.println("Start node not found.");
	        return null; // Start node not found in the graph
	    }

	    frontier.add(startNode);
	    List<Node> explored = new ArrayList<>();

	    while (!frontier.isEmpty()) {
	        Node current = frontier.poll();

	        if (current.getLabel().equals(goal)) {
	            return current; // Goal found
	        }

	        explored.add(current);

	        for (Edge e : current.getChildren()) {
	            Node endNode = e.getEnd();
	            double newPathCost = current.getPathCost() + e.getWeight();

	            if (!explored.contains(endNode) && !frontier.contains(endNode)) {
	                endNode.setPathCost(newPathCost);
	                endNode.setParent(current);
	                frontier.add(endNode);
	            } else if (frontier.contains(endNode) && newPathCost < endNode.getPathCost()) {
	                // Update the path cost and parent if a better path is found
	                endNode.setPathCost(newPathCost);
	                endNode.setParent(current);
	            }
	        }
	    }

	    return null; // Goal not found
	}
	
	// Helper method to find a node by label
	private Node findNode(Node root, String label) {
	    if (root.getLabel().equals(label)) {
	        return root;
	    } else {
	        for (Node child : root.getChildrenNodes()) {
	            Node found = findNode(child, label);
	            if (found != null) {
	                return found;
	            }
	        }
	    }
	    return null; // Node not found
	}

	@Override
	public Node execute_TreeS(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute_TreeS(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
        // Create your graph
        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeH = new Node("H");
        Node nodeR = new Node("R");
        Node nodeP = new Node("P");
        Node nodeQ = new Node("Q");
        Node nodeG = new Node("G");
        nodeS.addEdge(nodeD, 3);
        nodeS.addEdge(nodeE, 9);
        nodeS.addEdge(nodeP, 1);
        nodeD.addEdge(nodeB, 1);
        nodeD.addEdge(nodeC, 8);
        nodeB.addEdge(nodeA, 2);
        nodeC.addEdge(nodeA, 2);
        nodeD.addEdge(nodeE, 2);
        nodeE.addEdge(nodeH, 1);
        nodeE.addEdge(nodeR, 9);
        nodeP.addEdge(nodeQ, 15);
        nodeQ.addEdge(nodeR, 3);
        nodeR.addEdge(nodeF, 5);
        nodeF.addEdge(nodeG, 5);
        nodeF.addEdge(nodeC, 5);
        nodeH.addEdge(nodeP, 4);
        nodeH.addEdge(nodeQ, 4);

        // Create an instance of UniformCostSearchAlgo
        ISearchAlgo algo = new UniformCostSearchAlgo();

        // Define the goal node
        String goalNodeLabel = "G";

        // Execute UCS from the root node to the goal node
        Node result = algo.execute(nodeS, goalNodeLabel);

        // Print the path from the root to the goal node
        List<String> path = NodeUtils.printPath(result);
        System.out.println("Path from S to " + goalNodeLabel + ": " + String.join(" -> ", path));

        // Print the goal node and its path cost
        System.out.println("Goal node: " + result.getLabel());
        System.out.println("Path cost: " + result.getPathCost());
    }

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}
}
