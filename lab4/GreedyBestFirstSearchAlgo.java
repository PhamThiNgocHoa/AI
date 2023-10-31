package lab4;

import java.util.*;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                return (int) (node.getG() - t1.getG() + node.getH() - t1.getH());
            }
        });
        List<Node> explored = new ArrayList<>();
        frontier.add(root);
        explored.add(root);
        while (!frontier.isEmpty()) {
            Node cur = frontier.poll();
            if (cur.getLabel().equals(goal)) return cur;
            for (Edge edge : cur.getChildren()) {
                Node child = edge.getEnd();
                if (!frontier.contains(child) && !explored.contains(child)) {
                    child.setParent(cur);
                    frontier.add(child);
                }
            }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Queue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node, Node t1) {
                return (int) (node.getG() - t1.getG() + node.getH() - t1.getH());
            }
        });
        List<Node> explored = new ArrayList<>();
        frontier.add(root);
        explored.add(root);
        boolean flag = false;
        while (!frontier.isEmpty()) {
            Node cur = frontier.poll();
            if (cur.getLabel().equals(start)) {
                flag = true;
                frontier.clear();
            }
            if (cur.getLabel().equals(goal) && flag) return cur;
            for (Edge edge : cur.getChildren()) {
                Node child = edge.getEnd();
                if (!frontier.contains(child) && !explored.contains(child)) {
                    if (flag) {
                        child.setParent(cur);
                    }
                    frontier.add(child);
                }
            }
        }
        return null;
    }
}
