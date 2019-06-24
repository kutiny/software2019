package game;

public class MageSkill2 extends Skill{
	public MageSkill2() {
		this.skillName = "Wildfire";
		this.critProbability = 0.30;
		this.failProbability = 0.25;
		this.damage= new Damage(new DamageType("magical"), 58, 58);
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

