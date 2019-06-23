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
