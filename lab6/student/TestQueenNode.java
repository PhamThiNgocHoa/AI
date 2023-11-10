package student;

import java.util.List;
public class TestQueenNode {
    public static void main(String[] args) {
        // Test Task 1 - Queen class
        Queen queen1 = new Queen(2, 3);
        System.out.println("Vị trí ban đầu của Queen 1: " + queen1);
        queen1.move();
        System.out.println("Sau khi di chuyển Queen 1: " + queen1);

        Queen queen2 = new Queen(4, 3);
        System.out.println("Vị trí ban đầu của Queen 2: " + queen2);
        System.out.println("Queen 1 và Queen 2 có xung đột không? " + queen1.isConflict(queen2));

        // Test Task 2 - Node class
        Node initialNode = new Node();
        System.out.println("\nTrạng thái Node ban đầu:");

        // Thêm kiểm tra null trước khi gọi phương thức displayBoard
        if (initialNode != null && initialNode.getState() != null) {
            initialNode.displayBoard();
            System.out.println("Heuristic ban đầu: " + initialNode.getH());
        } else {
            System.out.println("Trạng thái Node là null hoặc chưa được khởi tạo đúng cách.");
        }

        List<Node> candidates = initialNode.generateAllCandidates();
        System.out.println("\nCác ứng viên được tạo ra:");
        for (Node candidate : candidates) {
            // Thêm kiểm tra null trước khi gọi phương thức displayBoard
            if (candidate != null && candidate.getState() != null) {
                candidate.displayBoard();
                System.out.println("Heuristic: " + candidate.getH() + "\n");
            } else {
                System.out.println("Trạng thái ứng viên là null hoặc chưa được khởi tạo đúng cách.");
            }
        }

        Node randomCandidate = initialNode.selectNextRandomCandidate();
        System.out.println("\nỨng viên Ngẫu nhiên được chọn:");

        // Thêm kiểm tra null trước khi gọi phương thức displayBoard
        if (randomCandidate != null && randomCandidate.getState() != null) {
            randomCandidate.displayBoard();
            System.out.println("Heuristic: " + randomCandidate.getH());
        } else {
            System.out.println("Trạng thái ứng viên ngẫu nhiên là null hoặc chưa được khởi tạo đúng cách.");
        }
    }
}


