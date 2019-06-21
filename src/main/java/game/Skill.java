package game;

public abstract class Skill {
  protected String skillName;
  protected double critProbability;
  protected double failProbability;
  protected int damagePoints;
  
  public abstract int use();

}
