import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.*;

public class GameTile extends StackPane{
	//Fields
	private int tileValue;
	public static int[][] tileStatus = 
			new int[GameGui.NUM_TILES_PER_SIDE][GameGui.NUM_TILES_PER_SIDE]; 
	
	public static final int TILE_DIMENSIONS = 20;
	private static final int NODE_CIRCLE_RADIUS = TILE_DIMENSIONS / 4;
	
	//Node identifiers
	public static final int WALL = -1;
	public static final int EMPTY = 0;
	public static final int ENEMY = 1;
	public static final int ITEM = 2;
	public static final int PLAYER = 9;
	public static final int EXIT = 4;
	
	private static final int NUMBER_OF_POSSIBLE_EXITS = 3;
	private static int[] exitLocation;
	//Exit locations are the bottom left, right, and upper right corners.
	private static final int[] EXIT_LOC_1 = 
		{GameGui.NUM_TILES_PER_SIDE - 4, GameGui.NUM_TILES_PER_SIDE - 4};
	private static final int[] EXIT_LOC_2 =
		{GameGui.NUM_TILES_PER_SIDE - 4, GameGui.NUM_TILES_PER_SIDE - 26};
	private static final int[] EXIT_LOC_3 = 
		{GameGui.NUM_TILES_PER_SIDE - 26, GameGui.NUM_TILES_PER_SIDE - 4};
	
	private static Random RNG = new Random();
	
	/*
	 * Constructor: GameTile
	 * Create a GameTile object with attributes color, type, and an array entry.
	 * Type can be: empty space, item, enemy, or wall.
	 * Each tile's array entry in tilesInformation contains its (row, col) position
	 * and status as a wall, empty, enemy, or item. 
	 */
	public GameTile(int floorNum, int row, int col){
		if(row == Floor.ROW_START && col == Floor.COL_START) {
			tileValue = PLAYER;
		}
		else if(IsCreatePerimeterWalls(row, col)) {
			tileValue = WALL;
		}
		else {
			//Use RNG to assign a tile to be an enemy. The chance is based on floorNum.
			switch(RNG.nextInt(getEnemyFrequency(floorNum))) {
			case ENEMY: tileValue = ENEMY; break; 
			default: tileValue = EMPTY; break;
			}
			
			//Use RNG to assign a tile to be an item. The chance if based on floorNum. 
			if(tileValue == EMPTY)
				switch(RNG.nextInt(getItemFrequency(floorNum))) {
				case ITEM: tileValue = ITEM; break; 
				default: tileValue = EMPTY; break;
				}
		}
		
		//Set exit location lastly, so it doesn't get overrided. 
		if(exitLocation[0] == row && exitLocation[1] == col)
			tileValue = EXIT;
			
		//Record (row, col) position and status
		tileStatus[row][col] = tileValue;
		
		//Create shapes for respective nodes if applicable
		
		switch(tileValue) {
		case WALL: this.getChildren().add(
						new Rectangle(TILE_DIMENSIONS, TILE_DIMENSIONS, Color.LIGHTGRAY));
					break;
		case EMPTY: 
					break;
		case ENEMY: this.getChildren().add(
						new Circle(NODE_CIRCLE_RADIUS, Color.RED)); 
					break;
		case ITEM: this.getChildren().add(
						new Circle(NODE_CIRCLE_RADIUS, Color.PINK));
					break;
		case EXIT: this.getChildren().add(
						new Rectangle(TILE_DIMENSIONS, TILE_DIMENSIONS, Color.BLACK));
		}
	}
	

	//Methods
	/*
	 * Method: createGameTile
	 * Calls the constructor GameTile to create a GameTile object.
	 */
	public static GameTile createGameTile(int floorNum, int row, int col) {
		return new GameTile(floorNum, row, col);
	}
	
	/*
	 * Method: IsCreatePerimeterWalls
	 * Is used to assign tiles on the perimeter of the playing field to be walls.
	 */
	private static boolean IsCreatePerimeterWalls(int row, int col) {
		//Horizontal Walls
		if(row == 0 || row == GameGui.NUM_TILES_PER_SIDE - 1)
			return true;
		//Vertical Wall
		else if(col == 0 || col == GameGui.NUM_TILES_PER_SIDE - 1)
			return true;
		else
			return false;
	}
	
	
	/*
	 * Method: getEnemyFrequency
	 * Contains the frequency levels of enemies spawning on each floor. 
	 * The frequency is calculated by 1.0/getEnemyFrequency(floorNum). 
	 * The frequency of spawns increases as floorNum increases. 
	 * 
	 * return: int
	 */
	private static int getEnemyFrequency(int floorNum) {
		switch(floorNum) {
		case 1: return 50; 
		case 2: return 45;  
		case 3: return 40;
		case 4: return 35;
		case 5: return 30;  
		case 6: return 20;  
		case 7: return 10;
		case 8: return 1; //No chance of enemies on floor 8. Reserved for boss. 
		default: return -1; //Unreachable code.
		}
	}
	
	/*
	 * Method: getItemFrequency
	 * Contains the frequency levels of items spawning on each floor.
	 * The frequency is calculated by 1.0/getItemFrequency(floorNum).
	 * The frequeny of spawns decreases as floorNum increases. 
	 */
	private static int getItemFrequency(int floorNum) {
		switch(floorNum) {
		case 1: return 50; 
		case 2: return 55;  
		case 3: return 60;
		case 4: return 65;
		case 5: return 70;  
		case 6: return 80;  
		case 7: return 90;
		case 8: return 100; //No chance of item spawns on floor 8. 
		default: return -1; //Unreachable code.
		}
	}
	/*
	 * Method: getExitLocation
	 * Returns a random exit location from a set pool of locations 
	 * each time a new floor is generated. 
	 */
	public static void setExitLocation() {
		switch(RNG.nextInt(NUMBER_OF_POSSIBLE_EXITS)) {
		case 0: 
			exitLocation = EXIT_LOC_1; break; 
		case 1:
			exitLocation = EXIT_LOC_2; break; 
		case 2:
			exitLocation = EXIT_LOC_3; break; 
		}
	}
	
	//Getters and Setters
	public int[][] getTilesInformation(){
		return tileStatus;
	}
	
	

}
