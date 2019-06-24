package game;

import java.util.ArrayList;

public class Mage extends CharacterClass {
	  public Mage(){
		  this.className="Mage";
		  this.skills= new ArrayList<Skill>();
		  this.skills.add(new MageSkill1());
		  this.skills.add(new MageSkill2());
		  this.skills.add(new MageSkill3());
		  maxHealth=200;
		  armor=100;
		  magicResist=200;

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