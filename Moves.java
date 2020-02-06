import java.util.Scanner;

public class Moves {
	String playerMove="w";
	Node[][] gameBoard;
	int maxMoves;
	public Moves(int maxMoves,Node[][] gameBoard) {
		this.maxMoves=maxMoves;
		this.gameBoard=gameBoard;
	}
	
	public void startGame() {
		Scanner myvar=new Scanner(System.in);
		int userInput=myvar.nextInt();
		if(userInput==1) {
			random randGame=new random(maxMoves,gameBoard);
			randGame.playRandomly();
		}
	}
}
