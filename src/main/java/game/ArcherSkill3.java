package game;

public class ArcherSkill3 extends Skill{
	public ArcherSkill3() {
		  this.skillName = "Long Shot";
		  this.critProbability = 0.15;
		  this.failProbability = 0.15;
		  this.damage= new Damage(new DamageType("physical"), 39, 39);
	}

	@Override
	public Damage use() {
		// TODO Auto-generated method stub
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
