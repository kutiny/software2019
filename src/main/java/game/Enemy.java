package game;

import lib.Observer;

public abstract class Enemy implements Observer{
	protected static final double MEDIUMPROB = 0.5;
	protected String enemyName;
	protected int level;
	protected int hp;
	protected double armor;
	protected double critProb;
	protected double failProb;
	protected double magicResist;
	protected int expKilled;
	protected Damage damage;

	public Enemy(String name, int lv, int hp, Damage damage, double armor, double critProb, double failProb, double magicResist, int expKilled) {
		this.enemyName = name;
		this.level = lv;
		this.critProb = critProb;
		this.magicResist = magicResist;
		this.expKilled = expKilled;
		this.hp = hp;
		this.damage = damage;
		this.armor = armor;
		this.failProb = failProb;
	}

	public abstract Damage fight();

	public void levelUp() {
		level++;
	}

	public String getEnemyName(){
		return this.enemyName;
	}

	public void setEnemyName(String enemyName){
		this.enemyName = enemyName;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return this.level;
	}
	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp=hp;
	}
	public double getArmor() {
		return this.armor;
	}
	public void setArmor(double armor) {
		this.armor = armor;
	}
	public double getCritProb() {
		return this.critProb;
	}
	public double getFailProb() {
		return this.failProb;
	}
	public double getMagicResist() {
		return this.magicResist;
	}

	public void setMagicResist(double mr) {
		this.magicResist = mr;
	}
	public int getExpKilled() {
		return this.expKilled;
	}

	public void setDamage(Damage dmg) {
		this.damage=dmg;
	}

	public Damage getDamage() {
		return this.damage;
	}

	public boolean receiveDamage(int damage) {
		this.hp = Math.max(0, this.hp - damage);
		return this.hp > damage;
	}

	public int calculateRecievedDamage(Damage damage) {
		int danio = damage.getDamageAmmount();
		String type = damage.getDamageType().toString();
		if (type.equals("physical")){
			int danioARecibir = (int)(danio * (1.0 - this.armor));
			return danioARecibir;
		}
		else {
			int danioARecibir = (int)(danio * (1.0 - this.magicResist));
			return danioARecibir;
		}
	}


	public abstract void notifyHandler(Object value) throws IllegalArgumentException;

}
