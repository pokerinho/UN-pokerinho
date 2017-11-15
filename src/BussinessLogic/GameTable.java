package BussinessLogic;

import Data.Card;
import Data.Player;
import Data.Deck;
import UI.UI;

public class GameTable {
    
    public static void replace(UI ui, Deck deck, Player player) {
        String rejected = "";
	if (ui.askReject() == 1) {
            rejected = ui.askWhatReject();
	}
	if (!rejected.equals("")) { 
            for (int j=0; j<rejected.length(); j++) {									
		int cardToRemove=Integer.parseInt(rejected.substring(j, j+1)); 
		Card card = deck.draw();
		player.setCard(cardToRemove-1,card);
            }
            ui.printNewCards(player);
        }
    }
	
    
}
