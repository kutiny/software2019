package game;

public class EnemyType3 extends Enemy {

	static double MEDIUMPROBABILITY = 0.5;

	public EnemyType3() {
		super("Enemy1", 1, 15, new Damage(new DamageType("physical"), 50, 50), 0.1, 0.0, 0.3, 0.1, 200);
	}
	
	@Override

	public Damage fight() {
		if( (this.failProb + Math.random()) < MEDIUMPROB) {
			damage.setDamageAmmount(0);
		}
		else if (this.critProb + Math.random() < MEDIUMPROB) {
			damage.setDamageAmmount(damage.getBasicDamageAmmount() * 2);
		}
		else {
			damage.setDamageAmmount(damage.getBasicDamageAmmount());
		}
		return damage;

	}
	
	public void notifyHandler(Object value) throws IllegalArgumentException {
		if(value instanceof Integer) {
			this.setLevel((int)value);			
		}else {
			throw new IllegalArgumentException();
		}
	}

}