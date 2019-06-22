package game;

public class ArcherSkill3 extends Skill{
public ArcherSkill3() {
	  this.skillName = "Long Shot";
	  this.critProbability = 0.15;
	  this.failProbability = 0.15;
	  this.damage= new Damage(new DamageType("physical"), 39, 39);
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
