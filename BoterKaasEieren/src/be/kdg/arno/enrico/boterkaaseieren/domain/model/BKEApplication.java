package be.kdg.arno.enrico.boterkaaseieren.domain.model;

import java.io.IOException;
import java.util.Scanner;

public class BKEApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BoterKaasEieren game;
        int choice;
        do {
            System.out.println("What do you want to do?\n- 1: 【\uD83C\uDFAE】Play 1v1\n- 2: 【\uD83E\uDD16】Play against computer\n- 3: 【\uD83C\uDFC6】Leaderboard\n- 4: 【\uD83D\uDCBE】Played games\n- 5: 【\uD83D\uDCD6】Game rules\n- 6: 【❌】Exit game");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            /*public void start1v1(){
                game = new BoterKaasEieren();
                System.out.print("Player one (O), give your name: ");
                String player1 = sc.next();
                System.out.print("Player two (X), give your name: ");
                String player2 = sc.next();
                System.out.printf("%s, you're playing against %s. Good luck to the both of you!\n", player1, player2);
                System.out.print("Press <ENTER> to continue!");
                System.out.println();
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                game.clearPlayers();
                game.twoPlayers(player1, player2);
                game.playGame();
//                    PlayedGames.addGame(game);
            }

            public void playComputer(){
                game = new BoterKaasEieren();
                System.out.print("What's your name?: ");
                String player = sc.next();
                System.out.printf("%s, you're playing against the computer. Good luck!\n", player);
                System.out.print("Press <ENTER> to continue!");
                System.out.println();
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                game.clearPlayers();
                game.OnePlayerOneComputer(player);
                game.playGame();
                //PlayedGames.addGame(game);
            }

            public void showLeaderboard(){
                Leaderboard.printLeaderboard();
            }

            public void showPlayedGames(){
                PlayedGames.getGames();
            }*/

            switch (choice) {
                case 1:
                    game = new BoterKaasEieren(3);
                    System.out.print("Player one (O), give your name: ");
                    String player1 = sc.next();
                    System.out.print("Player two (X), give your name: ");
                    String player2 = sc.next();
                    System.out.printf("%s, you're playing against %s. Good luck to the both of you!\n", player1, player2);
                    System.out.print("Press <ENTER> to continue!");
                    System.out.println();
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    game.clearPlayers();
                    game.twoPlayers(player1, player2);
                    game.playGame();
//                    PlayedGames.addGame(game);
                    break;
                case 2:
                    game = new BoterKaasEieren(3);
                    System.out.print("What's your name?: ");
                    String player = sc.next();
                    System.out.printf("%s, you're playing against the computer. Good luck!\n", player);
                    System.out.print("Press <ENTER> to continue!");
                    System.out.println();
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    game.clearPlayers();
                    game.onePlayerOneComputer(player);
                    game.playGame();
                    //PlayedGames.addGame(game);
                    break;
                case 3:
                    /*Leaderboard.printLeaderboard();*/
                    break;
                case 4:
                    /*PlayedGames.getGames();*/
                    break;
                case 5:
                    /*GameRules rules = new GameRules();
                    rules.printGameRules();*/
                    break;
                case 6:
                    break;
                default:
                    System.out.println("This is not a valid choice!\n");
                    break;
            }
        } while (choice != 6);
    }
}
