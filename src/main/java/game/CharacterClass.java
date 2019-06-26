package game;

import java.util.ArrayList;

public abstract class CharacterClass  {
  protected String className;
  protected ArrayList<Skill> skills;
  protected Skill activeSkill;
  protected int maxHealth;
  protected int armor;
  protected int magicResist;
  protected Damage damage;

  public abstract Damage fight();
  public abstract int calculateRecievedDamage(Damage damage);
  
  public void setActiveSkill(Skill skill){
    this.activeSkill = skill;
  }

  public Skill getActiveSkill(){
    return this.activeSkill;
  }

  public void setMaxHealth(int hp) throws IllegalArgumentException{
	  if(hp<0) {
		  throw new IllegalArgumentException("Los HP maximos no pueden ser negativos");
	  }
    this.maxHealth = hp;
  }

  public int getMaxHealth(){
    return this.maxHealth;
  }

  public void setArmor(int ap){
    this.armor = ap;
  }

  public int getArmor(){
    return this.armor;
  }

  public void setMagicResist(int mr){
    this.magicResist = mr;
  }

  public int getMagicResist(){
    return this.magicResist;
  }

  public ArrayList<Skill> getSkills() {
	  return this.skills;
  }
  
  public void setSkills(ArrayList<Skill> skills) {
	  this.skills = skills;
  }
  
  
  
}

