package game;

import java.util.ArrayList;

public abstract class CharacterClass  {
  protected String className;
  protected ArrayList<Skill> skills;
  protected Skill activeSkill;
  protected int maxHealth;
  protected double armor;
  protected double magicResist;
  protected Damage damage;

  public abstract Damage fight();
  public abstract int calculateRecievedDamage(Damage damage);
  
  public String getClassName() {
	  return this.className;
  }
  public void setActiveSkill(Skill skill){
    this.activeSkill = skill;
  }
  
  public ArrayList<Skill> getSkills(){
	  return this.skills;
  }
  
  
  public void statsLevelUp() {
		double toIncreaseArmor;
		double toIncreaseMagicResist;
		toIncreaseArmor= this.getArmor()/10;
		this.setArmor( Math.round(this.getArmor() + toIncreaseArmor));
		
		toIncreaseMagicResist= this.getMagicResist()/10;
		this.setMagicResist( (int) (this.getMagicResist() + toIncreaseMagicResist) );
  }
  
  
  
  public void SkillsLevelUp() {
	  int toIncreaseBasicDmg;
	  for(int i=0; i<skills.size(); i++) {
		  
		 toIncreaseBasicDmg = Math.round(( skills.get(i).getDamage().getBasicDamageAmmount() )/10);
		 skills.get(i).getDamage().setBasicDamageAmmount( skills.get(i).getDamage().getBasicDamageAmmount() + toIncreaseBasicDmg);
	  }
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

  public void setArmor(double ap){
    this.armor = ap;
  }

  public double getArmor(){
    return this.armor;
  }

  public void setMagicResist(double mr){
    this.magicResist = mr;
  }

  public double getMagicResist(){
    return this.magicResist;
  }

  
  public void setSkills(ArrayList<Skill> skills) {
	  this.skills = skills;
  }
  
  
  
}

