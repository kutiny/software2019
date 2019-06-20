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
	
	public void characterAttack() {
		this.isCharacterNext = false;	
	}
	
}
