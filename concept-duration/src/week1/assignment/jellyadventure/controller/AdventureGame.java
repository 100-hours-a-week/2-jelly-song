package week1.assignment.jellyadventure.controller;

import java.util.Scanner;
import week1.assignment.jellyadventure.domain.Monster;
import week1.assignment.jellyadventure.domain.monster.Balrog;
import week1.assignment.jellyadventure.domain.monster.Goblin;
import week1.assignment.jellyadventure.domain.monster.Slime;
import week1.assignment.jellyadventure.domain.Player;

public class AdventureGame {
    Scanner scanner = new Scanner(System.in);
    public void start() {
        Player player = new Player();

        printStartDescription();
        while (player.isAlive()) {
            printPlayerSelectMenu();
            player.printStatus();

            Menu menu = selectMenu();
            if (isNoBattleMenu(menu)) {
                processNoBattleMenu(menu, player);
                continue;
            }

            battle(player, menu);
        }
        printEndDescription();
    }

    private static boolean isNoBattleMenu(Menu menu) {
        if (menu.equals(Menu.EXERCISE) || menu.equals(Menu.REST)) {
            return true;
        }
        return false;
    }

    private static boolean processNoBattleMenu(Menu menu, Player player) {
        if (menu.equals(Menu.EXERCISE)) {
            player.exercise();
            return true;
        }
        if (menu.equals(Menu.REST)) {
            player.rest();
            return true;
        }
        return false;
    }

    private Menu selectMenu() {
        Integer select = getIntegerFromUserByRange(1,5);;
        return Menu.changeToMenu(select);
    }

    private void battle(Player player, Menu menu) {
        Monster curMonster = Menu.changeToMonster(menu); // 변경 요망

        while (player.isAlive() && curMonster.isAlive()) {
            player.attack(curMonster);
            curMonster.attack(player);
            System.out.println("<<배틀 결과>>");
            player.printStatus();
            curMonster.printStatus();
            System.out.println();

            if (player.isAlive() && curMonster.isAlive()) {
                System.out.println("도망 가시겠습니까? 1.예 2.아니오");
                Integer select = getIntegerFromUserByRange(1,2);
                if (select == 1) {
                    break;
                }
            }

        }
    }

    private Integer getIntegerFromUserByRange(Integer start, Integer end) {
        Integer select = 0;
        while (true) {
            String next = scanner.next();
            if (!validateNumber(next)) {
                continue;
            }
            select = Integer.parseInt(next);

            if (!(start <= select && select <= end)) {
                System.out.println("**" + start + "부터 " + end + "까지 중 숫자 하나를 입력해 주세요!**");
            }

            if (start <= select && select <= end) {
                break;
            }
        }
        return select;
    }

    private static Boolean validateNumber(String next) {
        try {
            Integer.parseInt(next);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("**숫자를 입력해 주세요!**");
            return false;
        }
        return true;
    }

    private static void printEndDescription() {
        System.out.println("!!!!!패배!!!!!");
    }

    private static void printStartDescription() {
        System.out.println("****모험을 시작합니다****");
    }

    private static void printPlayerSelectMenu() {
        System.out.println("어떤 몬스터와 싸우시겠습니까?");
        System.out.println("1. 슬라임, 2. 고블린, 3. 발록, 4. 운동하기, 5. 휴식하기");
    }

    enum Menu {
        NONE, BATTLE_SLIME, BATTLE_BALROG, BATTLE_GOBLIN, EXERCISE, REST, YES, NO;

        static Monster changeToMonster(Menu menu) {
            if (menu.equals(Menu.BATTLE_SLIME)) {
                return new Slime();
            } else if (menu.equals(Menu.BATTLE_GOBLIN)) {
                return new Goblin();
            } else if (menu.equals(Menu.BATTLE_BALROG)) {
                return new Balrog();
            } else {
                return null;
            }
        }

         static Menu changeToMenu(Integer number) {
            if (number == 1) {
                return Menu.BATTLE_SLIME;
            } else if (number == 2) {
                return Menu.BATTLE_GOBLIN;
            } else if (number == 3) {
                return Menu.BATTLE_BALROG;
            } else if (number == 4) {
                return Menu.EXERCISE;
            } else if (number == 5) {
                return Menu.REST;
            }
            return Menu.NONE;
        }
    }
}