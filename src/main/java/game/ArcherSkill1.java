package game;

public class ArcherSkill1 extends Skill{
public ArcherSkill1() {
	  this.skillName = "Poison Arrow";
	  this.critProbability = 0.15;
	  this.failProbability = 0.2;
	  this.damagePoints = 56;
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
