package week1.assignment.jellyadventure.domain.monster;

import week1.assignment.jellyadventure.domain.Monster;

public class Slime extends Monster {
    private static final Integer SLIME_HP = 5;
    private static final Integer SLIME_POWER = 1;
    public Slime() {
        super(SLIME_HP, SLIME_POWER);
    }
}
