package src.main.game;

public abstract class Enemy {
	protected String enemyName;
	protected int level;
	protected int hp;
	protected int dps;
	protected int armor;
	protected int critProb;
	protected int failProb;
	protected int magicResist;
	protected int expKilled;
	
	public Enemy(String name, int lv, int hp, int dps, int armor, int critProb, int failProb, int magicResist, int expKilled) {
		this.enemyName = name;
		this.level = lv;
		this.critProb = critProb;
		this.magicResist = magicResist;
		this.expKilled = expKilled;
		this.hp = hp;
		this.dps = dps;
		this.armor = armor;
		this.failProb = failProb;
	}
	
	public abstract void fight(Character character);
	public void levelUp() {
		level++;
	}
	public int getMagicResist(){
		return this.magicResist;
	}
	public void setMagicResist(int mr) {
		this.magicResist=mr;
	}
}
