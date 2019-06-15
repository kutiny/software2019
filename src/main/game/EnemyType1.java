package src.main.game;

public class EnemyType1 extends Enemy {

	public EnemyType1(String name, int lv, int hp, int dps, int armor, int critProb, int failProb, int magicResist, int expKilled) {
		super(name,lv,hp,dps,armor,critProb,failProb,magicResist,expKilled);
	}
	
	@Override
	public void fight(Character character) {
		int damage;
		if( Math.random() * this.failProb < 0.5) {
			damage = 0;
		}else{
			damage=(int) Math.round(this.dps*(1+(this.critProb*Math.random())));
		}
		character.receiveDamage(damage);
	}
	

}
