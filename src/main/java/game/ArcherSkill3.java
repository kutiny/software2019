package game;

public class ArcherSkill3 extends Skill{
public ArcherSkill3() {
	  this.skillName = "Long Shot";
	  this.critProbability = 0.15;
	  this.failProbability = 0.15;
	  this.damagePoints = 39;
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
