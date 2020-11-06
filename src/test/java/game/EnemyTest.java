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

	@Test
	public void levelUpTest() {
		Enemy e = new EnemyType1();
		int lvl = e.getLevel();
		e.levelUp();
		assertEquals(lvl + 1, e.getLevel());
	}

	@Test
	public void setEnemyNameTest() {
		Enemy e = new EnemyType1();
		String ename = "Pablito";
		e.setEnemyName(ename);
		assertEquals(ename, e.getEnemyName());
	}

	@Test
	public void setEnemyDamageTest() {
		Enemy e = new EnemyType1();
		Damage dmg = new Damage(new DamageType("Physical"), 30, 30);
		e.setDamage(dmg);
		assertEquals(dmg, e.getDamage());
	}

	@Test
	public void EnemyCritTest() {
		// String name, int lv, int hp, Damage damage, double armor, double critProb, double failProb, double magicResist, int expKilled
		double crit = 0.0;
		Enemy e = new EnemyType1();
		assertEquals(crit, e.getCritProb(), 0);
	}

	@Test
	public void EnemyFailTest() {
		double fail = 0.2;
		Enemy e = new EnemyType1();
		assertEquals(fail, e.getFailProb(), 0);
	}
}
