package start;

import game.Map;
import game.Skill;
import game.Duel;

public class Model {
	private int columnas= 10;
	private int filas =10;
	private Map map;
	private Duel duel;
	private boolean inDuel;
	
	public Model() {
		this.map = new Map();
		this.inDuel=false;
	}
	
	
	public String moveUp() {
		this.map.moveCharacterUp();
		return this.map.toString();
	}

	public void fightTurn() {
		inDuel=true;
		if(!duel.characterAttack()) {
			inDuel=false;
			}
		else if(!duel.enemyAttack()) {
			inDuel=false;
		}		
	}

}
