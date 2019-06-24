package game;

import lib.Observer;

public abstract class Enemy implements Observer{
	protected static final double MEDIUMPROB = 0.5;
	protected String enemyName;
	protected int level;
	protected int hp;
	protected int armor;
	protected double critProb;
	protected double failProb;
	protected int magicResist;
	protected int expKilled;
	protected Damage damage;
	
	public Enemy(String name, int lv, int hp, Damage damage, int armor, double critProb, double failProb, int magicResist, int expKilled) {
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
	
	public abstract Damage fight(Character character);
	
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
	public int getArmor() {
		return this.armor;
	}
	public double getCritProb() {
		return this.critProb;
	}
	public double getFailProb() {
		return this.failProb;
	}
	public int getMagicResist() {
		return this.magicResist;
	}
	
	public void setMagicResist(int mr) {
		this.magicResist = mr;
	}
	
	public boolean receiveDamage(int damage) {
		if(this.hp > damage) {
			this.hp -= damage;
			return true;
		}else {
			this.hp = 0;
			return false;
		}
	}
	
	public abstract void notifyHandler(Object value) throws IllegalArgumentException;

}
