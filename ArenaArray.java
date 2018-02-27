import java.util.Random;
/**
 * This class contains a method for creating the array that operates in relation 
 * to the playing field. The array determines the location of nodes, such as
 * enemies and items. This class contains getter methods for retrieving data on
 * the adjacent tiles to the player. 
 * This class contains public methods and public variables for usage in Dungeon.java. 
 *
 */

public class ArenaArray{

	//CHANGE ALL TO PRIVATE FIELDS ONCE PLAYER CLASS IS MADE??? yea probably lol
	
	//fields
	public int[][] arenaArray; //make this public for Player class? 
	
	private static int floor = 1; //Will increase
	private static int floorWidth = 150; //By default in floor 1
	private static int floorHeight = 100; //By default in floor 1
	//make these public for usage in Dungeon.java?
	public static final int EMPTY_SPACE = 0;
	public static final int ENEMY = 1;
	public static final int ITEM = 2;
	public static final int WALL = 3;
	public static final int PLAYER = 999;
	
	
	public static int[] playerPosition = new int[2];
	
	/*Create an array representation of the playing field. Used to store
	 * location of nodes, like items and enemies.*/
	public static int[][] createArenaArray() {
		Random RNG = new Random();
		int floorHeight = getFloorDimensions(floor)[0][0];
		int floorWidth = getFloorDimensions(floor)[0][1];
		
		int[][] arena = new int[floorHeight][floorWidth]; 
		
		for(int i = 0; i < floorHeight; i++) {
			for(int j = 0; j < floorWidth; j++) {
				//10% chance of a tile being an encounter
				switch(RNG.nextInt(100)) {
				case 1: arena[i][j] = ENEMY; break; 
				case 2: arena[i][j] = ITEM; break;
				default: arena[i][j] = EMPTY_SPACE; break;
				}
					
			}
		}
		//create walls for arena
		createWalls(arena, floorHeight, floorWidth);
		
		playerPosition[0] = 74; //magic numbers, BAD XD 
		playerPosition[1] = 49;
		
		floor += 1;
		return arena;
		
	}
	
	/*Create arena walls*/
	public static void createWalls(int[][] arena, int floorHeight, int floorWidth) {
		//Horizontal walls
		for(int col = 0; col < floorWidth; col++) {
			arena[0][col] = WALL;
		}
		for(int col = 0; col< floorWidth; col++) {
			arena[floorHeight - 1][col] = WALL;
		}
			
		//Vertical walls
		for(int row = 0; row < floorHeight; row++) {
			arena[row][0] = WALL;
		}
		for(int row = 0; row < floorHeight; row++) {
			arena[row][floorWidth - 1] = WALL;
		}
		
	}
	
	/*Used for storing and retrieving each floor's dimensions*/
	public static int[][] getFloorDimensions(int floor){
		int[][] dimensions = new int[1][2]; //[height][width]
		switch(floor) {
		case 1: dimensions[0][0] = 150; dimensions[0][1] = 100; break; //replace these magic number later on
		case 2: 
		case 3:
		case 4:
		case 5:
		case 6: 
		case 7: 
		case 8: 
		}
		
		return dimensions;
	}
	
	/**
	 * switch (e.getCode()) {
			case W:
				human.setTranslateY(human.getTranslateY()-5);
				
				break;
			case S:
				human.setTranslateY(human.getTranslateY()+5);
				break;
			case A:
				human.setTranslateX(human.getTranslateX()-5);
				break;
			case D:
				human.setTranslateX(human.getTranslateX()+5);
				break;
			default:
				break;
			}
	 */
	
	/*Getter methods for adjacent nodes to player*/
	public static int getAbove(int[][] arena) {
		
		switch(arena[playerPosition[0]]  [playerPosition[1] + 1]) {
		case 1: return ENEMY; //replace magic numbers haha yes :) ^o^ .///.  >_<
		case 2: return ITEM;
		case 3: return WALL;
		default: return EMPTY_SPACE;
		}
	}
	public static int getBelow(int[][] arena) {
		switch(arena[playerPosition[0]]  [playerPosition[1] - 1]) {
		case 1: return ENEMY;
		case 2: return ITEM;
		case 3: return WALL;
		default: return EMPTY_SPACE;
		}
	}
	public static int getLeft() {
		return -1; 
	}
	public static int getRight() {
		return -1; 
	}
	
	//getter method for player position (x, y)
	/*
	 * public int[][] getPlayerPosition(int[][] arrayArena){
		for(int i = 0; i < arrayArena.length; i++) {
			for(int j = 0; j < arrayArena[i].length; j++) {
				if(arrayArena[i][j] == PLAYER) {
					playerPosition[0][0] = j;
					playerPosition[0][1] = i;
					break;
				}
			}
		}
		return playerPosition;
	}
	 */
	
	
	
	
	/*public static void main(String[] args) {
		int[][] arena = createArenaArray();
		for(int i = 0; i < arena.length; i++) 
			for(int j = 0; j < arena[i].length; j++) 
				System.out.print(arena[i][j]);
	}
	 */
}
