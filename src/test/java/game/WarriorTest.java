package game;

import src.main.java.game.Warrior;
import org.junit.Test;
import static org.junit.Assert.*;

public class WarriorTest {

  Warrior warrior = new Warrior();

  @Test
  public void setMaxHealthTest(){
    this.warrior.setMaxHealth(200);
    assertEquals(200, this.warrior.getMaxHealth());
  }
}