/*
Youngwoo Last Change
 I edited Line 48 to add 	GameGui gui = new GameGui();
 I edited Line 51 to add		gui.createGui();

It gonna help to go back to gameGui!
*/

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
public class PlayerTest extends testmain_toplayer{
	//fields for a player instance
	private int health = 100; // first health is 100; and if the health changes, use changeHealth(int potion). ( if player damaged just receive negative number)
	public int[] attackValue = new int[5]; // attackValue is different depending on the major
	/*
	 * attackValue[0] = computer science
	 * attackValue[1] = mathematics
	 * attackValue[2] = history
	 * attackValue[3] = art
	 * attackValue[4] = psychology
	 */
	private ArrayList<String> inventory = new ArrayList<String>(9); // it is an inventory of potion
	private ArrayList<String> weaponInven = new ArrayList<String>(9); // it is an inventory oof weapons
	private int itemNumber = -1;
	private int MAXITEMSPACE = 20;
	private String major; // major changes in PlayerTest(String maj) 
	private int score = 0; // initial score is 0. If you want to change it -> ascendingScore
						   // 					 If you want to get the score -> getScore();
	//inventory of objects
	
	//constructors
	PlayerTest(){
		this.health = 100;
		score = 0;
	}

	GameGui gui = new GameGui();
	// It is made for the button action after the login success
	public void PlayerTest(String maj) {
		this.major = maj;
		gui.createGui();
	}
	
	// It is getter function for major
	public String getMajor() {
		return major;
	}
	
	// If is getter function for health
	public int getHealth() {
		return health;
	}
	
	// If you want to change the health, use it.
	// If the player drinks the potion, int potion would be postive
	// If the player damaged, int potion would be negative
	public void changeHealth(int potion) {
		health+= potion;
	}
	
	// It is getter function for score
	public int getScore() {
		return score;
	}
	
	// If you want to change the score, use it.
	public void ascendingScore(int plusScore) {
		score += plusScore;
	}
	
	// If you want to get what potion inventory the players have, use it.
	public ArrayList<String> getInventory() {
//		for(int i = 0; i < inventory.size(); i++) {
//			System.out.print(inventory);
//		}
		return inventory;
	}
	
	// This works after the player get the potion.
	public void setInventory(String potionName) {
		inventory.add(potionName);
	}
	// This works after the player drink the potion
	// depending on the potion value, player change health different
	// However, after drinking the potion, it would remove from the inventory
	public void consumeInventory(String potion)
	{
		switch(potion) {
		case ("StarBucks Mocha") : changeHealth(10); break;
		case ("redbull") : changeHealth(25); break;
		case("Doubleshot Expreso"): changeHealth(50); break;
		case("Doritos") : changeHealth(3); break;
		case("Family Size bag of Munchies"): changeHealth(4); break;
		case("wow"): changeHealth(-1); break;
			}
		inventory.remove(potion);		
	}
	
	// It is getter function for weapons 
	public  ArrayList<String> getWeapons()
	{
		return weaponInven;
	}
	
	// After the player get any weapons, it would add in the weapons inventory though here
	public void addweapons(String weapons)
	{
		weaponInven.add(weapons);
	}
	
	
//	public PlayerTest() {
//		//ArrayList<Item> inventory = new ArrayList<>();
//		Item[] item = new Item[MAXITEMSPACE];
//		item[itemNumber] = new Item();
//		item[itemNumber].Itemcreate();
//	}
//	
//	public PlayerTest(int startingHealth, int[] inventory) { //more attributes to come
//		this.health = startingHealth;
//		this.inventory = inventory;
//		
//	}
//	
//	//Creates new instance of Player
////	public void createPlayer() {
////		Player player = new Player();
////	}
	
	/**
	 * Class for Item objects and its subclasses. 
	 */
	class Item{
		
		String itemName;
		PlayerTest player;
		
		public void Itemcreate() {
			Random rng = new Random();
			switch(rng.nextInt(3)) {
				case 0:
				case 1:
					Potion potion = new Potion();
					potion.potionEncountered();
					break;
				case 2:
					Weapon weapon = new Weapon();
					weapon.weaponEncountered();
					break;
			}
					}
		
		class Potion extends Item{
			int potionValue;
			Random rng = new Random();

			public int potionEncountered() {
			switch (rng.nextInt(10)) {
				case 0: 
				case 1:
				case 2:
					System.out.println("You have recieved a Starbuck Mocha(small health potion)");
					potionValue = 10;
					itemName = "StarBucks Mocha";
					player.setInventory(itemName);
					break;
				case 3:
				case 4:
					System.out.println("You have recieved a redbull (Mediom health potion)");
					potionValue = 25;
					itemName = "redbull";
					player.setInventory(itemName);
					break;
				case 5:
					System.out.println("You have recieved a DoubleShot Expresso (Large health potion)");
					potionValue = 50;
					itemName = "Doubleshot Expreso";
					player.setInventory(itemName);
					break;
				case 6:
				case 7:
					System.out.println("You have recieved Doritos (Small strength potion)");
					potionValue = 3;
					itemName = "Doritos";
					player.setInventory(itemName);
					break;
				case 8:
					System.out.println("You recieve a family size bag of Muchies (Large strength potion)");
					potionValue = 4;
					itemName = "Family Size bag of Munchies";
					player.setInventory(itemName);
					break;
				case 9:
					System.out.println("Whilst reaching for the mysterious, you trip and fall, subsequently crushing the item ( -5 health (good job -_-))");
					potionValue = -1;
					itemName = "wow";
					player.setInventory(itemName);
					break;
			}
			return potionValue;
			}
			
		}
			class Weapon extends Item{	
//				public int[] attackValue = new int[3];
				//Programing attack, Math Attack, Art Attack , histroy, pshycology in this order
					public int[] weaponEncountered() {
						
//					PlayerTest player;

					Random rng = new Random();
					switch (rng.nextInt(6)) {
					case 0:
					case 1:
						System.out.println("You have recieved a #2 pencil ( Weak overall stat weapon)");
						attackValue[0] = 2;
						attackValue[1] = 3;
						attackValue[2] = 4;
						attackValue[3] = 4;
						attackValue[4] = 3;
						itemName = "#2 pencil";
						break;
					case 2:
						System.out.println("You have recieved an ascii cheat sheet for all programing languages(Strong Progtaming Weapon)");
						attackValue[0] = 8;
						attackValue[1] = 2;
						attackValue[2] = 1;
						attackValue[3] = 1;
						attackValue[4] = 1;
						
						itemName = "ascii cheet sheet";
						break;
					case 3:
						System.out.println("You have recieved a Texas Instrument Ti- 89 ( Strong Math stat weapon)");
						attackValue[0] = 4;
						attackValue[1] = 8;
						attackValue[2] = 1;
						attackValue[3] = 2;
						attackValue[4] = 1;
						itemName = "Texas Instrument";
						break;
					case 4:
						System.out.println("You have recieved a set of Princeton Series 7050 Kolinsky Sable Round paint brushes ( Strong Fine-Arts stat weapon)");
						attackValue[0] = 1;
						attackValue[1] = 2;
						attackValue[2] = 8;
						attackValue[3] = 2;
						attackValue[4] = 1;
						itemName = "Paint Brushes";
						break;
					case 5:
						System.out.println("You have recieved Mac ios Air ( Medium overall stat weapon)");
						attackValue[0] = 7;
						attackValue[1] = 6;
						attackValue[2] = 5;
						attackValue[3] = 6;
						attackValue[4] = 7;
						itemName = "Mac ios Air";
						break;
					}
					player.addweapons(itemName);
					return attackValue;
					}
				}
				}}
