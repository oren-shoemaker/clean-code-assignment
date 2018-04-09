import java.util.*;
public class TicTacToe {
	
	static char[][] inputAsCharArrays;
	static int NUMBEROFINPUTS;
	static char[][] gameBoard;
	static int xWinningMove = 0;
	static int oWinningMove = 0;
	static String[] outputArray;

	public static void main(String[] args) {
		
		setNumberOfInputs(1);
		populateInputArray();
		outputArray = new String[NUMBEROFINPUTS];
		
		for(int i=0;i<NUMBEROFINPUTS;i++){
			
			solveTicTacToe(i);
			
		}
		
		printOutputArray();
	}
	
	private static void setNumberOfInputs(int numInputs){
		NUMBEROFINPUTS = numInputs;
	}
	
	private static void populateInputArray(){
		
		Scanner fromStdIn = new Scanner(System.in);
		inputAsCharArrays = new char[NUMBEROFINPUTS][];
		
		for(int i=0;i<NUMBEROFINPUTS;i++){
			inputAsCharArrays[i] = fromStdIn.nextLine().toCharArray();
		}
		
		fromStdIn.close();
	}
	
	private static void printOutputArray(){
		
		for(String s : outputArray){
			System.out.println(s);
		}
		
	}
	
	private static void solveTicTacToe(int indexOfProblem){
		
		setGameBoard(indexOfProblem);
		checkForWinningMoves();
		buildOutputLine(indexOfProblem);
		
		
	}
	
	private static void setGameBoard(int indexOfProblem){
		
		gameBoard = new char[3][3];
		int placeInLine = 0;
		
		for(int row=0;row<3;row++){
			for(int col=0;col<3;col++){
				gameBoard[row][col] = inputAsCharArrays[indexOfProblem][placeInLine];
				placeInLine++;
			}
		}
		
	}
	
	private static void checkForWinningMoves(){
		
		checkRows();
		checkColumns();
		checkMainDiagonal();
		checkSecondaryDiagonal();
		
	}
	
	private static void checkRows(){
		
		for(int row=0;row<3;row++){	
			
			int offset = row * 3;
			int positionInRow = getWinningMoveInLine(gameBoard[row]);
			
			if(couldWinThisLine(gameBoard[row], 'X')){
				setXWinningMove(offset, positionInRow);
			}
			
			if(couldWinThisLine(gameBoard[row], 'O')){
				setOWinningMove(offset, positionInRow);
			}
			
		}
		
	}
	
	private static void checkColumns(){
		
		for(int col=0;col<3;col++){
			
			char[] line = {gameBoard[0][col], gameBoard[1][col], gameBoard[2][col]};
			int offset = getWinningMoveInLine(line) * 3;
			int positionInRow = col;
			
			if(couldWinThisLine(line, 'X')){
				setXWinningMove(offset, positionInRow);
			}
			
			if(couldWinThisLine(line, 'O')){
				setOWinningMove(offset, positionInRow);
			}
			
		}
		
	}
	
	private static void checkMainDiagonal(){
		
		char[] line = {gameBoard[0][0] , gameBoard[1][1], gameBoard[2][2]};
		int positionInRow = getWinningMoveInLine(line);
		int offset = 3 * positionInRow;
		
		if(couldWinThisLine(line, 'X')){
			setXWinningMove(offset, positionInRow);
		}
		
		if(couldWinThisLine(line, 'O')){
			setOWinningMove(offset, positionInRow);
		}
		
	}
	
	private static void checkSecondaryDiagonal(){
		
		char[] line = {gameBoard[0][2], gameBoard[1][1], gameBoard[2][0]};
		int positionInRow = getWinningMoveInLine(line);
		int offset = 2 - positionInRow;
		
		if(couldWinThisLine(line, 'X')){
			setXWinningMove(offset, positionInRow);
		}
		
		if(couldWinThisLine(line, 'O')){
			setOWinningMove(offset, positionInRow);
		}
		
	}
	
	private static boolean couldWinThisLine(char[] line, char symbol){
		
		if(countSymbolInLine(line, symbol)==2 && countSymbolInLine(line, invertSymbol(symbol))==0){
			return true;
		} else {
			return false;
		}
		
	}
	
	private static int countSymbolInLine(char[] line, char symbol){
		
		int count = 0;
		
		for (int i=0;i<3;i++){
			if(line[i]==symbol){
				count++;
			}
		}
		
		return count;
		
	}
	
	private static char invertSymbol(char symbol){
		
		if(symbol=='X'){
			return 'O';
		}
		
		if(symbol=='O'){
			return 'X';
		}
		
		return 'B';
		
	}
	
	private static int getWinningMoveInLine(char[] line){
		
		for(int i=0;i<3;i++){
			if (line[i] == 'B'){
				return i;
			}
		}
		
		return -1;
		
	}
	
	private static void setXWinningMove(int offset, int positionInLine){
		
		xWinningMove = offset + positionInLine + 1;
		
	}
	
	private static void setOWinningMove(int offset, int positionInLine){
		
		oWinningMove = offset + positionInLine + 1;
		
	}
	
	private static void buildOutputLine(int indexOfProblem){
		
		String outputLine = "";
		
		if(!oCanWin() && !xCanWin()){
			outputLine += "NONE";
		}
		
		if(oCanWin()){
			outputLine += "O " + oWinningMove;
			if(xCanWin()){
				outputLine += " ";
			}
		}
		
		if(xCanWin()){
			outputLine += "X " + xWinningMove;
		}
		
		outputArray[indexOfProblem] = outputLine;
		
		
	}
	
	private static boolean xCanWin(){
		
		if(xWinningMove<=0){
			return false;
		} else {
			return true;
		}
		
	}
	
	private static boolean oCanWin(){
		
		if(oWinningMove<=0){
			return false;
		} else {
			return true;
		}
		
	}

	
}
