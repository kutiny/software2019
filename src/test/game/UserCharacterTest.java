package test.game;
import org.junit.*;
import static org.junit.Assert.assertEquals;

import src.game.*;

public class UserCharacterTest{

  UserCharacter character;

  @BeforeEach
  public void initEach() {
    this.character = new UserCharacter();
  }
  @Test
  @DisplayName("LevelUp Test")
  public void levelUpTest(){
    this.character.levelUp();
    assertEquals(3, this.character.getLevel());
  }

  public void setMaxHealthTest(){

  }
}
