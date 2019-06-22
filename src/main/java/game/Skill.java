package game;

public abstract class Skill {
  protected String skillName;
  protected double critProbability;
  protected double failProbability;
  protected Damage damage;
  
  public abstract void use();

}
