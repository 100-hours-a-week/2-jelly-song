package week2.assignment.jellyadventure.domain.menu;

import java.util.Arrays;
import java.util.function.Supplier;
import week2.assignment.jellyadventure.domain.character.Monster;
import week2.assignment.jellyadventure.domain.character.monster.Balrog;
import week2.assignment.jellyadventure.domain.character.monster.Goblin;
import week2.assignment.jellyadventure.domain.character.monster.Slime;

public enum MainMenu {
    NONE(0, null), BATTLE_SLIME(1, Slime::new), BATTLE_BALROG(3, Balrog::new),
    BATTLE_GOBLIN(2, Goblin::new), EXERCISE(4, null), REST(5, null);

    private final Integer id;
    private final Supplier<Monster> monsterSupplier;  // Monster 객체를 생성하는 Supplier

    // 생성자
    MainMenu(Integer id, Supplier<Monster> monsterSupplier) {
        this.id = id;
        this.monsterSupplier = monsterSupplier;
    }
    public static Monster changeToMonster(MainMenu mainMenu) {
        return Arrays.stream(values())
                .filter(menu -> menu.equals(mainMenu))
                .map(menu -> menu.monsterSupplier != null ? menu.monsterSupplier.get() : null)
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
