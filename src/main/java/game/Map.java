package game;

import java.util.ArrayList;

public class Map {
	private final int COLUMNS = 15;
	private final int ROWS = 15;
	private MapPosition[][] positions;
	private int xPos;
	private int yPos;
	private ArrayList<Enemy> enemies;
	
	public Map() {
		this.positions = new MapPosition[ROWS][COLUMNS];
		this.enemies = new ArrayList<Enemy>();
		this.generateEnemies();
		this.initializeMap();
		this.xPos = 4;
		this.yPos = 7;
	}
	
	public int getXPos() {
		return this.xPos;
	}
	
	public int getYPos() {
		return this.yPos;
	}
	
	public MapPosition getPosition(int x , int y) {
		return this.positions[y][x];
	}
	
	private void moveCharacterUp() {
		if(this.yPos > 0) {
			this.setCharacterPosition(this.xPos, this.yPos - 1);
		}
	}
	
	private void moveCharacterDown() {
		if(this.yPos < 14) {
			this.setCharacterPosition(this.xPos, this.yPos + 1);
		}
	}
	
	private void moveCharacterLeft() {
		if(this.xPos > 0) {
			this.setCharacterPosition(this.xPos - 1, this.yPos);
		}
	}
	
	private void moveCharacterRight() {
		if(this.xPos < 14) {
			this.setCharacterPosition(this.xPos + 1, this.yPos);
		}
	}
	
	private void setCharacterPosition(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void move(String lastMove) {
		this.getPosition(getXPos(), getYPos()).toggleExplored();
		switch(lastMove) {
			case "Up":
				this.moveCharacterUp();
				break;
				
			case "Down":
				this.moveCharacterDown();
	  		  	break;
			
			case "Left":
				this.moveCharacterLeft();
				break;
			
			case "Right":
				this.moveCharacterRight();
	  		  	break;
		}
		this.getPosition(getXPos(), getYPos()).toggleExplored();
	}
	
	public ArrayList<Enemy> getEnemies(){
		return this.enemies;
	}
	
	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	
	private void generateEnemies() {
		this.enemies.add(new EnemyType2());
		this.enemies.add(new EnemyType2());
		this.enemies.add(new EnemyType1());
		this.enemies.add(new EnemyType3());
		this.enemies.add(new EnemyType3());
		this.enemies.add(new EnemyType3());
		this.enemies.add(new EnemyType2());
		this.enemies.add(new EnemyType1());
		this.enemies.add(new EnemyType1());
		this.enemies.add(new EnemyType2());
		this.enemies.add(new EnemyType3());
		this.enemies.add(new EnemyType2());
		this.enemies.add(new EnemyType2());
		this.enemies.add(new EnemyType2());
		this.enemies.add(new EnemyType3());
		this.enemies.add(new EnemyType2());
		this.enemies.add(new EnemyType3());
		this.enemies.add(new EnemyType1());
		this.enemies.add(new EnemyType1());
		this.enemies.add(new EnemyType3());
		this.enemies.add(new EnemyType1());
		this.enemies.add(new EnemyType3());
	}
	
	@Override
	public String toString() {
		System.out.println("COLUMNA: " + this.xPos + " FILA: " + this.yPos);
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < ROWS ; i++) {
			for(int j = 0 ; j < COLUMNS ; j++) {
				if(j == this.xPos && i == this.yPos) {
					sb.append("X");
				}else {
					sb.append(this.positions[i][j]);					
				}
				if(j < ROWS) {
					sb.append(" ");
				}
			}
			if(i < ROWS)
				sb.append("\n");
		}
		return sb.toString();
	}
	
	private void initializeMap() {
		for(int i = 0 ; i < ROWS ; i++) {
			for(int j = 0 ; j < COLUMNS ; j++) {
				this.positions[i][j] = new MapPosition(true);
			}
		}
		try {
			this.positions[0][0].setExplorable(false);
			this.positions[0][1].setExplorable(false);
			this.positions[0][2].setExplorable(false);
			this.positions[0][5].setExplorable(false);
			this.positions[0][14].setExplorable(false);
			this.positions[0][12].setEnemy(this.enemies.get(0));
			this.positions[0][8].setTrap(new Trap());
			
			this.positions[1][0].setExplorable(false);
			this.positions[1][1].setExplorable(false);
			this.positions[1][2].setExplorable(false);
			this.positions[1][5].setExplorable(false);
			this.positions[1][14].setExplorable(false);
			this.positions[1][3].setEnemy(this.enemies.get(1));
			this.positions[1][4].setTrap(new Trap());
			this.positions[1][8].setTrap(new Trap());
			
			this.positions[2][0].setExplorable(false);
			this.positions[2][5].setExplorable(false);
			this.positions[2][8].setExplorable(false);
			this.positions[2][9].setExplorable(false);
			this.positions[2][14].setExplorable(false);
			this.positions[2][11].setEnemy(this.enemies.get(2)); //typ1 y trampa
			this.positions[2][13].setEnemy(this.enemies.get(3));
			
			this.positions[3][5].setExplorable(false);
			this.positions[3][2].setTrap(new Trap());
			
			this.positions[4][6].setEnemy(this.enemies.get(4));
			this.positions[4][10].setEnemy(this.enemies.get(5)); //typ3 y trampa
			this.positions[4][14].setEnemy(this.enemies.get(6));
			
			this.positions[5][0].setExplorable(false);
			this.positions[5][5].setExplorable(false);
			this.positions[5][6].setExplorable(false);
			this.positions[5][7].setExplorable(false);
			this.positions[5][8].setExplorable(false);
			this.positions[5][3].setEnemy(this.enemies.get(7));
			
			this.positions[6][0].setExplorable(false);
			this.positions[6][5].setExplorable(false);
			this.positions[6][14].setExplorable(false);
			this.positions[6][7].setEnemy(this.enemies.get(8));
			this.positions[6][12].setTrap(new Trap());
			
			this.positions[7][14].setExplorable(false);
			this.positions[7][10].setEnemy(this.enemies.get(9));
			
			this.positions[8][6].setExplorable(false);
			this.positions[8][12].setExplorable(false);
			this.positions[8][13].setExplorable(false);
			this.positions[8][14].setExplorable(false);
			this.positions[8][1].setEnemy(this.enemies.get(10));
			this.positions[8][8].setEnemy(this.enemies.get(11));
			
			this.positions[9][6].setExplorable(false);
			this.positions[9][4].setEnemy(this.enemies.get(12));
			
			this.positions[10][14].setEnemy(this.enemies.get(13));
			this.positions[10][12].setTrap(new Trap());
			this.positions[10][13].setTrap(new Trap());
			
			this.positions[11][2].setEnemy(this.enemies.get(14)); //typ3 y trampa
			this.positions[11][6].setEnemy(this.enemies.get(15)); //typ2 y trampa
			this.positions[11][9].setEnemy(this.enemies.get(16));
			this.positions[11][10].setEnemy(this.enemies.get(17));
			
			this.positions[12][0].setExplorable(false);
			this.positions[12][3].setExplorable(false);
			this.positions[12][7].setExplorable(false);
			this.positions[12][8].setExplorable(false);
			this.positions[12][14].setExplorable(false);
			this.positions[12][1].setEnemy(this.enemies.get(18)); //typ1 y trampa
			this.positions[12][13].setTrap(new Trap());
			
			this.positions[13][3].setExplorable(false);
			this.positions[13][14].setExplorable(false);
			this.positions[13][5].setEnemy(this.enemies.get(19)); //typ3 y trampa
			this.positions[12][9].setEnemy(this.enemies.get(20));
			
			this.positions[14][3].setExplorable(false);
			this.positions[14][10].setExplorable(false);
			this.positions[14][11].setExplorable(false);
			this.positions[14][12].setExplorable(false);
			this.positions[14][13].setExplorable(false);
			this.positions[14][14].setExplorable(false);
			this.positions[14][7].setEnemy(this.enemies.get(21));
			this.positions[14][2].setTrap(new Trap());
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Error al acceder a la matriz de enemigos.\n (IndexOutOfBounds)");
		}
	}
	

}
