package game;

public class MageSkill2 extends Skill{
public MageSkill2() {
	  this.skillName = "Wildfire";
	  this.critProbability = 0.30;
	  this.failProbability = 0.25;
	  this.damagePoints = 58;
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

