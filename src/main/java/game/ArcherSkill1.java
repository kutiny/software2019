package game;

public class ArcherSkill1 extends Skill{
	public ArcherSkill1() {
		this.skillName = "Poison Arrow";
		this.critProbability = 0.15;
		this.failProbability = 0.2;
		this.damage= new Damage(new DamageType("physical"), 56, 56);
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
