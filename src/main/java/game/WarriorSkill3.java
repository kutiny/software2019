package game;

public class WarriorSkill3 extends Skill {

  public WarriorSkill3(){
    this.skillName = "Chop";
    this.critProbability = 0.015;
    this.failProbability = 0.75;
    this.damage = new Damage(new DamageType("Physical"), 104);
  }

  public void use(){

  }
}
