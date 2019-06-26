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
		System.out.println("Daño a recibir base:" + damage.getDamageAmmount());
		int danio = damage.getDamageAmmount();
		System.out.println("MR" + this.magicResist);
		String type = damage.getDamageType().toString();
		if (type.equals("physical")){
			int danioARecibir = (int)(danio * (1.0 - this.armor));
			System.out.println("daño a recibir:" + danioARecibir);
			return danioARecibir;
		}
		else {
			int danioARecibir = (int)(danio * (1.0 - this.magicResist));
			double multiplier = 1 - this.magicResist;
			System.out.println("multip:" + multiplier);
			System.out.println("daño a recibir:" + danioARecibir);
			return danioARecibir;			
		}
	}

}