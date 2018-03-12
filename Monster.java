import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
public class Monster{
	public String MonsterName;
	public String MonsterSentence;
	public static int FLOOR_DIFFICULTY = Floor.floorNum * 3;
	public static int DIFFICULTY_FOR_BOSSES_TO_SPAWN = 15;
	public int MonsterHealth;
	public int[] MonsterResistence = new int[3];
	public int[] MonsterAttackValue = new int[3];
	
	public static final int CS_INDEX = 0;
	public static final int MATH_INDEX = 1; 
	public static final int FINE_ARTS_INDEX = 2;
	
	

	public boolean isBoss;
	private Random rng = new Random();
	
	public Monster() {
		
	}
	public Monster( int MonsterHealth, int[]MonasterMonsterAttackValue) { //remove type later.!!!!
		this.MonsterHealth= MonsterHealth;
		this.MonsterAttackValue = MonsterAttackValue;
	}
	/*
	 * public void EvaluateMonsterType(boolean isBoss) {
		if(!isBoss) {
			Minion minion = new Minion(FLOOR_DIFFICULTY);
			minion.MonsterEncountered();
		}
		else {
			BossMonster bossMonster = new BossMonster();
			bossMonster.MonsterEncountered();
		}
	}
	 */
	
	
		
}

class Minion extends Monster{
	
	public String MonsterName;
	public String MonsterSentence;
	public static int FLOOR_DIFFICULTY = Floor.floorNum * 3;
	public static int DIFFICULTY_FOR_BOSSES_TO_SPAWN = 15;
	public int MonsterHealth;
	public int[] MonsterResistence = new int[3];
	public int[] MonsterAttackValue = new int[3];
	
	public static final int CS_INDEX = 0;
	public static final int MATH_INDEX = 1; 
	public static final int FINE_ARTS_INDEX = 2;
	
	private static final Random RNG = new Random();
	
	public Minion(int FLOOR_DIFFICULTY, boolean isBoss) {
		if(!isBoss) {
			MinionEncountered(); //bad method name my dude
		}
		else {
			BossEncountered();
		}
	}
	public void MinionEncountered() {
	
		switch (RNG.nextInt(FLOOR_DIFFICULTY)) {
		case 0:
		case 1:
		case 2:
			MonsterSentence = "You have encountered an art homeowork to make a sketch(Easy Difficulty)";
			MonsterAttackValue[CS_INDEX] = 11;
			MonsterAttackValue[MATH_INDEX] = 13;
			MonsterAttackValue[FINE_ARTS_INDEX] = 15;
			MonsterName = "Art Homework (Easy Difficulty)";
			MonsterHealth = 10;
			MonsterResistence[CS_INDEX] = -15;
			MonsterResistence[MATH_INDEX] = -15;
			MonsterResistence[FINE_ARTS_INDEX] = 11;
		case 3:
		case 4:
		case 5:			
			MonsterSentence = "You have encountered a Java PA homework assignment(Easy Difficulty)";
			MonsterAttackValue[CS_INDEX] = 15;
			MonsterAttackValue[MATH_INDEX] = 13;
			MonsterAttackValue[FINE_ARTS_INDEX] = 11;
			MonsterName = "PA Assignment (Easy Difficulty)";
			MonsterHealth = 10;
			MonsterResistence[CS_INDEX] = 11;
			MonsterResistence[MATH_INDEX] = -12;
			MonsterResistence[FINE_ARTS_INDEX] = -18;
			break;
		case 7:
		case 8:
		case 9:			
			MonsterSentence = "You have encountered a linear Algebra Pop quiz(Easy Difficulty)";
			MonsterAttackValue[CS_INDEX] = 13;
			MonsterAttackValue[MATH_INDEX] = 15;
			MonsterAttackValue[FINE_ARTS_INDEX] = 11;
			MonsterName = "Linear Algebra Pop Quiz (Easy Difficulty)";
			MonsterHealth = 10;
			MonsterResistence[CS_INDEX] = -12;
			MonsterResistence[MATH_INDEX] = 11;
			MonsterResistence[FINE_ARTS_INDEX] = -18;
			break;
		case 10:
		case 11:
			MonsterSentence = "You have encountered a Fine Arts Midterm(Medium Boss Difficulty)";
				MonsterAttackValue[CS_INDEX] = 14;
			MonsterAttackValue[MATH_INDEX] = 14;
			MonsterAttackValue[FINE_ARTS_INDEX] = 15;
			MonsterName = "Fine Arts Midterm (Medium Boss Difficulty";
			MonsterHealth = 20;
			MonsterResistence[CS_INDEX] = -12;
			MonsterResistence[MATH_INDEX] = -13;
			MonsterResistence[FINE_ARTS_INDEX] = 13;
			break;
		case 12:
		case 13:
			MonsterSentence = "You have encountered a Calculouse Midterm(Medium Monster Difficulty)";
			MonsterAttackValue[CS_INDEX] = 16;
			MonsterAttackValue[MATH_INDEX] = 20;
			MonsterAttackValue[FINE_ARTS_INDEX] = 13;
			MonsterName = "Calculus Midterm (Medium Boss Difficulty)";
			MonsterHealth = 20;
			MonsterResistence[CS_INDEX] = 10;
			MonsterResistence[MATH_INDEX] = 13;
			MonsterResistence[FINE_ARTS_INDEX] = -15;
			break;
		case 14:
		case 15:			
			MonsterSentence = "You have encountered a CSE11 Midterm(Medium Boss Difficulty)";
			MonsterAttackValue[CS_INDEX] = 20;
			MonsterAttackValue[MATH_INDEX] = 16;
			MonsterAttackValue[FINE_ARTS_INDEX] = 13;
			MonsterName = "CSE11 Midterm(Medium Boss Difficulty)";
			MonsterHealth = 20;
			MonsterResistence[CS_INDEX] = 13;
			MonsterResistence[MATH_INDEX] = 10;
			MonsterResistence[FINE_ARTS_INDEX] = -15;
			break;
		case 16:
			MonsterSentence = "You have encountered a CSE11 Fianl Computer Science Assignment(Hard Boss Difficulty)";
			MonsterAttackValue[CS_INDEX] = 30;
			MonsterAttackValue[MATH_INDEX] = 20;
			MonsterAttackValue[FINE_ARTS_INDEX] = 17;
			MonsterName = "CSE11 Final Computer Science Assignment(Hard Boss Difficulty)";
			MonsterHealth = 35;
			MonsterResistence[CS_INDEX] = 20;
			MonsterResistence[MATH_INDEX] = 15;
			MonsterResistence[FINE_ARTS_INDEX] = 12;
			break;
		case 17:
			MonsterSentence = "You have encountered a 3 Math 140: Real Analysis due in 5 hours(Hard Boss Difficulty)";
			MonsterAttackValue[CS_INDEX] = 20;
			MonsterAttackValue[MATH_INDEX] = 30;
			MonsterAttackValue[FINE_ARTS_INDEX] = 17;
			MonsterName =  "3 Math Homeworks due 5 hours(Hard Boss Difficulty)";
			MonsterHealth = 35;
			MonsterResistence[CS_INDEX] = 20;
			MonsterResistence[MATH_INDEX] = 15;
			MonsterResistence[FINE_ARTS_INDEX] = 32;
			break;
		case 18:
			MonsterSentence = "You have encountered a CSE11 Midterm(Medium Boss Difficulty)";
			MonsterAttackValue[CS_INDEX] = 19;
			MonsterAttackValue[MATH_INDEX] = 19;
			MonsterAttackValue[FINE_ARTS_INDEX] = 30;
			MonsterName = "Fine Arts Midterm (Medium Boss Difficulty)";
			MonsterHealth = 35;
			MonsterResistence[CS_INDEX] = 14;
			MonsterResistence[MATH_INDEX] = 14;
			MonsterResistence[FINE_ARTS_INDEX] = 20;
			break;
		case 19:
		case 20:
			break;
		}
	}
	
	public void BossEncountered() {
		switch (RNG.nextInt(2)) {
		case 0:
			MonsterSentence = "You have encountered an art project! (boss)";
			MonsterAttackValue[CS_INDEX] = 10;
			MonsterAttackValue[MATH_INDEX] = 20;
			MonsterAttackValue[FINE_ARTS_INDEX] = 15;
		case 1:
			MonsterName = "You have encountered a PA! (boss)";
			MonsterHealth = 10;
			MonsterResistence[CS_INDEX] = -15;
			MonsterResistence[MATH_INDEX] = -15;
			MonsterResistence[FINE_ARTS_INDEX] = 10;
			break;
		}
	}
}


/*
 * class BossMonster extends Monster{
	public String MonsterName;
	public String MonsterSentence;
	public static int FLOOR_DIFFICULTY = Floor.floorNum * 3;
	public static int DIFFICULTY_FOR_BOSSES_TO_SPAWN = 15;
	public int MonsterHealth;
	public int[] MonsterResistence = new int[3];
	public int[] MonsterAttackValue = new int[3];
	
	public static final int CS_INDEX = 0;
	public static final int MATH_INDEX = 1; 
	public static final int FINE_ARTS_INDEX = 2;
	
	private static final Random RNG = new Random();
	


	}
}
 */
