package game;
import game.Character;
import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterTest {
  
  @Test
  public void levelUpTest(){
    Character uc = new Character();
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
	  character.addExp(1200);
	  assertEquals(2, character.getLevel());
  }
  
  @Test (expected = IllegalStateException.class)
  public void noEnemyToFightTest() {
	  Character character = new Character();
	  character.setActiveEnemy(null);
	  character.fight();
  }

  
//  @Test(expected = IllegalStateException.class)	
//  public void notCharacterTurnTest() {
//	Character character = new Character();
//	Enemy enemy = new EnemyType1();
//	Duel duel = new Duel(character, enemy);
//
//	character.setCharaClass(new Archer());
//	character.setActiveEnemy(enemy);
//	character.getCharaClass().setActiveSkill(new ArcherSkill1());
//	
//	duel.characterAttack();
//	duel.characterAttack();
//}
 
}
