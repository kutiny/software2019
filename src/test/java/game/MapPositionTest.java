package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MapPositionTest {
	
	MapPosition pos;
	
	@Before
	public void executedBeforeEach() {
		this.pos = new MapPosition(true);
	}
	
	@Test
	public void PositionNotExplorableString() {
		MapPosition pos = new MapPosition(false);
		assertEquals("M", pos.toString());
	}
	
	@Test
	public void PositionExploredString() {
		this.pos.toggleExplored();
		assertEquals("0", this.pos.toString());
	}
	
	@Test
	public void PositionNotExploredString() {
		assertEquals("+", this.pos.toString());
	}
}
