//import java.util.*;
//import java.util.*;

//**********************************
// <Last change>
//  3/12/2018 4:27am - I edited ending part; I put our name!
/*
This java file does
1. making new accounts -> MakingNewAccount(pane)
2. saving the new accounts in text file(so called, "Account.txt") -> MakingNewAccount(pane)
3. loading the accounts -> loadingAccount(pane)
4. reading the information from txt.file ->
5. put players' information into customers[][]
		
		 *  customers[n][1] : playerName;
		 *  customers[n][2] : password
		 *  customers[n][3] : major
		 *  customers[n][4] : bestScore
		 
6. After pressing login button, it shows the player successes to login & information(playername, major, and bestScore) ->loginSuccess
7. in loginSuccess class, I made start button,and I gonna make a connection to game later
==================================================
I gonna edit to 
1. check the ID exists after players type a new playername in MakingNewAccount
2. in loadingAccount, If the code could not find the player's name,
   it gonna ask player whether he or she want to make new account or type again.
3. check password also
****I know this code is really dirty!! I will organize it after finish****
*/


 */
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.*;

public class Account {

	private static  File file = new File("Account.txt");

	PlayerTest player = new PlayerTest();
	String playerName = "";
	String pw = "";
	String major = "";
	String bestScore = "0";
	int bestNum = 0;
	static int option;
	static int numofPpl = 100;
	String[][] customers = new String[numofPpl][4];
	boolean success = false;

	
	public Account() {
		
	}
	public Account(String Name, String password, String maj, String score) {
		// TODO Auto-generated constructor stub
		this.playerName = Name;
		this.pw = password;
		this.major = maj;
		this.bestScore = score;
	}
	
	public void setUserText(String Name)
	{
		this.playerName = Name;
	}

	public void setpwText(String password)
	{
		this.pw = password;
	}

	public void setmajorText(String maj)
	{
		this.major = maj;
	}
	public void setScore(String score, int sc)
	{
		this.bestScore = score;
		this.bestNum = sc;
	}

	public void setNumofPlayer(int n)
	{
		numofPpl = n;
	}
	
	public void  setPlayerInfo(String[] info) {
		
		for(int i = 0,  n = 0; i < numofPpl; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				this.customers[i][j] = info[n];
				n++;
			}
		}
		/*
		 *  customers[n][0] : playerName;
		 *  customers[n][1] : password
		 *  customers[n][2] : major
		 *  customers[n][3] : bestScore
		 */
	}
	public String getplayerInfo(int num, int opt) {
		return customers[num][opt];
	}
	public String getplayerName() {
		return playerName;
	}
	public String getBestScore() {
		return bestScore;
	}
	public String getMajor() {
		return major;
	}
	
	
	public void MakingNewAccount(GridPane pane1) throws Exception
	{				
		
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);

		readingInfo();
		
		Text Jointitle = new Text("Register");
		Jointitle.setFont(Font.font("Press Start K", FontWeight.BOLD, 60));
		Jointitle.setFill(Color.BROWN);
		Jointitle.setTranslateX(0);
		Jointitle.setTranslateY(-180);
	    DropShadow dropShadow = new DropShadow(); 
	    dropShadow.setBlurType(BlurType.GAUSSIAN); 
	    dropShadow.setColor(Color.ROSYBROWN); 
	    dropShadow.setHeight(8); 
	    dropShadow.setWidth(5);
	    dropShadow.setRadius(5); 
	      
	    dropShadow.setOffsetX(3); 
	    dropShadow.setOffsetY(2); 
	      
	    dropShadow.setSpread(12);  

	    Jointitle.setEffect(dropShadow);  
	    
 	    pane1.getChildren().add(Jointitle);
		
		Text title2 = new Text("Hi Hero, welcome to Geisel Library Crawl!");
		title2.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		title2.setTranslateY(-105);
		title2.setFill(Color.WHITE);
		pane1.getChildren().add(title2);
		
		Text title = new Text("Make your account.");
		title.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		title.setTranslateY(-60);
		title.setFill(Color.WHITE);
		
		pane1.setVgap(10);
		pane1.setAlignment(Pos.CENTER);
		pane1.setPadding(new Insets(25, 25, 25, 25));
		
		pane1.add(title, 0, 0 , 2 , 1);
		
		Label userName = new Label("User Name: ");
		userName.setTextFill(Color.WHITE);
		userName.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		pane1.add(userName, 0, 1);
	
		
		final TextField userTextField = new TextField();
		userTextField.setPromptText("User Name");
		userTextField.setTranslateX(220);
		userTextField.setTranslateY(52);
		userTextField.setMaxWidth(300);
		pane1.getChildren().add(userTextField);
		
		
		Label password = new Label("Password: ");
		password.setTextFill(Color.WHITE);
		password.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));

		pane1.add(password, 0, 2);
		
		final PasswordField pwField = new PasswordField();
		pwField.setPromptText("Password");
		pwField.setTranslateX(220);
		pwField.setTranslateY(92);
		pwField.setMaxWidth(300);
		pane1.getChildren().add(pwField);

		Label Major = new Label("Major: ");
		Major.setTextFill(Color.WHITE);
		Major.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));

		pane1.add(Major, 0, 3);
		
		MenuItem major1 = new MenuItem("Computer Science");
		MenuItem major2 = new MenuItem("Mathmatics");
		MenuItem major3 = new MenuItem("Art");
		MenuItem major4 = new MenuItem("History");
		MenuItem major5 = new MenuItem("Psychology");
		
		MenuButton menuButton = new MenuButton("Major   ", null, major1, major2, major3, major4, major5);
		HBox hbox = new HBox(menuButton);
		hbox.setTranslateX(220);
		hbox.setTranslateY(145);
		pane1.getChildren().add(hbox);

		major1.setOnAction(event->{
			setmajorText("Computer Science");
		});
		major2.setOnAction(event->{
			setmajorText("Mathmatics");
		});
		major3.setOnAction(event->{
			setmajorText("Art");
		});
		major4.setOnAction(event->{
			setmajorText("History");
		});
		major5.setOnAction(event->{
			setmajorText("Well..");
		});
		Button btn = new Button("Login");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		pane1.add(hbBtn, 0, 8);

		System.out.println("How many times do i come here?");

		btn.setOnAction((ActionEvent e) -> {
			success = false;

		for(int i = 0; i < numofPpl; i++) {
		if(userTextField.getText().equals(getplayerInfo(i,0)))
		{
			try {
				pane1.getChildren().clear();
				final Text actiontarget = new Text("There is same ID. Give me another playername");
				actiontarget.setTranslateX(170);
				actiontarget.setTranslateY(250);
				actiontarget.setFill(Color.YELLOW);
				actiontarget.setFont(Font.font("Press Start K", FontWeight.BOLD, 15));
				pane1.getChildren().add(actiontarget);

				MakingNewAccount(pane1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			success = true;
		}}
		if(success == false) {

			setUserText(userTextField.getText());
			setpwText(pwField.getText());
			
			try {
				
				bw.write(playerName);
				bw.newLine();
				bw.write(pw);
				bw.newLine();
				bw.write(major);
				bw.newLine();
				bw.write("0");
				bw.newLine();
				bw.flush();
				
				bw.close();
				fw.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		pane1.getChildren().clear();
		loginSuccess(pane1);
		}});	
				
		}
	
	
	public void loadingAccount(GridPane pane1) throws Exception
	{
		readingInfo();
		
		
		Text welbac = new Text("Welcome Back!");
		welbac.setFont(Font.font("Press Start K", FontWeight.BOLD, 60));
		welbac.setFill(Color.BROWN);
		welbac.setTranslateX(0);
		welbac.setTranslateY(-150);
		pane1.getChildren().add(welbac);
		
	    DropShadow dropShadow = new DropShadow(); 
	    dropShadow.setBlurType(BlurType.GAUSSIAN); 
	    dropShadow.setColor(Color.ROSYBROWN); 
	    dropShadow.setHeight(8); 
	    dropShadow.setWidth(5);
	    dropShadow.setRadius(5); 
	      
	    dropShadow.setOffsetX(3); 
	    dropShadow.setOffsetY(2); 
	      
	    dropShadow.setSpread(12);  

	    welbac.setEffect(dropShadow); 
		
		Text title = new Text("Type your account.");
		title.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		title.setTranslateY(-60);
		title.setFill(Color.WHITE);
		
		pane1.setVgap(10);
		pane1.setAlignment(Pos.CENTER);
		pane1.setPadding(new Insets(25, 25, 25, 25));
		
		pane1.add(title, 0, 0 , 2 , 1);
		
		Label userName = new Label("User Name: ");
		userName.setTextFill(Color.WHITE);
		userName.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		pane1.add(userName, 0, 1);
	
		
		final TextField userTextField = new TextField();
		userTextField.setPromptText("User Name");
		userTextField.setTranslateX(220);
		userTextField.setTranslateY(52);
		userTextField.setMaxWidth(300);
		pane1.getChildren().add(userTextField);
		
		
		Label password = new Label("Password: ");
		password.setTextFill(Color.WHITE);
		password.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));

		pane1.add(password, 0, 2);
		
		final PasswordField pwField = new PasswordField();
		pwField.setPromptText("Password");
		pwField.setTranslateX(220);
		pwField.setTranslateY(92);
		pwField.setMaxWidth(300);
		pane1.getChildren().add(pwField);
		
		Button btn = new Button("Login");
		pane1.add(btn, 0, 8);
		btn.setTranslateX(300);
		btn.setTranslateY(0);

		btn.setOnAction((ActionEvent e) -> {
			
			for(int i = 0 ; i < numofPpl ; i++)
			{
				if(userTextField.getText().equals(getplayerInfo(i,0)) && pwField.getText().equals(getplayerInfo(i,1))) //  check there is same ID with it
					{
					success = true;
					setUserText(getplayerInfo(i,0));
					setpwText(getplayerInfo(i,1));
					setmajorText(getplayerInfo(i,2));
					setScore(getplayerInfo(i,3), Integer.parseInt(getplayerInfo(i,3)));
					pane1.getChildren().clear();
					loginSuccess(pane1);

					}
			}
			if(success == false)
			{
			System.out.print("plz no");
			Rectangle back = new Rectangle(1000,800,800,500);
			back.setFill(Color.BLACK);
			back.setTranslateX(-85);
			back.setTranslateY(160);
			pane1.getChildren().add(back);
			
			Text Denying = new Text("Sorry, your account doesn't exist.");
			Denying.setTranslateX(15);
			Denying.setTranslateY(-20);
			Denying.setFill(Color.WHITE);
			Denying.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			pane1.getChildren().add(Denying);
		
			Text asking = new Text("Do you want to make new account?");
			asking.setTranslateX(15);
			asking.setTranslateY(20);
			asking.setFill(Color.WHITE);
			asking.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			pane1.getChildren().add(asking);
			
			Button bt1 = new Button("Making New Account");
			bt1.setTranslateX(160);
			bt1.setTranslateY(150);
			bt1.setTextFill(Color.WHITE);
	        bt1.setStyle("-fx-background-color: transparent");
			bt1.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			
			Label btlabel = new Label("*");
			btlabel.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			btlabel.setTranslateX(50);
			btlabel.setTranslateY(150);
			btlabel.setTextFill(null);
			pane1.getChildren().addAll(bt1,btlabel);
			
			Button bt2 = new Button("Go back to loading page");
			bt2.setTranslateX(110);
			bt2.setTranslateY(220);
			bt2.setTextFill(Color.WHITE);
	        bt2.setStyle("-fx-background-color: transparent");
			bt2.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			
			Label btlabel1 = new Label("*");
			btlabel1.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			btlabel1.setTranslateX(50);
			btlabel1.setTranslateY(220);
			btlabel.setTextFill(null);
			pane1.getChildren().addAll(bt2,btlabel1);
			
			
		    bt1.setOnMouseMoved((effect)->{
		    	btlabel.setTextFill(Color.BROWN);
		    });
		    bt1.setOnMouseExited((effect)->{
		    	btlabel.setTextFill(Color.BLACK);
		    });
		    
		    bt2.setOnMouseMoved((effect)->{
		    	btlabel1.setTextFill(Color.BROWN);
		    });
		    bt2.setOnMouseExited((effect)->{
		    	btlabel1.setTextFill(Color.BLACK);
		    });
		    
			bt1.setOnAction(event->{
				try {
					pane1.getChildren().clear();
					MakingNewAccount(pane1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			bt2.setOnAction(event->{
				try {
					pane1.getChildren().clear();
					loadingAccount(pane1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			}
			});
}
		
	
	
	public void readingInfo() throws Exception {
		
		// This checks whether file exists or not.
		if(!file.exists())
		{
			System.out.println("I made new file!");
			file.createNewFile();
		}	
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		

		String a;
		String[] info = new String[100];

		int num = 0;
		
		while((a = br.readLine()) != null)
		{
			info[num] = a;
			num++;
		}
		
		br.close();
		
		setNumofPlayer(num/4);
		
		setPlayerInfo(info);

		
		}
	
	public void loginSuccess(GridPane pane1)
	{
		
		System.out.print("I enter loginSuccess class");

//		Rectangle border = new Rectangle(100,100,100,100);
//
//		border.setFill(Color.WHITE);
//		border.setTranslateX(-85);
//		border.setTranslateY(-80);
//		border.setStyle("-fx-border-color : white"); 
//		border.setStyle("-fx-border-width : 5");
//		border.setStyle("-fx-border-style : segments(10,15,15,15) line-cap round"); 
//		pane1.getChildren().add(border);
		
		Rectangle back = new Rectangle(1000,800,800,500);
		back.setFill(Color.BLACK);
		back.setTranslateX(-85);
		back.setTranslateY(160);
		pane1.getChildren().add(back);
		
		Text login = new Text("<Login Successfully>");
		login.setFill(Color.WHITE);
		login.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		login.setTranslateX(206);
		login.setTranslateY(-200);
		pane1.getChildren().add(login);
		
		Text userText = new Text("Player Name: ");
		userText.setFill(Color.WHITE);
		userText.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		userText.setTranslateX(135);
		userText.setTranslateY(-130);
		pane1.getChildren().add(userText);
		
		Text user = new Text(getplayerName());
		user.setFill(Color.WHITE);
		user.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		user.setTranslateX(510);
		user.setTranslateY(-130);
		pane1.getChildren().add(user);
		
		Text MajorText = new Text("Major: ");
		MajorText.setFill(Color.WHITE);
		MajorText.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		MajorText.setTranslateX(135);
		MajorText.setTranslateY(-90);
		pane1.getChildren().add(MajorText);
		
		Text Majoris = new Text(getMajor());
		Majoris.setFill(Color.WHITE);
		Majoris.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		Majoris.setTranslateX(510);
		Majoris.setTranslateY(-90);
		pane1.getChildren().add(Majoris);
		
		Text scoreText = new Text("Best Score: ");
		scoreText.setFill(Color.WHITE);
		scoreText.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		scoreText.setTranslateX(135);
		scoreText.setTranslateY(-50);
		pane1.getChildren().add(scoreText);
		
		Text scoreIs = new Text(getBestScore());
		scoreIs.setFill(Color.WHITE);
		scoreIs.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		scoreIs.setTranslateX(510);
		scoreIs.setTranslateY(-50);
		pane1.getChildren().add(scoreIs);
		
		Button start = new Button("Start");
		start.setTextFill(Color.BLACK);
		start.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		start.setTranslateX(370);
		start.setTranslateY(300);
		pane1.getChildren().add(start);
		
		start.setOnAction(event->{
			try {
				pane1.getChildren().clear();
				player.PlayerTest(major);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	public String updateScore(int best) {
		if(best > bestNum)
		{
			bestScore= Integer.toString(best);
			setScore(bestScore,best);			
		}

		return bestScore;
	}

	public void rankingScore(GridPane pane1) throws Exception {
		
		String[][] str = new String[10][2];
		
		readingInfo();
		
		Text Jointitle = new Text("TOP SCORE");
		Jointitle.setFont(Font.font("Press Start K", FontWeight.BOLD, 60));
		Jointitle.setFill(Color.BROWN);
		Jointitle.setTranslateX(450);
		Jointitle.setTranslateY(180);
		
	    DropShadow dropShadow = new DropShadow(); 
	    dropShadow.setBlurType(BlurType.GAUSSIAN); 
	    dropShadow.setColor(Color.ROSYBROWN); 
	    dropShadow.setHeight(8); 
	    dropShadow.setWidth(5);
	    dropShadow.setRadius(5); 
	      
	    dropShadow.setOffsetX(3); 
	    dropShadow.setOffsetY(2); 
	      
	    dropShadow.setSpread(12);  

	    Jointitle.setEffect(dropShadow);  
	    
 	    pane1.getChildren().add(Jointitle);
 	    
		int[] rank = new int[numofPpl];
		
		for(int i  = 0; i < numofPpl ; i++) {
			rank[i] = 1;
			
			for(int j = 0 ; j < numofPpl; j++)
			{
				int iscore = Integer.parseInt(customers[i][3]);
				int jscore = Integer.parseInt(customers[j][3]);
				if(iscore < jscore) {
					rank[i]++;
				}
			}
		}
		
		for(int i = 1 ; i < 10; i++) {
			for(int j = 0; j < numofPpl; j++) {
				if(rank[j] == i ) { // if it exists
					if(!customers[j][0].equals(null)) {
					str[i][0] = customers[j][0]; // username
					str[i][1] = customers[j][3];  // bestScore
					}
				}
			}
		}
		Text text = new Text("Username     Score");
		text.setTranslateX(550);
		text.setTranslateY(300);
		text.setFill(Color.YELLOW);
		text.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		pane1.getChildren().add(text);
		
		for(int i = 1; i < numofPpl+1; i++)
		{
				Text ranknum = new Text(Integer.toString(i));
				ranknum.setTranslateX(450);
				ranknum.setTranslateY(300 + i*45);
				ranknum.setFill(Color.WHITE);
				ranknum.setFont(Font.font("Press Start K", FontWeight.BOLD, 30));
				pane1.getChildren().add(ranknum);
				
				Text rank1 = new Text(str[i][0]);
				rank1.setTranslateX(550);
				rank1.setTranslateY(300+i*45);
				rank1.setFill(Color.WHITE);
				rank1.setFont(Font.font("Press Start K", FontWeight.BOLD, 30));
				pane1.getChildren().add(rank1);
				
				Text rank2 = new Text("   >> " + str[i][1]);
				rank2.setTranslateX(650);
				rank2.setTranslateY(300+i*45);
				rank2.setFill(Color.WHITE);
				rank2.setFont(Font.font("Press Start K", FontWeight.BOLD, 30));
				pane1.getChildren().add(rank2);
						
		}
	}
 		public void Ending(GridPane pane1) {
 			System.out.println("Ending works");
 		   
 			Text endingtitle = new Text("THANK YOU FOR ENJOYING");
 			endingtitle.setFont(Font.font("Press Start K", FontWeight.BOLD, 60));
 			endingtitle.setFill(Color.BROWN);
 			endingtitle.setTranslateX(80);
 			endingtitle.setTranslateY(300);
 		    DropShadow dropShadow = new DropShadow(); 
 		    dropShadow.setBlurType(BlurType.GAUSSIAN); 
 		    dropShadow.setColor(Color.ROSYBROWN); 
 		    dropShadow.setHeight(8); 
 		    dropShadow.setWidth(5);
 		    dropShadow.setRadius(5); 
 		      
 		    dropShadow.setOffsetX(3); 
 		    dropShadow.setOffsetY(2); 
 		      
 		    dropShadow.setSpread(12);  

 		    endingtitle.setEffect(dropShadow);  
 		    
 	 	    pane1.getChildren().add(endingtitle);
			
				    Text made = new Text("Made by: ");
 		    Text makers1 = new Text("Victor Luong");
 		    Text makers2 = new Text("Ivan Cano");
 		    Text makers3 = new Text("Alex Wang");
 		    Text makers4 = new Text("Youngwoo Park");

 			made.setTranslateX(550);
 			made.setTranslateY(500);
 			made.setFill(Color.YELLOW);
 			made.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
 			pane1.getChildren().add(made);
 			
 			makers1.setTranslateX(800);
 			makers1.setTranslateY(500);
 			makers1.setFill(Color.WHITE);
 			makers1.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
 			pane1.getChildren().add(makers1);
 			
 			makers2.setTranslateX(800);
 			makers2.setTranslateY(550);
 			makers2.setFill(Color.WHITE);
 			makers2.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
 			pane1.getChildren().add(makers2);
 			
 			makers3.setTranslateX(800);
 			makers3.setTranslateY(600);
 			makers3.setFill(Color.WHITE);
 			makers3.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
 			pane1.getChildren().add(makers3);
 			
 			makers4.setTranslateX(800);
 			makers4.setTranslateY(650);
 			makers4.setFill(Color.WHITE);
 			makers4.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
 			pane1.getChildren().add(makers4);
 		    
 		    
 		    
 	 	    pane1.getChildren().add(endingtitle);
 		}
 		

	}


