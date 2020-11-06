package observer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ObserverTest {
	CharacterLevelObserver clo;
	CharacterLifeObserver clife;

	@Before
	public void ExecuteBeforeEach() {
		this.clo = new CharacterLevelObserver();
		this.clife = new CharacterLifeObserver();
	}

	@Test
	public void notifyLevelTest() {
		this.clo.notifyHandler(3);
		assertEquals(3, this.clo.getLastValue());
	}

	@Test
	public void notifyLifeTest() {
		this.clife.notifyHandler(3);
		assertEquals(3, this.clife.getLastValue());
	}

	@Test
	public void lifeNotifyHandlerErrorTest() {
		int val = 3;
		this.clife.notifyHandler(val);
		this.clife.notifyHandler(null);
		assertEquals(val, this.clife.getLastValue());
	}

	@Test
	public void levelNotifyHandlerErrorTest() {
		int val = 3;
		this.clo.notifyHandler(val);
		this.clo.notifyHandler("test");
		assertEquals(val, this.clo.getLastValue());
	}

}
