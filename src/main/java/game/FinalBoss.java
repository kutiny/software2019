package game;

public class FinalBoss extends Enemy {

	public FinalBoss(String name, int lv, int hp, Damage damage, int armor, double critProb, double failProb, int magicResist, int expKilled) {
		super("FinalBoss", 1, 200, new Damage(new DamageType("magical"), 50, 50), 150, 0.3, 0.1, 150, 10000);
		// TODO Auto-generated constructor stub
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
	