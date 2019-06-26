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
		duel.enemyAttack();
	}	

	  
	  
	@Test(expected = IllegalArgumentException.class)	  
	public void EnemyAttackNegativeDamageTest() {
		Character character = new Character();
		Enemy enemy = new EnemyType1();
		character.setCharaClass(new Mage());
		character.setActiveEnemy(enemy);
		character.getCharaClass().setActiveSkill(new MageSkill1());
		Damage damage = new Damage (new DamageType("magical"), -40, 30);
		enemy.setDamage(damage);
		Duel duel = new Duel(character, enemy);
	
		duel.characterAttack();
		duel.enemyAttack();
		}	
	
}
