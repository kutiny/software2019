package game;


public class EnemyType2 extends Enemy {

	static double MEDIUMPROBABILITY = 0.5;

	public EnemyType2() {
		super("Enemy1", 1, 8, new Damage(new DamageType("magical"), 20, 20), 0.1, 0.0, 0.1, 0.1, 150);
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
			this.damage.setBasicDamageAmmount( 20 * ( 1 + ( this.getLevel() / 10 ) ) );
			this.setHp( 60 * ( 1 + this.getLevel() / 100 ) );
			this.setArmor ( this.getArmor() * ( 1 + this.getLevel() * 0.02) );
			this.setMagicResist ( this.getMagicResist() * ( 1 + this.getLevel() * 0.02) );
		}else {
			throw new IllegalArgumentException();
		}
	}
	

}
