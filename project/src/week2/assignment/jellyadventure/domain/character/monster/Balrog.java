package week2.assignment.jellyadventure.domain.character.monster;

import week2.assignment.jellyadventure.domain.character.Monster;

public class Balrog extends Monster {
    private static final Integer BALROG_HP = 200;
    private static final Integer BALROG_POWER = 25;
    private static final Integer BALROG_EXP = 1000;
    public Balrog() {
        super(BALROG_HP, BALROG_POWER, BALROG_EXP);
    }
}
