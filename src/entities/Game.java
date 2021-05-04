package entities;

public class Game {

	private char[][] board;
	private char currentPlayerMark;

	public Game() {

		this.board = new char[3][3];
		currentPlayerMark = 'X';
		initializeBoard();
		drawBoard();
	}

	public char getCurrentPlayerMark() {
		return currentPlayerMark;
	}

	public void setCurrentPlayerMark(char currentPlayerMark) {
		this.currentPlayerMark = currentPlayerMark;
	}

	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}

	}
	
	
	public void perfomeMove(int row, int column) {
		if (row < 0 || row > 3 || column < 0 || column > 3) {
			throw new GameException("Position not exists, try again.");
		}
		if (board[row][column] != '-') {
			throw new GameException("Position is arealdy filled, choose another.");
		}
		board[row][column] = currentPlayerMark;
		drawBoard();
		if (checkForWin()) {
			System.out.println("Victory of Player "+currentPlayerMark);
		}
		changeCurrentPlayer();
	}
	
	
	private void changeCurrentPlayer() {
		if (currentPlayerMark == 'X') {
			currentPlayerMark = 'O';
		} else {
			currentPlayerMark = 'X';
		}
	}

	private void drawBoard() {
		System.out.print("-------------");
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println("");
			System.out.println("-------------");
		}
	}

	public boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkForWin() {
		return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin();
	}

	private boolean checkRowsForWin() {

		for (int i = 0; i < 3; i++) {
			if (checkFill(board[i][0], board[i][1], board[i][2])) {
				return true;
			}
		}
		return false;
	}

	private boolean checkColumnsForWin() {
		for (int i = 0; i < 3; i++) {
			if (checkFill(board[0][i], board[1][i], board[2][i])) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonalsForWin() {
		if (checkFill(board[0][0],board[1][1],board[2][2])) {
			return true;
		}
		if (checkFill(board[0][2],board[1][1],board[2][0])) {
			return true;
		}

		return false;
	}

	private boolean checkFill(char c1, char c2, char c3) {
		return c1 != '-' && c1 == c2 && c2 == c3;
	}
	
	public boolean tie() {
		if(isBoardFull() && !checkForWin()) {
			System.out.println("It's a TIE!");
			return true;
		}
		return false;
	}

}
