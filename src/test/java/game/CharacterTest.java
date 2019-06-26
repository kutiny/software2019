package game;
import game.Character;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterTest {
  
  @Test
  public void levelUpTest(){
    Character uc = new Character();
    uc.setCharaClass(new Mage());
    uc.levelUp();
    assertEquals(2, uc.getLevel());
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void negativeExperienceTest() {
	  Character character = new Character();
	  character.addExp(-40);
  }
  
  @Test 
  public void addExpAndLevelUpTest() {
	  Character character = new Character();
	  character.setCharaClass(new Archer());
	  character.addExp(1200);
	  assertEquals(2, character.getLevel());
  }
  
  @Test (expected = IllegalStateException.class)
  public void noEnemyToFightTest() {
	  Character character = new Character();
	  character.setActiveEnemy(null);
	  character.fight();
  }

  
  @Test
  public void notCharacterTurnTest() {
	  boolean thrown = false;
	  try {
		  Character character = new Character();
		  Enemy enemy = new EnemyType1();
		  Duel duel = new Duel(character, enemy);
		  
		  character.setCharaClass(new Archer());
		  character.setActiveEnemy(enemy);
		  character.getCharaClass().setActiveSkill(character.getCharaClass().getSkills().get(0));
		  
		  duel.characterAttack();
		  duel.characterAttack();	  
	  }catch(IllegalStateException e) {
		  thrown = true;
	  }
	  assertEquals(true, thrown);
  }
  
  @Test
  public void nameTest() {
	  Character character = new Character();
	  character.setName("Ellie");
	  assertEquals(character.getName(), "Ellie");
  }
  
  @Test
  public void characterClassTest() {
	  Character character = new Character();
	  character.setCharaClass(new Warrior());
	  assertEquals(character.getCharaClass().getClassName(), "Warrior");
  }
  
  @Test
  public void skillLevelUpTest(){
    Character uc = new Character();
    uc.setCharaClass(new Warrior());
    Skill activeSkill = uc.getCharaClass().getSkills().get(0); 
    uc.getCharaClass().setActiveSkill(activeSkill);
    int actualSkillDamage = uc.getCharaClass().getActiveSkill().getDamage().getBasicDamageAmmount();
    uc.levelUp();
    int newSkillDamage = uc.getCharaClass().getActiveSkill().getDamage().getBasicDamageAmmount();
    assertTrue(newSkillDamage > actualSkillDamage);
  }
    
 
}
