package game;

public class EnemyType1 extends Enemy {

	static double MEDIUMPROBABILITY = 0.5;

	public EnemyType1() {
		super("Enemy1", 1, 100, new Damage(new DamageType("physical"), 12, 12), 1, 0.0, 0.3, 1, 100);
	}
	
	@Override
	public Damage fight(Character character) {
		if( (this.failProb+Math.random())<0.5) {
			this.damage.setDamagePoints(0);
		}
		else if (this.critProb+Math.random()<0.5) {
			damage.setDamagePoints(damage.getBasicDamagePoints()*2);
		}
		else {
			damage.setDamagePoints(damage.getBasicDamagePoints());
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
