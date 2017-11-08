package BussinessLogic;

import java.util.Scanner;
import Data.Game;
import UI.UI;

public class GameEngine {

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
            Game game = new Game();
            int Credit = 100;
            System.out.printf("\nTienes %d créditos.\n", Credit);
            System.out.println("¿Cuántos créditos quieres apostar?: ");
            Scanner Bet = new Scanner(System.in);
            int BetGame = Bet.nextInt();

            game.play();
            System.out.println();
            //Credit=Credit+Multiplier.Credit(BetGame);
            System.out.printf("\nAhora tienes %d créditos.\n", Credit);
            System.out.println("\n¿Quieres jugar de nuevo? (1 - Sí / Cualquier tecla - No)");
            again = input.nextInt();
        } while (again == 1);
        System.out.println("\n¡Gracias por jugar!");
    }

    private static class Int {

        public Int() {
        }
    }
}
