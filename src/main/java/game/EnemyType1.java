package game;

public class EnemyType1 extends Enemy {
    public EnemyType1() {
        super("Enemy1", 1, 5, new Damage(new DamageType("physical"), 12, 12), 0.1, 0.0, 0.2, 0.12, 100);
    }

    @Override
    public Damage fight() {
        if ((this.failProb + Math.random()) < MEDIUMPROB) {
            this.damage.setDamageAmmount(0);
        } else if (this.critProb + Math.random() < MEDIUMPROB) {
            damage.setDamageAmmount(damage.getBasicDamageAmmount() * 2);
        } else {
            damage.setDamageAmmount(damage.getBasicDamageAmmount());
        }
        return damage;
    }

    public void notifyHandler(Object value) throws IllegalArgumentException {
        if (value instanceof Integer && (this.hp > 0)) {
            this.setLevel((int) value);
            this.damage.setBasicDamageAmmount(12 * (1 + (this.getLevel() / 10)));
            this.setHp(60 * (1 + this.getLevel() / 100));
            this.setArmor(this.getArmor() * (1 + this.getLevel() * 0.02));
            this.setMagicResist(this.getMagicResist() * (1 + this.getLevel() * 0.02));
        } else {
            throw new IllegalArgumentException();
        }
    }
}
