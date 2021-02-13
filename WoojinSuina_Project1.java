package LockNRoll;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WoojinSuina_Project1 {

	public static void main(String[] args) {
		
		//Instructions
		System.out.println("Welcome to LockNRoll!!");
		System.out.println("A game that requires luck and startegy to win the game!");
		System.out.println("                 ---------------");
		System.out.println("                 | How To Play |");
		System.out.println("                 ---------------");
		System.out.println("1. Player rolls 3 dice simultaneously for the first roll.");
		System.out.println("2. Player scores points based on the combination of: ");
		System.out.println("  - the sum of the dice");
		System.out.println("  - bonus points from rolling a pair(2pts), a triple(5pts), or a straight(8pts).");
		System.out.println("3. Decide whether to lock (l) the numbers or reroll (r) on each of the die to improve their score.");
		System.out.println("4. Add all the final results and player with the most points win the game.");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("Let's Begin!");
				
		//Player Name
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Player Name: ");
		String playerName = input.next();
		
		char redo;
		do {
		//Turns
		System.out.print("How many turns in this game: ");
		int turnCount = input.nextInt(); 
		
		String[] fullData = new String[turnCount];
		for (int i = 0; i < turnCount; i++) {				
			
			int dice1 = getRandNum(1,7);
			int dice2 = getRandNum(1,7);
			int dice3 = getRandNum(1,7);
			int[] roll1 = {dice1, dice2, dice3};
			
			Arrays.sort(roll1);   
			int[] sortedRoll = roll1;
		
			int getSum1 = getSum(dice1, dice2, dice3);
			int getPair1 = getPair(dice1, dice2, dice3);
			int getTriple1 = getTriple(dice1, dice2, dice3);
			int getStraight1 = getStraight(roll1);
			int totalSum = getSum1 + getPair1 + getTriple1 + getStraight1;
			
			int turnCounting = i + 1;
			System.out.println("\n---------------------- Turn " + turnCounting + " --------------------");
			System.out.println("                 Rolls               Extra Points");
			System.out.println("              _____________       _____________________");			
			System.out.println("              | R1  R2  R3 | Sum | Pair  Triple  Str8 | Total");
			System.out.println("              | --  --  -- | --- | ----  ------  ---- | ------      ");
			System.out.print("First Roll  	" + sortedRoll[0] + "   " + sortedRoll[1] + "   " +  sortedRoll[2] + "    " + getSum1 + "     " + getPair1 + "      " + getTriple1 
					+ "      " + getStraight1 + "      " + totalSum); 

			System.out.println("\n");
			System.out.println("Would you like to Lock or Roll?");
			System.out.println("\n");
			System.out.print("Dice1 value: [" + sortedRoll[0] + "]" + " Enter l or r: ");
			char playerChoice1 = input.next().trim().charAt(0);
			System.out.print("Dice2 value: [" + sortedRoll[1] + "]" + " Enter l or r: ");
			char playerChoice2 = input.next().trim().charAt(0);
			System.out.print("Dice3 value: [" + sortedRoll[2]+ "]" + " Enter l or r: ");
			char playerChoice3 = input.next().trim().charAt(0);
			
			//Lock or Reroll
			int newDice1 = getRandNum(1,7);
			int newDice2 = getRandNum(1,7);
			int newDice3 = getRandNum(1,7);
			int[] newRoll = {newDice1, newDice2, newDice3} ;
			if (playerChoice1 == 'r') {
				newRoll[0] = getRandNum(1,7);
			}else if (playerChoice1 == 'l') {
				newRoll[0] = sortedRoll[0];
			}
			if (playerChoice2 == 'r') {
				newRoll[1] = getRandNum(1,7);
			}else if (playerChoice2 == 'l') {
				newRoll[1] = sortedRoll[1];
			}
			if (playerChoice3 == 'r') {
				newRoll[2] = getRandNum(1,7);
			}else if (playerChoice3 == 'l') {
				newRoll[2] = sortedRoll[2];
			}
				
			//Second Roll
			int[] roll2 = {newRoll[0], newRoll[1], newRoll[2]};
			Arrays.sort(roll2);   
			int[] sortedRoll2 = roll2;
			
			int getSum2 = getSum(sortedRoll2[0], sortedRoll2[1], sortedRoll2[2]);
			int getPair2 = getPair(sortedRoll2[0], sortedRoll2[1], sortedRoll2[2]);
			int getTriple2 = getTriple(sortedRoll2[0], sortedRoll2[1], sortedRoll2[2]);
			int getStraight2 = getStraight(roll2);;
			int totalSum2 = getSum2 + getPair2 + getTriple2 + getStraight2;
			int finalTotalSum = totalSum2;
			int getImprovement = totalSum2 - totalSum; 
			
			System.out.println("\n");
			System.out.println("                 Rolls               Extra Points");
			System.out.println("              _____________       _____________________");			
			System.out.println("              | R1  R2  R3 | Sum | Pair  Triple  Str8 | Total");
			System.out.println("              | --  --  -- | --- | ----  ------  ---- | ------      ");
			System.out.print("Reroll           " + sortedRoll2[0] + "   " + sortedRoll2[1] + "   " +  sortedRoll2[2] + "    " + getSum2 + "     " + getPair2 + "      " + getTriple2 
					+ "      " + getStraight2 + "      " + totalSum2); 
			System.out.println("\n");
			System.out.println("                  --Roll 1-- " + " --Roll 2--" + " Sum "+ " Pair " + " Triple " + " Straight " + " Total " + " Improv ");
			System.out.println("                  -- -- --    -- -- --    ---  ---   ----    -------   ----  ------" );
			System.out.println("Turn " + turnCounting + "             " + sortedRoll[0] + "  " + sortedRoll[1] + "  " +  sortedRoll[2] + "     "+ sortedRoll2[0] + "  " + sortedRoll2[1] + "  " +  sortedRoll2[2] +
					"    " + getSum2 + "     " + getPair2 + "     " + getTriple2 + "        " + getStraight2 + "        " + totalSum2 +"      " + getImprovement);

			System.out.println("_____________________________________________________________________________________________________________________________________");	

			//Storing values for each turn
			String dataRoll1 = Arrays.toString(sortedRoll);  
			String dataRoll2 = Arrays.toString(sortedRoll2);
			String fullSum =String.valueOf(totalSum2);
			String fullImprovement =String.valueOf(getImprovement);
			String endCount =String.valueOf(turnCounting);
			
			
			String turnData = "  Turn " + endCount + ": " + dataRoll1 + " " + dataRoll2 + "  Pts: " + fullSum + "  Improvements: " + fullImprovement;
			
			fullData[i] = turnData;
			
			
			

        	 
		}//Exit Loop

		
		//History of game 
		System.out.println();
		System.out.println("GAME END");
		System.out.println();
		System.out.println("Turn History");
		for (int i = 0; i < turnCount; i++) {
		System.out.println(playerName + fullData[i]);}
		System.out.println();
		System.out.println();
		
		//Prompt user for New Game
		System.out.print("Would you like to play again? Enter Y or N : ");
		redo = input.next().trim().charAt(0);
		System.out.println();
		}
		while (redo == 'y');
		System.out.println("Thank You for playing!");
		}


	
	//Method for Sum
	public static int getSum(int x, int y, int z) {
		int w = x + y + z;
		return w;	
	}
	//Method for Pair
	public static int getPair(int x, int y, int z) {
		if (x == y) return 2;
		else if (x == z) return 2;
		else if (y == z) return 2;
		else if (x == y && y == z) return 0;
		else return 0;
	}
	//Method for Triple
	public static int getTriple(int x, int y, int z) {
		if (x == y && y == z) return 5;
		else return 0;
	}
	//Method for Straight
	public static int getStraight(int[] roll1) {
		if (roll1[1] == roll1[0]+ 1 && roll1[2] == roll1[0]+2) {
			return 8;
	} 
	else return 0;

	}
	//Method for Random Num
	public static int getRandNum(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
	//Method for FinalSum
	public static int getFinalSum(int x, int y, int z, int a, int b, int c) {
		int w = x + y + z + a + b + c;
		return w;	
	
	}}
