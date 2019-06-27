package game;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CharacterClassTest {
	
	CharacterClass c;
	
	@Before
	public void ExecuteBeforeEach() {
		this.c = new Mage();
	}
	
	@Test
	public void negativeSetMaxHp() {
		boolean thrown = false;
		try {
			this.c.setMaxHealth(-10);			
		}catch(IllegalArgumentException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void setSkillsTest() {
		ArrayList<Skill> sks = new ArrayList<Skill>();
		sks.add(new WarriorSkill1());
		this.c.setSkills(sks);
		Assert.assertNotNull("", this.c.getSkills().get(0));
	}
}
