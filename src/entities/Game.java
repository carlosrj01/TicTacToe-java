package entities;

public class Game {

	private char[][] board;
	private char currentPlayerMark;

	public Game() {

		this.board = new char[3][3];
		drawBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}

	}

	private void drawBoard() {
		System.out.print("-------------");
		System.out.println();
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				board[i][j] = 'X';
				System.out.print(board[i][j]+" | ");
			}
			System.out.println("");
			System.out.println("-------------");
		}
	}
	
	
	public boolean isBoardFull() {
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
	

}
