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
		this.positions[0][5].setExplorable(false);
		this.positions[0][14].setExplorable(false);
		this.positions[0][12].setEnemy(new EnemyType2());
		this.positions[0][8].setTrap(new Trap());
		
		this.positions[1][0].setExplorable(false);
		this.positions[1][1].setExplorable(false);
		this.positions[1][2].setExplorable(false);
		this.positions[1][5].setExplorable(false);
		this.positions[1][14].setExplorable(false);
		this.positions[1][3].setEnemy(new EnemyType2());
		this.positions[1][3].setTrap(new Trap());
		this.positions[1][8].setTrap(new Trap());
		
		this.positions[2][0].setExplorable(false);
		this.positions[2][5].setExplorable(false);
		this.positions[2][8].setExplorable(false);
		this.positions[2][9].setExplorable(false);
		this.positions[2][14].setExplorable(false);
		this.positions[2][11].setEnemy(new EnemyType1()); //typ1 y trampa
		this.positions[2][13].setEnemy(new EnemyType3());
		
		this.positions[3][5].setExplorable(false);
		this.positions[3][2].setTrap(new Trap());
		
		this.positions[4][6].setEnemy(new EnemyType3());
		this.positions[4][10].setEnemy(new EnemyType3()); //typ3 y trampa
		this.positions[4][14].setEnemy(new EnemyType2());
		
		this.positions[5][0].setExplorable(false);
		this.positions[5][5].setExplorable(false);
		this.positions[5][6].setExplorable(false);
		this.positions[5][7].setExplorable(false);
		this.positions[5][8].setExplorable(false);
		this.positions[5][3].setEnemy(new EnemyType1());
		
		this.positions[6][0].setExplorable(false);
		this.positions[6][5].setExplorable(false);
		this.positions[6][14].setExplorable(false);
		this.positions[6][7].setEnemy(new EnemyType1());
		this.positions[6][12].setTrap(new Trap());
		
		this.positions[7][14].setExplorable(false);
		this.positions[7][10].setEnemy(new EnemyType2());
		
		this.positions[8][6].setExplorable(false);
		this.positions[8][12].setExplorable(false);
		this.positions[8][13].setExplorable(false);
		this.positions[8][14].setExplorable(false);
		this.positions[8][1].setEnemy(new EnemyType3());
		this.positions[8][8].setEnemy(new EnemyType2());
		
		this.positions[9][6].setExplorable(false);
		this.positions[9][4].setEnemy(new EnemyType2());
		
		this.positions[10][14].setEnemy(new EnemyType2());
		this.positions[10][12].setTrap(new Trap());
		this.positions[10][13].setTrap(new Trap());
		
		this.positions[11][2].setEnemy(new EnemyType3()); //typ3 y trampa
		this.positions[11][6].setEnemy(new EnemyType2()); //typ2 y trampa
		this.positions[11][9].setEnemy(new EnemyType3());
		this.positions[11][10].setEnemy(new EnemyType1());
		
		this.positions[12][0].setExplorable(false);
		this.positions[12][3].setExplorable(false);
		this.positions[12][7].setExplorable(false);
		this.positions[12][8].setExplorable(false);
		this.positions[12][14].setExplorable(false);
		this.positions[12][1].setEnemy(new EnemyType1()); //typ1 y trampa
		this.positions[12][13].setTrap(new Trap());
		
		this.positions[13][3].setExplorable(false);
		this.positions[13][14].setExplorable(false);
		this.positions[13][5].setEnemy(new EnemyType3()); //typ3 y trampa
		this.positions[12][9].setEnemy(new EnemyType1());
		
		this.positions[14][3].setExplorable(false);
		this.positions[14][10].setExplorable(false);
		this.positions[14][11].setExplorable(false);
		this.positions[14][12].setExplorable(false);
		this.positions[14][13].setExplorable(false);
		this.positions[14][14].setExplorable(false);
		this.positions[14][7].setEnemy(new EnemyType3());
		this.positions[14][2].setTrap(new Trap());
	}

}
