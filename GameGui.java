import javafx.application.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;
import javafx.geometry.*;


public class GameGui extends Application{
	public static void main(String[] args) {
		Application.launch(args); //runs the start method
	}
	
	//GUI Fields
	private static final int SPACE_BETWEEN_HBOX_NODES = 50;
	private static final int INSETS_SPACING_FOR_HBOX = 20;
	private static final String P_STAGE_TITLE = "Geisel Dungeon Crawler";
	public static final int P_STAGE_SIZE = 800;
	public static final int GRID_PANE_SIZE = 600; 
	
	public static final int NUM_TILES_PER_SIDE = 
			GRID_PANE_SIZE / GameTile.TILE_DIMENSIONS; //600/20 = 30
	public GameTile[][] tiles = 
			new GameTile[NUM_TILES_PER_SIDE][NUM_TILES_PER_SIDE];
	
	private HBox topHBox;
	private GridPane tilesGridPane;
	private BorderPane borderPane;
	private StackPane stackPane;
	private Text floorNumHeader;
	private Text notificationHeader;
	private Node human;
	private Node flashlight;
	private static final int FL_RADIUS = 200;
	private static final int FL_OFFSET = 990;
	
	public static Stage window;
	public static Scene scene;
	//private GridPane humanGridPane;
	
	private Floor floor;
	
	//Pictures
	private static final String PLAYER_PICTURE = "Player.png";
	
	//Methods
	public void start(Stage primaryStage) {
		//do {
			window = primaryStage;
			createGui(window);
			
		//} while(floor.isFloorComplete);
		
		/** BELOW IS FUTURE GAME LOOP TO GO THROUGH THE FLOORS **/
		//for(int floorNum = Floor.FIRST_FLOOR; floorNum <= Floor.LAST_FLOOR; floorNum++) {
			//createGui(primaryStage); 
		//}
		
	}
	/*
	 * Method: createGui
	 * This method will create the GUI for each floor depending on the
	 * floor number the player is currently on. 
	 */
	private void createGui(Stage primaryStage) {
		//Set primaryStage attributes
		System.out.println(Floor.floorNum);
		primaryStage.setTitle(P_STAGE_TITLE);
		primaryStage.setMaxWidth(P_STAGE_SIZE);
		primaryStage.setMaxHeight(P_STAGE_SIZE);
		
		//Create HBox to hold header for floor #
		topHBox = new HBox(SPACE_BETWEEN_HBOX_NODES);
		topHBox.setPadding(new Insets(INSETS_SPACING_FOR_HBOX, INSETS_SPACING_FOR_HBOX
				,INSETS_SPACING_FOR_HBOX, INSETS_SPACING_FOR_HBOX));
		topHBox.setStyle("-fx-background-color: lavender");
		
		//Create floor# and notification text and put it in topHBox
		floorNumHeader = new Text("Floor: " + Floor.floorNum);
		topHBox.getChildren().add(floorNumHeader);
		topHBox.setAlignment(Pos.TOP_LEFT);
		System.out.println(Floor.floorNum);
		setNotificationText("You ascend to the next floor!");
		if(Floor.floorNum == Floor.FIRST_FLOOR)
			setNotificationText("After sleeping the night in Geisel, you awaken "
					+ "to find hostile exams, \nhomework assignments and essays after you. "
						+ "\nFight your way to the top to get that A!!!!");
		
		//Create GridPane to store empty GameTile objects to be overrided later on
		tilesGridPane = new GridPane();
		tilesGridPane.setPrefSize(GRID_PANE_SIZE, GRID_PANE_SIZE);
		tilesGridPane.setAlignment(Pos.CENTER);
		
		//Store gametiles and make a new Floor object. 
		GameTile.setExitLocation();
		createGameArray(Floor.floorNum, tilesGridPane);
		floor = new Floor(Floor.floorNum);
		
		//Create human object and flashlight to follow human
		human = createHuman();
		flashlight = createFlashlight();
		tilesGridPane.add(human, Floor.COL_START, Floor.ROW_START);

		
		//Create StackPane to store flashlight and tilesGridPane
		stackPane = new StackPane();
		stackPane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
		stackPane.getChildren().addAll(tilesGridPane,flashlight);
		stackPane.setTranslateX(-P_STAGE_SIZE); /**why negatives?**/
		stackPane.setTranslateY(-P_STAGE_SIZE);
		
		//Create borderPane and scene
		borderPane = new BorderPane();
		borderPane.setCenter(stackPane);
		borderPane.setTop(topHBox);
		scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		
		
		//Display primaryStage
		primaryStage.show();
		
		//From now on, player controls the human node. 
		allowUserInput(scene, human, Floor.floorNum);
		
	}
	/*
	 * Method: createGameArray
	 * Stores a total of 900 tiles in tilesGridPane (30 x 30).
	 * Stores each tile created in an array to be referenced later on. 
	 */
	public void createGameArray(int floorNum, GridPane tilesGridPane) {
		for(int row = 0; row < NUM_TILES_PER_SIDE; row++) {
			for(int col = 0; col < NUM_TILES_PER_SIDE; col++) {
				GameTile tile = GameTile.createGameTile(floorNum, row, col);
				tilesGridPane.add(tile, col, row);
				tiles[row][col] = tile;
			}
		}
	}
	
	/*
	 * Method: setNotificationText
	 * Accepts a String parameter and sets outputs it following the
	 * notificationHeader at the top of the GUI. 
	 */
	public void setNotificationText(String notification) {
		if(topHBox.getChildren().contains(notificationHeader)) {
			topHBox.getChildren().remove(notificationHeader);
		}
		notificationHeader = new Text(notification);
		topHBox.getChildren().add(notificationHeader);
		topHBox.setAlignment(Pos.TOP_LEFT);
	}
	
	
	/*
	 * Method: createHuman
	 * Creates a Node human to navigate the playing field. 
	 */
	public Node createHuman() {
		Image player = new Image(PLAYER_PICTURE);
		ImageView playerIV = new ImageView();
		playerIV.setImage(player);
		playerIV.setFitWidth(GameTile.TILE_DIMENSIONS);
		playerIV.setPreserveRatio(true);
		playerIV.setSmooth(true);
		playerIV.setCache(true);
		return playerIV;
	}
	/*
	 * Create FlashLight
	 * Creates a Node flashlight to follow human around playing field. 
	 */
	private Node createFlashlight() {
		Rectangle dark = new Rectangle(3*P_STAGE_SIZE,3*P_STAGE_SIZE,Color.BLACK);
		Circle light = new Circle(FL_OFFSET, FL_OFFSET, FL_RADIUS);
		Shape flashlight = Shape.subtract(dark, light);
		return flashlight;
	}

	/*
	 * Method: allowUserInput
	 * This method is called after creation of the GUI. 
	 * This method prompts user input through the arrow keys, allowing
	 * the player to control movement of the human. 
	 */
	public void allowUserInput(Scene scene, Node human, int floorNum) {
		//Create floor object, which contains the array for the nodes on the screen.
		//floor = new Floor(floorNum);
				
		//Accept user input
		scene.setOnKeyPressed(key -> {
			switch(key.getCode()) {
			case UP: 
				switch(floor.getAbove()) {
				case GameTile.WALL: 
					promptEncounters(floor.getAbove()); break;
				default:
					RemovePreviousTile();
					promptEncounters(floor.getAbove());
					floor.moveUp();
					Floor.testPrintArray(floor.floorArray);
					human.setTranslateY(human.getTranslateY() - GameTile.TILE_DIMENSIONS);
					flashlight.setTranslateY(flashlight.getTranslateY() - GameTile.TILE_DIMENSIONS);
					checkIfFloorComplete();
				}
				break;
			case LEFT:
				switch(floor.getLeft()) {
				case GameTile.WALL: 
					promptEncounters(floor.getLeft()); break;
				default:
					RemovePreviousTile();
					promptEncounters(floor.getLeft());
					floor.moveLeft();
					Floor.testPrintArray(floor.floorArray);
					human.setTranslateX(human.getTranslateX() - GameTile.TILE_DIMENSIONS);
					flashlight.setTranslateX(flashlight.getTranslateX() - GameTile.TILE_DIMENSIONS);
					checkIfFloorComplete();
				}
				break;
			case DOWN:
				switch(floor.getBelow()) {
				case GameTile.WALL: 
					promptEncounters(floor.getBelow()); break;
				default:
					RemovePreviousTile();
					promptEncounters(floor.getBelow());
					floor.moveDown();
					Floor.testPrintArray(floor.floorArray);
					human.setTranslateY(human.getTranslateY() + GameTile.TILE_DIMENSIONS);
					flashlight.setTranslateY(flashlight.getTranslateY() + GameTile.TILE_DIMENSIONS);
					checkIfFloorComplete();
				}
				break;
			case RIGHT:
				switch(floor.getRight()) {
				case GameTile.WALL: 
					promptEncounters(floor.getRight()); break;
				default:
					RemovePreviousTile();
					promptEncounters(floor.getRight()); 
					floor.moveRight();
					Floor.testPrintArray(floor.floorArray);
					human.setTranslateX(human.getTranslateX() + GameTile.TILE_DIMENSIONS);
					flashlight.setTranslateX(flashlight.getTranslateX() + GameTile.TILE_DIMENSIONS);
					checkIfFloorComplete();
				}
				break;
			default:
				break;
			}
		});	
	}
	/*
	 * Method: promptEncounters
	 * Prompts the appropriate events depending on what type node is encountered
	 * by the player. Prints the appropriate notifications to console and GUI. 
	 */
	public void promptEncounters(int nodeEncountered) {
		switch(nodeEncountered) {
		case GameTile.WALL: 
			System.out.println("Wall"); 
			setNotificationText("You encounter a wall.");
			break; 
		case GameTile.ENEMY: 
			System.out.println("Enemy");
			window.setScene(BattleScene.battleStart()); 
			setNotificationText("You encountered an enemy!");
			break; //fill in
		case GameTile.ITEM: 
			System.out.println("Item");
			setNotificationText("You pick up an item.");
			break; //fill in
		case GameTile.EXIT: 
			System.out.println("Exit");
			setNotificationText("You ascend to the next floor!");
			//setIsFloorComplete(true);
			Floor.floorNum++;
			floor.isFloorComplete = true;
			break; //fill in
		
		}
	}
	
	/*
	 * Method: RemovePreviousTile
	 * Places a "snow" colored rectangle on the gridpane to visually cover up
	 * encountered nodes. 
	 */
	public void RemovePreviousTile() {
		tilesGridPane.getChildren()
			.remove(tiles[floor.playerPosition[0]][floor.playerPosition[1]]);
	}
	/*
	 * Method: setIsFloorComplete
	 * Setter method to set boolean isFloorComplete. Called with parameter
	 * true when player reaches a floor exit. 
	 */
	//public void setIsFloorComplete(boolean isAtExit) {
	//	floor.isFloorComplete = isAtExit;
	//}
	
	/*
	 * Method: checkIfFloorComplete
	 * This method will generate a new floor if players reach the exit of a floor.
	 */
	public void checkIfFloorComplete() {
		if(floor.isFloorComplete) {
			floor.isFloorComplete = false;
			start(window);
		}
	}


}

class Floor extends StackPane{
	
	//Fields 
	public boolean isFloorComplete;
	public static final int FIRST_FLOOR = 1;
	public static final int LAST_FLOOR = 8;
	public static int floorNum = 1;
	
	public int[][] floorArray
		= new int[GameGui.NUM_TILES_PER_SIDE][GameGui.NUM_TILES_PER_SIDE];
	//private static int[][] wallsArray;
	public static final int ROW_START = 4;
	public static final int COL_START = 4;
	
	public int[] playerPosition = new int[2];
	
	//private static final int FLOOR_ARRAY_SIZE = GameGui.NUM_TILES_PER_SIDE;

	/*
	 * The constructor for Floor stores the floorNum and the layout of
	 * each floor
	 */
	public Floor(int nextFloor) {
		floorNum = nextFloor;
		//transferring the tiles information to floorArray. 
		this.floorArray = copyArray(floorArray, GameTile.tileStatus);
		this.isFloorComplete = false;
		
		//Prints floorArray. Used for testing. Will be removed. 
		testPrintArray(floorArray);
		playerPosition[0] = ROW_START;
		playerPosition[1] = COL_START;
	}
	
	

	/*
	 * Method: move__
	 * Activated to move in that specific direction. 
	 * This method replaces previous space with empty, moves player in
	 * the array, and updates playerPosition. 
	 */
	public void moveUp() {
		floorArray[playerPosition[0]][playerPosition[1]] = GameTile.EMPTY;
		floorArray[playerPosition[0] - 1][playerPosition[1]] = GameTile.PLAYER;
		playerPosition[0] -= 1;
	}
	public void moveLeft() {
		floorArray[playerPosition[0]][playerPosition[1]] = GameTile.EMPTY;
		floorArray[playerPosition[0]][playerPosition[1] - 1] = GameTile.PLAYER;
		playerPosition[1] -= 1;
	}
	public void moveDown() {
		floorArray[playerPosition[0]][playerPosition[1]] = GameTile.EMPTY;
		floorArray[playerPosition[0] + 1][playerPosition[1]] = GameTile.PLAYER;
		playerPosition[0] += 1;
	}
	public void moveRight() {
		floorArray[playerPosition[0]][playerPosition[1]] = GameTile.EMPTY;
		floorArray[playerPosition[0]][playerPosition[1] + 1] = GameTile.PLAYER;
		playerPosition[1] += 1;
	}
	
	
	/*
	 * Method: get___
	 * The following four getter methods return an int corresponding to the 
	 * type of node in the direction the player chooses. 
	 */
	public int getAbove() {
		switch(floorArray[playerPosition[0] - 1][playerPosition[1]]) {
		case GameTile.WALL: return GameTile.WALL; 
		case GameTile.ENEMY: return GameTile.ENEMY;
		case GameTile.ITEM: return GameTile.ITEM;
		case GameTile.EMPTY: return GameTile.EMPTY;
		case GameTile.EXIT: return GameTile.EXIT;
		default: return -1; //Unreachable code
		}
	}
	public int getBelow() {
		switch(floorArray[playerPosition[0] + 1][playerPosition[1]]) {
		case GameTile.WALL: return GameTile.WALL; 
		case GameTile.ENEMY: return GameTile.ENEMY;
		case GameTile.ITEM: return GameTile.ITEM;
		case GameTile.EMPTY: return GameTile.EMPTY;
		case GameTile.EXIT: return GameTile.EXIT;
		default: return -1; //Unreachable code
		}
	}
	public int getLeft() {
		switch(floorArray[playerPosition[0]][playerPosition[1] - 1]) {
		case GameTile.WALL: return GameTile.WALL; 
		case GameTile.ENEMY: return GameTile.ENEMY;
		case GameTile.ITEM: return GameTile.ITEM;
		case GameTile.EMPTY: return GameTile.EMPTY;
		case GameTile.EXIT: return GameTile.EXIT;
		default: return -1; //Unreachable code
		}
	}
	public int getRight() {
		switch(floorArray[playerPosition[0]][playerPosition[1] + 1]) {
		case GameTile.WALL: return GameTile.WALL; 
		case GameTile.ENEMY: return GameTile.ENEMY;
		case GameTile.ITEM: return GameTile.ITEM;
		case GameTile.EMPTY: return GameTile.EMPTY;
		case GameTile.EXIT: return GameTile.EXIT;
		default: return -1; //Unreachable code
		}
	}
	
	/*
	 * Method: createFloorWalls
	 * This static method creates the layout of the walls for each floor
	 * by modifying floorArray.length directly. 
	 * 
	 * Return: void
	 */
	public static void createFloorWalls(int floorNum, int[][] floorArray) {
		switch(floorNum) {
		case 1: 
		case 2: 
		case 3:
		case 4:
		case 5:
		case 6: 
		case 7: 
		case 8: 
		}
	}
	
	/*
	 * Method: copyArray
	 * This method takes in two 2D arrays as parameters and assigns
	 * values from the second to the first. 
	 */
	public static int[][] copyArray(int[][] a1, int[][] a2) {
		for(int row = 0; row < a1.length; row++) {
			for(int col = 0; col < a1[row].length; col++) {
				a1[row][col] = a2[row][col];
			}
		}
		return a1;
	}

	
	/*
	 * Method: testPrintArray
	 * Used for testing. Prints a passed-in 2D array 
	 */
	public static void testPrintArray(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		for(int i = 0; i < 20; i++)
			System.out.print("-");
		System.out.println();
	}
	
	
	//Getters and Setters
	public int getFloorNum() {
		return floorNum;
	}
	


}
