package game;

import java.util.ArrayList;

public class App {
	private Character c;
	private Map m;
	private String history;
	private String map;
	private String status;
	private Enemy enemy;
	private boolean huir; //true si puedo
	private Duel duel;
	private CharacterClass charaClass;
  
	// Constructor
	public App() {
		m = new Map();
		c = new Character();
	  
		history = "Bienvenido";
		map = m.toString();
		status = "Libre";
		
		// suscripcion de los enemigos al character (level)
		ArrayList<Enemy> enemies = m.getEnemies();
		for(Enemy e : enemies) {
			this.c.levelObservable.subscribe(e);
		}
	}
  
  	public CharacterClass getcharaClass() {
	  return this.charaClass;
  	}
  
  	public void setcharaClass(String charaClass) {
  		switch(charaClass) {
		  	case "Maga":
		  		this.charaClass = new Mage();
		  		break;
		  	case "Guerrero":
		  		this.charaClass = new Warrior();
		  		break;
		  	case "Arquera":
		  		this.charaClass = new Archer();
		  		break;
		  	default:
		  		this.charaClass = new Warrior();
  		}
	  	this.c.setCharaClass(this.charaClass);
  	}
  
  	public void setcharaName(String charaName) {
	  	this.c.setName(charaName);
  	}
  
  	public String getHistory() {
  		return this.history;
  	}
  
  	public String getMap() {
	  	return this.map;
  	}
  
  	public String getStatus() {
  		return this.status;
  	}
  
  	private void setMap(String map) {
  		this.map = map;
  	}
  
  	private void addHistory(String h) {
  		this.history = this.history + "\n" + h;
  	}
  
  	private void setStatus(String status) {
  		this.status = status;
  	}

  	public void moveUp() {
  		System.out.println(this.charaClass);
  		MapPosition pos = m.getPosition(m.getXPos(), m.getYPos() - 1);
	 	// ver cuando son null
  		Enemy enemy = pos.getEnemy();
  		Trap trap = pos.getTrap();
	  
	  	if(!pos.isExplorable() || (m.getYPos() - 1 < 0)) {
		  	addHistory("Sos o no ves la pared?");
		  	return;
	  	}
	  
	  	if(enemy != null && enemy.getHp() > 0) {
			  this.enemy = enemy;
			  if(this.huir) {
				  setStatus("PreDuelo");
				  this.huir = false;
				  addHistory("Has encontrado un enemigo. Parece que el aun no te ha visto. Puedes intentar huir");
		  	}else {
				  m.moveCharacterUp();
				  setStatus("Duelo");
				  //INICIAR DUELO, PEGA PJ PRIMERO
				  this.c.setActiveEnemy(this.enemy);
				  duel = new Duel(this.c, this.enemy);
				  addHistory("Has encontrado un enemigo. Debes empezar a pelear");
		  	}
	  	}else {
			  m.moveCharacterUp();
			  if(trap != null && trap.getActive()) {
				  addHistory("Has pisado una trampa");
				  trap.setDeactivated();
			  }else {
				  addHistory("Mas vacio que el amor de ella");
			  }
	  	}
	  
	  	setMap(m.toString());
  	}
  	
  	public void skill(int skNumber) {
  		CharacterClass clase = c.getCharaClass();
	  	clase.setActiveSkill(clase.getSkills().get(skNumber - 1));
	  	
		
	  	if(!duel.characterAttack()) {
			this.setStatus("Libre");
			this.addHistory("Has matado a tu enemigo");
			return;
		}
	  	addHistory("Has aplicado " + this.charaClass.getActiveSkill().getSkillName() + " a tu enemigo.");
		
	  	if(!duel.enemyAttack()) {
			this.setStatus("GameOver");
			this.addHistory("Te han matado!");
			return;
		}
	  	this.addHistory("El enemigo ha contraatacado");
  	}

  	public void rest() {
  		c.rest();
  	}
  
  	public void runAway() {
		  if(this.c.runAway()) {
			  this.status = "Libre";
		  }
		  else {
			  this.c.setActiveEnemy(this.enemy);
			  this.status = "Duelo";
			  this.addHistory("El enemigo te ha acorralado, no puedes escapar!");
			  this.duel = new Duel (this.c, this.enemy);
		  }
  	}
  
}
