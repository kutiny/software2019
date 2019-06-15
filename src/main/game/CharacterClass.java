package src.main.game;

import java.util.ArrayList;

public abstract class CharacterClass {
  private String className;
  private ArrayList<Skill> skills;
  private Skill activeSkill;
  private int maxHealth;
  private int armor;
  private int magicResist;

  public abstract void fight();
  
  public void setSkill(Skill skill){
    this.activeSkill = skill;
  }

  public Skill getSkill(){
    return this.activeSkill;
  }

  public void setMaxHealth(int hp){
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

  public int getMagiResist(){
    return this.magicResist;
  }

}

