import java.util.Random;
import java.util.Scanner;

public class random {
	String playerMove="w";
	int maxMoves;
	Node[][] gameBoard;
	public random(int maxMoves,Node[][] gameBoard) {
		this.maxMoves=maxMoves;
		this.gameBoard=gameBoard;
	}
	public void playRandomly() {
		while(maxMoves!=0) {


			if(playerMove.equals("w")) {
				Scanner myvar=new Scanner(System.in);
				System.out.print("Your move (? for help):");
				String userInput=myvar.nextLine();
				String letter1=userInput.substring(0,1);
				String letter2=userInput.substring(3,4);
				int fromIndex1=0;
				switch(letter1) {
				case "a":
					fromIndex1=0;
					break;
				case "b":
					fromIndex1=1;
					break;
				case "c":
					fromIndex1=2;
					break;
				case "d":
					fromIndex1=3;
				}
				int toIndex1=0;
				switch(letter2) {
				case "a":
					toIndex1=0;
					break;
				case "b":
					toIndex1=1;
					break;
				case "c":
					toIndex1=2;
					break;
				case "d":
					toIndex1=3;
				}
				int fromIndex2=Integer.parseInt(userInput.substring(1,2));
				fromIndex2--;
				int toIndex2=Integer.parseInt(userInput.substring(4,5));
				toIndex2--;


				if(gameBoard[fromIndex1][fromIndex2].squareContent.equals("w") ||gameBoard[fromIndex1][fromIndex2].squareContent.equals("wk") ) {
					if(validateMoveWhite(fromIndex1,fromIndex2,toIndex1,toIndex2)) {
						System.out.println("move successful");
						Board temp=new Board(4);
						temp.gameBoard=gameBoard;

						temp.printBoard();
						playerMove="b";
						maxMoves--;
					}else {

					}

				}else {
					System.out.println("You don't have a piece to move at the specified location");
				}





			}else if(playerMove.equals("b")) {

				Random rand=new Random();
				int x,y;
				int count=0;
				int count2=0;
				do {
					count=0;

					do {
						x=rand.nextInt(4);
						y=rand.nextInt(4);
						//System.out.println(x+","+y);
					}while(!(gameBoard[x][y].squareContent.equals("b") || gameBoard[x][y].squareContent.equals("bk")));
					int fromIndex1=x;
					int fromIndex2=y;

					int toIndex1,toIndex2;

					do {
						toIndex1=rand.nextInt(4);
						toIndex2=rand.nextInt(4);
						System.out.println(toIndex1+","+toIndex2);
						count++;
						if(count==50) {
							break;
						}

					}while(!validateMoveBlack(fromIndex1,fromIndex2,toIndex1,toIndex2));
					count2++;
					if(count2==50) {
						break;
					}
					
				}while(count==50);

				Board updatedBoard=new Board(4);
				updatedBoard.gameBoard=gameBoard;
				updatedBoard.printBoard();
				playerMove="w";
			}

		}

	}
	public boolean validateMoveWhite(int fromIndex1,int fromIndex2,int toIndex1,int toIndex2) {
		int checkIndex=toIndex1+1;
		int cIndex2=toIndex1+2;
		
if(gameBoard[fromIndex1][fromIndex2].squareContent.equals("w")) {
	System.out.print("Sdsd");
		if(checkIndex==fromIndex1) {

			int checkIndex1=toIndex2+1;
			int checkIndex2=toIndex2-1;

			if(checkIndex1==fromIndex2 || checkIndex2==fromIndex2) {

				if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {

					gameBoard[toIndex1][toIndex2].squareContent="w";
					gameBoard[fromIndex1][fromIndex2].squareContent=" ";
					if(toIndex1==0) {
						gameBoard[toIndex1][toIndex2].squareContent="wk";
					}
					return true;
				}else {
					System.out.print("Illegal Move");
				}
			}else {
				System.out.print("Illegal Move");
			}
		}else if(cIndex2==fromIndex1) {
			int checkIndex1=toIndex2+2;
			int checkIndex2=toIndex2-2;
			if(checkIndex1==fromIndex2 || checkIndex2==fromIndex2) {

				if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
					int CaseOneIndex1=toIndex1+1;
					int CaseOneIndex2=toIndex2+1;
					int CaseTwoIndex1=toIndex1+1;
					int CaseTwoIndex2=toIndex2-1;
					if(checkIndex1==fromIndex2 && gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("b")) {
						System.out.print(toIndex1+","+toIndex2);
						int blackIndex1=toIndex1+1;
						int blackIndex2=toIndex2+1;
						gameBoard[toIndex1][toIndex2].squareContent="w";
						gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						gameBoard[blackIndex1][blackIndex2].squareContent=" ";
						if(toIndex1==0) {
							gameBoard[toIndex1][toIndex2].squareContent="wk";
						}
						return true;
					}else if(checkIndex2==fromIndex2&& gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("b")) {
						System.out.print(toIndex1+","+toIndex2);
						int blackIndex1=toIndex1+1;
						int blackIndex2=toIndex2-1;
						gameBoard[toIndex1][toIndex2].squareContent="w";
						gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						gameBoard[blackIndex1][blackIndex2].squareContent=" ";
						if(toIndex1==0) {
							gameBoard[toIndex1][toIndex2].squareContent="wk";
						}
						return true;
					}

				}else {
					System.out.print("Illegal Move");
				}
			}else {
				System.out.print("Illegal Move");
			}

		}
		else {
			System.out.print("Illegal Move");
		}
}else if(gameBoard[fromIndex1][fromIndex2].squareContent.equals("wk")) {
	int fwdIndex1=toIndex1+1;
	int fwdIndex11=toIndex1+2;
	int backIndex1=toIndex1-1;
	int backIndex11=toIndex1-2;
	if(fwdIndex1==fromIndex1 || backIndex1==fromIndex1) {
		if(fwdIndex1==fromIndex1) {
			int fwdIndex2=toIndex2+1;
			int fwdIndex22=toIndex2-1;

			if(fwdIndex2==fromIndex2 || fwdIndex22==fromIndex2) {

				if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {

					gameBoard[toIndex1][toIndex2].squareContent="wk";
					gameBoard[fromIndex1][fromIndex2].squareContent=" ";
					
					return true;
				}else {
					System.out.print("Illegal Move");
				}
			}else {
				System.out.print("Illegal Move");
			}
		}
		if(backIndex1==fromIndex1) {
			int backIndex2=toIndex2+1;
			int backIndex22=toIndex2-1;

			if(backIndex2==fromIndex2 || backIndex22==fromIndex2) {

				if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {

					gameBoard[toIndex1][toIndex2].squareContent="wk";
					gameBoard[fromIndex1][fromIndex2].squareContent=" ";
					return true;
				}
			}
		}
		
	}else if(fwdIndex11==fromIndex1 ||backIndex11==fromIndex1) {
		
		if(fwdIndex11==fromIndex1) {
			
			
			
			int fwdIndex2=toIndex2+2;
			int fwdIndex22=toIndex2-2;
			if(fwdIndex2==fromIndex2 || fwdIndex22==fromIndex2) {

				if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
					int CaseOneIndex1=toIndex1+1;
					int CaseOneIndex2=toIndex2+1;
					int CaseTwoIndex1=toIndex1+1;
					int CaseTwoIndex2=toIndex2-1;
					if(fwdIndex2==fromIndex2 && gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("b")) {
						System.out.print(toIndex1+","+toIndex2);
						int blackIndex1=toIndex1+1;
						int blackIndex2=toIndex2+1;
						gameBoard[toIndex1][toIndex2].squareContent="wk";
						gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						gameBoard[blackIndex1][blackIndex2].squareContent=" ";
					
						return true;
					}else if(fwdIndex22==fromIndex2&& gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("b")) {
						System.out.print(toIndex1+","+toIndex2);
						int blackIndex1=toIndex1+1;
						int blackIndex2=toIndex2-1;
						gameBoard[toIndex1][toIndex2].squareContent="wk";
						gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						gameBoard[blackIndex1][blackIndex2].squareContent=" ";
						return true;
					}

				}else {
					System.out.print("Illegal Move1");
				}
			}else {
				System.out.print("Illegal Move2");
			}

		}else if(backIndex11==fromIndex1) {
			
			int backIndex2=toIndex2+2;
			int backIndex22=toIndex2-2;
			if(backIndex2==fromIndex2 || backIndex22==fromIndex2) {
				
				if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
					//System.out.print("DSfsdf");
					int CaseOneIndex1=toIndex1-1;
					int CaseOneIndex2=toIndex2-1;
					int CaseTwoIndex1=toIndex1-1;
					int CaseTwoIndex2=toIndex2+1;
					try {
					if(backIndex22==fromIndex2 && gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("b") ) {
						//System.out.print("DSfsdf");
						//System.out.print(toIndex1+","+toIndex2);
						int whiteIndex1=toIndex1-1;
						int whiteIndex2=toIndex2-1;
						gameBoard[toIndex1][toIndex2].squareContent="wk";
						gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
						
						return true;
					}else if(backIndex2==fromIndex2 && gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("b")) {
						//System.out.print("DSfsdf");
						//System.out.print(toIndex1+","+toIndex2);
						int whiteIndex1=toIndex1-1;
						int whiteIndex2=toIndex2+1;
						gameBoard[toIndex1][toIndex2].squareContent="wk";
						gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
						
						return true;
					}
					}catch(Exception e) {
						System.out.print("DSfsdf");
					}

				}else {
					//System.out.print("Illegal Move");
					//System.out.print("DSfsdf");
				}
			}else {
				//System.out.print("Illegal Move");
			}
		}
		
		
	}
}
	

		
		return false;
	}
	public boolean validateMoveBlack(int fromIndex1,int fromIndex2,int toIndex1,int toIndex2) {
		int checkIndex=toIndex1-1;
		int cIndex2=toIndex1-2;
		if(gameBoard[fromIndex1][fromIndex2].squareContent.equals("b")) {
		if(checkIndex==fromIndex1) {

			int checkIndex1=toIndex2+1;
			int checkIndex2=toIndex2-1;

			if(checkIndex1==fromIndex2 || checkIndex2==fromIndex2) {

				if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {

					gameBoard[toIndex1][toIndex2].squareContent="b";
					gameBoard[fromIndex1][fromIndex2].squareContent=" ";
					if(toIndex1==3) {
						gameBoard[toIndex1][toIndex2].squareContent="bk";
					}
					return true;
				}
			}
		}else if(cIndex2==fromIndex1) {
			int checkIndex1=toIndex2+2;
			int checkIndex2=toIndex2-2;
			if(checkIndex1==fromIndex2 || checkIndex2==fromIndex2) {

				if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
					int CaseOneIndex1=toIndex1-1;
					int CaseOneIndex2=toIndex2-1;
					int CaseTwoIndex1=toIndex1-1;
					int CaseTwoIndex2=toIndex2+1;
					try {
					if(checkIndex2==fromIndex2 && gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("w") ) {
						//System.out.print(toIndex1+","+toIndex2);
						int whiteIndex1=toIndex1-1;
						int whiteIndex2=toIndex2-1;
						gameBoard[toIndex1][toIndex2].squareContent="b";
						gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
						if(toIndex1==3) {
							gameBoard[toIndex1][toIndex2].squareContent="bk";
						}
						return true;
					}else if(checkIndex1==fromIndex2 && gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("w")) {
						//System.out.print(toIndex1+","+toIndex2);
						int whiteIndex1=toIndex1-1;
						int whiteIndex2=toIndex2+1;
						gameBoard[toIndex1][toIndex2].squareContent="b";
						gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
						if(toIndex1==3) {
							gameBoard[toIndex1][toIndex2].squareContent="bk";
						}
						return true;
					}
					}catch(Exception e) {
						
					}

				}else {
					//System.out.print("Illegal Move");
				}
			}else {
				//System.out.print("Illegal Move");
			}

		}
		else {
			//System.out.print("Illegal Move");
		}
		}else if(gameBoard[fromIndex1][fromIndex2].squareContent.equals("bk")) {
			int fwdIndex1=toIndex1+1;
			int fwdIndex11=toIndex1+2;
			int backIndex1=toIndex1-1;
			int backIndex11=toIndex1-2;
			if(fwdIndex1==fromIndex1 || backIndex1==fromIndex1) {
				if(fwdIndex1==fromIndex1) {
					int fwdIndex2=toIndex2+1;
					int fwdIndex22=toIndex2-1;

					if(fwdIndex2==fromIndex2 || fwdIndex22==fromIndex2) {

						if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {

							gameBoard[toIndex1][toIndex2].squareContent="bk";
							gameBoard[fromIndex1][fromIndex2].squareContent=" ";
							
							return true;
						}else {
							System.out.print("Illegal Move");
						}
					}else {
						System.out.print("Illegal Move");
					}
				}
				if(backIndex1==fromIndex1) {
					int backIndex2=toIndex2+1;
					int backIndex22=toIndex2-1;

					if(backIndex2==fromIndex2 || backIndex22==fromIndex2) {

						if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {

							gameBoard[toIndex1][toIndex2].squareContent="bk";
							gameBoard[fromIndex1][fromIndex2].squareContent=" ";
							return true;
						}
					}
				}
				
			}else if(fwdIndex11==fromIndex1 ||backIndex11==fromIndex1) {
				
				if(fwdIndex11==fromIndex1) {
					
					
					
					int fwdIndex2=toIndex2+2;
					int fwdIndex22=toIndex2-2;
					if(fwdIndex2==fromIndex2 || fwdIndex22==fromIndex2) {

						if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
							int CaseOneIndex1=toIndex1+1;
							int CaseOneIndex2=toIndex2+1;
							int CaseTwoIndex1=toIndex1+1;
							int CaseTwoIndex2=toIndex2-1;
							if(fwdIndex2==fromIndex2 && gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("w")) {
								System.out.print(toIndex1+","+toIndex2);
								int blackIndex1=toIndex1+1;
								int blackIndex2=toIndex2+1;
								gameBoard[toIndex1][toIndex2].squareContent="bk";
								gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								gameBoard[blackIndex1][blackIndex2].squareContent=" ";
								
								return true;
							}else if(fwdIndex22==fromIndex2&& gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("w")) {
								System.out.print(toIndex1+","+toIndex2);
								int blackIndex1=toIndex1+1;
								int blackIndex2=toIndex2-1;
								gameBoard[toIndex1][toIndex2].squareContent="bk";
								gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								gameBoard[blackIndex1][blackIndex2].squareContent=" ";
							
								return true;
							}

						}else {
							System.out.print("Illegal Move1");
						}
					}else {
						System.out.print("Illegal Move2");
					}

				}else if(backIndex11==fromIndex1) {
					
					int backIndex2=toIndex2+2;
					int backIndex22=toIndex2-2;
					if(backIndex2==fromIndex2 || backIndex22==fromIndex2) {
						
						if(gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
							//System.out.print("DSfsdf");
							int CaseOneIndex1=toIndex1-1;
							int CaseOneIndex2=toIndex2-1;
							int CaseTwoIndex1=toIndex1-1;
							int CaseTwoIndex2=toIndex2+1;
							try {
							if(backIndex22==fromIndex2 && gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("w") ) {
								//System.out.print("DSfsdf");
								//System.out.print(toIndex1+","+toIndex2);
								int whiteIndex1=toIndex1-1;
								int whiteIndex2=toIndex2-1;
								gameBoard[toIndex1][toIndex2].squareContent="bk";
								gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
								
								return true;
							}else if(backIndex2==fromIndex2 && gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("w")) {
								//System.out.print("DSfsdf");
								//System.out.print(toIndex1+","+toIndex2);
								int whiteIndex1=toIndex1-1;
								int whiteIndex2=toIndex2+1;
								gameBoard[toIndex1][toIndex2].squareContent="wk";
								gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
								
								return true;
							}
							}catch(Exception e) {
								System.out.print("DSfsdf");
							}

						}else {
							//System.out.print("Illegal Move");
							//System.out.print("DSfsdf");
						}
					}else {
						//System.out.print("Illegal Move");
					}
				}
				
				
			}
		}
		return false;
	}
}
