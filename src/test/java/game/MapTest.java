package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MapTest {
	
	Map m;
	
	@Before
	public void ExecuteBeforeEach() {
		this.m = new Map();
	}
	
	@Test
	public void constructTest() {
		assertNotNull("", this.m);
	}
	
	@Test
	public void toStringTest() {
		assertNotNull("", this.m.toString());
	}
	
	@Test
	public void getEnemiesTest() {
		assertNotNull("", this.m.getEnemies());
	}
	
	@Test
	public void setEnemiesTest() {
		ArrayList<Enemy> enemies = new ArrayList<>();
		enemies.add(new EnemyType1());
		this.m.setEnemies(enemies);
		assertNotNull("", this.m.getEnemies().get(0));
	}
	
	@Test
	public void moveUpTest() {
		this.m.move("Up");
		assertEquals(6, this.m.getYPos());
	}
	
	@Test
	public void moveDownTest() {
		this.m.move("Down");
		assertEquals(8, this.m.getYPos());
	}
	
	@Test
	public void moveLeftTest() {
		this.m.move("Left");
		assertEquals(3, this.m.getXPos());
	}
	
	@Test
	public void moveRightTest() {
		this.m.move("Right");
		assertEquals(5, this.m.getXPos());
	}
	
}
