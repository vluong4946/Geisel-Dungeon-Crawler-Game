import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This class contains the code used for the beginning screen (account creation 
 * and logging in). It creates the GUI used for gameplay. It contains the movement
 * controls for the player (WASD-Keys). 
 * 
 * NOTES: 
 * Will likely split this into multiple classes later on, and make code more
 * readable and concise with more methods. 
 *
 */
public class Dungeon extends Application{

	//Create array for playing field
	int[][] arena = ArenaArray.createArenaArray();
	
	private ArrayList<Shape> nodes;
	
	private Parent createContent() {
		nodes = new ArrayList<>();
		GridPane root = new GridPane();
		root.setPrefSize(1500, 1000);
		human = initHuman();
		
		//**** will redo resolution later on hopefully...
		for (int x = 0; x < arena.length; x++){
		    for (int y = 0; y < arena[x].length; y++){
		    	if (arena[x][y]==3) { //REPLACE MAGIC NUMBERS -Victor
		    		root.add(new Rectangle(10, 10, Color.BLACK), x, y);
		    		nodes.add(new Rectangle(10, 10, Color.BLACK));}
		    	else if (arena[x][y]==2) { 
			    	root.add(new Rectangle(10, 10, Color.PINK), x, y);
		    		nodes.add(new Rectangle(10, 10, Color.PINK));}
		    	else if (arena[x][y]==1) {
			    	root.add(new Rectangle(10, 10, Color.WHITE), x, y);
		    		nodes.add(new Rectangle(10, 10, Color.WHITE));}
		    	else {
		    	root.add(new Rectangle(10, 10, Color.WHITE), x, y);
		    	nodes.add(new Rectangle(10, 10, Color.WHITE));}
		    }
		}
		
		root.add(human,75,50);
		return root;
	}
	
	private Node human;

	
	private Node initHuman() {
		Rectangle human = new Rectangle(10, 10, Color.AQUA);
		return human;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {


		GridPane pane = new GridPane();
		GridPane pane1 = new GridPane();
			
		Button bt1,bt2,bt3,bt4;
		
		Scene scene,scene1;
		Scene sc = new Scene(createContent());
		
		//primaryStage.setScene(new Scene(createContent()));

		primaryStage.centerOnScreen();
		primaryStage.show();
		
	    scene = new Scene(pane,2000,1000);
	    scene1 = new Scene(pane1,500,800);

	    primaryStage.setScene(scene);

	    Label label = new Label("Geisel Library Crawl");
	    label.setTextFill(Color.BROWN);
	    label.setFont(Font.font("MONOSPACED", FontWeight.BOLD, 80));
	    
		bt1 = new Button();
		bt2 = new Button();
		bt3 = new Button();
		bt4 = new Button();
		
		bt1.setText("Create New Account");
		bt2.setText("WORKING"); // Call your file
		bt3.setText("WORKING"); // See the rank
		bt4.setText("WORKING"); // quit
		
	    pane.getChildren().add(label);
	    
	    pane.add(bt1,0,8);
	    pane.add(bt2, 0, 10);
	    pane.add(bt3, 5, 8);
	    pane.add(bt4, 5, 10);
	    pane.setPadding(new Insets(180,100,100,500));
		
	    pane.setVgap(10);
		pane.setHgap(10);
	    
	    bt1.setOnAction((ActionEvent e) -> {
	   	
	    if(e.getSource() == bt1)
			primaryStage.setScene(scene1);
		});
	    
		pane1.setVgap(10);
		pane1.setAlignment(Pos.CENTER);
		pane1.setPadding(new Insets(25, 25, 25, 25));
		
		Text title = new Text("Hi Hero, Make your account");
		title.setFont(Font.font("MONOSPACED", FontWeight.BOLD, 20));
		//title.setFill(Color.BLACK);
		
		pane1.add(title, 0, 0 , 2 , 1);
		
		Label userName = new Label("User Name: ");
		pane1.add(userName, 0, 1);
		
		TextField userTextField = new TextField();
		pane1.add(userTextField, 1, 1);

		Label password = new Label("Password: ");
		pane1.add(password, 0, 2);
		
		PasswordField pwField = new PasswordField();
		pane1.add(pwField, 1, 2);
		
		Button btn = new Button("Login");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		pane1.add(hbBtn, 1, 4);
		
		final Text actiontarget = new Text();
		pane1.add(actiontarget,1, 6);
	    pane.setStyle("-fx-background-color: yellow;-fx-padding: 10px;");
//	    pane1.setStyle("-fx-background-color: red;-fx-padding: 10px;");
		
    
	    btn.setOnAction((ActionEvent e)->{
	    	if(e.getSource() == btn)
	    		primaryStage.setScene(sc);
	    
		/*The following switch statement allows WASD input from the player. 
		 * Should the player make an encounter with a node such as a wall, enemy,
		 * or item, the appropriate events would ensue (events not implemented
		 * yet. ATM it's just some print statements saying you encountered something. 
		 * 
		 * NOTE: not fully functional. Logic errors present - sometimes encountering
		 * something will not prompt appropriate events.  */		
		sc.setOnKeyPressed(ke -> {
			switch (ke.getCode()) {
			case W:
				//if(ArenaArray.getAbove()!=WALL) {
				//	if(ArenaArray.getAbove()==ENEMY) {
				//		System.out.println("You enter battle");
				//	}
				//	if(ArenaArray.getAbove()==ITEM) {
				//		System.out.println("You pick up an item");
				//	}
				if(ArenaArray.getAbove(arena) != ArenaArray.WALL) {
					if(ArenaArray.getAbove(arena) == ArenaArray.ENEMY)
						System.out.println("You enter battle");
					if(ArenaArray.getAbove(arena) == ArenaArray.ITEM)
						System.out.println("You pick up an item");
				
					ArenaArray.playerPosition[1] += 1;	
					human.setTranslateY(human.getTranslateY()-10);
					}
				break;
				
				//}
				
			case S:
				//if(ArenaArray.getBelow()!=3) {
				//	if(ArenaArray.getBelow()==2) {
				//		System.out.println("You enter battle");
				//	}
				//	if(ArenaArray.getBelow()==4) {
				//		System.out.println("You ascend to the next floor");
				//	}
				if(ArenaArray.getBelow(arena) != ArenaArray.WALL) {
					switch(ArenaArray.getBelow(arena)) {
					case ArenaArray.ENEMY: System.out.println("You enter battle"); break; //will put encounter methods here
					case ArenaArray.ITEM: System.out.println("You pick up an item"); break;
					case ArenaArray.EMPTY_SPACE: break;
					}
					ArenaArray.playerPosition[1] -= 1;	
					human.setTranslateY(human.getTranslateY()+10);
				}
				//human.setTranslateY(human.getTranslateY()+10);//}
				break;
			case A:
				//if(ArenaArray.getLeft()!=3) {
				//	if(ArenaArray.getLeft()==2) {
				//		System.out.println("You enter battle");
				//	}
				//	if(ArenaArray.getLeft()==4) {
				//		System.out.println("You ascend to the next floor");
				//	}
				human.setTranslateX(human.getTranslateX()-10);//}
				break;
			case D:
				//if(ArenaArray.getRight()!=3) {
				//	if(ArenaArray.getRight()==2) {
				//		System.out.println("You enter battle");
				//	}
				//	if(ArenaArray.getRight()==4) {
				//		System.out.println("You ascend to the next floor");
				//	}
				human.setTranslateX(human.getTranslateX()+10);//}
				break;
			default:
				break;
			}
		});
	    });

	
	
}
	public static void main(String[] args) {
		launch(args);
	}	
	
}
