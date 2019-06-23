package start;

import game.Map;
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
	public void startDuel() {
		this.inDuel=true;

		this.fightTurn(this.duel.getCharacter().getCharaClass().getActiveSkill());
	}
	
	public void fightTurn(Skill skill) {
		if(!duel.characterAttack(skill)) {
			inDuel=false;
			}
		else if(!duel.EnemyAttack()) {
			inDuel=false;
		}		
	}

}
