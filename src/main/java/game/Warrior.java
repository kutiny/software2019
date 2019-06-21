package game;

import java.util.ArrayList;

public class Warrior extends CharacterClass {
  public Warrior(){
	  this.className="Warrior";
	  this.skills= new ArrayList<Skill>();
	  this.skills.add(new WarriorSkill1());
	  this.skills.add(new WarriorSkill2());
	  this.skills.add(new WarriorSkill3());
	  activeSkill=null;
	  maxHealth=200;
	  armor=200;
	  magicResist=100;

  }

  public int fight(){
    return this.activeSkill.use();
  }
}