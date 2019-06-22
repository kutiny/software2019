package game;

public class Map {
	private final int COLUMNS = 15;
	private final int ROWS = 15;
	private MapPosition[][] positions;
	private int xPos;
	private int yPos;
	
	public Map() {
		
		this.positions = new MapPosition[COLUMNS][ROWS];
		
		
	}
	
	public int getXPos() {
		return this.xPos;
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
	public void moveCharacterUp() {
		if(this.yPos > 1) {
			this.setCharacterPosition(this.xPos, this.yPos - 1);
		}
	}
	
	private void setCharacterPosition(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < COLUMNS ; i++) {
			for(int j = 0 ; j < ROWS ; j++) {
				sb.append(this.positions[i][j]);
			}
		}
		return sb.toString();
	}
	
	private void initializeMap() {
		for(int i = 0 ; i < COLUMNS ; i++) {
			for(int j = 0 ; j < ROWS ; j++) {
				this.positions[i][j] = new MapPosition(true);
			}
		}
		
		this.positions[0][0].setExplorable(false);
		this.positions[0][1].setExplorable(false);
		this.positions[0][2].setExplorable(false);
		this.positions[1][0].setExplorable(false);
		this.positions[1][1].setExplorable(false);
		this.positions[1][2].setExplorable(false);
		this.positions[2][0].setExplorable(false);
		
		
		
	}

}
