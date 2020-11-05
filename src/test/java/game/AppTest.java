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
        assertEquals(y - 1, this.app.getMapa().getYPos());
    }

	@Test
	public void moveRightOkTest() {
        MapPosition mp = this.app.pos;
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Right");
        assertEquals(x + 1, this.app.getMapa().getXPos());
    }

    @Test
	public void moveDownOkTest() {
        MapPosition mp = this.app.pos;
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Down");
        assertEquals(y + 1, this.app.getMapa().getYPos());
    }

    @Test
	public void moveLeftOkTest() {
        MapPosition mp = this.app.pos;
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Left");
        assertEquals(x - 1, this.app.getMapa().getXPos());
    }

    @Test
	public void moveUpErrorTest() {
        MapPosition mp = this.app.pos;
        this.app.move("Right");
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Up");
        assertEquals(y, this.app.getMapa().getYPos());
    }

    @Test
	public void moveUpWallErrorTest() {
        MapPosition mp = this.app.pos;
        this.app.move("Right");
        for (int i = 0; i < 7; i++) {
            this.app.move("Up");
        }
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Up");
        assertEquals(y, this.app.getMapa().getYPos());
    }

	@Test
	public void moveRightErrorTest() {
        MapPosition mp = this.app.pos;
        this.app.move("Up");
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Right");
        assertEquals(x, this.app.getMapa().getXPos());
    }

    @Test
	public void moveDownErrorTest() {
        MapPosition mp = this.app.pos;
        this.app.move("Right");
        this.app.move("Right");
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Down");
        assertEquals(y, this.app.getMapa().getYPos());
    }

    @Test
	public void moveLeftErrorTest() {
        MapPosition mp = this.app.pos;
        this.app.move("Right");
        this.app.move("Right");
        this.app.move("Up");
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.move("Left");
        assertEquals(x, this.app.getMapa().getXPos());
    }

    @Test
    public void moveFightAndRestTest() {
        CharacterClass me = new Mage();
        this.app.setcharaClass(me.getClassName());
        this.app.setcharaName("test");
        MapPosition mp = this.app.pos;
        this.app.move("Down");
        this.app.setHuir(false);
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.rest();
        this.app.move("Down");

        Enemy e = this.app.getDuel().getEnemy();
        while(e.getHp() > 0) {
            this.app.skill(1);
        }

        assertEquals(e.getHp(), 0);
    }

    @Test
    public void moveHuirTest() {
        CharacterClass me = new Mage();
        this.app.setcharaClass(me.getClassName());
        this.app.setcharaName("test");
        MapPosition mp = this.app.pos;
        this.app.move("Down");
        this.app.setHuir(true);
        int x = this.app.getMapa().getXPos();
        int y = this.app.getMapa().getYPos();
        this.app.rest();
        this.app.move("Down");

        Duel d = this.app.getDuel();
        Enemy e;
        if (d != null) {
            e = d.getEnemy();
            if (e != null) {
                while(e.getHp() > 0) {
                    this.app.skill(1);
                }
                assertEquals(e.getHp(), 0);
            } else {
                assertEquals(null, e);
            }
        }
        assertEquals(null, d);
    }

    @Test
    public void StartHistoryTest() {
        String t = this.app.getHistory();
        assertEquals("Bienvenido", t);
    }

}
