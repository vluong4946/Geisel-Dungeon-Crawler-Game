import java.util.Random;

public class ArenaArray{

	//fields
	public int[][] arenaArray; //make this public for Player class? 
	
	private static int floor = 1; 
	private int floorWidth;
	private int floorHeight;
	
	private static final int EMPTY_SPACE = 0;
	private static final int ENEMY = 1;
	private static final int CONSUMABLE = 2;
	private static final int WALL = 3;
	


	
	
	//Methods
	
	public static int[][] createArenaArray() {
		Random RNG = new Random();
		int floorHeight = getFloorDimensions(floor)[0][0];
		int floorWidth = getFloorDimensions(floor)[0][1];
		
		int[][] arena = new int[floorHeight][floorWidth]; 
		
		for(int i = 0; i < floorHeight; i++) {
			for(int j = 0; j < floorWidth; j++) {
				//10% chance of a tile being an encounter
				switch(RNG.nextInt(10)) {
				case 1: arena[i][j] = ENEMY; break; 
				case 2: arena[i][j] = CONSUMABLE; break;
				default: arena[i][j] = EMPTY_SPACE; break;
				}
					
			}
		}
		
		//create walls
		createWalls(arena, floorHeight, floorWidth);
		
		floor += 1;
		return arena;
		
	}
	
	//create walls for array
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
	
	//each floor's dimensions
	public static int[][] getFloorDimensions(int floor){
		int[][] dimensions = new int[1][2]; //[height][width]
		switch(floor) {
		case 1: dimensions[0][0] = 100; dimensions[0][1] = 150; break; //replace these magic number later on
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
	
	
	
	
	
	
	public static void main(String[] args) {
		int[][] arena = createArenaArray();
		for(int i = 0; i < arena.length; i++) 
			for(int j = 0; j < arena[i].length; j++) 
				System.out.print(arena[i][j]);
	}

		
	
	/**Testing array
	   
	 */
}


