import java.util.*;
import java.io.IOException;
import java.io.*;
import java.io.FileNotFoundException;

/*
 *  I don't finish yet, so not use for now. SORRRYYYYYY 
 */
public class Account {

	static String playerName;
	static String major;
	static int bestScore = 0;
	static int option;
	
	public Account(String Name, String maj, int score) {
		// TODO Auto-generated constructor stub
		this.playerName = Name;
		this.major = maj;
		this.bestScore = score;
	}

	public String getplayerName() {
		return playerName;
	}
	
	public String major() {
		return major;
	}
	
	
	public static Account MakingNewAccount() throws Exception
	{
		int majorI;
		String file = "Account.txt";
		
		Scanner input = new Scanner(System.in);

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
	
		//name
		System.out.println("Hi Hero");
		System.out.println("Welcome to our Gisel Library");
		System.out.println("We need your help");
		System.out.print("What is your name: ");
		playerName = input.next();
		
		//major
	do{
		System.out.println(playerName + "! Which major character do you want to play?");
		System.out.println("1. Computer Science ");
		System.out.println("2. History");
		System.out.println("3. Art");
		System.out.println("4. ");	
		
		majorI = input.nextInt();
		
		switch(majorI)
		{
		case 1: major = "Computer Scinece"; System.out.println("You choose Computer Science! Is it correct?"); break;
		case 2: major = "History"; System.out.println("You choose History! Is it correct?"); break;
		case 3: major = "Art"; System.out.println("You choose Art! Is it correct?"); break;
		case 4: major = " "; System.out.println("You choose ! Is it correct?");break;
		default: System.out.println("You choose out of range. Please choose again"); break;
		}
		
		System.out.println("Press 1, if it is right. Otherwise, press other key");
		option = input.nextInt();
		
	}while(option != 1 || majorI > 4 || majorI <1);
		
		bestScore = 0;
		
		Account account = new Account(playerName , major, bestScore);

		fw.write(playerName);
		fw.write(major);
		fw.write(bestScore);
		
		fw.close();
				
		return account;
	}

}
