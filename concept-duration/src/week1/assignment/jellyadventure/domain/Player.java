package week1.assignment.jellyadventure.domain;

import week1.assignment.jellyadventure.domain.Character;

public class Player extends Character {
    static final Integer INITIAL_PLAYER_HP = 100;
    static final Integer INITIAL_PLAYER_POWER = 30;
    public Player() {
        super(INITIAL_PLAYER_HP, INITIAL_PLAYER_POWER);
    }

}
