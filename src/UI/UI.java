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
    
    public String printWelcome();
    public void printMainMenu(Player player);
    public int askMenuOption();
    public void printInstructions();
    public String askReject();
    public void printCards(Player player);
    public void printNewCards(Player player);
    public void printCredits(Player player);
    public int askBetAmount();
    public int askPlayAgain();
    public void printCategorizeHand(Player player);
    
}
