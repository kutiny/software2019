package game;

public class WarriorSkill3 extends Skill {

	public WarriorSkill3(){
		this.skillName = "Chop";
		this.critProbability = 0.015;
		this.failProbability = 0.75;
		this.damage = new Damage(new DamageType("Physical"), 104, 104);
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
