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
	
	@Override
	public String toString() {
		String ceil = "";
		if(!this.explorable)
			ceil = "M";
		else {
			ceil = "+";
			if(this.explored) {
				ceil = "0";
			}
		}
		return ceil;
	}
}
