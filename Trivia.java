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
		while (numPlayers < 2) {
			try {
				numPlayers = Integer.parseInt(input);
				if (numPlayers < 2) {
					System.out.println("There must be at least two players.");
					System.out.print("How many playerswill there be?: ");
					input = keyboard.nextLine();
				}
			} catch(NumberFormatException e) {
				
			}
		}
		for(int i=0; i<numPlayers; i++){
			players.add(new Player());
			System.out.print("Enter Player Name: ");
			players.get(i).setName(keyboard.nextLine());
			System.out.print("Enter Player Pin: ");
			players.get(i).setPin(keyboard.nextInt());
			System.out.println("");
			keyboard.nextLine();
			
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
	}
	public static int random(int num){
	
		Random generator= new Random ();
		int randomNumber;
		randomNumber= generator.nextInt(num);
		return randomNumber;
	}	
}
