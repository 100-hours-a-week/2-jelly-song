package week2.assignment.jellyadventure.domain.menu;

import java.util.Arrays;

public enum BattleContinueMenu {
    NONE(0), YES(1), NO(2);

    private Integer id;

    BattleContinueMenu(Integer id) {
        this.id = id;
    }

    public static BattleContinueMenu getFrom(Integer integer) {
        return Arrays.stream(values())
                .filter(menu -> menu.id.equals(integer))
                .findFirst()
                .orElse(NONE);
    }
}
