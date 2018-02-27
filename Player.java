import java.util.Arrays;
import java.util.Random;
public class Player extends Dungeon{
	//fields for a player instance
	private int health =100;
	private int[][] inventory;
	//inventory of objects
	
	//constructors
	public Player() {
		Item item = new Item();
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
		Random rng = new Random();
		int item_value;
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
			public int potionEncountered() {
			switch (rng.nextInt(10)) {
				case 0: 
				case 1:
				case 2:
					System.out.println("You have recieved a Starbuck Mocha(small health potion)");
					item_value = 0;
					break;
				case 3:
				case 4:
					System.out.println("You have recieved a redbull (Mediom health potion)");
					item_value = 1;
					break;
				case 5:
					System.out.println("You have recieved a DoubleShot Expresso (Large health potion)");
					item_value = 2;
					break;
				case 6:
				case 7:
					System.out.println("You have recieved Doritos (Small strength potion)");
					item_value = 3;
					break;
				case 8:
					System.out.println("You recieve a family size bag of Muchies (Large strength potion)");
					item_value = 4;
					break;
				case 9:
					System.out.println("Whilst reaching for the mysterious, you trip and fall, subsequently crushing the item ( -5 health (good job -_-))");
					item_value = 5;
					break;
			}
			return item_value;
			}
				class Weapon extends Item{
					public int weaponEncountered() {
					switch (rng.nextInt(6)) {
					case 0:
					case 1:
						System.out.println("You have recieved a #2 pencil ( Weak overall stat weapon)");
						item_value = 6;
						break;
					case 2:
						System.out.println("You have recieved an ascii cheat sheet for all programing languages");
						item_value = 7;
						break;
					case 3:
						System.out.println("You have recieved a Texas Instrument Ti- 89 ( Strong Math stat weapon)");
						item_value = 8;
						break;
					case 4:
						System.out.println("You have recieved a set of Princeton Series 7050 Kolinsky Sable Round paint brushes ( Strong Fine-Arts stat weapon)");
						break;
					case 5:
						System.out.println("You have recieved Mac ios Air ( Medium overall stat weapon)");
						break;
					}
					return item_value;
					
				}
				}
		public void storingItem() {
			
			
			}
				
			}
		}
			
		

}
