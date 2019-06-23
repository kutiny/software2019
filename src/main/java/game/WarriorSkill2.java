package game;

public class WarriorSkill2 extends Skill {

	public WarriorSkill2(){
	  	this.skillName = "Double Slash";
    	this.critProbability = 0.05;
    	this.failProbability = 0.5;
    	this.damage = new Damage(new DamageType("Physical"), 71, 71);
  	}

  	@Override
  	public Damage use() {
		// TODO Auto-generated method stub
		if( (this.failProbability + Math.random()) < MEDIUMPROB) {
			damage.setDamagePoints(0);
		}
		else if (this.critProbability + Math.random() < MEDIUMPROB) {
			damage.setDamagePoints(damage.getBasicDamagePoints()*2);
		}
		else {
			damage.setDamagePoints(damage.getBasicDamagePoints());
		}
		return damage;
	}
}
