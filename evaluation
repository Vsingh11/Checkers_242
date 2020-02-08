public class evaluation {
 
	Node[][] gameBoard;
	int value;
	int whiteCount = 0;
	int blackCount = 0;
	
	public evaluation(Node[][] gameBoard) {
		
		this.gameBoard = gameBoard;
		
	}
	
	public int evaluater(){
		 
		for(int i = 0; i < gameBoard.length; i++){
		    for(int j = 0; j < gameBoard[i].length; j++){
		    	  
		            if(gameBoard[i][j].squareContent.equals("w")) {
		            	whiteCount++;
		            }else if(gameBoard[i][j].squareContent.equals("b")) {
		            	blackCount++;
		            }else if(gameBoard[i][j].squareContent.equals("wk")) {
		            	whiteCount = whiteCount+5;
		            }else if(gameBoard[i][j].squareContent.equals("bk")) {
		            	blackCount = blackCount+5;
		            }
		    }
		}
		
		value = whiteCount - blackCount;
		return value;
	}
	
    	
	
}
