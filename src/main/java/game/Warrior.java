package src.main.java.game;

public class Warrior extends CharacterClass {
  public Warrior(){

  }

  public void fight(){
    this.activeSkill.use();
  }
}