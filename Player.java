import java.util.Arrays;

public class Player {
	//fields for a player instance
	private int health;
	//inventory of objects
	
	//constructors
	public Player() {
		
	}
	
	public Player(int startingHealth, int[][] inventory) { //more attributes to come
		this.health = startingHealth;
		this.inventory = inventory;
		
	}
	
	//methods
	public void createPlayer() {
		Player player = new Player();
	}
	
	
	class Item{
		class Potion extends Item{
			
		}
		//... more Item objects to come
	}

	

}
