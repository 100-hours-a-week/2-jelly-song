package week2.assignment.jellyadventure.domain.character;

import java.util.List;

public class Player extends Character {
    private static final Integer INITIAL_PLAYER_HP = 100;
    private static final Integer INITIAL_PLAYER_POWER = 30;
    List<Integer> requiredExps = List.of(0, 30, 100, 400, 1000, 5000);
    private Integer MAX_LEVEL = requiredExps.size();

    private Integer level;
    private Integer exp;

    public Player() {
        super(INITIAL_PLAYER_HP, INITIAL_PLAYER_POWER);
        exp = 0;
        level = 1;
    }

    @Override
    public void attack(Character target) {
        super.attack(target);
        if (target instanceof Monster && !target.isAlive()) {
            Monster targetMonster = (Monster) target;
            targetMonster.giveExp(this);
            if (isPossibleLevelUp()) {
                levelUp();
            }
        }
    }

    private boolean isPossibleLevelUp() {
        return MAX_LEVEL > level && exp > requiredExps.get(level);
    }

    private void levelUp() {
        level++;
        exp = 0;
    }

    public void rest() {
        getFullHp();
    }

    public void exercise() {
        plusPower(1);
    }

    public void plusExp(int exp) {
        this.exp += exp;
    }

    @Override
    public void printStatus() {
        System.out.println(getClass().getSimpleName() + "의 상태: MAX_HP: " + getMaxHp() +
                " HP:" + getHp() + " POWER:" + getPower() + " EXP:" + exp + " LEVEL:" + level);
    }
}
