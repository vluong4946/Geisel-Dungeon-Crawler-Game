import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
public class Monster extends testMonster{
	public String MonsterSentence;
	private int MonsterHealth;
	private int[] MonsterResistence = new int[3];
	public int[] MonsterAttackValue = new int[3];
	public String MonsterName;
	//test remove later!!!!
	public int type = 1;
	public Monster() {
		EvaluateMonsterType(type);
	}
	public Monster( int MonsterHealth, int[]MonasterMonsterAttackValue) { //remove type later.!!!!
		this.MonsterHealth= MonsterHealth;
		this.MonsterAttackValue = MonsterAttackValue;
	}
	public void EvaluateMonsterType( int type) {
		if(type == 1) {
			Minion minion = new Minion();
			minion.MonsterEncountered();
		}
		else {
			BossMonster bossMonster = new BossMonster();
			bossMonster.MonsterEncountered();
		}
	}
	public class Minion{
		public void MonsterEncountered() {
		//Monster Attack Value in this order Programing, Math, and Fine arts;
		Random rng = new Random();
		switch (rng.nextInt(21)) {
		case 0:
		case 1:
		case 2:
			MonsterSentence = "You have encountered an art homeowork to make a sketch(Easy Difficulty)";
			MonsterAttackValue[0] = 1;
			MonsterAttackValue[1] = 3;
			MonsterAttackValue[2] = 5;
			MonsterName = "art homeowork to make a sketch(Easy Difficulty)";
			MonsterHealth = 10;
			MonsterResistence[0] = -5;
			MonsterResistence[1] = -5;
			MonsterResistence[2] = 1;
		case 3:
		case 4:
		case 5:			
			MonsterSentence = "You have encountered a C++ homework assignment(Easy Difficulty)";
			MonsterAttackValue[0] = 5;
			MonsterAttackValue[1] = 3;
			MonsterAttackValue[2] = 1;
			MonsterName = "C++ homework assignment(Easy Difficulty)";
			MonsterHealth = 10;
			MonsterResistence[0] = 1;
			MonsterResistence[1] = -2;
			MonsterResistence[2] = -8;
			break;
		case 7:
		case 8:
		case 9:			
			MonsterSentence = "You have encountered a linear Algebra Pop quiz(Easy Difficulty)";
			MonsterAttackValue[0] = 3;
			MonsterAttackValue[1] = 5;
			MonsterAttackValue[2] = 1;
			MonsterName = "Algebra Pop quiz(Easy Difficulty)";
			MonsterHealth = 10;
			MonsterResistence[0] = -2;
			MonsterResistence[1] = 1;
			MonsterResistence[2] = -8;
			break;
		case 10:
		case 11:
			MonsterSentence = "You have encountered a Fine Arts Midterm(Medium Boss Difficulty)";
			MonsterAttackValue[0] = 4;
			MonsterAttackValue[1] = 4;
			MonsterAttackValue[2] = 15;
			MonsterName = "Fine Arts Midterm (Medium Boss Difficulty)";
			MonsterHealth = 20;
			MonsterResistence[0] = -2;
			MonsterResistence[1] = -3;
			MonsterResistence[2] = 3;
			break;
		case 12:
		case 13:
			MonsterSentence = "You have encountered a Calculouse Midterm(Medium Monster Difficulty)";
			MonsterAttackValue[0] = 6;
			MonsterAttackValue[1] = 10;
			MonsterAttackValue[2] = 3;
			MonsterName = "Calculouse Midterm (Medium Boss Difficulty)";
			MonsterHealth = 20;
			MonsterResistence[0] = 0;
			MonsterResistence[1] = 3;
			MonsterResistence[2] = -5;
			break;
		case 14:
		case 15:			
			MonsterSentence = "You have encountered a CSE11 Midterm(Medium Boss Difficulty)";
			MonsterAttackValue[0] = 10;
			MonsterAttackValue[1] = 6;
			MonsterAttackValue[2] = 3;
			MonsterName = "CSE11 Midterm(Medium Boss Difficulty)";
			MonsterHealth = 20;
			MonsterResistence[0] = 3;
			MonsterResistence[1] = 0;
			MonsterResistence[2] = -5;
			break;
		case 16:
			MonsterSentence = "You have encountered a CSE11 Fianl Programing Assignment(Hard Boss Difficulty)";
			MonsterAttackValue[0] = 20;
			MonsterAttackValue[1] = 10;
			MonsterAttackValue[2] = 7;
			MonsterName = "CSE11 Fianl Programing Assignment(Hard Boss Difficulty)";
			MonsterHealth = 35;
			MonsterResistence[0] = 10;
			MonsterResistence[1] = 5;
			MonsterResistence[2] = 2;
			break;
		case 17:
			MonsterSentence = "You have encountered a 3 Math 140: Real Analysis due in 5 hours(Hard Boss Difficulty)";
			MonsterAttackValue[0] = 10;
			MonsterAttackValue[1] = 20;
			MonsterAttackValue[2] = 7;
			MonsterName =  "3 Math Homeworks due 5 hours(Hard Boss Difficulty)";
			MonsterHealth = 35;
			MonsterResistence[0] = 10;
			MonsterResistence[1] = 5;
			MonsterResistence[2] = 2;
			break;
		case 18:
			MonsterSentence = "You have encountered a CSE11 Midterm(Medium Boss Difficulty)";
			MonsterAttackValue[0] = 9;
			MonsterAttackValue[1] = 9;
			MonsterAttackValue[2] = 20;
			MonsterName = "Fine Arts Midterm (Medium Boss Difficulty)";
			MonsterHealth = 35;
			MonsterResistence[0] = 4;
			MonsterResistence[1] = 4;
			MonsterResistence[2] = 10;
			break;
		case 19:
		case 20:
			break;
		}
		}
	}
		public class BossMonster{
			//			public BossMonster() {
//	}
			public void MonsterEncountered() {
			//Monster Attack Value in this order Programing, Math, and Fine arts;
			Random rng = new Random();
			switch (rng.nextInt(1)) {
			case 0:
				MonsterSentence = "You have encountered an art homeowork to make a sketch(Easy Difficulty)";
				MonsterAttackValue[0] = 1;
				MonsterAttackValue[1] = 3;
				MonsterAttackValue[2] = 5;
				MonsterName = "art homeowork to make a sketch(Easy Difficulty)";
				MonsterHealth = 10;
				MonsterResistence[0] = -5;
				MonsterResistence[1] = -5;
				MonsterResistence[2] = 1;
				break;
			}

}
}
}

	

