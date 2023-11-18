package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
    public static final int POP_SIZE = 100;
    public static final double MUTATION_RATE = 0.03;
    public static final int MAX_ITERATIONS = 1000;

    List<Node> population = new ArrayList<>();
    Random rd = new Random();

    // initialize the individuals of the population
    public void initPopulation() {
        for (int i = 0; i < POP_SIZE; i++) {
            Node ni = new Node();
            ni.generateBoard();
            population.add(ni);
        }
    }

    public Node execute() {
        for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
            List<Node> newPopulation = new ArrayList<>();

            for (int i = 0; i < POP_SIZE; i++) {
                Node parent1 = getParentByTournamentSelection();
                Node parent2 = getParentByTournamentSelection();

                Node child = reproduce(parent1, parent2);

                if (rd.nextDouble() > MUTATION_RATE) {
                    mutate(child);
                }

                newPopulation.add(child);
            }

            population = newPopulation;

            for (Node individual : population) {
                if (individual.getH() == 0) {
                    // Solution found
                    return individual;
                }
            }
        }

        // If no solution found, return the best individual in the last population
        return getBestIndividual();
    }

    // Mutate an individual by selecting a random Queen and move it to a random row.
    public void mutate(Node node) {
        int index = rd.nextInt(Node.N);
        int newRow = rd.nextInt(Node.N);
        node.setRow(index, newRow);
    }

    // Crossover x and y to reproduce a child
    public Node reproduce(Node x, Node y) {
        Node child = new Node();
        for (int i = 0; i < Node.N; i++) {
            if (rd.nextBoolean()) {
                child.setRow(i, x.getRow(i));
            } else {
                child.setRow(i, y.getRow(i));
            }
        }
        return child;
    }

    // Select K individuals from the population at random and select the best out of these to become a parent.
    public Node getParentByTournamentSelection() {
        int tournamentSize = 5;
        Node bestParent = null;
        int bestH = Integer.MAX_VALUE;

        for (int i = 0; i < tournamentSize; i++) {
            Node randomIndividual = population.get(rd.nextInt(POP_SIZE));
            if (randomIndividual.getH() < bestH) {
                bestParent = randomIndividual;
                bestH = randomIndividual.getH();
            }
        }
        return bestParent;
    }

    // Select a random parent from the population
    public Node getParentByRandomSelection() {
        return population.get(rd.nextInt(POP_SIZE));
    }

    // Get the best individual in the current population
    private Node getBestIndividual() {
        Node bestIndividual = population.get(0);
        int bestH = bestIndividual.getH();

        for (Node node : population) {
            if (node.getH() < bestH) {
                bestIndividual = node;
                bestH = node.getH();
            }
        }

        return bestIndividual;
    }
}
