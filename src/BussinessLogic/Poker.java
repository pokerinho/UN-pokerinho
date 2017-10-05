package BussinessLogic;

import java.util.Scanner;
import Data.Game;
import UI.UI;


public class Poker {
	
    public static void main(String[] args) {
        UI.mainMenu();
    }
    
    public static void startGame(int again, Scanner input){
        do {
            Game game=new Game(); 
            game.play();
            System.out.println();
            System.out.println("¿Quieres jugar de nuevo?(1 - Sí/0 - No)");
            again = input.nextInt(); 
	}while (again == 1);
	System.out.println("¡Gracias por jugar!");
    }
}
