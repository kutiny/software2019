package game;

public class WarriorSkill2 extends Skill {

  public WarriorSkill2(){
    this.skillName = "Double Slash";
    this.critProbability = 0.05;
    this.failProbability = 0.5;
    this.damage = new Damage(new DamageType("Physical"), 71);
  }

  public void use(){

  }
}
