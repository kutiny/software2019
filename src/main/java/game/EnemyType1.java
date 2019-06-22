package game;

public class EnemyType1 extends Enemy {

	static double MEDIUMPROBABILITY = 0.5;

	public EnemyType1() {
		super("Enemy1", 1, 100, new Damage(new DamageType("physical"), 12), 1, 0.0, 0.3, 1, 100);
	}
	
	@Override
	public void fight(Character character) {
		int damage;
		if( Math.random() * this.failProb < MEDIUMPROBABILITY) {
			damage = 0;
		}else{
			damage=(int) Math.round(this.dps * (1 + (this.critProb * Math.random())));
		}
		character.receiveDamage(damage);
	}
	

}
