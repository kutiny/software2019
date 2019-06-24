package game;

public class WarriorSkill1 extends Skill {
	public WarriorSkill1(){
		this.skillName = "Slash";
		this.critProbability = 0.1;
		this.failProbability = 0.1;
		this.damage = new Damage(new DamageType("Physical"), 42, 42);
	}

	@Override
	public Damage use() {
		if( (this.failProbability+Math.random()) < MEDIUMPROB) {
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
