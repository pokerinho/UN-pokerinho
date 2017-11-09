package BussinessLogic;

import Data.Card;
import Data.Deck;
import Data.Player;
import java.util.Scanner;
import UI.UI;

public class GameEngine {
    
    private final Scanner input = new Scanner(System.in);
    
    public static Deck deck = new Deck();
    public static Player player = new Player();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);
        int again = 0;
        UI.printWelcome();
        int option = input.nextInt();
        switch (option) {
            case 1: {
                startGame(again, input);
                break;
            }
            case 2: {
                UI.printInstructions();
                mainMenu();
                break;
            }
            case 3: {
                break;
            }
        }
    }

    public static void startGame(int again, Scanner input) {
        do {
            int Credit = 100;
            System.out.printf("\nTienes %d créditos.\n", Credit);
            System.out.println("¿Cuántos créditos quieres apostar?: ");
            Scanner Bet = new Scanner(System.in);
            int BetGame = Bet.nextInt();

            
            for (int i = 0; i < 5; i++) {
                Card card = deck.draw();
                player.addCard(card);
            }
            System.out.println("\nTus cartas son:\n");
            System.out.println(player.toString());
            rejectCards(input, deck, player);
            System.out.println();
            System.out.println(GameTable.categorizeHand());
            
            
            System.out.println();
            //Credit=Credit+Multiplier.Credit(BetGame);
            System.out.printf("\nAhora tienes %d créditos.\n", Credit);
            System.out.println("\n¿Quieres jugar de nuevo? (1 - Sí / Cualquier tecla - No)");
            again = input.nextInt();
        } while (again == 1);
        System.out.println("\n¡Gracias por jugar!");
    }
    
    public static void rejectCards(Scanner input, Deck deck, Player player) {
        
	int reject;
	String rejected = ""; 
	UI.askReject();
	reject = input.nextInt();
	if (reject == 1) {
            UI.askWhatReject();
            rejected = input.next();
	}
	GameTable.replace(rejected, deck, player);
    }
}
