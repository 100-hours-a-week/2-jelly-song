package week1.assignment.jellyadventure.domain.monster;

import week1.assignment.jellyadventure.domain.Monster;

public class Goblin extends Monster {
    private static final Integer GOBLIN_HP = 50;
    private static final Integer GOBLIN_POWER = 10;

    public Goblin() {
        super(50, 10);
    }
}
