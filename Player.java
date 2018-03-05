import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class player contains the constructors for creating new instances of
 * Player object, and the classes and their subclasses for the other
 * objects in the game, such as items and enemies. 
 * 
 * NOTE:
 * This class is not yet fully implemented into the project yet. 
 * Its features are still not present in the game. 
 *
 */
public class Player extends testmian_toplayer{
	//fields for a player instance
	private int health = 100;

	private int[] inventory = new int[9];
	//inventory of objects
	
	//constructors
	public Player() {
		//ArrayList<Item> inventory = new ArrayList<>();
		//Item[] inventory = new Item[20];
		Item item = new Item();
	}
	
	public Player(int startingHealth, int[] inventory) { //more attributes to come
		this.health = startingHealth;
		this.inventory = inventory;
		
	}
	
	//Creates new instance of Player
	public void createPlayer() {
		Player player = new Player();
	}
	
	/**
	 * Class for Item objects and its subclasses. 
	 */
	class Item{
		Random rng = new Random();
		String itemName;
		
		public Item() {
			switch(rng.nextInt(3)) {
				case 0:
				case 1:
					Potion potion = new Potion();
					break;
				case 2:
					Weapon weapon = new Weapon();
					break;
			}
		}
		class Potion extends Item{
			int potionValue;
			public int potionEncountered() {
			switch (rng.nextInt(10)) {
				case 0: 
				case 1:
				case 2:
					System.out.println("You have recieved a Starbuck Mocha(small health potion)");
					potionValue = 10;
					itemName = "StarBucks Mocha";
					break;
				case 3:
				case 4:
					System.out.println("You have recieved a redbull (Mediom health potion)");
					potionValue = 25;
					itemName = "redbull";
					break;
				case 5:
					System.out.println("You have recieved a DoubleShot Expresso (Large health potion)");
					potionValue = 50;
					itemName = "Doubleshot Expreso";
					break;
				case 6:
				case 7:
					System.out.println("You have recieved Doritos (Small strength potion)");
					potionValue = 3;
					itemName = "Doritos";
					break;
				case 8:
					System.out.println("You recieve a family size bag of Muchies (Large strength potion)");
					potionValue = 4;
					itemName = "Family Size bag of Munchies";
					break;
				case 9:
					System.out.println("Whilst reaching for the mysterious, you trip and fall, subsequently crushing the item ( -5 health (good job -_-))");
					potionValue = -1;
					itemName = "wow";
					break;
			}
			return potionValue;
			}
			
			}
				class Weapon extends Item{	
				public int[] attackValue = new int[3];
				//Programing attack, Math Attack, Art Attack in this order
					public int[] weaponEncountered() {
					switch (rng.nextInt(6)) {
					case 0:
					case 1:
						System.out.println("You have recieved a #2 pencil ( Weak overall stat weapon)");
						attackValue[0] = 2;
						attackValue[1] = 3;
						attackValue[2] = 4;
						itemName = "#2 pencil";
						break;
					case 2:
						System.out.println("You have recieved an ascii cheat sheet for all programing languages(Strong Progtaming Weapon)");
						attackValue[0] = 8;
						attackValue[1] = 2;
						attackValue[2] = 1;
						itemName = "ascii cheet sheet";
						break;
					case 3:
						System.out.println("You have recieved a Texas Instrument Ti- 89 ( Strong Math stat weapon)");
						attackValue[0] = 2;
						attackValue[1] = 8;
						attackValue[2] = 1;
						itemName = "Texas Instrument";
						break;
					case 4:
						System.out.println("You have recieved a set of Princeton Series 7050 Kolinsky Sable Round paint brushes ( Strong Fine-Arts stat weapon)");
						attackValue[0] = 1;
						attackValue[1] = 2;
						attackValue[2] = 8;
						itemName = "Paint Brushes";
						break;
					case 5:
						System.out.println("You have recieved Mac ios Air ( Medium overall stat weapon)");
						attackValue[0] = 7;
						attackValue[1] = 6;
						attackValue[2] = 5;
						itemName = "Mac ios Air";
						break;
					}
					return attackValue;
					
				}
				}
//		public void storingItem() {
//			
//			
//			}
				
			
		}
			
		

}
