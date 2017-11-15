package BussinessLogic;

import Data.Card;
import Data.Deck;
import Data.Player;
import UI.UI;

public class GameEngine {
    
    public static Deck deck = new Deck();
    

    public static void main(String[] args) {
        Player player = new Player(UI.printWelcome());
        mainMenu(player);
    }

    public static void mainMenu(Player player) {
        int again = 0;
        UI.printMainMenu();
        switch (UI.askMenuOption()) {
            case 1: {
                startGame(player, again);
                break;
            }
            case 2: {
                UI.printInstructions();
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
            UI.printCredits(player);
            int Bet = UI.askBetAmount();
            play(player);
            System.out.println();
            UI.printCredits(player);
            again = UI.askPlayAgain();
        } while (again == 1);
        System.out.println("\n¡Gracias por jugar!");
    }
    
    public static void play(Player player){
        player.newHand();
        for (int i = 0; i < 5; i++) {
                Card card = deck.draw();
                player.addCard(card);
        }
        UI.printCards(player);
        GameTable.replace(deck, player);
        System.out.println();
        UI.printCategorizeHand(player);
    }
}
