import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Trivia {

	public static void main(String[] args) {
		
		ArrayList<Question> questions = new ArrayList<Question>();
		ArrayList<String> questionStrings = new ArrayList<String>();
		ArrayList<Player> players = new ArrayList<Player>();
		
		File questionFile = null
		Scanner questionScanner = null;
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		int numPlayers = 0;
		
		while(noFile){ //loops for correct file
			System.out.print("Enter Question File: ");
			fileName= keyboard.nextLine();
			questionFile=new File(fileName);
			try{
				questionScanner = new Scanner(questionFile);
				noFile=false;
			} catch(FileNotFoundException e) {
				System.out.println("File not found");
				noFile= true;
			}
		}
		Question q = null;
		while(questionScanner.hasNext()) {
			q = new Question(questionScanner.nextLine());
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
		System.out.println(q.getQuestion());
		for (int i = 0; i < 4; i++) {
			System.out.println(q.getAnswers()[i]);
		}
		System.out.println(q.getRightAnswer());
	}
}
