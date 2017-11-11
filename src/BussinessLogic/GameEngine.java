package BussinessLogic;

import Data.Card;
import Data.Deck;
import Data.Player;
import java.util.Scanner;
import UI.UI;

public class GameEngine {
    
    private static final Scanner input = new Scanner(System.in);
    public static Deck deck = new Deck();
    public static Player player = new Player();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        int again = 0;
        UI.printMainMenu();
        switch (UI.askMenuOption()) {
            case 1: {
                startGame(again);
                break;
            }
            case 2: {
                UI.printInstructions();
                mainMenu();
                break;
            }
            case 3: {
                System.exit(0);
            }
        }
    }

    public static void startGame(int again) {
        do {
            UI.printCredits(player);
            int Bet = UI.askBetAmount();
            play();
            System.out.println();
            UI.printCredits(player);
            again = UI.askPlayAgain();
        } while (again == 1);
        System.out.println("\n¡Gracias por jugar!");
    }
    
    public static void play(){
        for (int i = 0; i < 5; i++) {
                Card card = deck.draw();
                player.addCard(card);
        }
        UI.printCards(player);
        GameTable.rejectCards(input, deck, player);
        System.out.println();
        System.out.println(MoveHandler.categorizeHand(player));
    }
}
