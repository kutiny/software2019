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
			damage.setDamagePoints(0);
		}
		else if (this.critProbability + Math.random() < MEDIUMPROB) {
			damage.setDamagePoints(damage.getBasicDamagePoints() * 2);
		}
		else {
			damage.setDamagePoints(damage.getBasicDamagePoints());
		}
		return damage;
	}
}

