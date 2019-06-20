package game;

public class Damage {
	private DamageType dmgType;
	private int dmgAmmount;
	
	public Damage(DamageType type, int ammount) {
		this.dmgType = type;
		this.dmgAmmount = ammount;
	}
	
	public int getDamagePoints() {
		return this.dmgAmmount;
	}
	
	public DamageType getDamageType() {
		return this.dmgType;
	}

}
