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
		
		Question q = null;
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
		int randomNum= random(lineCount);
		System.out.println(questions.get(randomNum).getQuestion());
		for (int i = 0; i < 4; i++) {
			System.out.println(questions.get(randomNum).getAnswers()[i]);
		}
		//System.out.println(q.getRightAnswer());
		while(questionScanner.hasNextLine()){
		}
		//System.out.println(random(lineCount));
		
	}
	public static int random(int num){
	
		Random generator= new Random ();
		int randomNumber;
		randomNumber= generator.nextInt(num);
		return randomNumber;
	}	
}
