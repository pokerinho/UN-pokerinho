package BussinessLogic;

import java.util.Scanner;
import Data.Game;
import UI.UI;
import BussinessLogic.Multiplier;


public class Poker {
	
    public static void main(String[] args) {
        UI.mainMenu();
    }
    
    public static void startGame(int again, Scanner input){
        do {
            Game game=new Game(); 
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
	}while (again == 1);
	System.out.println("\n¡Gracias por jugar!");
    }

    private static class Int {

        public Int() {
        }
    }
}
