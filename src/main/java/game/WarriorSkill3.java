package game;

public class WarriorSkill3 extends Skill {

  public WarriorSkill3(){
    this.skillName = "Chop";
    this.critProbability = 0.015;
    this.failProbability = 0.75;
    this.damage = new Damage(new DamageType("physical"), 104, 104);
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
