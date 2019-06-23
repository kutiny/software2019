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
		// TODO Auto-generated method stub
		if( (this.failProbability+Math.random())<0.5) {
			damage.setDamagePoints(0);
		}
		else if (this.critProbability+Math.random()<0.5) {
			damage.setDamagePoints(damage.getBasicDamagePoints()*2);
		}
		else {
			damage.setDamagePoints(damage.getBasicDamagePoints());
		}
		return damage;
	}
	}
