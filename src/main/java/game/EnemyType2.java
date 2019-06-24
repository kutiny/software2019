package game;

<<<<<<< HEAD

=======
>>>>>>> 62fcfdc597f2d5d0ecdb5c541ae4415969a81eee
public class EnemyType2 extends Enemy {

	static double MEDIUMPROBABILITY = 0.5;

	public EnemyType2() {
		super("Enemy1", 1, 100, new Damage(new DamageType("magical"), 20, 20), 1, 0.0, 0.3, 1, 100);
	}
	
	@Override
<<<<<<< HEAD
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
=======
	public Damage fight(Character character) {
		if( (this.failProb + Math.random()) < MEDIUMPROB) {
			damage.setDamageAmmount(0);
		}
		else if (this.critProb + Math.random() < MEDIUMPROB) {
			damage.setDamageAmmount(damage.getBasicDamageAmmount() * 2);
>>>>>>> 62fcfdc597f2d5d0ecdb5c541ae4415969a81eee
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