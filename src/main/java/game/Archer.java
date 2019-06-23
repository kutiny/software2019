package game;

import java.util.ArrayList;

public class Archer extends CharacterClass {
	  public Archer(){
		  this.className="Archer";
		  this.skills= new ArrayList<Skill>();
		  this.skills.add(new ArcherSkill1());
		  this.skills.add(new ArcherSkill2());
		  this.skills.add(new ArcherSkill3());
		  activeSkill=null;
		  maxHealth=200;
		  armor=150;
		  magicResist=100;

	  }

	  public Damage fight(){
	    return this.activeSkill.use();
	  }

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public int calculateRecievedDamage(Damage damage) {
		if ((damage.getDamageType()).equals("physical")){
			return (damage.getDamagePoints()/(this.armor/100));
		}
		else
			return damage.getDamagePoints()/(this.magicResist/100);
	}
}