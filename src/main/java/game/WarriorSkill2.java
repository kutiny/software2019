package game;

public class WarriorSkill2 extends Skill {

  public WarriorSkill2(){
    this.skillName = "Double Slash";
    this.critProbability = 0.05;
    this.failProbability = 0.5;
    this.damage = new Damage(new DamageType("physical"), 71, 71);
  }


  	@Override
  	public Damage use() {
		// TODO Auto-generated method stub
		if( (this.failProbability + Math.random()) < MEDIUMPROB) {
			damage.setDamageAmmount(0);
		}
		else if (this.critProbability + Math.random() < MEDIUMPROB) {
			damage.setDamageAmmount(damage.getBasicDamageAmmount()*2);
		}
		else {
			damage.setDamageAmmount(damage.getBasicDamageAmmount());
		}
		return damage;
	}
}
