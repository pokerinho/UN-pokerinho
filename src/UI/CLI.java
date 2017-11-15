package UI;

import Data.Player;
import java.util.Scanner;
import BussinessLogic.MoveHandler;

public class CLI implements UI{

    private static final Scanner input = new Scanner(System.in);

    @Override
    public String printWelcome() {
        System.out.println("BIENVENIDO A UN POKERINHO\n");
        System.out.println("¿Cual es tu nombre?\n");
        return input.nextLine();
    }

    @Override
    public void printMainMenu() {
        System.out.println("1. Comenzar el juego");
        System.out.println("2. Instrucciones");
        System.out.println("3. Salir");
        System.out.print("\nSelecciona una opción: \n");
    }

    @Override
    public int askMenuOption() {
        return input.nextInt();
    }

    @Override
    public void printInstructions() {
        System.out.println("1. Para ganar deberás usar tu suerte tanto como puedas, comenzarás con 5 cartas y deberás hacer\n" + "combinaciones de éstas en dos oportunidades, podrás cambiar en una ocasión las cartas que quieras,\n" + "para luego con las nuevas cartas multiplicar o perder tu apuesta.\n");
        System.out.println("Podrás hacer las siguientes combinaciones de cartas:\n");
        System.out.println("Escalera Real: Escalera desde 10 hasta A de la misma pinta.");
        System.out.println("Escalera de Color: Cualquier escalera de la misma pinta.");
        System.out.println("Póker: Cuatro cartas del mismo número.");
        System.out.println("Full House: Un trío y un par.");
        System.out.println("Color: Cinco cartas de la misma pinta.");
        System.out.println("Escalera: Cualquier escalera de diferente pinta.");
        System.out.println("Trío: Tres cartas del mismo número.");
        System.out.println("Dos Pares: Dos pares de números con diferentes pintas.");
        System.out.println("Par: Dos cartas del mismo número.");
        System.out.println("Nada: Ninguna combinación anterior.\n");
        System.out.println("2. Comenzarás con 100 créditos que podrás apostar.\n"
                + "Tu apuesta se multiplicará así:");
        System.out.println("*********************************				\n"
                + "* Escalera Real		1-500	*\n"
                + "* Escalera de Color	1-200	*\n"
                + "* Póker			1-100	*\n"
                + "* Full House		1-50	*\n"
                + "* Color			1-20	*\n"
                + "* Escalera		1-10	*\n"
                + "* Trío			1-3	*\n"
                + "* Dos Pares		1-2	*\n"
                + "* Par			1-1	*\n"
                + "* Nada			1-0	*				\n"
                + "*********************************\n");
        System.out.println("Entre más créditos tengas mejores premios podrás redimir.");
    }

    @Override
    public int askReject() {
        System.out.println("\n¿Desear cambiar alguna carta? (1 - Sí / Cualquier tecla - No)");
        return input.nextInt();
    }

    @Override
    public String askWhatReject() {
        System.out.println("\n¿Cuáles cartas deseas cambiar?");
        return input.next();
    }

    @Override
    public void printCards(Player player) {
        System.out.println("\nTus cartas son:\n");
        System.out.println(player.toString());
    }

    @Override
    public void printNewCards(Player player) {
        System.out.println("\nTus nuevas cartas son: \n");
        System.out.println(player.toString());
    }

    @Override
    public void printCredits(Player player) {
        System.out.printf("\nTienes %d créditos.\n", player.getCredits());
    }

    @Override
    public int askBetAmount() {
        System.out.println("¿Cuántos créditos quieres apostar?: ");
        return input.nextInt();
    }

    @Override
    public int askPlayAgain() {
        System.out.println("\n¿Quieres jugar de nuevo? (1 - Sí / Cualquier tecla - No)");
        return input.nextInt();
    }

    @Override
    public void printCategorizeHand(Player player) {
        if (MoveHandler.categorizeHand(player) == 5000) {
            System.out.println("¡Tienes una Flor Imperial!");
        }
        if (MoveHandler.categorizeHand(player) == 200) {
            System.out.println("¡Tienes una Escalera de Color!");
        }
        if (MoveHandler.categorizeHand(player) == 100) {
            System.out.println("¡Tienes un Póker!");
        }
        if (MoveHandler.categorizeHand(player) == 50) {
            System.out.println("¡Tienes un Póker!");
        }
        if (MoveHandler.categorizeHand(player) == 20) {
            System.out.println("¡Tienes un Color!");
        }
        if (MoveHandler.categorizeHand(player) == 10) {
            System.out.println("¡Tienes una Escalera!");
        }
        if (MoveHandler.categorizeHand(player) == 3) {
            System.out.println("¡Tienes un Trío!");
        }
        if (MoveHandler.categorizeHand(player) == 2) {
            System.out.println("¡Tienes dos Pares!");
        }
        if (MoveHandler.categorizeHand(player) == 1) {
            System.out.println("¡Tienes un Par!");
        } else {
            System.out.println("No tienes nada");
        }
    }
}