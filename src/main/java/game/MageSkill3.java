package game;

public class MageSkill3 extends Skill{
public MageSkill3() {
	  this.skillName = "Lightning Storm";
	  this.critProbability = 0.10;
	  this.failProbability = 0.05;
	  this.damagePoints = 55;
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
