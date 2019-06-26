package game;

import org.junit.Test;

public class NegativeDamageTest {
	
	  @Test(expected = IllegalArgumentException.class)	
	public void AttackNegativeDamageTest() {
		Character character = new Character();
		Enemy enemy = new EnemyType1();
		Duel duel = new Duel(character, enemy);
	
		character.setCharaClass(new Mage());
		character.setActiveEnemy(enemy);
		MageSkill1 skill = new MageSkill1(); 
		Damage damage= new Damage(new DamageType("physical"), -34, -34);
		skill.setDamage(damage);
		character.getCharaClass().setActiveSkill(skill);
		
		duel.characterAttack();
		duel.EnemyAttack();
	}
	  
	  
//	@Test(expected = IllegalArgumentException.class)	  
//	public void EnemyAttackNegativeDamageTest() {
//		Character character = new Character();
//		Enemy enemy = new EnemyType1();
//		Duel duel = new Duel(character, enemy);
//		
//		character.setCharaClass(new Mage());
//		character.setActiveEnemy(enemy);
//		Damage damage = new Damage (new DamageType("magical"), -34, -34);
//		enemy.setDamage(damage);
//		character.getCharaClass().setActiveSkill(new MageSkill1());
//			
//		duel.characterAttack();
//		duel.EnemyAttack();
//		}	
	
}
