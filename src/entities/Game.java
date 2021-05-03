package entities;

public class Game {
	
	private char[][] board;
	private char currentPlayerMark;
	public Game() {
		
		this.board = new char[3][3];
		currentPlayerMark = 'x';
		initializeBoard();
		
	}
	
	public void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("-");
				
			}
			System.out.println("");
		}
	}
	
	
	
	

}
