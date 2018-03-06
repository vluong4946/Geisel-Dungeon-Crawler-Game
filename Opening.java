import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
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

//import java.awt.BorderLayout;
//import javax.swing.*;

public class Opening extends Application {

	
	public static void Opening(Stage primaryStage) throws Exception {
	    
	}
	
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		GridPane pane1 = new GridPane();

		Scene scene,scene1;
		
		String file = "Account.txt";

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		Account account = new Account();

		//primaryStage.setScene(new Scene(createContent()));
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

		pane.getChildren().addAll(btlabel,loadlabel, ranklabel,quitlabel);
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
					Account.MakingNewAccount(pane1);
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
	    
	    rank.setOnMouseMoved((effect)->{
	    	ranklabel.setTextFill(Color.BROWN);
	    });
	    rank.setOnMouseExited((effect)->{
	    	ranklabel.setTextFill(Color.BLACK);
	    });
	    quit.setOnMouseMoved((effect)->{
	    	quitlabel.setTextFill(Color.BROWN);
	    });
	    quit.setOnMouseExited((effect)->{
	    	quitlabel.setTextFill(Color.BLACK);
	    });
	}
	
	public static void main(String [] args)
	{
		Application.launch(args);
	}

	
}
