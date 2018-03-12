
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class BattleScene{
	static StackPane battlePane;
	static Scene battle;
	
	public static Scene battleStart(){
		
		//Create four buttons for each action	
		Button attack = new Button("ATTACK");
		Button run = new Button("RUN");
		Button skill = new Button("SKILL");
		Button item = new Button("ITEM");
		Label pHealth = new Label("Health");
		Label pEnergy = new Label("Energy");
		Label eHealth = new Label("Health");
		
		//Create rectangles that represent resource bars
		//variables replaced with resources
		
		int PLAYER_HEALTH=10;
		int PLAYER_ENERGY=10;
		int ENEMY_HEALTH=10;
		
		Rectangle playerHealth = new Rectangle(PLAYER_HEALTH*10,20,Color.GREEN);
		Rectangle playerEnergy = new Rectangle(PLAYER_ENERGY*10,20,Color.BLUE);
		Rectangle enemyHealth = new Rectangle(ENEMY_HEALTH*10,20,Color.RED);
		
		//imports images for the enemies and players
		Image triton = new Image("Triton.png");
		ImageView tritonIV = new ImageView();
		tritonIV.setImage(triton);
		tritonIV.setFitWidth(200);
		tritonIV.setPreserveRatio(true);
		tritonIV.setSmooth(true);
		tritonIV.setCache(true);
		
		
		
		//Assigns actions to the buttons
		attack.setOnAction(e -> GameGui.window.setScene(GameGui.scene));
		
		
		
		//Creates the stack pane
		battlePane = new StackPane();
		
		//Adds color strip to bottom
		Rectangle strip = new Rectangle(GameGui.P_STAGE_SIZE,200);
		
		//Adds children to the pane and creates the scene
		
		battlePane.getChildren().addAll(strip,attack,run,skill,item,playerHealth,playerEnergy,enemyHealth,tritonIV,
				pHealth,pEnergy,eHealth);
		
		attack.setTranslateX(-250);
		attack.setTranslateY(230);
		
		skill.setTranslateX(250);
		skill.setTranslateY(230);
		
		item.setTranslateX(-250);
		item.setTranslateY(300);
		
		run.setTranslateX(250);
		run.setTranslateY(300);
		
		playerHealth.setTranslateX(150);
		playerHealth.setTranslateY(50);
		pHealth.setTranslateX(150);
		pHealth.setTranslateY(50);
		
		
		playerEnergy.setTranslateX(150);
		playerEnergy.setTranslateY(70);
		pEnergy.setTranslateX(150);
		pEnergy.setTranslateY(70);
		
		enemyHealth.setTranslateX(-230);
		enemyHealth.setTranslateY(-350);
		eHealth.setTranslateX(-230);
		eHealth.setTranslateY(-350);
		
		tritonIV.setTranslateX(-200);
		tritonIV.setTranslateY(40);
		
		strip.setTranslateY(300);
		
		battle = new Scene(battlePane,GameGui.P_STAGE_SIZE,GameGui.P_STAGE_SIZE);
		
		return battle;
	}
	
	//methods for each action
	public static void attack() {
		
		updateBattle();
	}
	
	public static void skill() {
		
		updateBattle();
	}
	
	public static void item() {
		
		updateBattle();
	}
	
	public static void run() {
		
		updateBattle();
	}
	
	
	public static void updateBattle(){
		
	}
}
