package src.main.java.game;

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
		this.activeEnemy = null;
	}

	public void move(String direction){

	}

	public void fight(){

	}

	public void rest(){

	}

	public void runAway(){
		this.activeEnemy = null;
	}

	public void levelUp(){
		this.level += 1;
	}

	public void setEnemy(Enemy enemy){
		this.activeEnemy = enemy;
	}

	public void addExp(int exp){
		if(exp >= 0) {
			this.experience += exp;
		}else {
			throw new IllegalArgumentException("La experiencia no puede ser negativa.");
		}

	}
	
	public void receiveDamage(int dm){
		if(dm >= 0) {
			this.hp -= dm;			
		}else {
			throw new IllegalArgumentException("El daño recibido no puede ser negativo.");
		}
	}

	public int getLevel(){
		return this.level;
	}
	
}
