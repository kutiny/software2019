package start;

import game.Map;

public class Model {
	private int columnas= 10;
	private int filas =10;
	private Map map;
	
	public Model() {
		this.map = new Map();
	}
	
	
	
	public String moveUp() {
		this.map.moveCharacterUp();
		return this.map.toString();
	}

}
