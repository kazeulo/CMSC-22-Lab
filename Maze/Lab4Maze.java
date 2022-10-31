/*
 * class name: Lab4Maze
 * description: a maze game in which the goal is to solve the maze by reaching the X
 * author: KS Manejo
 */

import java.util.Scanner;

public class Lab4Maze {
	
	public static void main(String[] args) {
		
		int row = 1, col = 0, new_row, new_col;
		String move;
		String[][] maze = {{"@", "@", "@", "@", "@"},
						   {" ", " ", "@", " ", "X"},
						   {"@", " ", "@", " ", "@"},
						   {"@", " ", " ", " ", " "},
						   {"@", "@", "@", " ", "@"},};
		
		Scanner in = new Scanner(System.in);
		System.out.println("\n===== The Maze =====\n");
		
		//starting position
		maze[row][col] = "1";
		
		while (true) {
			
			try {
				
				//print the maze
				for (int i = 0; i<maze.length; i++) {
					System.out.println();
					for (int j=0; j<maze.length; j++) {
						System.out.print(maze[i][j]);
					}
				}
			
				System.out.println("\n\nWhich way do you want to go? Up Left Right Down");
				System.out.print("Move: ");
				move = in.nextLine();
				
				new_row = row; new_col = col;
			
				//if players moves up
				if (move.equalsIgnoreCase("Up")) {
					
					//update index to be accessed
					new_row -= 1;	
					
					//checks if space
					if (maze[new_row][new_col] == " ") {
						maze[new_row][new_col] = "1";
						maze[row][col] = " ";
					}
					
					//checks if wall
					else if (maze[new_row][new_col] == "@") {
						System.out.println("Oops! You hit a wall.");
						new_row = row;		//player stays in the same place
					}
				}
			
				//if player moves left
				else if (move.equalsIgnoreCase("Left")) {
					new_col -= 1;
				
					if (maze[new_row][new_col] == " ") {
						maze[new_row][new_col] = "1";
						maze[row][col] = " ";
					}
				
					else if (maze[new_row][new_col] == "@") {
						System.out.println("Oops! You hit a wall.");
						new_col = col;
					}
				}
			
				//if player moves right
				else if (move.equalsIgnoreCase("Right")) {
					new_col += 1;
				
					if (maze[new_row][new_col] == " ") {
						maze[new_row][new_col] = "1";
						maze[row][col] = " ";
					}
				
					else if (maze[new_row][new_col] == "@") {
						System.out.println("Oops! You hit a wall.");
						new_col = col;
					}
				
				}
			
				//if player moves down
				else if (move.equalsIgnoreCase("Down")) {
					new_row += 1;
				
					if (maze[new_row][new_col] == " ") {
						maze[new_row][new_col] = "1";
						maze[row][col] = " ";
					}
				
					else if (maze[new_row][new_col] == "@") {
						System.out.println("Oops! You hit a wall.");
						new_row -= 1;
					}
				}
			
				//if user entered an invalid input
				else {
					System.out.println("Uh-oh that is not a valid input.");
				}
			
				//update values of row and col
				row = new_row; col = new_col;
			
				//if player reaches the goal
				if (maze[row][col] == "X") {
					System.out.println("\n===== End of the maze =====");
					System.out.print("Good job! You got out of the maze!");
					break;		//break the loop
				}
			}
			
			//if player moves out of bounds
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Out of bounds. STAY IN THE MAZE!");
			}
		}
	}
}