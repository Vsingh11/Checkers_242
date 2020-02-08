import java.util.LinkedList;

public class main {

	public static void main(String[] args) {
		Board board=new Board(4);
		board.initializeBoard();
		Minimax mini=new Minimax(board);
		mini.constructTree(4);
		mini.printTree();
//LinkedList<Board> explored=new LinkedList<Board>();
//explored.add(board);
//Board board2=new Board(4);
//board2.initializeBoard();
//if(explored.get(0).areEqual(board2.gameBoard)) {
//	System.out.print("sdfsdf");
//}

	}

}
