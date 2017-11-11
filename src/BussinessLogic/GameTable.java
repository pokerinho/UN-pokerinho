package BussinessLogic;

import Data.Card;
import Data.Player;
import Data.Deck;
import UI.UI;
import java.util.Scanner;

public class GameTable {
    
    public static void rejectCards(Scanner input, Deck deck, Player player) {
	String rejected = "";
	if (UI.askReject() == 1) {
            rejected = UI.askWhatReject();
	}
	replace(rejected, deck, player);
    }
	
    public static void replace(String rejected, Deck deck, Player player) {
	if (!rejected.equals("")) { 
            for (int j=0; j<rejected.length(); j++) {									
		int cardToRemove=Integer.parseInt(rejected.substring(j, j+1)); 
		Card card = deck.draw();
		player.setCard(cardToRemove-1,card);
            }
            UI.printNewCards(player);
        }
    }
	
    
}
