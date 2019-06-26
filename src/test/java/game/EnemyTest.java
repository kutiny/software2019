package game;


import org.junit.Test;
import static org.junit.Assert.*;

public class EnemyTest {
	@Test
	public void levelUpTestWithSubscriptionToCharacter() {
		Character c = new Character();
		CharacterClass clase = new Warrior();
		c.setCharaClass(clase);
		
		Enemy e = new EnemyType1();
		
		c.levelObservable.subscribe(e);
		c.levelUp();
		
		assertEquals(2, e.getLevel());
	}
}
