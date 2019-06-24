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
