package src.game;

public abstract class Skill {
  private String skillName;
  private float critProbability;
  private float failProbability;
  private int damagePoints;
  
  public abstract void use();

}
