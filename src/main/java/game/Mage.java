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
		  armor=0.1;
		  magicResist=0.2;

	  }

	  public Damage fight(){
	    return this.activeSkill.use();
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
