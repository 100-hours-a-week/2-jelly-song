package week2.assignment.jellyadventure.domain.character;

public abstract class Character {
    protected Integer maxHp;
    protected Integer hp;
    protected Integer power;

    public Character(Integer hp, Integer power) {
        this.maxHp = hp;
        this.hp = hp;
        this.power = power;
    }
    public void attack(Character target) {
        target.takeDamaged(power);
    }

    private void takeDamaged(Integer enemyPower) {
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
        System.out.println(getClass().getSimpleName() + "의 상태: MAX_HP: " + maxHp +
                " HP:" + hp + " POWER:" + power);
    }

}
