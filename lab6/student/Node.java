package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Queen[] getState() {
		return state;
	}

	public void setState(Queen[] state) {
		this.state = state;
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
	    this.state = new Queen[N];
	    for (int i = 0; i < N; i++) {
	        Queen qi = n.state[i];
	        if (qi != null) {
	            this.state[i] = new Queen(qi.getRow(), qi.getColumn());
	        } else {
	            // Handle the case where Qi is null (e.g., generateBoard() was called before)
	            // You can choose to initialize it to a new Queen or handle it differently based on your logic.
	            // For now, let's initialize it to a new Queen at (0, 0).
	            this.state[i] = new Queen(0, 0);
	        }
	    }
	}


	private int stepClimbed = 0; // Thêm thuộc tính để theo dõi số bước đã đi
    public int getStepClimbed() {
        return stepClimbed;
    }
   

	 public void generateBoard() {
	        Random random = new Random();
	        for (int i = 0; i < N; i++) {
	            state[i] = new Queen(random.nextInt(N), i);
	        }
	    }
	 // Heuristic function to calculate the number of conflicts
	 public int getH() {
		    int heuristic = 0;
		    for (int i = 0; i < N; i++) {
		        if (state[i] != null) {
		            for (int j = i + 1; j < N; j++) {
		                if (state[j] != null && state[i].isConflict(state[j])) {
		                    heuristic++; // Increment heuristic for each pair of conflicting queens
		                }
		            }
		        }
		    }
		    return heuristic;
		}
	 public List<Node> generateAllCandidates() {
		    List<Node> result = new ArrayList<>();
		    for (int i = 0; i < N; i++) {
		        if (state[i] != null) {
		            for (int j = 0; j < N; j++) {
		                if (j != state[i].getRow()) {
		                    Queen[] newState = new Queen[N];
		                    for (int k = 0; k < N; k++) {
		                        if (state[k] != null) {
		                            newState[k] = new Queen(state[k].getRow(), state[k].getColumn());
		                        } else {
		                            // Handle the case where Queen at state[k] is null
		                            // You can initialize it to a new Queen or handle it based on your logic
		                            // For now, let's initialize it to a new Queen at (0, 0).
		                            newState[k] = new Queen(0, 0);
		                        }
		                    }
		                    newState[i].setRow(j);
		                    result.add(new Node(newState));
		                }
		            }
		        } else {
		            System.out.println("Queen tại vị trí " + i + " là null.");
		            // Handle the case where Queen at state[i] is null
		            // You can choose to initialize it to a new Queen or handle it differently based on your logic
		            // For now, let's initialize it to a new Queen at (0, 0).
		            state[i] = new Queen(0, 0);
		        }
		    }
		    return result;
		}



	 public Node selectNextRandomCandidate() {
		    List<Node> candidates = generateAllCandidates().stream()
		            .filter(candidate -> candidate != null)
		            .collect(Collectors.toList());

		    if (candidates.isEmpty()) {
		        throw new IllegalArgumentException("Không có ứng viên hợp lệ nào");
		    }

		    Random random = new Random();
		    return candidates.get(random.nextInt(candidates.size()));
		}

	 // Simulated Annealing algorithm
	 public Node simulatedAnnealing(double initialTemperature, double coolingRate) {
	        Node current = new Node(this); // Initial state
	        double temperature = initialTemperature;

	        while (temperature > 0) {
	            Node next = current.selectNextRandomCandidate();
	            int deltaE = next.getH() - current.getH();

	            if (deltaE < 0) {
	                // If the new state is better, accept it
	                current = next;
	            } else {
	                // If the new state is worse, accept it with a probability based on temperature
	                double probability = Math.exp(-deltaE / temperature);
	                if (Math.random() < probability) {
	                    current = next;
	                }
	            }

	            temperature *= 1 - coolingRate;
	            stepClimbed++; // Cập nhật số bước đã đi
	        }

	        return current;
	    }
	
    public void displayBoard() {
        if (state == null) {
            System.out.println("Mảng state là null.");
            return;
        }

        int[][] board = new int[N][N];
        // set queen position on the board
        for (int i = 0; i < N; i++) {
            if (state[i] != null) {
                board[state[i].getRow()][state[i].getColumn()] = 1;
            } else {
                System.out.println("Queen tại vị trí " + i + " là null.");
                return;
            }
        }

        // print board
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q" + " ");
                } else {
                    System.out.print("-" + " ");
                }
            }
            System.out.println();
        }
    }
}
