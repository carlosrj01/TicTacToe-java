package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Game;
import entities.GameException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int row, column;
		
		Game tictactoe = new Game();
		
		while(!tictactoe.checkForWin() && !tictactoe.tie()) {
			try {
			
			System.out.println("Player "+tictactoe.getCurrentPlayerMark());
			System.out.print("Choose the row: [1-3] ");
			row = Integer.parseInt(sc.nextLine()) - 1;
			System.out.print("Choose the column: [1-3] ");
			column = Integer.parseInt(sc.nextLine()) - 1;
			clearScreen();
			tictactoe.perfomeMove(row, column);
			
		}
			catch (GameException e) {
				System.out.println(e.getMessage()); 
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
		
		
	}
	

