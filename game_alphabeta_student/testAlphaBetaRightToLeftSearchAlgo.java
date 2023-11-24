package game_alphabeta_student;

public class testAlphaBetaRightToLeftSearchAlgo {
public static void main(String[] args) {
	   
    //*-----------------------------------------------
    Node root3= new Node("A",0);
    Node b3 = new Node("B",0);
    Node c3 = new Node("C", 0);
    Node d3 = new Node("D", 0);
    Node e3 = new Node("E", 0);
    Node f3 = new Node("F", 0);
    Node g3 = new Node("G", 0);
    Node h3 = new Node("H", 0);
    Node i3 = new Node("I", 0);
    Node j3 = new Node("J", 0);
    Node k3 = new Node("K", 0);
    Node l3 = new Node("L", 0);
    Node m3 = new Node("M", 0);
    Node n3 = new Node("N", 0);
    Node o3 = new Node("O", 0);
    Node p3 = new Node("P", 0);
    Node q3 = new Node("Q", 0);
    Node r3 = new Node("R", 0);
    Node s3 = new Node("S", 0);
    Node t3 = new Node("T", 0);
   
    root3.addChild(b3);
    root3.addChild(c3);
    root3.addChild(d3);
 
    b3.addChild(e3);
    b3.addChild(f3);
   
    c3.addChild(g3);
    c3.addChild(h3);
  

    d3.addChild(i3);
    d3.addChild(j3);
   
    
    e3.addChild(k3);
    e3.addChild(l3);
    
    f3.addChild(m3);
    f3.addChild(n3);

    
    g3.addChild(o3);
    h3.addChild(p3);
    h3.addChild(q3);

    
    i3.addChild(r3);
    i3.addChild(s3);
    
    j3.addChild(t3);
    
    Node a1 = new Node("a1",4);
    Node a2 = new Node("a2", 9);
    Node a3 = new Node("a3", 2);
    Node a4 = new Node("a4", 1);
    Node a5 = new Node("a5", 10);
    Node a6 = new Node("a6", 0);
    Node a7 = new Node("a7", 7);
    Node a8 = new Node("a8", 4);
    Node a9 = new Node("a9", 2);
    Node a10 = new Node("a10", 1);
    Node a11 = new Node("a11", 8);
    Node a12 = new Node("a12", 3);
    Node a13 = new Node("a13", 7);
    Node a14 = new Node("a14", 4);
    Node a15 = new Node("a15", 3);
    Node a16 = new Node("a16", 1);
    
    k3.addChild(a1);
    k3.addChild(a2);
    l3.addChild(a3);
    m3.addChild(a4);
    m3.addChild(a5);
    n3.addChild(a6);
    n3.addChild(a7);
    o3.addChild(a8);
    p3.addChild(a9);
    q3.addChild(a10);
    q3.addChild(a11);
    r3.addChild(a12);
    s3.addChild(a13);
    s3.addChild(a14);
    t3.addChild(a15);
    t3.addChild(a16);
    
    
   kiemThuThuatToans("Thuật toán Alpha-Beta", new AlphaBetaRightToLeftSearchAlgo(), root3);
   System.out.println("------------------------");
}

private static void kiemThuThuatToans(String tenThuatToan, AlphaBetaRightToLeftSearchAlgo alphaBetaRightToLeftSearchAlgo, Node root3) {
	 System.out.println("Kiểm thử " + tenThuatToan);
  
	alphaBetaRightToLeftSearchAlgo.execute(root3);
     System.out.println("------------------------");

}

}
