
public class Board {
	private int length;
	Node[][] gameBoard;
	public Board(int length) {
		this.length=length;
	}
	
	public void initializeBoard() {
		gameBoard=new Node[length][length];
		boolean isWhite=true;
		for(int x=0;x<length;x++) {
			for(int y=0;y<length;y++) {
				gameBoard[x][y]=new Node("");
			}
		}
		if(length==4) {
			gameBoard[0][1].setSquareContent("b");
			gameBoard[0][3].setSquareContent("b");
			gameBoard[3][0].setSquareContent("w");
			gameBoard[3][2].setSquareContent("w");
			
		}
	}

	
}
