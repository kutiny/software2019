package game;

public class Character {
	private String name;
	private String gender;
	private int experience;
	private int hp;
	private int level;
	private Enemy activeEnemy;

	public Character(){
		this.level = 1;
		this.experience = 0;
	}

	public void move(String direction){

	}

	public void fight(){

	}

	public void rest(){

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
	
	public void receiveDamage(int dm){
		if(dm >= 0) {
			this.setHp(this.getHp() - dm);		
		}else {
			throw new IllegalArgumentException("El daño recibido no puede ser negativo.");
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
