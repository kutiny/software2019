package game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TrapTest {
	
	Trap t;
	
	@Before
	public void ExecuteBeforeEach() {
		this.t = new Trap();
	}
	
	@Test
	public void trapConstructor() {
		assertNotNull("", this.t);
	}
	
	@Test
	public void activationTest() {
		assertTrue(this.t.getActive());
	}
	
	@Test
	public void deactivateTest() {
		this.t.setDeactivated();
		assertFalse(this.t.getActive());
	}
}
