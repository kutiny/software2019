package game;

public class MageSkill1 extends Skill{
public MageSkill1() {
	  this.skillName = "Winter's Grasp";
	  this.critProbability = 0.15;
	  this.failProbability = 0.2;
	  this.damagePoints = 53;
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
