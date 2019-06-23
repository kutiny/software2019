package game;

public class Duel {
	private Character character;
	private Enemy enemy;
	private boolean isCharacterNext;
	private boolean isEnemyAlive;
	private boolean isCharacterAlive;
	
	public Duel(Character c, Enemy e) {
		this.character = c;
		this.enemy = e;
		this.isCharacterNext = true;
		this.isCharacterAlive=true;
		this.isEnemyAlive=true;
	}
	
	public void fight() {
		while (this.isEnemyAlive&&this.isCharacterAlive) {
		   if(this.characterAttack(character.getCharaClass().getActiveSkill())) {
			   this.isCharacterAlive= this.EnemyAttack();
		   }
		   else {
			   this.isEnemyAlive=false;
			   break;
		   }
		}
		if(this.isCharacterAlive) {
			character.addExp(this.enemy.getExpKilled());
		}
	}
	
	
	public boolean characterAttack(Skill skill) throws IllegalStateException {
		if(this.isCharacterNext) {
			this.isCharacterNext = false;

			this.character.getCharaClass().setActiveSkill(skill);
			this.enemy.receiveDamage(this.enemy.calculateRecievedDamage(this.character.fight()));
			if(enemy.getHp()>0)
			return true;
			else return false;
			
		}else {
			throw new IllegalStateException("No puedes atacar durante el turno del enemigo");
		}
		
	}
	public boolean EnemyAttack(){
		if(!this.isCharacterNext) {
			this.isCharacterNext = true;
			
			this.character.receiveDamage(this.character.getCharaClass().calculateRecievedDamage(this.enemy.fight()));
			return true;
			
		}else {
			throw new IllegalStateException("No puedes atacar durante el turno del enemigo");
		}
		
	}
	
}
