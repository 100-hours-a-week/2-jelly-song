package week1.assignment.jellyadventure.controller;

import java.util.Scanner;
import week1.assignment.jellyadventure.domain.character.Monster.Balrog;
import week1.assignment.jellyadventure.domain.character.Monster.Goblin;
import week1.assignment.jellyadventure.domain.character.Monster.Monster;
import week1.assignment.jellyadventure.domain.character.Monster.Slime;
import week1.assignment.jellyadventure.domain.character.Player;

public class AdventureGame {
    Scanner scanner = new Scanner(System.in);
    public void start() {
        Player player = new Player();

        printStartDescription();
        while (player.isAlive()) {
            printPlayerSelectMenu(player);
            Monster curMonster = selectMenu(player);
            if (curMonster == null) {
                continue;
            }
            battle(player, curMonster);
        }
        printEndDescription();
    }

    private Monster selectMenu(Player player) {
        int select = scanner.nextInt();
        Monster curMonster = null;
        if (select == 1) {
            curMonster = new Slime();
        } else if (select == 2) {
            curMonster = new Goblin();
        } else if (select == 3) {
            curMonster = new Balrog();
        } else if (select == 4) {
            player.exercise();
            return null;
        } else if (select == 5) {
            player.rest();
            return null;
        } else {
            System.out.println("잘못된 선택입니다 다시 선택하세요");
            return null;
        }
        return curMonster;
    }

    private void battle(Player player, Monster curMonster) {
        while (player.isAlive() && curMonster.isAlive()) {
            player.attack(curMonster);
            curMonster.attack(player);
            System.out.println("<<배틀 결과>>");
            player.printStatus();
            curMonster.printStatus();
            System.out.println();

            if (player.isAlive() && curMonster.isAlive()) {
                System.out.println("도망 가시겠습니까? 1.예 2.아니오");
                int select = scanner.nextInt();
                if (select == 1) {
                    break;
                }
            }

        }
    }

    private static void printEndDescription() {
        System.out.println("!!!!!패배!!!!!");
    }

    private static void printStartDescription() {
        System.out.println("****모험을 시작합니다****");
    }

    private static void printPlayerSelectMenu(Player player) {
        System.out.println("어떤 몬스터와 싸우시겠습니까?");
        System.out.println("1. 슬라임, 2. 고블린, 3. 발록, 4. 운동하기, 5. 휴식하기");
        player.printStatus();
    }
}
