package game;

public class Damage {
	private DamageType damageType;
	private int damageAmmount;
	private int basicDamageAmmount;
	
	public Damage(DamageType type, int ammount, int basicAmmount) {
		this.damageType = type;
		this.damageAmmount = ammount;
		this.basicDamageAmmount = basicAmmount;
	}
	
	public int getDamageAmmount() {
		return this.damageAmmount;
	}
	
	public DamageType getDamageType() {
		return this.damageType;
	}
	
	public void setDamageType(DamageType d) {
		this.damageType = d;
	}
	
	public void setDamageAmmount(int damage) {
		this.damageAmmount = damage;
	}
	
	public int getBasicDamageAmmount() {
		return this.basicDamageAmmount;
	}
	
	public void setBasicDamageAmmount(int dmg) {
		this.basicDamageAmmount = dmg;
	}
	
}
