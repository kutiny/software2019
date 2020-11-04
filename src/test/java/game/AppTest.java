package game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

	App app;

	@Before
	public void ExecuteBeforeEach() {
        this.app = new App();
	}

	@Test
	public void moveUpOkTest() {
        MapPosition mp = this.app.pos;
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Up");
        if (this.app.getMapa().getPosition(x, y - 1).isExplorable()){
            assertEquals(y - 1, this.app.getMapa().getYPos());
        } else {
            assertEquals(y, this.app.getMapa().getYPos());
        }
    }

	public void moveDownTest() {
        MapPosition mp = this.app.pos;
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Down");
        System.out.println(this.app.getMapa().getPosition(x, y + 1).isExplorable());
        if (this.app.getMapa().getPosition(x, y + 1).isExplorable()){
            assertEquals(y + 1, this.app.getMapa().getYPos());
        } else {
            assertEquals(y, this.app.getMapa().getYPos());
        }
	}
}
