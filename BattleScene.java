
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
	//Create four buttons for each action	
	static Button attack = new Button("ATTACK");
	static Button run = new Button("RUN");
	static Button skill = new Button("SKILL");
	static Button item = new Button("ITEM");
	static Label pHealth = new Label("Health");
	static Label pEnergy = new Label("Energy");
	static Label eHealth = new Label("Health");

	//Create rectangles that represent resource bars
	//variables replaced with resources

	//these variables should equal values gotten from the player and monster class
	static int PLAYER_HEALTH=100;
	static int PLAYER_ENERGY=100;
	static int ENEMY_HEALTH=100;

	static int PLAYER_ATTACK;
	static int ENEMY_ATTACK;

	static Rectangle playerHealth;
	static Rectangle playerEnergy;
	static Rectangle enemyHealth;

	//Adds color strip to bottom
	static Rectangle strip = new Rectangle(GameGui.P_STAGE_SIZE,200);

	//imports images for the enemies and players
	static Image triton = new Image("Triton.png");
	static ImageView tritonIV = new ImageView();
	
	public static Scene battleStart(/*pass in a value that identifies enemy*/){
		
		
		//Assigns actions to the buttons
		attack.setOnAction(e -> attack());
		skill.setOnAction(e -> skill());
		item.setOnAction(e -> item());
		run.setOnAction(e -> run());
		
		
		
		//Creates the stack pane
		battlePane = new StackPane();
		
		updateBattle();
		
		battle = new Scene(battlePane,GameGui.P_STAGE_SIZE,GameGui.P_STAGE_SIZE);
		
		return battle;
	}
	
	//methods for each action
	public static void attack() {
		System.out.println("You attack the enemy!");
		ENEMY_HEALTH-=PLAYER_ATTACK;
		System.out.println("The enemy attacks you!");
		enemyAttack();
		updateBattle();
	}
	
	public static void skill() {
		if(PLAYER_ENERGY>=10) {
			System.out.println("You spend 10 energy and use a super attack!");
			ENEMY_HEALTH-=PLAYER_ATTACK*2;
			PLAYER_ENERGY-=10;
			System.out.println("The enemy attacks you!");
			enemyAttack();
			updateBattle();}
		else
			System.out.println("You do not have enough energy!");
			updateBattle();
	}
	
	public static void item(/*opens bag with items*/) {
		
		
		updateBattle();
	}
	
	public static void run() {
		if (PLAYER_ENERGY>=50) {
			System.out.println("You try to get away!");
			PLAYER_ENERGY-=50;
			updateBattle();}
		else 
			System.out.println("You do not have enough energy!");
			updateBattle();
	}
	
	public static void enemyAttack() {
		PLAYER_HEALTH-=ENEMY_ATTACK;
	}
	
	
	public static void updateBattle(){
		battlePane.getChildren().clear();
		//sizes the image for the player
		tritonIV.setImage(triton);
		tritonIV.setFitWidth(200);
		tritonIV.setPreserveRatio(true);
		tritonIV.setSmooth(true);
		tritonIV.setCache(true);
		
		//Changes the size of resource bar after every action
		playerHealth = new Rectangle(PLAYER_HEALTH,20,Color.GREEN);
		playerEnergy = new Rectangle(PLAYER_ENERGY,20,Color.BLUE);
		enemyHealth = new Rectangle(ENEMY_HEALTH,20,Color.RED);
		
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
		
		if (ENEMY_HEALTH==0)
			GameGui.window.setScene(GameGui.scene);
		if (PLAYER_HEALTH==0)
			//send to ending screen
			GameGui.window.setScene(GameGui.scene); //this is temporary
		
	}
}
