package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
public class DamageTypeTest {
	
	DamageType d;
	
	@Before
	public void ExecuteBeforeEach() {
		this.d = new DamageType("physical");
	}
	
	@Test
	public void toStringTest() {
		assertEquals(this.d.toString(), "physical");
	}
}
