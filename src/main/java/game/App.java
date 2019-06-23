package game;

public class App {
  
  // Constructor
  public static void main(String[] args){
	  Map m = new Map();
	  
	  Character c = new Character();
	  System.out.println(c.getLevel());
	  
	  Enemy en = new EnemyType1();
	  
	  c.levelObservable.subscribe(en);
	  
	  System.out.println("Enemy Level:" + en.getLevel());
	  c.levelUp();
	  System.out.println("Enemy Level:" + en.getLevel());
	  c.levelUp();
	  System.out.println("Enemy Level:" + en.getLevel());
  }
}
