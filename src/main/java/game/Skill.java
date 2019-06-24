package game;

public abstract class Skill {
  protected String skillName;
  protected double critProbability;
  protected double failProbability;
  protected Damage damage;
  protected static final double MEDIUMPROB = 0.5;
  
  public abstract Damage use();

}
