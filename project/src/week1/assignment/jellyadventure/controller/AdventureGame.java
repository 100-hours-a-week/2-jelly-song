package week1.assignment.jellyadventure.controller;

import java.util.Scanner;
import week1.assignment.jellyadventure.domain.character.Monster;
import week1.assignment.jellyadventure.domain.menu.BattleContinueMenu;
import week1.assignment.jellyadventure.domain.character.Player;
import week1.assignment.jellyadventure.domain.menu.MainMenu;

public class AdventureGame {
    Scanner scanner = new Scanner(System.in);
    public void start() {
        Player player = new Player();

        printStartDescription();
        while (player.isAlive()) {
            printPlayerSelectMenu();
            player.printStatus();

            MainMenu mainMenu = selectMenu();
            if (isNoBattleMenu(mainMenu)) {
                processNoBattleMenu(mainMenu, player);
                continue;
            }

            battle(player, mainMenu);
        }
        printEndDescription();
    }

    private static boolean isNoBattleMenu(MainMenu mainMenu) {
        if (mainMenu.equals(MainMenu.EXERCISE) || mainMenu.equals(MainMenu.REST)) {
            return true;
        }
        return false;
    }

    private static boolean processNoBattleMenu(MainMenu mainMenu, Player player) {
        if (mainMenu.equals(MainMenu.EXERCISE)) {
            player.exercise();
            return true;
        }
        if (mainMenu.equals(MainMenu.REST)) {
            player.rest();
            return true;
        }
        return false;
    }

    private MainMenu selectMenu() {
        Integer select = getIntegerFromUserByRange(1,5);;
        return MainMenu.changeToMenu(select);
    }

    private void battle(Player player, MainMenu mainMenu) {
        Monster curMonster = MainMenu.changeToMonster(mainMenu); // 변경 요망

        while (player.isAlive() && curMonster.isAlive()) {
            battleEachOther(player, curMonster);
            printBattleResult(player, curMonster);

            if (player.isAlive() && curMonster.isAlive()) {
                System.out.println("도망 가시겠습니까? 1.예 2.아니오");
                Integer select = getIntegerFromUserByRange(1,2);
                BattleContinueMenu selectMenu = BattleContinueMenu.getFrom(select);
                if (selectMenu == BattleContinueMenu.YES) {
                    break;
                }
            }

        }
    }

    private static void printBattleResult(Player player, Monster curMonster) {
        System.out.println("<<배틀 결과>>");
        player.printStatus();
        curMonster.printStatus();
        System.out.println();
    }

    private static void battleEachOther(Player player, Monster curMonster) {
        player.attack(curMonster);
        curMonster.attack(player);
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
                continue;
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

}