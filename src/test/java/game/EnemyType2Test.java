package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.*;

public class EnemyType2Test {

	EnemyType2 enemy;
	
	@Before
	public void ExecuteBeforeEach() {
		this.enemy = new EnemyType2();
	}
	
	@Test
	public void constructionTest() {
		assertNotNull("", this.enemy);
	}
	
	@Test
	public void fightTest() {
		Damage d = this.enemy.fight();
		assertNotNull("", d);
	}
	
	@Test
	public void notifyTest() {
		this.enemy.notifyHandler(2);
		assertEquals(2, this.enemy.getLevel());
	}
}
