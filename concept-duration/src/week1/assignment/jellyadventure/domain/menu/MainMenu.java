package week1.assignment.jellyadventure.domain.menu;

import java.util.Arrays;
import week1.assignment.jellyadventure.domain.character.Monster;
import week1.assignment.jellyadventure.domain.character.monster.Balrog;
import week1.assignment.jellyadventure.domain.character.monster.Goblin;
import week1.assignment.jellyadventure.domain.character.monster.Slime;

public enum MainMenu {
    NONE(0, null), BATTLE_SLIME(1, new Slime()), BATTLE_BALROG(2, new Balrog()),
    BATTLE_GOBLIN(3, new Goblin()), EXERCISE(4, null), REST(5, null);

    private Integer id;
    private Monster instance;

    MainMenu(Integer id, Monster instance) {
        this.id = id;
        this.instance = instance;
    }
    public static Monster changeToMonster(MainMenu mainMenu) {
        return Arrays.stream(values())
                .filter(menu -> menu.equals(mainMenu))
                .map(menu -> menu.instance)
                .findFirst()
                .orElse(null);
    }

    public static MainMenu changeToMenu(Integer number) {
        return Arrays.stream(values())
                .filter(menu -> menu.id.equals(number))
                .findFirst()
                .orElse(NONE);
    }
}
