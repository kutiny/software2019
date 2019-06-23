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

