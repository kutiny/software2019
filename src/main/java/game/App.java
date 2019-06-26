package game;


public class App {
	private Character c;
	private Map m;
	private String history;
	private String map;
	private String status;
	private Enemy enemy;
	private boolean huir; //true si puedo
	private Duel duel;
	private String charaClass;
	private String charaName;
  
  // Constructor
  public App() {
	  m = new Map();
	  c = new Character();
	  
	  history = "Bienvenido";
	  map = m.toString();
	  status = "Libre";
	  
	}
  public static void main(String[] args){
	  
  }
  
  public String getcharaClass() {
	  return this.charaClass;
  }
  
  public String getcharaName() {
	  return this.charaName;
  }
  
  public void setcharaClass(String charaClass) {
	  this.charaClass = charaClass;
  }
  
  public void setcharaName(String charaName) {
	  this.charaName = charaName;
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
	  MapPosition pos = m.getPosition(m.getXPos(), m.getYPos() - 1);
	  
		  Enemy enemy = pos.getEnemy();
		  Trap trap = pos.getTrap();		  
	  //}catch(NullPointerException e) {
		//  addHistory("Sos o no ves la pared?");
		  //return;
	  //}
	  
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
  
  public void skill1() {
	  switch(this.charaClass) {
	  	case "Maga":
	  		c.getCharaClass().setActiveSkill(new MageSkill1());
	  	case "Guerrero":
	  		c.getCharaClass().setActiveSkill(new WarriorSkill1());
	  	case "Arquera":
	  		c.getCharaClass().setActiveSkill(new ArcherSkill1());
	  }
		if(!duel.characterAttack()) {
			this.status = "Libre";
			 addHistory("Has matado a tu enemigo");
			}
		else if(!duel.EnemyAttack()) {
			this.status = "GameOver";
			 addHistory("Mejor juga al minecraft");
		} else {
			 addHistory("Has atacado pero tu enemigo tambien");
		}
  }
  
  public void skill2() {
	  switch(this.charaClass) {
	  	case "Maga":
	  		c.getCharaClass().setActiveSkill(new MageSkill2());
	  	case "Guerrero":
	  		c.getCharaClass().setActiveSkill(new WarriorSkill2());
	  	case "Arquera":
	  		c.getCharaClass().setActiveSkill(new ArcherSkill2());
	  }
		if(!duel.characterAttack()) {
			this.status = "Libre";
			 addHistory("Has matado a tu enemigo");
			}
		else if(!duel.EnemyAttack()) {
			this.status = "GameOver";
			 addHistory("Mejor juga al minecraft");
		} else {
			 addHistory("Has atacado pero tu enemigo tambien");
		}
  }
  
  public void skill3() {
	  switch(this.charaClass) {
	  	case "Maga":
	  		c.getCharaClass().setActiveSkill(new MageSkill3());
	  	case "Guerrero":
	  		c.getCharaClass().setActiveSkill(new WarriorSkill3());
	  	case "Arquera":
	  		c.getCharaClass().setActiveSkill(new ArcherSkill3());
	  }
		if(!duel.characterAttack()) {
			this.status = "Libre";
			 addHistory("Has matado a tu enemigo");
			}
		else if(!duel.EnemyAttack()) {
			this.status = "GameOver";
			 addHistory("Mejor juga al minecraft");
		} else {
			 addHistory("Has atacado pero tu enemigo tambien");
		}
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
		  this.duel = new Duel (this.c, this.enemy);
	  }
  }
  
}
