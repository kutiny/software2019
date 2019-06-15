package game;
import src.main.java.game.Character; 
import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterTest {
  
  @Test
  public void levelUpTest(){
    Character uc = new Character();
    uc.levelUp();
    assertEquals(2, uc.getLevel());
  }

}
