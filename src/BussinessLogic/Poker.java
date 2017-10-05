package BussinessLogic;

import java.util.Scanner;
import Data.Game;


public class Poker {
	
    public static void main(String[] args) {
		
        Scanner input = new Scanner(System.in);
	int again = 1;
	while (again == 1) { 
            Game game=new Game(); 
            game.play();
            System.out.println();
            System.out.println("¿Quieres jugar de nuevo?(1 - Sí/0 - No)");
            again = input.nextInt(); 
	}
	System.out.println("¡Gracias por jugar!");
    }
}