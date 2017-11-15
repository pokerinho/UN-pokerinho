package BussinessLogic;

import Data.Card;
import Data.Deck;
import Data.Player;
import UI.UI;
import UI.CLI;

public class GameEngine {
    
    public static Deck deck = new Deck();
    
    private static UI ui;
    
    private static void selectUI(String[] args) {
        if (args.length == 0) {
            ui = new CLI();
        } else if (args[0].equals("text")) {
            ui = new CLI();
        } else {
            ui = new CLI();
        }
    }

    public static void main(String[] args) {
        selectUI(args);
        Player player = new Player(ui.printWelcome());
        mainMenu(player);
    }

    public static void mainMenu(Player player) {
        int again = 0;
        ui.printMainMenu();
        switch (ui.askMenuOption()) {
            case 1: {
                startGame(player, again);
                break;
            }
            case 2: {
                ui.printInstructions();
                mainMenu(player);
                break;
            }
            case 3: {
                System.exit(0);
            }
        }
    }

    public static void startGame(Player player, int again) {
        do {
            ui.printCredits(player);
            int Bet = ui.askBetAmount();
            play(player);
            System.out.println();
            ui.printCredits(player);
            again = ui.askPlayAgain();
        } while (again == 1);
        System.out.println("\n¡Gracias por jugar!");
    }
    
    public static void play(Player player){
        player.newHand();
        for (int i = 0; i < 5; i++) {
                Card card = deck.draw();
                player.addCard(card);
        }
        ui.printCards(player);
        GameTable.replace(ui, deck, player);
        System.out.println();
        ui.printCategorizeHand(player);
    }
}
