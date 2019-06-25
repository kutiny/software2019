package game;

public class MapPosition {
	private Enemy enemy;
	private Trap trap;
	private boolean explored;
	private boolean explorable;
	
	public MapPosition(boolean explorable) {
		this.explorable = explorable;
		this.explored = false;
	}
	
	public void setEnemy(Enemy e) {
		this.enemy = e;
	}
	
	public void toggleExplored() {
		this.explored = true;
	}
	
	public void setExplorable(boolean explorable) {
		this.explorable = explorable;
	}
	
	public void setTrap(Trap t) {
		this.trap = t;
	}
	
	public Enemy getEnemy() {
		return this.enemy;
	}
	
	public Trap getTrap() {
		return this.trap;
	}
	
	@Override
	public String toString() {
		String celda;
		if(!this.explorable)
			celda = "M";
		else {
			if(!this.explored) {
				celda = "+";				
			}else {
				celda = "0";
			}
		}
		return celda;
	}
}
