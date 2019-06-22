package game;

public class WarriorSkill1 extends Skill {

  public WarriorSkill1(){
    this.skillName = "Slash";
    this.critProbability = 0.1;
    this.failProbability = 0.1;
    this.damage = new Damage(new DamageType("Physical"), 42);
  }

  @Override
  public int use() {
  	// TODO Auto-generated method stub
  	if( (this.failProbability+Math.random())<0.5) {
  		return 0;
  	}
  	else if ((this.critProbability+ Math.random())<0.5) {
  		return (this.damagePoints*2);
  	}
  	else {
  		return this.damagePoints;
  	}
  }
  }
