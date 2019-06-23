package game;

public class Character {
	private String name;
	private String gender;
	private int experience;
	private int hp;
	private int level;
	private Enemy activeEnemy;
	private CharacterClass charaClass;

	public Character(){
		this.level = 1;
		this.experience = 0;
		this.activeEnemy=null;
	}

	public void move(String direction){

	}

	public Damage fight(){
		return charaClass.fight();
	}

	public void rest(){
		if(Math.random()<0.5) {
			this.hp+=(Math.random()*this.hp/2);
		}
		else if (Math.random()>0.25){
			this.hp-=(Math.random()*this.hp/2);
		}
	}

	public void runAway(){
		this.setActiveEnemy(null);
	}

	public void levelUp(){
		this.setLevel(this.getLevel() + 1);
	}

	public void addExp(int exp){
		if(exp >= 0) {
			this.setExperience(this.getExperience() + exp);
		}else {
			throw new IllegalArgumentException("La experiencia no puede ser negativa.");
		}

	}
	
	public boolean receiveDamage(int dm){
		if(dm < 0) {
			throw new IllegalArgumentException("El daño recibido no puede ser negativo.");
		}
		if(this.hp > dm) {
			this.hp -= dm;
			return true;
		}else {
			this.hp = 0;
			return false;
		}
	}

	// ACCESSORS
	public void setActiveEnemy(Enemy enemy){
		this.activeEnemy = enemy;
	}

	public Enemy getActiveEnemy(){
		return this.activeEnemy;
	}

	public int getLevel(){
		return this.level;
	}

	public void setLevel(int level){
		this.level = level;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getHp(){
		return this.hp;
	}

	public void setHp(int hp){
		this.hp = hp;
	}

	public int getExperience(){
		return this.experience;
	}

	public void setExperience(int experience){
		this.experience = experience;
	}
	

}
