package game;

public class Trap {
	private Damage damage;
	
	public Trap(Damage damage) {
		this.damage = damage;
	}
	
	public DamageType getDamageType(){
		return this.damage.getDamageType();
	}
	
	public int getDamageAmmount() {
		return this.damage.getDamagePoints();
	}
}
