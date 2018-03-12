import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.*;

/*****************************************************************
 * It is definitely made for Opening Screen. 
 * It shows the title with our group name.
 * And there are four buttons:
 * start New Game, Load a Game, See the Rank, Quit the Game
 * and I made event handler for each buttons which are in Account
 * ***************************************************************
 *  What I GONNA DO
 *  1. I think if there is any back ground or something else, it would be coool
 *  2. Comment all functions
 *  
 *  As you guys know, my English is not fluence as u
 *  so if the word is weird, change it and tell me
 */

public class Opening extends Application {

		private static Account account; // yes account of course
		//static Stage primaryStage;
		/*
		 * If you want to call the Opening java file, call this
		 */
	public void Opening(Stage primaryStage) throws Exception {
		
		//Application.launch(GameGui.class,args);
		
		GridPane pane = new GridPane(); // It is first page which contains title, and buttons
		GridPane pane1 = new GridPane(); // It is Gridpane which gonna be called by 

		Scene scene,scene1;
		
		account = new Account(); 

		primaryStage.centerOnScreen();
		primaryStage.show();
		
	    scene = new Scene(pane,1500, 1000);
	    scene1 = new Scene(pane1, 1500, 1000);

	    primaryStage.setScene(scene);
	    primaryStage.setTitle("OpeningPage"); // Set the stage title
	    
	    // Title
	    Label label = new Label("Geisel Library Crawl");
	    label.setTextFill(Color.BROWN);
	    label.setFont(Font.font("Press Start K", FontWeight.BOLD, 50));
	    label.setTranslateX(250);
	    label.setTranslateY(180);
	    
		Label copyRight = new Label("©2018 THE SALTY SPITOON");
		copyRight.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		copyRight.setTranslateX(500);
		copyRight.setTranslateY(250);
	    copyRight.setTextFill(Color.WHITE);
	    
		DropShadow dropShadow = new DropShadow(); 
	    dropShadow.setBlurType(BlurType.GAUSSIAN); 
	    dropShadow.setColor(Color.ROSYBROWN); 
	    dropShadow.setHeight(8); 
	    dropShadow.setWidth(5);
	    dropShadow.setRadius(5);
	    dropShadow.setOffsetX(3); 
	    dropShadow.setOffsetY(2); 
	    dropShadow.setSpread(12);  

	    label.setEffect(dropShadow);  
	    
 	    pane.getChildren().add(label);
	    
 	    // buttons
		Button bt = new Button();
		Button load = new Button();
		Button rank = new Button();
		Button quit = new Button();
		
		bt.setText("Start New Game");
		bt.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		bt.setTextFill(Color.WHITE);		
		bt.setTranslateX(570);
		bt.setTranslateY(500);
		bt.setMaxSize(350, 500);
        bt.setStyle("-fx-background-color: transparent");
  
		Label btlabel = new Label("*                * ");
		btlabel.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		btlabel.setTranslateX(568);
		btlabel.setTranslateY(500);
		btlabel.setMaxSize(450, 500);
		btlabel.setTextFill(null);
		
		load.setText("Load a Game");
		load.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		load.setTextFill(Color.WHITE);		
		load.setTranslateX(600);
		load.setTranslateY(600);
		load.setMaxSize(280, 500);
        load.setStyle("-fx-background-color: black");
		Label loadlabel = new Label("*                * ");
		loadlabel.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		loadlabel.setTranslateX(568);
		loadlabel.setTranslateY(600);
		loadlabel.setMaxSize(450, 500);
		loadlabel.setTextFill(null);
		
		rank.setText("See the Rank");
		rank.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		rank.setTextFill(Color.WHITE);		
		rank.setTranslateX(600);
		rank.setTranslateY(700);
		rank.setMaxSize(300, 500);
        rank.setStyle("-fx-background-color: black");
		Label ranklabel = new Label("*                * ");
		ranklabel.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		ranklabel.setTranslateX(568);
		ranklabel.setTranslateY(700);
		ranklabel.setMaxSize(450, 500);
		ranklabel.setTextFill(null);

		quit.setText("Quit the Game");
		quit.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		quit.setTextFill(Color.WHITE);		
		quit.setTranslateX(600);
		quit.setTranslateY(800);
		quit.setMaxSize(300, 500);
        quit.setStyle("-fx-background-color: black");
		Label quitlabel = new Label("*                * ");
		quitlabel.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		quitlabel.setTranslateX(568);
		quitlabel.setTranslateY(800);
		quitlabel.setMaxSize(450, 500);
		quitlabel.setTextFill(null);

		pane.getChildren().addAll(copyRight,btlabel,loadlabel, ranklabel,quitlabel);
		pane.getChildren().addAll(load,bt,rank,quit);
		
	    pane.setStyle("-fx-background-color: black;");
	    pane1.setStyle("-fx-background-color: black;");
	    
	    // event handlers
	    // As you see there are three event handler per each button
	    // because i want to change the screen whether the mouse on or not on the button(not sure u guys can understand my word:(!)
	    
	    // making new account buttons
	    bt.setOnMouseMoved((effect)->{
	    	btlabel.setTextFill(Color.BROWN);
	    });
	    bt.setOnMouseExited((effect)->{
	    	btlabel.setTextFill(Color.BLACK);
	    });
	    bt.setOnAction((ActionEvent e) -> {
	    		primaryStage.setScene(scene1);
			    try {
					account.MakingNewAccount(pane1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	    
	    //loading the save file button
	    load.setOnMouseMoved((effect)->{
	    	loadlabel.setTextFill(Color.BROWN);
	    });
	    load.setOnMouseExited((effect)->{
	    	loadlabel.setTextFill(Color.BLACK);
	    });
	    
	    load.setOnAction((ActionEvent e)->{
	    	primaryStage.setScene(scene1);
	    	try {
				account.loadingAccount(pane1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    
	    // see the rank button
	    rank.setOnMouseMoved((effect)->{
	    	ranklabel.setTextFill(Color.BROWN);
	    });
	    rank.setOnMouseExited((effect)->{
	    	ranklabel.setTextFill(Color.BLACK);
	    });
	    rank.setOnAction((ActionEvent e)->{
	    	primaryStage.setScene(scene1);
	    	try {
				account.rankingScore(pane1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    
	    // quit the game button
	    quit.setOnMouseMoved((effect)->{
	    	quitlabel.setTextFill(Color.BROWN);
	    });
	    quit.setOnMouseExited((effect)->{
	    	quitlabel.setTextFill(Color.BLACK);
	    });
	    quit.setOnAction((ActionEvent e)->{
	    	primaryStage.setScene(scene1);
	    	try {
				account.Ending(pane1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	}
	
	// It is made for testing. Therefore, u can test from here
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		GridPane pane1 = new GridPane();

		Scene scene,scene1;
		
		account = new Account();

		primaryStage.centerOnScreen();
		primaryStage.show();
		
	    scene = new Scene(pane,1500, 1000);
	    scene1 = new Scene(pane1, 1500, 1000);

	    primaryStage.setScene(scene);
	    primaryStage.setTitle("OpeningPage"); // Set the stage title
	    
	    
	    Label label = new Label("Geisel Library Crawl");
	    label.setTextFill(Color.BROWN);
	    label.setFont(Font.font("Press Start K", FontWeight.BOLD, 50));
	    label.setTranslateX(250);
	    label.setTranslateY(180);
	    
		Label copyRight = new Label("©2018 THE SALTY SPITOON");
		copyRight.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		copyRight.setTranslateX(500);
		copyRight.setTranslateY(250);
	    copyRight.setTextFill(Color.WHITE);
	    
		DropShadow dropShadow = new DropShadow(); 
	    dropShadow.setBlurType(BlurType.GAUSSIAN); 
	    dropShadow.setColor(Color.ROSYBROWN); 
	    dropShadow.setHeight(8); 
	    dropShadow.setWidth(5);
	    dropShadow.setRadius(5);
	    dropShadow.setOffsetX(3); 
	    dropShadow.setOffsetY(2); 
	    dropShadow.setSpread(12);  

	    label.setEffect(dropShadow);  
	    
 	    pane.getChildren().add(label);
	    
		Button bt = new Button();
		Button load = new Button();
		Button rank = new Button();
		Button quit = new Button();
		
		bt.setText("Start New Game");
		bt.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		bt.setTextFill(Color.WHITE);		
		bt.setTranslateX(570);
		bt.setTranslateY(500);
		bt.setMaxSize(350, 500);
        bt.setStyle("-fx-background-color: transparent");
  
		Label btlabel = new Label("*                * ");
		btlabel.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		btlabel.setTranslateX(568);
		btlabel.setTranslateY(500);
		btlabel.setMaxSize(450, 500);
		btlabel.setTextFill(null);
		
		load.setText("Load a Game");
		load.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		load.setTextFill(Color.WHITE);		
		load.setTranslateX(600);
		load.setTranslateY(600);
		load.setMaxSize(280, 500);
        load.setStyle("-fx-background-color: black");
		Label loadlabel = new Label("*                * ");
		loadlabel.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		loadlabel.setTranslateX(568);
		loadlabel.setTranslateY(600);
		loadlabel.setMaxSize(450, 500);
		loadlabel.setTextFill(null);
		
		rank.setText("See the Rank");
		rank.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		rank.setTextFill(Color.WHITE);		
		rank.setTranslateX(600);
		rank.setTranslateY(700);
		rank.setMaxSize(300, 500);
        rank.setStyle("-fx-background-color: black");
		Label ranklabel = new Label("*                * ");
		ranklabel.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		ranklabel.setTranslateX(568);
		ranklabel.setTranslateY(700);
		ranklabel.setMaxSize(450, 500);
		ranklabel.setTextFill(null);

		quit.setText("Quit the Game");
		quit.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		quit.setTextFill(Color.WHITE);		
		quit.setTranslateX(600);
		quit.setTranslateY(800);
		quit.setMaxSize(300, 500);
        quit.setStyle("-fx-background-color: black");
		Label quitlabel = new Label("*                * ");
		quitlabel.setFont(Font.font("Press Start K", FontWeight.BOLD, 20));
		quitlabel.setTranslateX(568);
		quitlabel.setTranslateY(800);
		quitlabel.setMaxSize(450, 500);
		quitlabel.setTextFill(null);

		pane.getChildren().addAll(copyRight,btlabel,loadlabel, ranklabel,quitlabel);
		pane.getChildren().addAll(load,bt,rank,quit);
	    pane.setStyle("-fx-background-color: black;");
	    
	    pane1.setStyle("-fx-background-color: black;");
	    bt.setOnMouseMoved((effect)->{
	    	btlabel.setTextFill(Color.BROWN);
	    });
	    bt.setOnMouseExited((effect)->{
	    	btlabel.setTextFill(Color.BLACK);
	    });
	    bt.setOnAction((ActionEvent e) -> {
	    		primaryStage.setScene(scene1);
			    try {
					account.MakingNewAccount(pane1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	    
	    load.setOnMouseMoved((effect)->{
	    	loadlabel.setTextFill(Color.BROWN);
	    });
	    load.setOnMouseExited((effect)->{
	    	loadlabel.setTextFill(Color.BLACK);
	    });
	    
	    load.setOnAction((ActionEvent e)->{
	    	primaryStage.setScene(scene1);
	    	try {
				account.loadingAccount(pane1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    rank.setOnMouseMoved((effect)->{
	    	ranklabel.setTextFill(Color.BROWN);
	    });
	    rank.setOnMouseExited((effect)->{
	    	ranklabel.setTextFill(Color.BLACK);
	    });
	    rank.setOnAction((ActionEvent e)->{
	    	primaryStage.setScene(scene1);
	    	try {
				account.rankingScore(pane1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	    quit.setOnMouseMoved((effect)->{
	    	quitlabel.setTextFill(Color.BROWN);
	    });
	    quit.setOnMouseExited((effect)->{
	    	quitlabel.setTextFill(Color.BLACK);
	    });
	    quit.setOnAction((ActionEvent e)->{
	    	primaryStage.setScene(scene1);
	    	try {
				account.Ending(pane1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
	}
	public static void main(String [] args)
	{
		Application.launch(args);
	}

	
}
