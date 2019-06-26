package game;

import java.util.ArrayList;
import observer.*;

public class App {
	private Character c;
	private Map m;
	private String history;
	private String map;
	private String status;
	private String lastMove;
	private Enemy enemy;
	private Trap trap;
	private boolean huir; //true si puedo
	private Duel duel;
	private CharacterClass charaClass;
	private CharacterLevelObserver characterLevelObserver;
	private CharacterLifeObserver characterLifeObserver;
	MapPosition pos;
  
	// Constructor
	public App() {
		m = new Map();
		c = new Character();
	  
		history = "Bienvenido";
		map = m.toString();
		status = "Libre";
		this.huir = true;
	  
		this.characterLevelObserver = new CharacterLevelObserver();
		this.characterLifeObserver = new CharacterLifeObserver();
		
		this.c.levelObservable.subscribe(this.characterLevelObserver);
		this.c.lifePointsObservable.subscribe(this.characterLifeObserver);

		this.c.setHp(this.c.getHp());
		this.c.setLevel(this.c.getLevel());
		
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
  	
  	private void addHistoryPared() {
  		addHistory("Sos o no ves la pared?");
  	}
  
  	private void setStatus(String status) {
  		this.status = status;
  	}
  	
  	public void rest() {
  		c.rest();
  	}

  	public void move(String lastMove) {
  		this.lastMove = lastMove;
  		
  		try {
  			switch(lastMove) {
  			case "Up":
  				this.pos = m.getPosition(this.m.getXPos(), this.m.getYPos() - 1);
  	  		  	if(!this.pos.isExplorable() || (m.getYPos() - 1 < 0)) {
  	  		  		addHistoryPared();
  	  			  	return;
  	  		  	}  				
  				break;
  			
  			case "Down":
  				this.pos = m.getPosition(this.m.getXPos(), this.m.getYPos() + 1);
  	  		  	if(!this.pos.isExplorable() || (m.getYPos() + 1 > 14)) {
  	  		  		addHistoryPared();
  	  			  	return;
  	  		  	}
  	  		  	break;
  			
  			case "Left":
  				this.pos = m.getPosition(this.m.getXPos() - 1, this.m.getYPos());
  	  		  	if(!this.pos.isExplorable() || (m.getXPos() - 1 < 0)) {
  	  		  		addHistoryPared();
  	  			  	return;
  	  		  	}  				
  				break;
  			
  			case "Right":
  				this.pos = m.getPosition(this.m.getXPos() + 1, this.m.getYPos());
  	  		  	if(!this.pos.isExplorable() || (m.getXPos() + 1 > 14)) {
  	  		  		addHistoryPared();
  	  			  	return;
  	  		  	}
  	  		  	break;
  			}
  			
  		  	this.enemy = this.pos.getEnemy();
			this.trap = this.pos.getTrap();
  		  
  		  	if(enemy != null && enemy.getHp() > 0) {
				if(this.huir) {
					setStatus("PreDuelo");
					this.huir = false;
					addHistory("Has encontrado un enemigo que aun no te ha visto.");
					addHistory("Puedes intentar huir.");
				}else {
					m.move(lastMove);
					setStatus("Duelo");
					//INICIAR DUELO, PEGA PJ PRIMERO
					this.c.setActiveEnemy(this.enemy);
					duel = new Duel(this.c, this.enemy);
					addHistory("Has encontrado un enemigo. Debes empezar a pelear");
				  	}
				}else {
					m.move(lastMove);
					if(trap != null && trap.getActive()) {
						addHistory("Has pisado una trampa");
						c.trapDamage();
						trap.setDeactivated();
					}
				}  		  	
  		}catch(IndexOutOfBoundsException e) {
  			addHistory("Has dado contra un objeto que no permite el paso.");
  		}catch(NullPointerException e){
  			m.move(lastMove);
  		}finally {
  			setMap(m.toString());
  		}
  	}
  	
  	public void skill(int skNumber) {
  		CharacterClass clase = c.getCharaClass();
	  	clase.setActiveSkill(clase.getSkills().get(skNumber - 1));
	  	
	  	if(!duel.characterAttack()) {
			this.setStatus("Libre");
			this.addHistory("Has matado a tu enemigo");
			this.huir = true;
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
  
  	public void runAway() {
		  if(this.c.runAway()) {
			  this.status = "Libre";
			  this.addHistory("Has logrado huir de tu enemigo");
		  }
		  else {
			  this.c.setActiveEnemy(this.enemy);
			  this.status = "Duelo";
			  this.addHistory("El enemigo te ha acorralado, no puedes escapar!");
			  this.duel = new Duel (this.c, this.enemy);
			  m.move(lastMove);
			  setMap(m.toString());
		  }
  	}
  	
  	public void fight() {
  		this.c.setActiveEnemy(this.enemy);
		  this.status = "Duelo";
		  this.addHistory("Buena desicion. No siempre es bueno escapar");
		  this.duel = new Duel (this.c, this.enemy);
		  m.move(this.lastMove);
		  System.out.println("Me movi");
		  setMap(m.toString());
  	}
  
  	public int getNivelPersonaje() {
  		return this.characterLevelObserver.getLastValue();
  	}
  	
  	public int getVidaPersonaje() {
  		return this.characterLifeObserver.getLastValue();
  	}
}
