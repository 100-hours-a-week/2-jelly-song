package week2.assignment.jellyadventure.domain.character;

public abstract class Monster extends Character {
    private Integer exp;
    public Monster(Integer hp, Integer power, Integer exp) {
        super(hp, power);
        this.exp = exp;
    }

    public void giveExp(Player player) {
        player.plusExp(exp);
    }
}
