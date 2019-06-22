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
	
	public boolean characterAttack(Skill skill) throws IllegalStateException {
		if(this.isCharacterNext) {
			this.isCharacterNext = false;
			if(this.enemy.receiveDamage(0)) {
				return true;
			}else {
				this.enemy.fight(this.character);
				this.isCharacterNext = true;
				return false;
			}
		}else {
			throw new IllegalStateException("No puedes atacar durante el turno del enemigo");
		}
	}
	
}
