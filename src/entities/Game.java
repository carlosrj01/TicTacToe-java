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
				board[i][j] = 'X'; // just testing if checkForWin works!
			}
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
		if (board[0][0] == currentPlayerMark && board[0][1] == currentPlayerMark && board[0][2] == currentPlayerMark) {
			return true;
		}
		if (board[1][0] == currentPlayerMark && board[1][1] == currentPlayerMark && board[1][2] == currentPlayerMark) {
			return true;
		}
		if (board[2][0] == currentPlayerMark && board[2][1] == currentPlayerMark && board[2][2] == currentPlayerMark) {
			return true;
		}

		return false;
	}

	private boolean checkColumnsForWin() {
		if (board[0][0] == currentPlayerMark && board[1][0] == currentPlayerMark && board[2][0] == currentPlayerMark) {
			return true;
		}
		if (board[0][1] == currentPlayerMark && board[1][1] == currentPlayerMark && board[2][1] == currentPlayerMark) {
			return true;
		}
		if (board[0][2] == currentPlayerMark && board[1][2] == currentPlayerMark && board[2][2] == currentPlayerMark) {
			return true;
		}

		return false;
	}
	
	private boolean checkDiagonalsForWin() {
		if (board[0][0] == currentPlayerMark && board[1][1] == currentPlayerMark && board[2][2] == currentPlayerMark) {
			return true;
		}
		if (board[0][2] == currentPlayerMark && board[1][1] == currentPlayerMark && board[2][0] == currentPlayerMark) {
			return true;
		}

		return false;
	}
	
}
