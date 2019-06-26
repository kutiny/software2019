package game;

public class MageSkill1 extends Skill{
	public MageSkill1() {
		this.skillName = "Winter's Grasp";
		this.critProbability = 0.15;
		this.failProbability = 0.2;
		this.damage= new Damage(new DamageType("magical"), 53, 53);
	}


	@Override
	public Damage use() {
		if( (this.failProbability + Math.random()) < MEDIUMPROB) {
			damage.setDamageAmmount(0);
		}
		else if (this.critProbability + Math.random() < MEDIUMPROB) {
			damage.setDamageAmmount(damage.getBasicDamageAmmount() * 2);
		}
		else {
			damage.setDamageAmmount(damage.getBasicDamageAmmount());
		}
		return damage;
	}
	
	public void setDamage(Damage dmg) {
		this.damage=dmg;
	}
}

