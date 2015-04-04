import java.io.*;
import java.util.*;

public class Trivia {

	public static void main(String[] args) {
		
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<String> questionStrings = new ArrayList<String>();
		ArrayList<Player> players = new ArrayList<Player>();
		
		
		
		File questionFile = new File("Questions.dat");
		Scanner questionScanner = null;
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		int numPlayers = 0;
		int lineCount=0;
		int pin=-1;
		try{
			questionScanner = new Scanner(questionFile);
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		while(questionScanner.hasNext()) {
			questions.add(new Question(questionScanner.nextLine()));
			lineCount++;
		}
		System.out.print("How many players will there be?: ");
		input = keyboard.nextLine();
		boolean notInteger=true;
		while (numPlayers < 2 && notInteger) {
			try {
				numPlayers = Integer.parseInt(input);
				notInteger=false;
				if (numPlayers < 2) {
					System.out.println("There must be at least two players.");
					System.out.print("How many players will there be?: ");
					input = keyboard.nextLine();
					notInteger=true;
				}

			} catch(NumberFormatException e) {
				notInteger=true;
				System.out.print("Error: invalid input!\nHow many players will there be?: ");
				input = keyboard.nextLine();
			}
		}
		for(int i=0; i<numPlayers; i++){
			players.add(new Player());
			System.out.print("Enter Player Name: ");
			players.get(i).setName(keyboard.nextLine());
			System.out.print("Enter Player Pin: ");
			pin= validatePin(keyboard.nextLine());
			players.get(i).setPin(pin);
			System.out.println("");
			
			
		}
		
		int randomNum=-1;
		boolean underSix=true;
		
		for(int counter=0; counter<6; counter++){
			randomNum=random(questions.size());
			for(int i=0; i<numPlayers; i++){
				System.out.println(players.get(i).getName()+"'s Turn\n");
				System.out.println(questions.get(randomNum).getQuestion());
				for (int k = 0; k < 4; k++) {
					System.out.println(questions.get(randomNum).getAnswers()[k]);
				}
				System.out.print("Answer: ");
				String answerChoice= keyboard.nextLine();
				if(answerChoice.equalsIgnoreCase(questions.get(randomNum).getRightAnswer())){
					System.out.println("You are right");
					players.get(i).addPoint();
				}
				else{
					System.out.println("You are wrong");
				}
				
			}	
			questions.remove(randomNum);
			for(int i=0; i<numPlayers; i++){
				System.out.println(players.get(i).getName()+"'s Points: "+players.get(i).getPoints());
			}
			
		}
			
			
		}
	
	public static int random(int num){
	
		Random generator= new Random ();
		int randomNumber;
		randomNumber= generator.nextInt(num);
		return randomNumber;
	}	
	
	public static int validatePin (String str)
	{
		Scanner keyboard= new Scanner(System.in);
		int number=-1;
		boolean isItInt=false;
		boolean fourDigit=false;
		while (isItInt==false&& fourDigit==false)
		{
			try
			{	
				number= Integer.parseInt(str);
				isItInt=true;
				if(str.length()==4)
				{
					fourDigit=true;
				}
				else
				{
					isItInt=false;
					System.out.print("Pin must be four digits\n Please enter a new pin:");
					str= keyboard.nextLine();
				}
			}
			catch(NumberFormatException n)
			{
				isItInt=false;
				System.out.print("Error: Enter a number:");
				str= keyboard.nextLine();		
			}
		}
		return number;
	}
	
}
