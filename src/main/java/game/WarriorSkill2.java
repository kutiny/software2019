package game;

public class WarriorSkill2 extends Skill {

  public WarriorSkill2(){
    this.skillName = "Double Slash";
    this.critProbability = 0.05;
    this.failProbability = 0.5;
    this.damage = new Damage(new DamageType("Physical"), 71);
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
