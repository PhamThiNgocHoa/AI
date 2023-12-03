package game_nim_student;

import java.util.Arrays;

public class TestNode {
    public static void main(String[] args) {
        // Test with 7 tokens
        Node node7 = new Node();
        Integer[] data7 = {7};
        node7.addAll(Arrays.asList(data7));
        testMinimax(node7);

        // Test with 8 tokens
        Node node8 = new Node();
        Integer[] data8 = {8};
        node8.addAll(Arrays.asList(data8));
        testMinimax(node8);

        // Test with 9 tokens
        Node node9 = new Node();
        Integer[] data9 = {9};
        node9.addAll(Arrays.asList(data9));
        testMinimax(node9);
    }

    private static void testMinimax(Node node) {
        System.out.println("Initial State: " + node);
        MinimaxAlgo algo = new MinimaxAlgo();
        algo.execute(node);
        System.out.println("--------------------");
    }
}
