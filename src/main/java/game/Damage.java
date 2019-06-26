package game;

public class Damage {
	private DamageType damageType;
	private int damageAmmount;
	private int basicDamageAmmount;
	
	public Damage(DamageType type, int ammount, int basicAmmount) throws IllegalArgumentException {
		if(ammount < 0 || basicAmmount < 0) {
			throw new IllegalArgumentException("El daño de un ataque no puede ser negativo");
		}
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
	
	public void setDamageAmmount(int damage){
		if(damage<0) {
			throw new IllegalArgumentException("El daño de un ataque no puede ser negativo");
		}
		this.damageAmmount = damage;
	}
	
	public int getBasicDamageAmmount() {
		return this.basicDamageAmmount;
	}
	
	public void setBasicDamageAmmount(int dmg){
		if(dmg<0) {
			throw new IllegalArgumentException("El daño de un ataque no puede ser negativo");
		}
		this.basicDamageAmmount = dmg;
	}
	
}
