package week2.assignment.jellyadventure.domain.character;

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

    public void plusPower(Integer power) {
        this.power += power;
    }

    public void getFullHp() {
        this.hp = maxHp;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getPower() {
        return power;
    }
}
