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
	  armor=0.2;
	  magicResist=0.1;

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
