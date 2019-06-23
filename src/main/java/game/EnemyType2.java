package game;

import game.Character;
import game.Damage;
import game.DamageType;
import game.Enemy;

public class EnemyType2 extends Enemy {

	static double MEDIUMPROBABILITY = 0.5;

	public EnemyType2() {
		super("Enemy1", 1, 100, new Damage(new DamageType("magical"), 20, 20), 1, 0.0, 0.3, 1, 100);
	}
	
	@Override
	public Damage fight(Character character) {
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