package game;

public class Map {
	private final int COLUMNS = 10;
	private final int ROWS = 10;
	private String[][] positions;
	private int xPos;
	private int yPos;
	
	public Map() {
		
		this.positions = new String[COLUMNS][ROWS];
		
		for(int i = 0 ; i < COLUMNS ; i++) {
			for(int j = 0 ; j < ROWS ; j++) {
				this.positions[i][j] = "X";
			}
		}
	}
	
	public int getXPos() {
		return this.xPos;
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
	public void setCharacterPosition(int x, int y) {
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

}
