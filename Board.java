
public class Board {
	private int length;
	int counter=0;
	Node[][] gameBoard;
	String playerMove;
	public Board(int length) {
		this.length=length;
	}
	
	public void initializeBoard() {
		gameBoard=new Node[length][length];
		boolean isWhite=true;
		for(int x=0;x<length;x++) {
			for(int y=0;y<length;y++) {
				gameBoard[x][y]=new Node(" ");
			}
		}
		if(length==4) {
			gameBoard[0][1].setSquareContent("b");
			gameBoard[0][3].setSquareContent("b");
			gameBoard[3][0].setSquareContent("w");
			gameBoard[3][2].setSquareContent("w");
//			gameBoard[2][1].setSquareContent("wk");
//			gameBoard[1][2].setSquareContent("b");
//			
		}
		playerMove="w";
		
	}
	public void playGame() {
		if(length==4) {
			Moves moves=new Moves(10,gameBoard);
			moves.startGame();
		}
	}
	public void printBoard() {

		System.out.println("  1 2 3 4");
		System.out.println(" +-+-+-+-+");
		
		for(int x=0;x<length;x++) {
			 if(counter==0) {
				  System.out.print("A|");
			  }else if(counter==1) {
				  System.out.print("B|");
			  }else if(counter==2) {
				  System.out.print("C|");
			  }else if(counter==3) {
				  System.out.print("D|");
			  }
					
			
		for(int y=0;y<length;y++) {
		 System.out.print(gameBoard[x][y].squareContent);
		 System.out.print("|");
			}
		System.out.println(" ");
			System.out.println(" +-+-+-+-+");
			counter = counter + 1;
		}

	
}
}
