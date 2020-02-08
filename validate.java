
public class validate {
	public boolean validateMoveWhite(Board current,int fromIndex1,int fromIndex2,int toIndex1,int toIndex2) {
		int checkIndex=toIndex1+1;
		int cIndex2=toIndex1+2;
		
if(current.gameBoard[fromIndex1][fromIndex2].squareContent.equals("w")) {
	System.out.print("Sdsd");
		if(checkIndex==fromIndex1) {

			int checkIndex1=toIndex2+1;
			int checkIndex2=toIndex2-1;

			if(checkIndex1==fromIndex2 || checkIndex2==fromIndex2) {

				if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
					Board newBoard=new Board(4);
					newBoard.gameBoard=current.gameBoard;
					newBoard.gameBoard[toIndex1][toIndex2].squareContent="w";
					newBoard.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
					if(toIndex1==0) {
						newBoard.gameBoard[toIndex1][toIndex2].squareContent="wk";
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

				if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {
					int CaseOneIndex1=toIndex1+1;
					int CaseOneIndex2=toIndex2+1;
					int CaseTwoIndex1=toIndex1+1;
					int CaseTwoIndex2=toIndex2-1;
					if(checkIndex1==fromIndex2 && current.gameBoard[CaseOneIndex1][CaseOneIndex2].squareContent.equals("b")) {
						System.out.print(toIndex1+","+toIndex2);
						int blackIndex1=toIndex1+1;
						int blackIndex2=toIndex2+1;
						current.gameBoard[toIndex1][toIndex2].squareContent="w";
						current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						current.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
						if(toIndex1==0) {
							current.gameBoard[toIndex1][toIndex2].squareContent="wk";
						}
						return true;
					}else if(checkIndex2==fromIndex2&& current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("b")) {
						System.out.print(toIndex1+","+toIndex2);
						int blackIndex1=toIndex1+1;
						int blackIndex2=toIndex2-1;
						current.gameBoard[toIndex1][toIndex2].squareContent="w";
						current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						current.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
						if(toIndex1==0) {
							current.gameBoard[toIndex1][toIndex2].squareContent="wk";
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

					current.gameBoard[toIndex1][toIndex2].squareContent="wk";
					current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
					
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

					current.gameBoard[toIndex1][toIndex2].squareContent="wk";
					current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
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
						current.gameBoard[toIndex1][toIndex2].squareContent="wk";
						current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						current.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
					
						return true;
					}else if(fwdIndex22==fromIndex2&& current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("b")) {
						System.out.print(toIndex1+","+toIndex2);
						int blackIndex1=toIndex1+1;
						int blackIndex2=toIndex2-1;
						current.gameBoard[toIndex1][toIndex2].squareContent="wk";
						current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						current.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
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
						current.gameBoard[toIndex1][toIndex2].squareContent="wk";
						current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						current.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
						
						return true;
					}else if(backIndex2==fromIndex2 && current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("b")) {
						//System.out.print("DSfsdf");
						//System.out.print(toIndex1+","+toIndex2);
						int whiteIndex1=toIndex1-1;
						int whiteIndex2=toIndex2+1;
						current.gameBoard[toIndex1][toIndex2].squareContent="wk";
						current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						current.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
						
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
	public boolean validateMoveBlack(Board current,int fromIndex1,int fromIndex2,int toIndex1,int toIndex2) {
		int checkIndex=toIndex1-1;
		int cIndex2=toIndex1-2;
		if(current.gameBoard[fromIndex1][fromIndex2].squareContent.equals("b")) {
		if(checkIndex==fromIndex1) {

			int checkIndex1=toIndex2+1;
			int checkIndex2=toIndex2-1;

			if(checkIndex1==fromIndex2 || checkIndex2==fromIndex2) {

				if(current.gameBoard[toIndex1][toIndex2].squareContent.equals(" ")) {

					current.gameBoard[toIndex1][toIndex2].squareContent="b";
					current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
					if(toIndex1==3) {
						current.gameBoard[toIndex1][toIndex2].squareContent="bk";
					}
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
						current.gameBoard[toIndex1][toIndex2].squareContent="b";
						current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						current.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
						if(toIndex1==3) {
							current.gameBoard[toIndex1][toIndex2].squareContent="bk";
						}
						return true;
					}else if(checkIndex1==fromIndex2 && current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("w")) {
						//System.out.print(toIndex1+","+toIndex2);
						int whiteIndex1=toIndex1-1;
						int whiteIndex2=toIndex2+1;
						current.gameBoard[toIndex1][toIndex2].squareContent="b";
						current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
						current.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
						if(toIndex1==3) {
							current.gameBoard[toIndex1][toIndex2].squareContent="bk";
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

							current.gameBoard[toIndex1][toIndex2].squareContent="bk";
							current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
							
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

							current.gameBoard[toIndex1][toIndex2].squareContent="bk";
							current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
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
								current.gameBoard[toIndex1][toIndex2].squareContent="bk";
								current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								current.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
								
								return true;
							}else if(fwdIndex22==fromIndex2&& current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("w")) {
								System.out.print(toIndex1+","+toIndex2);
								int blackIndex1=toIndex1+1;
								int blackIndex2=toIndex2-1;
								current.gameBoard[toIndex1][toIndex2].squareContent="bk";
								current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								current.gameBoard[blackIndex1][blackIndex2].squareContent=" ";
							
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
								current.gameBoard[toIndex1][toIndex2].squareContent="bk";
								current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								current.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
								
								return true;
							}else if(backIndex2==fromIndex2 && current.gameBoard[CaseTwoIndex1][CaseTwoIndex2].squareContent.equals("w")) {
								//System.out.print("DSfsdf");
								//System.out.print(toIndex1+","+toIndex2);
								int whiteIndex1=toIndex1-1;
								int whiteIndex2=toIndex2+1;
								current.gameBoard[toIndex1][toIndex2].squareContent="wk";
								current.gameBoard[fromIndex1][fromIndex2].squareContent=" ";
								current.gameBoard[whiteIndex1][whiteIndex2].squareContent=" ";
								
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

