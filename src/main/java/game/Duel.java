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
	public boolean getIsCharacterNext() {
		return this.isCharacterNext;
	}
	public Character getCharacter() {
		return this.character;
	}
	
	/**
	 * 
	 * @return true id enemy still alive
	 * @throws IllegalStateException
	 */
	public boolean characterAttack() throws IllegalStateException {
		if(this.isCharacterNext) {
			this.isCharacterNext = false;
			System.out.println(enemy.getHp());
			this.enemy.receiveDamage(this.enemy.calculateRecievedDamage(this.character.fight()));
			System.out.println(enemy.getHp());
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
	/**
	 * 
	 * @return 
	 * @throws IllegalStateException
	 */
	public boolean enemyAttack() throws IllegalStateException{
		if(!this.isCharacterNext) {
			this.isCharacterNext = true;
			
			this.character.receiveDamage(this.character.getCharaClass().calculateRecievedDamage(this.enemy.fight()));
			return character.getHp() > 0;
		}
		else {
			throw new IllegalStateException("Enemigo atacando en turno de personaje");
		}
		
	}
	
}
