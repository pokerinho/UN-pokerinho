/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BussinessLogic.Poker;
import java.util.Scanner;

/**
 *
 * @author wilder-eb
 */
public class UI {
    
    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        int again=0;
        printWelcome();
        int option=input.nextInt();
        switch(option){
            case 1:{
                Poker.startGame(again, input);
                break;
            }
            case 2:{
                printInstructions();
                break;
            }
            case 3:{
                break;
            }
        }
    }
    
    public static void printWelcome(){
        System.out.println("Bienvenido a UN Pokerinho");
        System.out.println("1. Comenzar el juego");
        System.out.println("2. Instrucciones");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion > ");
    }
    
    public static void printInstructions(){
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
        System.out.println("Nada: Ninguna combinación anterior.");
    }
}
