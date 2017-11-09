package BussinessLogic;

import Data.Card;
import Data.Deck;
import Data.Player;

public class GameTable {
	
    public static void replace(String rejected, Deck deck, Player player) {
	if (!rejected.equals("")) { 
            for (int j=0; j<rejected.length(); j++) {									
		int cardToRemove=Integer.parseInt(rejected.substring(j, j+1)); 
		Card card = deck.draw();
		player.setCard(cardToRemove-1,card);
            }
            System.out.println("\nTus nuevas cartas son: \n");
            System.out.println(player.toString());		
        }
    }
	
    
}
