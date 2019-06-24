package game;

import java.util.ArrayList;

public class Warrior extends CharacterClass {
  public Warrior(){
	  this.className="Warrior";
	  this.skills= new ArrayList<Skill>();
	  this.skills.add(new WarriorSkill1());
	  this.skills.add(new WarriorSkill2());
	  this.skills.add(new WarriorSkill3());
	  maxHealth=200;
	  armor=200;
	  magicResist=100;

  }

  public Damage fight(){
    return this.activeSkill.use();
  }

@SuppressWarnings("unlikely-arg-type")
@Override
public int calculateRecievedDamage(Damage damage) {
	if ((damage.getDamageType()).equals("physical")){
		return (damage.getDamageAmmount()/(this.armor/100));
	}
	else
		return damage.getDamageAmmount()/(this.magicResist/100);
}
}