/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Data.Player;

/**
 *
 * @author wilder-eb
 */
public interface UI {
    
    public static final String ERROR_INVALID_INPUT = "Entrada incorrecta";
    
    public static final String ERROR_INCORRECT_OPTION = "Opcion incorrecta";
    
    public static final String ERROR_INCORRECT_BET = "La apuesta ingresada no se hizo en multiplos de 10 o supera la cantidad de créditos del jugador";
    
    public static final String ERROR_INCORRECT_INDEX = "Solo puedes cambiar cinco cartas";
    
    public static final String ERROR_IO = "Ocurrio un error";
    
    public static final String ERROR_INCORRECT_REJECT = "Solo puedes ingresar valores enteros entre 1 y 5";
    
    public void printWelcome();
    public void printMainMenu(Player player);
    public void printInstructions();
    public void printCards(Player player);
    public void printNewCards(Player player);
    public void printCredits(Player player);
    public void printCategorizeHand(Player player);
    public void printSaved();
    public void printLoaded();
    public void printError(String error);
    public String askName();
    public int askMenuOption();
    public int askBetAmount(Player player);
    public int[] askReject();
    public boolean printGameOver();
}
