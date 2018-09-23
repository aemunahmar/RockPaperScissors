//Developed by Aemun Ahmar 1047508
//CSCI 125 M04 Fall 2016
//Professor Wenjia Li
//Homework 3: Rock, Paper, Scissors
//Date Created: December 8, 2016

import javax.swing.JOptionPane;

public class RockPaperScissors 
{
	public static void main(String[] args)
	{
		//Prints the introduction
		PrintIntro();
		
		//Initializing variables and arrays
		String playAgain;
		int totalGames = 0;
		String[] gameLog = new String[50];

		do
		{
			//Saves the results 
			gameLog[totalGames] = CalculateResult();
			
			totalGames++;
			//Asks if the user want s to play again
			playAgain = JOptionPane.showInputDialog("Do you want to play again?\nOnly type yes or no");
			
			if(playAgain.equals("No") || playAgain.equals("no"))
			{	
				//Copies the elements in the old game log array to the new game log array
				String[] newGameLog = new String[totalGames];
				for(int i = 0; i < newGameLog.length; i++)
				{
					newGameLog[i] = gameLog[i]; 
				}
				
				//Prints out the log in the DOS Console
				System.out.println("GAME LOG\n" + "------------------------------\n");
				for(int i = 0; i < newGameLog.length; i++)
				{
					System.out.println("Game " + (i+1) + ":\n" + newGameLog[i]+ "\n");
				}
				System.out.println("------------------------------"+"\nThanks for playing!!");
			}
		}while(playAgain.equals("Yes") || playAgain.equals("yes"));
	}
	
	/****This method will just print an introduction when the user starts the program.
	 **** The introduction is an explanation of what the rules are for the game.****/
	public static void PrintIntro()
	{
		JOptionPane.showMessageDialog(null, "Welcome to Rock, Paper, Scissor!\n"
				+ "\nLet me remind you the rule first:" + "\n1. Scissor cuts paper "
				+ "\n2. Paper covers rock \n3. Rock breaks scissors");
	}
	
	/****This method will ask for the user's choice. It will also make sure that the user only
	 ****only inputs a valid choice. If not, the program will prompt an error message.****/
	public static int UserChoice()
	{
		int yourChoice;
		String yourInput;
		do
		{
			yourInput = JOptionPane.showInputDialog("Enter one of the following as your choice:\n"
					+ "\n0: Rock \n1: Paper \n2: Scissors");
			yourChoice = Integer.parseInt(yourInput);
			if(yourChoice < 0 || yourChoice > 2)
			{
				JOptionPane.showMessageDialog(null, "You can only choose 0, 1, or 2. \nTry again.");
			}
		}while(yourChoice < 0 || yourChoice > 2);
		
		return yourChoice;		
	}
	
	/****This method will randomly generate a choice for the computer.****/
	public static int ComputerChoice()
	{
		int computerChoice;
		
		//Get computer choice
		computerChoice = (int)(Math.random()*10); //generate a random number
		computerChoice %= 3; //Why we need to modulus 3 here? Think about it.
		
		return computerChoice;
	}

	/****This method will compare your choice with the computer's choice and will decide if 
	 ****you win, lose, or if both are tied.****/
	public static String CalculateResult()
	{
		int yourChoice = UserChoice();
		String yourMove = Integer.toString(yourChoice);
		
		//Your number input to corresponding move
		if(yourChoice == 0)
		{
			yourMove = "Rock";
		} else if(yourChoice == 1)
		{
			yourMove = "Paper";
		} else
		{
			yourMove = "Scissors";
		}
		
		int computerChoice = ComputerChoice();
		String computerMove = Integer.toString(computerChoice);
		
		//Changing computer number to corresponding move
		if(computerChoice == 0)
		{
			computerMove = "Rock";
		} else if(computerChoice == 1)
		{
			computerMove = "Paper";
		} else 
		{
			computerMove = "Scissors";
		}

		//Case I: Both you and computer pick the same choice, then it's a tie!
		if(yourChoice == computerChoice)
		{
			JOptionPane.showMessageDialog(null, "You both chose: " + yourMove + "\nIt's a tie!");
			return "You both chose: " + yourMove + "\nIt's a tie!";
		}
		
		//Case II: You win
		else if(yourChoice == 1 && computerChoice == 0)
		{
			JOptionPane.showMessageDialog(null, "You chose: " + yourMove + "\nThe computer chose: " 
					+ computerMove + "\nPaper beats Rock.\n" + "\nCongratulations! You win!!");
			
			return "You chose: " + yourMove + "\nThe computer chose: " 
				+ computerMove + "\nPaper beats Rock.\n" + "\nCongratulations! You win!!";
		} else if (yourChoice == 0 && computerChoice == 2)
		{
			JOptionPane.showMessageDialog(null, "You chose: " + yourMove + "\nThe computer chose: " 
					+ computerMove + "\nRock beats Scissor.\n" + "\nCongratulations! You win!!");
			
			return "You chose: " + yourMove + "\nThe computer chose: " 
				+ computerMove + "\nRock beats Scissor.\n" + "\nCongratulations! You win!!";
		} else if (yourChoice == 2 && computerChoice == 1)
		{
			JOptionPane.showMessageDialog(null, "You chose: " + yourMove + "\nThe computer chose: " 
					+ computerMove + "\nScissor beats Paper.\n" + "\nCongratulations! You win!!");
			
			return "You chose: " + yourMove + "\nThe computer chose: " 
				+ computerMove + "\nScissor beats Paper.\n" + "\nCongratulations! You win!!";
		}
		
		//Case III: You lose 
		else if(yourChoice == 0 && computerChoice == 1)
		{
			JOptionPane.showMessageDialog(null, "You chose: " + yourMove + "\nThe computer chose: " 
					+ computerMove + "\n\nPaper beats Rock. Sorry, you lose.");
			
			return "You chose: " + yourMove + "\nThe computer chose: " 
				+ computerMove + "\n\nPaper beats Rock. You lost.";
		} else if(yourChoice == 2 && computerChoice == 0)
		{
			JOptionPane.showMessageDialog(null,  "You chose: " + yourMove + "\nThe computer chose: " 
					+ computerMove + "\n\nRock beats Scissors. Sorry you lose.");
			
			return "You chose: " + yourMove + "\nThe computer chose: " 
				+ computerMove + "\n\nRock beats Scissors. You lost.";
		} else
		{
			JOptionPane.showMessageDialog(null, "You chose: " + yourMove + "\nThe computer chose: " 
					+ computerMove + "\n\nScissor beats Paper. Sorry, you lose.");
			
			return "You chose: " + yourMove + "\nThe computer chose: " 
				+ computerMove + "\n\nRock beats Scissors. You lost.";
		}
	}
}