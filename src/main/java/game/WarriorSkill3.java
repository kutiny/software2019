package game;

public class WarriorSkill3 extends Skill {

  public WarriorSkill3(){
    this.skillName = "Chop";
    this.critProbability = 0.015;
    this.failProbability = 0.75;
    this.damagePoints = 104;
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
