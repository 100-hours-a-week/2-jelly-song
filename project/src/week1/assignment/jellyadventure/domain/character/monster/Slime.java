package week1.assignment.jellyadventure.domain.character.monster;

import week1.assignment.jellyadventure.domain.character.Monster;

public class Slime extends Monster {
    private static final Integer SLIME_HP = 5;
    private static final Integer SLIME_POWER = 1;
    private static final Integer SLIME_EXP = 1;
    public Slime() {
        super(SLIME_HP, SLIME_POWER, SLIME_EXP);
    }
}
