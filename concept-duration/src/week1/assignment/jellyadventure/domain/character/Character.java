package week1.assignment.jellyadventure.domain.character;

public abstract class Character {
    private Integer maxHp;
    private Integer hp;
    private Integer power;

    public Character(Integer hp, Integer power) {
        this.maxHp = hp;
        this.hp = hp;
        this.power = power;
    }
    public void attack(Character target) {
        target.isDamaged(power);
    }

    private void isDamaged(Integer enemyPower) {
        hp = hp - enemyPower;
        if (isHpMinus()) {
            hp = 0;
        }
    }

    private boolean isHpMinus() {
        return hp < 0;
    }

    public Boolean isAlive() {
        return hp > 0;
    }

    public void printStatus() {
        System.out.println(getClass().getSimpleName() + "의 상태: HP:" + hp + " POWER:" + power );
    }

    public void rest() {
        hp = maxHp;
    }

    public void exercise() {
        power += 1;
    }
}
