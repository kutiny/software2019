package game;

public class MageSkill3 extends Skill{
public MageSkill3() {
	  this.skillName = "Lightning Storm";
	  this.critProbability = 0.10;
	  this.failProbability = 0.05;
	  this.damage= new Damage(new DamageType("magical"), 55, 55);
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
