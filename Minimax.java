import java.util.LinkedList;

public class Minimax {
	Board current;
	Board root;
	Board prev;
	LinkedList<Board> explored=new LinkedList<Board>();
	boolean isWhite=true;
	public Minimax(Board current) {
		this.current=current;
		root=current;
	}
	public void printTree() {
		current=root.children.get(1);
		current.printBoard();
		for(int x=0;x<current.children.size();x++) {
			current.children.get(x).printBoard();
		}
	}
	public void constructTree(int length) {
			
		
		
		if(isWhite) {
			for(int x=0;x<length;x++) {
				for(int y=0;y<length;y++) {
					if(current.gameBoard[x][y].squareContent.equals("w")|| current.gameBoard[x][y].squareContent.equals("wk")) {
						validateWhite(x,y);
					}
				}
			}	
			isWhite=false;
			int size=current.children.size();
			for(int x=0;x<size;x++) {
				try {
					current.children.get(x).prev=current;
					current=current.children.get(x);

					constructTree(4);
					current=current.prev;
					}catch(Exception e ) {
						break;
					}
				
				
			}
		}else {
			for(int x=0;x<length;x++) {
				for(int y=0;y<length;y++) {
					if(current.gameBoard[x][y].squareContent.equals("b") || current.gameBoard[x][y].squareContent.equals("bk")) {
						validateBlack(x,y);
					}
				}
			}
			isWhite=true;
			int size=current.children.size();
			for(int x=0;x<size;x++) {
				try {
					current.children.get(x).prev=current;
					current=current.children.get(x);

					constructTree(4);
					current=current.prev;
					}catch(Exception e ) {
						break;
					}
				
				
				
			}
		}
			
			
		
		
	}
	public void validateWhite(int Index1, int Index2) {
		current.printBoard();
		if(current.gameBoard[Index1][Index2].squareContent.equals("w")) {
		int moveIndex1=Index1-1;
		int moveIndexLeft=Index2-1;
		int moveIndexRight=Index2+1;
		int killIndex1Left=Index1-2;
		int killIndex2Left=Index2-2;
		int killIndex1Right=Index1-2;
		int killIndex2Right=Index2+2;
		System.out.println(Index1+","+Index2);
		System.out.println(moveIndex1+","+moveIndexRight);
		validateMoveWhite(Index1,Index2,moveIndex1,moveIndexLeft);
		validateMoveWhite(Index1,Index2,moveIndex1,moveIndexRight);
		validateMoveWhite(Index1,Index2,killIndex1Left,killIndex2Left);
		validateMoveWhite(Index1,Index2,killIndex1Right,killIndex2Right);
		}else {
			int movefwdIndex1=Index1-1;
			int movebackIndex1=Index1+1;
			int moveIndexLeft=Index2-1;
			int moveIndexRight=Index2+1;
			
			int killfwdIndex1Left=Index1-2;
			int killfwdIndex2Left=Index2-2;
			int killfwdIndex1Right=Index1-2;
			int killfwdIndex2Right=Index2+2;
			int killbackIndex1Left=Index1+2;
			int killbackIndex2Left=Index2-2;
			int killbackIndex1Right=Index1+2;
			int killbackIndex2Right=Index2+2;
		
			validateMoveWhite(Index1,Index2,movefwdIndex1,moveIndexLeft);
			validateMoveWhite(Index1,Index2,movefwdIndex1,moveIndexRight);
			
			validateMoveWhite(Index1,Index2,movebackIndex1,moveIndexLeft);
			validateMoveWhite(Index1,Index2,movebackIndex1,moveIndexRight);
			
			validateMoveWhite(Index1,Index2,killfwdIndex1Left,killfwdIndex2Left);
			validateMoveWhite(Index1,Index2,killfwdIndex1Right,killfwdIndex2Right);
			validateMoveWhite(Index1,Index2,killbackIndex1Left,killbackIndex2Left);
			validateMoveWhite(Index1,Index2,killbackIndex1Right,killbackIndex2Right);
			
			
			
			
		}

	}
	public void validateBlack(int Index1, int Index2) {
		if(current.gameBoard[Index1][Index2].squareContent.equals("b")) {
		int moveIndex1=Index1+1;
		int moveIndexLeft=Index2-1;
		int moveIndexRight=Index2+1;
		int killIndex1Left=Index1+2;
		int killIndex2Left=Index2-2;
		int killIndex1Right=Index1+2;
		int killIndex2Right=Index2+2;
		System.out.println(Index1+","+Index2);
		System.out.println(moveIndex1+","+moveIndexRight);
		validateMoveBlack(Index1,Index2,moveIndex1,moveIndexLeft);
		validateMoveBlack(Index1,Index2,moveIndex1,moveIndexRight);
		validateMoveBlack(Index1,Index2,killIndex1Left,killIndex2Left);
		validateMoveBlack(Index1,Index2,killIndex1Right,killIndex2Right);
		}else {
			int movefwdIndex1=Index1-1;
			int movebackIndex1=Index1+1;
			int moveIndexLeft=Index2-1;
			int moveIndexRight=Index2+1;
			
			int killfwdIndex1Left=Index1-2;
			int killfwdIndex2Left=Index2-2;
			int killfwdIndex1Right=Index1-2;
			int killfwdIndex2Right=Index2+2;
			int killbackIndex1Left=Index1+2;
			int killbackIndex2Left=Index2-2;
			int killbackIndex1Right=Index1+2;
			int killbackIndex2Right=Index2+2;
		
			validateMoveBlack(Index1,Index2,movefwdIndex1,moveIndexLeft);
			validateMoveBlack(Index1,Index2,movefwdIndex1,moveIndexRight);
			
			validateMoveBlack(Index1,Index2,movebackIndex1,moveIndexLeft);
			validateMoveBlack(Index1,Index2,movebackIndex1,moveIndexRight);
			
			validateMoveBlack(Index1,Index2,killfwdIndex1Left,killfwdIndex2Left);
			validateMoveBlack(Index1,Index2,killfwdIndex1Right,killfwdIndex2Right);
			validateMoveBlack(Index1,Index2,killbackIndex1Left,killbackIndex2Left);
			validateMoveBlack(Index1,Index2,killbackIndex1Right,killbackIndex2Right);
		}

	}
	public void copyArray(Node[][] newBoard, Node[][] oldBoard) {
		for(int x=0;x<4;x++) {
			for(int y=0;y<4;y++) {
				newBoard[x][y].squareContent=oldBoard[x][y].squareContent;
			}
		}

	}

	public boolean validateMoveWhite(int fromIndex1,int fromIndex2,int toIndex1,int toIndex2) {
		try {
			int checkIndex=toIndex1+1;
			int cIndex2=toIndex1+2;

			if(current.gameBoard[fromIndex1][fromIndex2].squareContent.equals("w")) {

				if(checkIndex==fromIndex1) {

					int checkIndex1=toIndex2+1;
					int checkIndex2=toIndex2-1;

					if(checkIndex1==fromIndex2 || checkIndex2==fromIndex2) {

						if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {

							Board newBoard=new Board(4);
							newBoard.initializeBoard();

							copyArray(newBoard.gameBoard,current.gameBoard);

							newBoard.gameBoard[toIndex1][toIndex2].squareContent="w";
							newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
							
							if(toIndex1==0) {
								newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
							}
							//newBoard.printBoard();
							System.out.println("");
							//current.printBoard();
							System.out.println("");
							System.out.println("from: "+fromIndex1+","+fromIndex2);
							System.out.println("to: "+toIndex1+","+toIndex2);
							//current.printBoard();
							current.children.add(newBoard);
							System.out.print("SUCCESS");


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

						if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
							int CaseOneIndex1=toIndex1+1;
							int CaseOneIndex2=toIndex2+1;
							int CaseTwoIndex1=toIndex1+1;
							int CaseTwoIndex2=toIndex2-1;
							if(checkIndex1==fromIndex2 && current.gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("b")) {
								System.out.print(toIndex1+","+toIndex2);
								int blackIndex1=toIndex1+1;
								int blackIndex2=toIndex2+1;
								Board newBoard=new Board(4);
								newBoard.initializeBoard();
								copyArray(newBoard.gameBoard,current.gameBoard);
								newBoard.gameBoard[toIndex1][toIndex2].squareContent="w";
								newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								newBoard.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
								if(toIndex1==0) {
									newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
								}
								System.out.print("Sdsd");
								current.children.add(newBoard);
								return true;
							}else if(checkIndex2==fromIndex2&& current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("b")) {
								System.out.print(toIndex1+","+toIndex2);
								int blackIndex1=toIndex1+1;
								int blackIndex2=toIndex2-1;
								Board newBoard=new Board(4);
								newBoard.initializeBoard();
								copyArray(newBoard.gameBoard,current.gameBoard);
								newBoard.gameBoard[toIndex1][toIndex2].squareContent="w";
								newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								newBoard.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
								if(toIndex1==0) {
									newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
								}
								System.out.print("Sdsd");
								current.children.add(newBoard);
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
			}else if(current.gameBoard[fromIndex1][fromIndex2].squareContent.equals("wk")) {
				int fwdIndex1=toIndex1+1;
				int fwdIndex11=toIndex1+2;
				int backIndex1=toIndex1-1;
				int backIndex11=toIndex1-2;
				if(fwdIndex1==fromIndex1 || backIndex1==fromIndex1) {
					if(fwdIndex1==fromIndex1) {
						int fwdIndex2=toIndex2+1;
						int fwdIndex22=toIndex2-1;

						if(fwdIndex2==fromIndex2 || fwdIndex22==fromIndex2) {

							if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
								Board newBoard=new Board(4);
								newBoard.initializeBoard();
								copyArray(newBoard.gameBoard,current.gameBoard);
								newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
								newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								System.out.print("Sdsd");
								if(!this.containsState(newBoard, explored)) {
								current.children.add(newBoard);
								explored.add(newBoard);
								}
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

							if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
								Board newBoard=new Board(4);
								newBoard.initializeBoard();
								copyArray(newBoard.gameBoard,current.gameBoard);
								newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
								newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								System.out.print("Sdsd");
								if(!this.containsState(newBoard, explored)) {
									current.children.add(newBoard);
									explored.add(newBoard);
									}
								return true;
							}
						}
					}

				}else if(fwdIndex11==fromIndex1 ||backIndex11==fromIndex1) {

					if(fwdIndex11==fromIndex1) {



						int fwdIndex2=toIndex2+2;
						int fwdIndex22=toIndex2-2;
						if(fwdIndex2==fromIndex2 || fwdIndex22==fromIndex2) {

							if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
								int CaseOneIndex1=toIndex1+1;
								int CaseOneIndex2=toIndex2+1;
								int CaseTwoIndex1=toIndex1+1;
								int CaseTwoIndex2=toIndex2-1;
								if(fwdIndex2==fromIndex2 && current.gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("b")) {
									System.out.print(toIndex1+","+toIndex2);
									int blackIndex1=toIndex1+1;
									int blackIndex2=toIndex2+1;
									Board newBoard=new Board(4);
									newBoard.initializeBoard();
									copyArray(newBoard.gameBoard,current.gameBoard);
									newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
									newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
									newBoard.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
									System.out.print("Sdsd");
									if(!this.containsState(newBoard, explored)) {
										current.children.add(newBoard);
										explored.add(newBoard);
										}

									return true;
								}else if(fwdIndex22==fromIndex2&& current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("b")) {
									System.out.print(toIndex1+","+toIndex2);
									int blackIndex1=toIndex1+1;
									int blackIndex2=toIndex2-1;
									Board newBoard=new Board(4);
									newBoard.initializeBoard();
									copyArray(newBoard.gameBoard,current.gameBoard);
									newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
									newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
									newBoard.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
									System.out.print("Sdsd");
									if(!this.containsState(newBoard, explored)) {
										current.children.add(newBoard);
										explored.add(newBoard);
										}
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

							if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
								//System.out.print("DSfsdf");
								int CaseOneIndex1=toIndex1-1;
								int CaseOneIndex2=toIndex2-1;
								int CaseTwoIndex1=toIndex1-1;
								int CaseTwoIndex2=toIndex2+1;
								try {
									if(backIndex22==fromIndex2 && current.gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("b") ) {
										//System.out.print("DSfsdf");
										//System.out.print(toIndex1+","+toIndex2);
										int whiteIndex1=toIndex1-1;
										int whiteIndex2=toIndex2-1;
										Board newBoard=new Board(4);
										newBoard.initializeBoard();
										copyArray(newBoard.gameBoard,current.gameBoard);
										newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
										newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
										newBoard.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
										System.out.print("Sdsd");
										if(!this.containsState(newBoard, explored)) {
											current.children.add(newBoard);
											explored.add(newBoard);
											}

										return true;
									}else if(backIndex2==fromIndex2 && current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("b")) {
										//System.out.print("DSfsdf");
										//System.out.print(toIndex1+","+toIndex2);
										int whiteIndex1=toIndex1-1;
										int whiteIndex2=toIndex2+1;
										Board newBoard=new Board(4);
										newBoard.initializeBoard();
										copyArray(newBoard.gameBoard,current.gameBoard);
										newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
										newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
										newBoard.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
										System.out.print("Sdsd");
										if(!this.containsState(newBoard, explored)) {
											current.children.add(newBoard);
											explored.add(newBoard);
											}

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
		}

		catch(Exception e ) {
			System.out.print(e);
		}

		return false;
	}
	public boolean validateMoveBlack(int fromIndex1,int fromIndex2,int toIndex1,int toIndex2) {
		int checkIndex=toIndex1-1;
		int cIndex2=toIndex1-2;
		try {
		if(current.gameBoard[fromIndex1][fromIndex2].squareContent.equals("b")) {
			if(checkIndex==fromIndex1) {

				int checkIndex1=toIndex2+1;
				int checkIndex2=toIndex2-1;

				if(checkIndex1==fromIndex2 || checkIndex2==fromIndex2) {

					if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
						Board newBoard=new Board(4);
						newBoard.initializeBoard();
						copyArray(newBoard.gameBoard,current.gameBoard);
						newBoard.gameBoard[toIndex1][toIndex2].squareContent="b";
						newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						if(toIndex1==3) {
							newBoard.gameBoard[toIndex1][toIndex2].squareContent="bk";
						}
						current.children.add(newBoard);
						return true;
					}
				}
			}else if(cIndex2==fromIndex1) {
				int checkIndex1=toIndex2+2;
				int checkIndex2=toIndex2-2;
				if(checkIndex1==fromIndex2 || checkIndex2==fromIndex2) {

					if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
						int CaseOneIndex1=toIndex1-1;
						int CaseOneIndex2=toIndex2-1;
						int CaseTwoIndex1=toIndex1-1;
						int CaseTwoIndex2=toIndex2+1;
						try {
							if(checkIndex2==fromIndex2 && current.gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("w") ) {
								//System.out.print(toIndex1+","+toIndex2);
								int whiteIndex1=toIndex1-1;
								int whiteIndex2=toIndex2-1;
								Board newBoard=new Board(4);
								newBoard.initializeBoard();
								copyArray(newBoard.gameBoard,current.gameBoard);
								newBoard.gameBoard[toIndex1][toIndex2].squareContent="b";
								newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								newBoard.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
								if(toIndex1==3) {
									newBoard.gameBoard[toIndex1][toIndex2].squareContent="bk";
								}
								current.children.add(newBoard);
								return true;
							}else if(checkIndex1==fromIndex2 && current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("w")) {
								//System.out.print(toIndex1+","+toIndex2);
								int whiteIndex1=toIndex1-1;
								int whiteIndex2=toIndex2+1;
								Board newBoard=new Board(4);
								newBoard.initializeBoard();
								copyArray(newBoard.gameBoard,current.gameBoard);
								newBoard.gameBoard[toIndex1][toIndex2].squareContent="b";
								newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								newBoard.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
								if(toIndex1==3) {
									newBoard.gameBoard[toIndex1][toIndex2].squareContent="bk";
								}
								current.children.add(newBoard);
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
		}else if(current.gameBoard[fromIndex1][fromIndex2].squareContent.equals("bk")) {
			int fwdIndex1=toIndex1+1;
			int fwdIndex11=toIndex1+2;
			int backIndex1=toIndex1-1;
			int backIndex11=toIndex1-2;
			if(fwdIndex1==fromIndex1 || backIndex1==fromIndex1) {
				if(fwdIndex1==fromIndex1) {
					int fwdIndex2=toIndex2+1;
					int fwdIndex22=toIndex2-1;

					if(fwdIndex2==fromIndex2 || fwdIndex22==fromIndex2) {

						if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
							Board newBoard=new Board(4);
							newBoard.initializeBoard();
							copyArray(newBoard.gameBoard,current.gameBoard);
							newBoard.gameBoard[toIndex1][toIndex2].squareContent="bk";
							newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
							if(!this.containsState(newBoard, explored)) {
								current.children.add(newBoard);
								explored.add(newBoard);
								}
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

						if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
							Board newBoard=new Board(4);
							newBoard.initializeBoard();
							copyArray(newBoard.gameBoard,current.gameBoard);
							newBoard.gameBoard[toIndex1][toIndex2].squareContent="bk";
							newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
							if(!this.containsState(newBoard, explored)) {
								current.children.add(newBoard);
								explored.add(newBoard);
								}
				
							return true;
						}
					}
				}

			}else if(fwdIndex11==fromIndex1 ||backIndex11==fromIndex1) {

				if(fwdIndex11==fromIndex1) {



					int fwdIndex2=toIndex2+2;
					int fwdIndex22=toIndex2-2;
					if(fwdIndex2==fromIndex2 || fwdIndex22==fromIndex2) {

						if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
							int CaseOneIndex1=toIndex1+1;
							int CaseOneIndex2=toIndex2+1;
							int CaseTwoIndex1=toIndex1+1;
							int CaseTwoIndex2=toIndex2-1;
							if(fwdIndex2==fromIndex2 && current.gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("w")) {
								System.out.print(toIndex1+","+toIndex2);
								int blackIndex1=toIndex1+1;
								int blackIndex2=toIndex2+1;
								Board newBoard=new Board(4);
								newBoard.initializeBoard();
								copyArray(newBoard.gameBoard,current.gameBoard);
								newBoard.gameBoard[toIndex1][toIndex2].squareContent="bk";
								newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								newBoard.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
								if(!this.containsState(newBoard, explored)) {
									current.children.add(newBoard);
									explored.add(newBoard);
									}
								return true;
							}else if(fwdIndex22==fromIndex2&& current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("w")) {
								System.out.print(toIndex1+","+toIndex2);
								int blackIndex1=toIndex1+1;
								int blackIndex2=toIndex2-1;
								Board newBoard=new Board(4);
								newBoard.initializeBoard();
								copyArray(newBoard.gameBoard,current.gameBoard);
								newBoard.gameBoard[toIndex1][toIndex2].squareContent="bk";
								newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								newBoard.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
								if(!this.containsState(newBoard, explored)) {
									current.children.add(newBoard);
									explored.add(newBoard);
									}
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

						if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
							//System.out.print("DSfsdf");
							int CaseOneIndex1=toIndex1-1;
							int CaseOneIndex2=toIndex2-1;
							int CaseTwoIndex1=toIndex1-1;
							int CaseTwoIndex2=toIndex2+1;
							try {
								if(backIndex22==fromIndex2 && current.gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("w") ) {
									//System.out.print("DSfsdf");
									//System.out.print(toIndex1+","+toIndex2);
									int whiteIndex1=toIndex1-1;
									int whiteIndex2=toIndex2-1;
									Board newBoard=new Board(4);
									newBoard.initializeBoard();
									copyArray(newBoard.gameBoard,current.gameBoard);
									newBoard.gameBoard[toIndex1][toIndex2].squareContent="bk";
									newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
									newBoard.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
									if(!this.containsState(newBoard, explored)) {
										current.children.add(newBoard);
										explored.add(newBoard);
										}
									return true;
								}else if(backIndex2==fromIndex2 && current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("w")) {
									//System.out.print("DSfsdf");
									//System.out.print(toIndex1+","+toIndex2);
									int whiteIndex1=toIndex1-1;
									int whiteIndex2=toIndex2+1;
									Board newBoard=new Board(4);
									newBoard.initializeBoard();
									copyArray(newBoard.gameBoard,current.gameBoard);
									newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
									newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
									newBoard.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
									if(!this.containsState(newBoard, explored)) {
										current.children.add(newBoard);
										explored.add(newBoard);
										}
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
		}catch(Exception e ) {
			System.out.print(e);
		}
		return false;
	}
	public boolean containsState(Board newBoard,LinkedList<Board> explored) {
		for(int x=0;x<explored.size();x++) {
			if(explored.get(x).areEqual(newBoard.gameBoard)) {
				return true;
			}
		}
		return false;
	}
	
}

