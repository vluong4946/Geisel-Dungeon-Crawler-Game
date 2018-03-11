import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;
import java.io.*;

public class GameGui extends Application{
	public static void main(String[] args) {
		Application.launch(args); //runs the start method
	}
	
	//Fields
	private static final int SPACE_BETWEEN_HBOX_NODES = 50;
	private static final int INSETS_SPACING_FOR_HBOX = 20;
	private static final String P_STAGE_TITLE = "Geisel Dungeon Crawler";
	private static final int P_STAGE_SIZE = 800;
	public static final int GRID_PANE_SIZE = 600; 
	
	public static final int NUM_TILES_PER_SIDE = 
			GRID_PANE_SIZE / GameTile.TILE_DIMENSIONS; //600/20 = 30
	
	private HBox topHBox;
	private GridPane tilesGridPane;
	private Text floorNumText;
	private BorderPane borderPane;
	private Scene scene;
	private Node human;
	//private GridPane humanGridPane;
	
	private Floor floor;
	private int floorNum = 1;
	
	public static final int ROW_START = 4;
	public static final int COL_START = 4;
	
	//Methods
	public void start(Stage primaryStage) {
		
		createGui(primaryStage); //1 is temporary for testing
		
		
		/** BELOW IS FUTURE GAME LOOP TO GO THROUGH THE FLOORS **/
		//for(int floorNum = Floor.FIRST_FLOOR; floorNum <= Floor.LAST_FLOOR; floorNum++) {
			//Floor floor = new Floor(floorNum);
			//createGui(primaryStage, floor.getFloorNum()); 
		//}
		
	}
	/*
	 * Method: createGui
	 * This method will create the GUI for each floor depending on the
	 * floor number the player is currently on. 
	 */
	private void createGui(Stage primaryStage) {
		//Set primaryStage attributes
		primaryStage.setTitle(P_STAGE_TITLE);
		primaryStage.setMaxWidth(P_STAGE_SIZE);
		primaryStage.setMaxHeight(P_STAGE_SIZE);
		
		//Create HBox to hold header for floor #
		topHBox = new HBox(SPACE_BETWEEN_HBOX_NODES);
		topHBox.setPadding(new Insets(INSETS_SPACING_FOR_HBOX, INSETS_SPACING_FOR_HBOX
				,INSETS_SPACING_FOR_HBOX, INSETS_SPACING_FOR_HBOX));
		topHBox.setStyle("-fx-background-color: lavender");
		
		//Create floor# text and put it in topHBox
		floorNumText = new Text("Floor: " + floorNum);
		topHBox.getChildren().add(floorNumText);
		topHBox.setAlignment(Pos.CENTER);
		
		//Create GridPane to store empty GameTile objects to be overrided later on
		tilesGridPane = new GridPane();
		tilesGridPane.setPrefSize(GRID_PANE_SIZE, GRID_PANE_SIZE);
		tilesGridPane.setAlignment(Pos.CENTER);
		//Stores a total of 900 tiles in tilesGridPane (30 x 30)
		for(int row = 0; row < NUM_TILES_PER_SIDE; row++) {
			for(int col = 0; col < NUM_TILES_PER_SIDE; col++) {
				tilesGridPane.add(GameTile.createGameTile(floorNum, row, col)
						, col, row);
			}
		}
		
		human = createHuman();
		tilesGridPane.add(human, COL_START, ROW_START);
		
		//Create borderPane and scene
		borderPane = new BorderPane();
		borderPane.setTop(topHBox);
		borderPane.setCenter(tilesGridPane);
		scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		
		
		//Display primaryStage
		primaryStage.show();
		
		//From now on, player controls the human node. 
		allowUserInput(scene, human, floorNum);
		
	}
	
	/*
	 * Method: createHuman
	 * Creates a Node human to navigate the playing field. 
	 */
	public Node createHuman() {
		human = new Rectangle(GameTile.TILE_DIMENSIONS, 
				GameTile.TILE_DIMENSIONS, Color.LIGHTGREEN);
		return human;
	}
	
	public void allowUserInput(Scene scene, Node human, int floorNum) {
		//Create floor object
		floor = new Floor(floorNum);
				
		//Accept user input
		scene.setOnKeyPressed(key -> {
			switch(key.getCode()) {
			//Probably break these up into methods. 
			case W: 
				switch(floor.getAbove()) {
				case GameTile.WALL: floor.promptEncounters(floor.getAbove()); break;
				default:
					CoverPreviousTile();
					floor.promptEncounters(floor.getAbove());
					floor.moveUp();
					
					//Visually update position
					human.setTranslateY(human.getTranslateY() - GameTile.TILE_DIMENSIONS);
				}
				break;
			case A:
				switch(floor.getLeft()) {
				case GameTile.WALL: floor.promptEncounters(floor.getLeft()); break;
				default:
					CoverPreviousTile();
					floor.promptEncounters(floor.getLeft());
					floor.moveLeft();
					human.setTranslateX(human.getTranslateX() - GameTile.TILE_DIMENSIONS);
				}
				break;
			case S:
				switch(floor.getBelow()) {
				case GameTile.WALL: floor.promptEncounters(floor.getBelow()); break;
				default:
					CoverPreviousTile();
					floor.promptEncounters(floor.getBelow());
					floor.moveDown();
					human.setTranslateY(human.getTranslateY() + GameTile.TILE_DIMENSIONS);
				}
				break;
			case D:
				switch(floor.getRight()) {
				case GameTile.WALL: floor.promptEncounters(floor.getRight()); break;
				default:
					CoverPreviousTile();
					floor.promptEncounters(floor.getRight());
					floor.moveRight();
					human.setTranslateX(human.getTranslateX() + GameTile.TILE_DIMENSIONS);
				}
				break;
			}
		});		
	}
	
	/*
	 * Method: CoverPreviousTile
	 * Places a "snow" colored rectangle on the gridpane to visually cover up
	 * encountered nodes. 
	 */
	public void CoverPreviousTile() {
		//tilesGridPane.getChildren().remove(tilesGridPane.);
		//tilesGridPane.add(
				//new Rectangle(GameTile.TILE_DIMENSIONS, GameTile.TILE_DIMENSIONS, Color.SNOW), 
					//floor.playerPosition[1], floor.playerPosition[0]);
	}


}

class Floor extends StackPane{
	
	//Fields 
	public int floorNum;
	public static final int FIRST_FLOOR = 1;
	public static final int LAST_FLOOR = 8;
	
	public int[][] floorArray;
	private static int[][] wallsArray;
	
	public int[] playerPosition = {GameGui.ROW_START, GameGui.COL_START};
	
	private static final int FLOOR_ARRAY_SIZE = GameGui.NUM_TILES_PER_SIDE;

	/*
	 * The constructor for Floor stores the floorNum and the layout of
	 * each floor
	 */
	public Floor(int floorNum) {
		this.floorNum = floorNum;
		
		//Creating array for floor and transferring the tiles information to it. 
		this.floorArray = 
				new int[GameGui.NUM_TILES_PER_SIDE][GameGui.NUM_TILES_PER_SIDE];
		this.floorArray = copyArray(floorArray, GameTile.tileStatus);
		
		
		
		//Prints floorArray. Used for testing. Will be removed. 
		testPrintArray(floorArray);
		
	}
	/*
	 * Method: promptEncounters
	 * Prompts the appropriate events depending on what type node is encountered
	 * by the player. 
	 */
	public void promptEncounters(int nodeEncountered) {
		switch(nodeEncountered) {
		case GameTile.WALL: System.out.println("You encounter a wall."); break; 
		case GameTile.ENEMY: System.out.println("e"); break; //fill in
		case GameTile.ITEM: System.out.println("i"); break; //fill in
		case GameTile.EXIT: System.out.println("exit"); break; //fill in
		}
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
	 * Method: printLine
	 * Used for testing. Prints a line of - 's
	 */
	public static void printLine() {
		for(int i = 0; i < 10; i++)
			System.out.print("-");
		System.out.println();
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
		printLine();
	}
	
	
	//Getters and Setters
	public int getFloorNum() {
		return floorNum;
	}
	


}