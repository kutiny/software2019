package game;

public class Damage {
	private DamageType dmgType;
	private int dmgAmmount;
	private int basicDmgAmmount;
	
	public Damage(DamageType type, int ammount, int basicAmmount) {
		this.dmgType = type;
		this.dmgAmmount = ammount;
		this.basicDmgAmmount = basicAmmount;
	}
	
	public int getDamagePoints() {
		return this.dmgAmmount;
	}
	
	public DamageType getDamageType() {
		return this.dmgType;
	}
	public void setDamagePoints(int damage) {
		this.dmgAmmount=damage;
	}
	public int getBasicDamagePoints() {
		return this.basicDmgAmmount;
	}
	
}
