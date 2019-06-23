package game;

public class App {
  
  // Constructor
  public static void main(String[] args){
	  Map m = new Map();
	  
	  Character c = new Character();
	  System.out.println(c.getLevel());
	  
	  Enemy en1 = new EnemyType1();
	  Enemy en2 = new EnemyType2();
	  Enemy en3 = new EnemyType3();
	  
	  c.levelObservable.subscribe(en1);
	  c.levelObservable.subscribe(en2);
	  c.levelObservable.subscribe(en3);
	  
	  System.out.println("Enemy1 Level:" + en1.getLevel());
	  c.levelUp();
	  System.out.println("Enemy1 Level:" + en1.getLevel());
	  c.levelUp();
	  System.out.println("Enemy1 Level:" + en1.getLevel());
	  System.out.println("Enemy2 Level:" + en2.getLevel());
	  System.out.println("Enemy3 Level:" + en3.getLevel());
  }
}
