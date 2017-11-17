package BussinessLogic;

import Data.Card;
import Data.Deck;
import Data.Player;
import UI.UI;
import UI.CLI;

public class GameEngine {
    
    private static final Deck deck = new Deck();
    private static Player player;
    
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
        player = new Player(ui.printWelcome(), 100);
        mainMenu();
    }

    public static void mainMenu() {
        do{
            ui.printMainMenu(player);
            switch (ui.askMenuOption()) {
                case 1: {
                    startGame();
                }
                break;
                case 2: {
                    ui.printInstructions();
                }
                break;
                case 0: {
                    System.exit(0);
                }
            }
        } while (true);
    }

    public static void startGame() {
            ui.printCredits(player);
            int bet = ui.askBetAmount();
            player.setCredits(-bet);
            play();
            bet *= MoveHandler.categorizeHand(player);
            player.setCredits(bet);
            ui.printCredits(player);
    }
    
    public static void play(){
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
