package week1.assignment.jellyadventure.domain;

public class Player extends Character {
    private static final Integer INITIAL_PLAYER_HP = 100;
    private static final Integer INITIAL_PLAYER_POWER = 30;
    private Integer exp;
    public Player() {
        super(INITIAL_PLAYER_HP, INITIAL_PLAYER_POWER);
        exp = 0;
    }

    @Override
    public void attack(Character target) {
        super.attack(target);
        if( target instanceof Monster && !target.isAlive() ) {
            Monster targetMonster = (Monster) target;
            targetMonster.giveExp(this);
        }
    }

    public void rest() {
        hp = maxHp;
    }

    public void exercise() {
        power += 1;
    }

    public void plusExp(int exp) {
        this.exp += exp;
    }

    @Override
    public void printStatus() {
        System.out.println(getClass().getSimpleName() + "의 상태: MAX_HP: " + maxHp +
                " HP:" + hp + " POWER:" + power + " EXP:" + exp);
    }
}
