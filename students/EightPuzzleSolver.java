package students;

public class EightPuzzleSolver {
    public static void main(String[] args) {
        Puzzle problem = new Puzzle();

        // Đọc trạng thái ban đầu và mục tiêu từ tệp hoặc tạo chúng ở đây

        // Đo thời gian và số bước di chuyển của DFS
        long startTimeDFS = System.currentTimeMillis();
        int movesDFS = DepthFirstSearch.solve(problem);
        long endTimeDFS = System.currentTimeMillis();
        System.out.println("DFS - Số bước: " + movesDFS + " - Thời gian: " + (endTimeDFS - startTimeDFS) + " ms");

        // Đo thời gian và số bước di chuyển của BFS
        long startTimeBFS = System.currentTimeMillis();
        int movesBFS = BreadthFirstSearch.solve(problem);
        long endTimeBFS = System.currentTimeMillis();
        System.out.println("BFS - Số bước: " + movesBFS + " - Thời gian: " + (endTimeBFS - startTimeBFS) + " ms");

        // Đo thời gian và số bước di chuyển của Hill Climbing
        long startTimeHillClimbing = System.currentTimeMillis();
        int movesHillClimbing = HillClimbing.solve(problem);
        long endTimeHillClimbing = System.currentTimeMillis();
        System.out.println("Hill Climbing - Số bước: " + movesHillClimbing + " - Thời gian: " + (endTimeHillClimbing - startTimeHillClimbing) + " ms");

        // Đo thời gian và số bước di chuyển của A* với h1
        long startTimeAStarH1 = System.currentTimeMillis();
        int movesAStarH1 = AStarSearchH1.solve(problem);
        long endTimeAStarH1 = System.currentTimeMillis();
        System.out.println("A* with h1 - Số bước: " + movesAStarH1 + " - Thời gian: " + (endTimeAStarH1 - startTimeAStarH1) + " ms");

        // Đo thời gian và số bước di chuyển của A* với h2
        long startTimeAStarH2 = System.currentTimeMillis();
        int movesAStarH2 = AStarSearchH2.solve(problem);
        long endTimeAStarH2 = System.currentTimeMillis();
        System.out.println("A* with h2 - Số bước: " + movesAStarH2 + " - Thời gian: " + (endTimeAStarH2 - startTimeAStarH2) + " ms");
    }
}

