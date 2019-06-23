package game;

public class EnemyType3 extends Enemy {

	static double MEDIUMPROBABILITY = 0.5;

	public EnemyType3() {
		super("Enemy1", 1, 100, new Damage(new DamageType("physical"), 50, 50), 1, 0.0, 0.3, 1, 100);
	}
	
	@Override
	public Damage fight() {
			// TODO Auto-generated method stub
			if( (this.failProb+Math.random())<0.5) {
				damage.setDamagePoints(0);
			}
			else if (this.critProb+Math.random()<0.5) {
				damage.setDamagePoints(damage.getBasicDamagePoints()*2);
			}
			else {
				damage.setDamagePoints(damage.getBasicDamagePoints());
			}
			return damage;
	}
	

}