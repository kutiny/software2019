package game;

public class ArcherSkill2 extends Skill{
	public ArcherSkill2() {
		  this.skillName = "Fire Arrow";
		  this.critProbability = 0.30;
		  this.failProbability = 0.3;
		  this.damage= new Damage(new DamageType("magical"), 50, 50);
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
}

