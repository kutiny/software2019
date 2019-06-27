package game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EnemyTest {

		@Test	
		public void enemyLevelUpTest(){
				Character uc = new Character();
				uc.setCharaClass(new Mage());
				Enemy enemy= new EnemyType1();
				uc.levelObservable.subscribe(enemy);
				uc.levelUp();
				assertEquals(2, enemy.getLevel());
		}

		@Test	
		public void enemyHpUpdateWhenLevelUpTest(){
				Character uc = new Character();
				uc.setCharaClass(new Mage());
				Enemy enemy= new EnemyType1();
				int actualHp=enemy.hp;
				uc.levelObservable.subscribe(enemy);
				uc.levelUp();
				assertTrue(actualHp<enemy.getHp());
		}
		
		@Test
		public void calculateReceivedPhysicalDamageTest() {
			int danioBase = 100;
			Damage d = new Damage(new DamageType("physical"), danioBase, danioBase);
			Enemy e = new EnemyType1();
			int danioRecibe = e.calculateRecievedDamage(d);
			assertTrue(danioRecibe < danioBase);
		}
		
		@Test
		public void calculateReceivedMagicalDamageTest() {
			int danioBase = 100;
			Damage d = new Damage(new DamageType("magical"), danioBase, danioBase);
			Enemy e = new EnemyType1();
			int danioRecibe = e.calculateRecievedDamage(d);
			assertTrue(danioRecibe < danioBase);
		}
}
