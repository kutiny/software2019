package game;

import java.util.ArrayList;

public class Archer extends CharacterClass {
	  public Archer(){
		  this.className="Archer";
		  this.skills = new ArrayList<Skill>();
		  this.skills.add(new ArcherSkill1());
		  this.skills.add(new ArcherSkill2());
		  this.skills.add(new ArcherSkill3());
		  maxHealth=200;
		  armor=0.15;
		  magicResist=0.15;

	  }

	  public Damage fight(){
		  Damage d = this.activeSkill.use();
		  return d;
	  }

	public int calculateRecievedDamage(Damage damage) {
		int danio = damage.getDamageAmmount();
		String type = damage.getDamageType().toString();
		if (type.equals("physical")){
			int danioARecibir = (int)(danio * (1.0 - this.armor));
			return danioARecibir;
		}
		else {
			int danioARecibir = (int)(danio * (1.0 - this.magicResist));
			return danioARecibir;
		}
	}
}
