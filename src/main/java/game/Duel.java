package game;

public class Duel {
	private Character character;
	private Enemy enemy;
	private boolean isCharacterNext;

	
	public Duel(Character c, Enemy e) {
		this.character = c;
		this.enemy = e;
		this.isCharacterNext = true;

	}
	public Character getCharacter() {
		return this.character;
	}
	
	public boolean characterAttack() throws IllegalStateException {
		if(this.isCharacterNext) {
			this.isCharacterNext = false;

//			this.character.getCharaClass().setActiveSkill(skill);
			this.enemy.receiveDamage(this.enemy.calculateRecievedDamage(this.character.fight()));
				if(enemy.getHp()>0)
				return true;
				else {
						character.setActiveEnemy(null);
						character.addExp(this.enemy.getExpKilled());
					return false;
				}
		}else {
			throw new IllegalStateException("No puedes atacar durante el turno del enemigo");
		}
		
	}
	public boolean EnemyAttack() throws IllegalStateException{
		if(!this.isCharacterNext) {
			this.isCharacterNext = true;
			
			this.character.receiveDamage(this.character.getCharaClass().calculateRecievedDamage(this.enemy.fight()));
			if(character.getHp()>0) 
				return true;
			else return false;
		}
		else {
			throw new IllegalStateException("Enemigo atacando en turno de personaje");
		}
		
	}
	
}
