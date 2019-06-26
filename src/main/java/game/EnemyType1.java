package game;

public class EnemyType1 extends Enemy {

	static double MEDIUMPROBABILITY = 0.5;

	public EnemyType1() {
		super("Enemy1", 1, 5, new Damage(new DamageType("physical"), 12, 12), 0.1, 0.0, 0.1, 0.1, 100);
		
	}
	

	
	@Override


	public Damage fight() {
		if( (this.failProb + Math.random()) < MEDIUMPROB) {
			this.damage.setDamageAmmount(0);
			
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
