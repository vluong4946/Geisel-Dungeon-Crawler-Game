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
	
	public Node human;
	public static final int ROW_START = 4;
	public static final int COL_START = 4;
	
	//Methods
	public void start(Stage primaryStage) {
		
		createGui(primaryStage, 1); //1 is temporary for testing
		Floor floor = new Floor(Floor.FIRST_FLOOR);
		
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
	private void createGui(Stage primaryStage, int floorNum) {
		//Set primaryStage attributes
		primaryStage.setTitle(P_STAGE_TITLE);
		primaryStage.setWidth(P_STAGE_SIZE);
		primaryStage.setHeight(P_STAGE_SIZE);
		
		//Create HBox to hold header for floor #
		HBox topHBox = new HBox(SPACE_BETWEEN_HBOX_NODES);
		topHBox.setPadding(new Insets(INSETS_SPACING_FOR_HBOX, INSETS_SPACING_FOR_HBOX
				,INSETS_SPACING_FOR_HBOX, INSETS_SPACING_FOR_HBOX));
		topHBox.setStyle("-fx-background-color: lavender");
		
		//Create floor# text and put it in topHBox
		Text floorNumText = new Text("Floor: " + floorNum);
		topHBox.getChildren().add(floorNumText);
		topHBox.setAlignment(Pos.CENTER);
		
		//Create GridPane to store empty GameTile objects to be overrided later on
		GridPane tilesGridPane = new GridPane();
		tilesGridPane.setPrefSize(GRID_PANE_SIZE, GRID_PANE_SIZE);
		tilesGridPane.setAlignment(Pos.CENTER);
		//Stores a total of 900 tiles in tilesGridPane (30 x 30)
		for(int row = 0; row < NUM_TILES_PER_SIDE; row++) {
			for(int col = 0; col < NUM_TILES_PER_SIDE; col++) {
				tilesGridPane.add(GameTile.createGameTile(floorNum, row, col)
						, col, row);
			}
		}
		//Place player into the GridPane
		tilesGridPane.add(createHuman(), COL_START, ROW_START); //magic numbers
		
		
		//Create borderPane and scene
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topHBox);
		borderPane.setCenter(tilesGridPane);	
		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		
		
		//Display primaryStage
		primaryStage.show();
		
		//From now on, player controls the human node. 
	}
	
	/*
	 * Method: createHuman
	 * Creates a Node human to navigate the playing field. 
	 */
	private Node createHuman() {
		Rectangle human = new Rectangle(GameTile.TILE_DIMENSIONS, 
				GameTile.TILE_DIMENSIONS, Color.LIGHTGREEN);
		return human;
	}

	
	

}

class Floor extends StackPane{
	
	//Fields 
	public int floorNum;
	public static final int FIRST_FLOOR = 1;
	public static final int LAST_FLOOR = 8;
	
	private int[][] floorArray;
	private static int[][] wallsArray;
	
	
	private static final int FLOOR_ARRAY_SIZE = GameGui.GRID_PANE_SIZE;

	/*
	 * The constructor for Floor stores the floorNum and the layout of
	 * each floor
	 */
	public Floor(int floorNum) {
		this.floorNum = floorNum;
		this.floorArray = 
				new int[GameGui.NUM_TILES_PER_SIDE][GameGui.NUM_TILES_PER_SIDE];
		this.floorArray = copyArray(floorArray, GameTile.tileStatus);
		
		testPrintArray(floorArray);
		
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
	}
	
	
	//Getters and Setters
	public int getFloorNum() {
		return floorNum;
	}
	


}
