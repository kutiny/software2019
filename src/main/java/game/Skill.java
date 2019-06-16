package src.main.java.game;

public abstract class Skill {
  protected String skillName;
  protected float critProbability;
  protected float failProbability;
  protected int damagePoints;
  
  public abstract void use();

}
