//import java.util.*;

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

	String playerName = "";
	String pw = "";
	String major;
	String bestScore = "0";
	static int option;
	static int numofPpl = 100;
	String[][] customers = new String[numofPpl][4];
	
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
	public void setScore(String score)
	{
		this.bestScore = score;
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
		 *  customers[n][1] : playerName;
		 *  customers[n][2] : password
		 *  customers[n][3] : major
		 *  customers[n][4] : bestScore
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
		MenuItem major5 = new MenuItem("Well..");
		
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

		

		btn.setOnAction((ActionEvent e) -> {

		setUserText(userTextField.getText());
		setpwText(pwField.getText());

		for(int i = 0; i < numofPpl; i++)
		if(userTextField.getText() == customers[i][0])
		{
			final Text actiontarget = new Text("There is same ID. Give me another playername");
			pane1.add(actiontarget,1, 6);
			
		}
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
		

		System.out.println("Player " + playerName);
		System.out.println("Password " + pw);

		});	
				
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
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		pane1.add(hbBtn, 0, 8);

		btn.setOnAction((ActionEvent e) -> {
			
			for(int i = 0 ; i < numofPpl ; i++)
			{
				System.out.print(userTextField.getText() +" ");
				System.out.println(customers[i][0]);
				if(userTextField.getText().equals(getplayerInfo(i,0))) //  check there is same ID with it
					{
					setUserText(getplayerInfo(i,0));
					setpwText(getplayerInfo(i,1));
					setmajorText(getplayerInfo(i,2));
					setScore(getplayerInfo(i,3));
					loginSuccess(pane1);
					}
			}
			/*
			Text Denying = new Text("Sorry, your account doesn't exist.");
			Denying.setTranslateX(0);
			Denying.setTranslateY(0);
			Denying.setFill(Color.WHITE);
			Denying.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			pane1.getChildren().add(Denying);
		
			Text asking = new Text("Do you want to make new account?");
			asking.setTranslateX(50);
			asking.setTranslateY(0);
			asking.setFill(Color.WHITE);
			asking.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			pane1.getChildren().add(asking);
			
			Button bt1 = new Button("");
			bt1.setTranslateX(80);
			bt1.setTranslateY(80);
			bt1.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			pane1.getChildren().add(bt1);
			
			Button bt2 = new Button("");
			bt2.setTranslateX(80);
			bt2.setTranslateY(190);
			bt2.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
			pane1.getChildren().add(bt2);
			System.out.print("Why am i here?");
		*/
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
		
		Rectangle back = new Rectangle(1000,800,800,500);
		back.setFill(Color.BLACK);
		back.setTranslateY(-80);
		back.setTranslateY(160);
		pane1.getChildren().add(back);
		
		Text login = new Text("<Login Successfully>");
		login.setFill(Color.WHITE);
		login.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		login.setTranslateX(200);
		login.setTranslateY(0);
		pane1.getChildren().add(login);
		
		Text userText = new Text("Player Name: ");
		userText.setFill(Color.WHITE);
		userText.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		userText.setTranslateX(100);
		userText.setTranslateY(70);
		pane1.getChildren().add(userText);
		
		Text user = new Text(getplayerName());
		user.setFill(Color.WHITE);
		user.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		user.setTranslateX(500);
		user.setTranslateY(70);
		pane1.getChildren().add(user);
		
		Text MajorText = new Text("Major: ");
		MajorText.setFill(Color.WHITE);
		MajorText.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		MajorText.setTranslateX(100);
		MajorText.setTranslateY(140);
		pane1.getChildren().add(MajorText);
		
		Text Majoris = new Text(getMajor());
		Majoris.setFill(Color.WHITE);
		Majoris.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		Majoris.setTranslateX(500);
		Majoris.setTranslateY(140);
		pane1.getChildren().add(Majoris);
		
		Text scoreText = new Text("Best Score: ");
		scoreText.setFill(Color.WHITE);
		scoreText.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		scoreText.setTranslateX(100);
		scoreText.setTranslateY(210);
		pane1.getChildren().add(scoreText);
		
		Text scoreIs = new Text(getBestScore());
		scoreIs.setFill(Color.WHITE);
		scoreIs.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		scoreIs.setTranslateX(500);
		scoreIs.setTranslateY(210);
		pane1.getChildren().add(scoreIs);
		
		Button start = new Button("Start");
		start.setTextFill(Color.BLACK);
		start.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		start.setTranslateX(330);
		start.setTranslateY(300);
		pane1.getChildren().add(start);
	}

	public String updateScore(int best) {
		bestScore= Integer.toString(best);
		setScore(bestScore);
		return bestScore;
	}

}

