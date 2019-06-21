package game;

public class ArcherSkill2 extends Skill{
public ArcherSkill2() {
	  this.skillName = "Explosive Shot";
	  this.critProbability = 0.30;
	  this.failProbability = 0.3;
	  this.damagePoints = 50;
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
