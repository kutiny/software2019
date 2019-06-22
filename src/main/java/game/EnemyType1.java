package game;

public class EnemyType1 extends Enemy {

	static double MEDIUMPROBABILITY = 0.5;

<<<<<<< HEAD
	public EnemyType1() {
		super("Enemy1", 1, 100, new Damage(new DamageType("physical"), 12), 1, 0.0, 0.3, 1, 100);
=======
	public EnemyType1(String name, int lv, int hp, int dps, int armor, int critProb, int failProb, int magicResist, int expKilled) {
		super(name, lv, hp, dps, armor, critProb, failProb, magicResist, expKilled);
>>>>>>> 93a4e621a64457ba602eca14e67cc2e761393227
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
