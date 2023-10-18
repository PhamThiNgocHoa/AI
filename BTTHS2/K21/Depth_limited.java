package k21;

import java.util.ArrayList;
import java.util.List;

public class Depth_limited implements ISearchAlgo {
    // Khai báo danh sách các con (children) của nút
    private List<Node> children = new ArrayList<>();

    @Override
    public Node execute(Node root, String goal, int limitedDepth) {
        return recursiveDLS(root, goal, limitedDepth);
    }

    private Node recursiveDLS(Node node, String goal, int limit) {
        if (node.getLabel().equals(goal)) {
            return node; // Goal node found
        } else if (limit == 0) {
            return new Node("cutoff"); // Cutoff
        } else {
            boolean cutoffOccurred = false;
            for (Node child : node.getChildrenNodes()) {
                Node result = recursiveDLS(child, goal, limit - 1);
                if (result != null) {
                    if (result.getLabel().equals("cutoff")) {
                        cutoffOccurred = true;
                    } else if (!result.getLabel().equals("failure")) {
                        return result; // Goal node found in a child or a non-failure result
                    }
                }
            }
            return cutoffOccurred ? new Node("cutoff") : new Node("failure");
        }
    
    }

    // Phương thức để thêm một nút con (child) vào danh sách
    public void addChild(Node child) {
        children.add(child);
    }

    // Các phương thức execute khác

    @Override
    public Node execute(Node root, String goal) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        // TODO Auto-generated method stub
        return null;
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
    public static void testDepthLimitedSearch() {
        // Create your graph
        Node root = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        Node l = new Node("L");
        Node m = new Node("M");
        Node n = new Node("N");
        Node o = new Node("O");
        Node p = new Node("P");
        Node r = new Node("R");
        Node s = new Node("S");
   

        root.addChild(new Edge(root, b));
        root.addChild(new Edge(root, c));
        root.addChild(new Edge(root, d));
        b.addChild(new Edge(b, e));
        b.addChild(new Edge(b, f));
        e.addChild(new Edge(e, i));
        f.addChild(new Edge(f, j));
        f.addChild(new Edge(f, k));
        k.addChild(new Edge(k, o));
        k.addChild(new Edge(k, p));
        c.addChild(new Edge(c, g));
        g.addChild(new Edge(g, l));
        l.addChild(new Edge(l, r));
        d.addChild(new Edge(d, h));
        h.addChild(new Edge(h, m));
        h.addChild(new Edge(h, n));
        n.addChild(new Edge(n, s));
       

        // Create an instance of Depth_limited
        Depth_limited depthLimited = new Depth_limited();

        // Test Depth Limited Search with a depth limit of 2
        Node result = depthLimited.execute(root, "R", 4);

        if (result != null && !result.getLabel().equals("cutoff") && !result.getLabel().equals("failure")) {
            System.out.println("Depth Limited Search - Goal node found: " + result.getLabel());
        } else if (result != null && result.getLabel().equals("cutoff")) {
            System.out.println("Depth Limited Search - Cutoff occurred.");
        } else {
            System.out.println("Depth Limited Search - Goal node not found.");
        }
    }
   public static void main(String[] args) {
	testDepthLimitedSearch();
}
}
