package week1.assignment.jellyadventure.domain.character.monster;

import week1.assignment.jellyadventure.domain.character.Monster;

public class Goblin extends Monster {
    private static final Integer GOBLIN_HP = 50;
    private static final Integer GOBLIN_POWER = 10;
    private static final Integer GOBLIN_EXP = 20;

    public Goblin() {
        super(GOBLIN_HP, GOBLIN_POWER, GOBLIN_EXP);
    }
}
