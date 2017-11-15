package BussinessLogic;

import Data.Card;
import Data.Player;
import Data.Deck;
import UI.UI;

public class GameTable {
    
    public static void replace(Deck deck, Player player) {
        String rejected = "";
	if (UI.askReject() == 1) {
            rejected = UI.askWhatReject();
	}
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
