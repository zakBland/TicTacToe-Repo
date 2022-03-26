import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {


		int filled = 0;
		int player;
		int moveX, moveY;
		int temp;
		Scanner input = new Scanner(System.in);
		Boolean comMoves[] = new Boolean[9];
		//declare pieces
		
		int X = -1;
		int O = -1;
		
		//set up board
		int board[][] = new int[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j  = 0; i < 3; j++) {
				board[i][j] = -1;
			}
		}
		
		//choose who goes first
		int choice = (int) (Math.random() * 4);

		if(choice % 2 == 0) { //user
			System.out.println("You have first move!\nMake your move (x,y)\n");
			player = 0;
		}
		else{			//computer
			System.out.println("Computer goes first!\n");
			player = 1;
		}
		
		//set up check
		
		
		//set up game
		
	
		
		input.close();

	}
	
	public static boolean check(int[][] board, int player) {
		for(int i = 0; i < 3; i++) {
			if(board[i][0] == player && board[i][1] == player && board[i][2] == player)
				return true;
			else if(board[0][i] == player && board[1][i] == player && board[2][i] == player)
				return true;
		}
		
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
			return true;
		}
		
		if(board[2][0] == player && board[1][1] == player && board[0][2] == player){
			return true;
		}
	
		return false;
	}
	
	public static String computerMove(int board) {
		int x = 0;
		int y = 0;
		
		return x +" " + y;
	}
	
	public static void ComputerGame(int[][] board, int filled, int player, int temp, int moveX, int moveY, Scanner input) {
		while(filled != 9) {
			boolean valid = true;
			
			if(player == 0) {
			
				do {
					moveX = input.nextInt();
					moveY = input.nextInt();
				
					if(board[moveX][moveY] == 0 || board[moveX][moveY] == 1) {
						System.out.println("Invalid move! Space filled, try again!");
						valid = false;
					}
				}while(!valid);	
				
				board[moveX][moveY] = 0;
				player = 1;
				filled++;
			}else {
				
				if(filled == 0) {//random
					temp = (int)(Math.random() * 9);
					moveX = temp/3;
					moveY = temp %3;
				}else {
					//for two in a row
				
					if(board[0][0] == 1) {
						if(board[0][1] == 1) 
							board[0][2] = 0;
						else if(board[1][0] == 1)  // 3
							board[2][0] = 0;
						else if(board[1][1] == 1)  //4
							board[2][2] = 0;
						else if(board[0][2] == 1)  //2
							board[0][1] = 0;
						else if(board[2][0] == 1) //6
							board[1][0] = 0;
						else if(board[2][2] == 1) //8
							board[1][1] = 0;
						else {
							//randomly choose one of six options
							temp = (int)(Math.random() * 6);
							
							if(temp == 0) 
								board[0][2] = 0;
							else if(temp == 1)  // 3
								board[2][0] = 0;
							else if(temp == 2)  //4
								board[2][2] = 0;
							else if(temp == 3)  //2
								board[0][1] = 0;
							else if(temp == 4) //6
								board[1][0] = 0;
							else if(temp == 5) //8
								board[1][1] = 0;
							
						}
						
					else if(board[0][2] == 1) {
							if(board[0][1] == 1) 
								board[0][0] = 0;
							else if(board[1][1] == 1)  // 3
								board[2][0] = 0;
							else if(board[1][2] == 1)  //4
								board[2][2] = 0;
							else if(board[2][0] == 1)  //2
								board[1][1] = 0;
							else if(board[2][0] == 1) //6
								board[1][0] = 0;
							else if(board[2][2] == 1) //8
								board[1][2] = 0;
							else {
								//randomly choose one of six options
								temp = (int)(Math.random() * 6);
								
								if(temp == 0) 
									board[0][2] = 0;
								else if(temp == 1)  // 3
									board[2][0] = 0;
								else if(temp == 2)  //4
									board[2][2] = 0;
								else if(temp == 3)  //2
									board[0][1] = 0;
								else if(temp == 4) //6
									board[1][0] = 0;
								else if(temp == 5) //8
									board[1][1] = 0;
								
							}
					}
				}
				player = 0;
				filled++;
			}
			
			if(check(board, player) == true) {
				if(player == 1) {
					System.out.println("You win!");
				}
				else {
					System.out.println("Computer wins. You lose!");
				}
				
				break;
			}
			}	
		
	}
}
