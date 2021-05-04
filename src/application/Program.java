package application;

import entities.Game;

public class Program {

	public static void main(String[] args) {
		
		Game tictactoe = new Game();
		
		// Just checking if checkForWin works!
		if (tictactoe.checkForWin()) {
			System.out.println("Victory!");
		} else {
			System.out.println("NO!");
		}
		
		
	}
	
}
