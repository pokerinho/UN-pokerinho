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
	
    public String categorizeHand(){ 
	for (int i = 0; i<5; i++){ 
            for (int j = 0; j<4; j++) {
		int compare = hand.get(j).compareTo(hand.get(j+1)); 
                if (compare>0){ 
                    Card temp=hand.get(j);
                    hand.set(j,hand.get(j+1));
                    hand.set(j+1, temp);
		}
            }
	}
	boolean pair = false, twopair = false, threeofakind = false,straight = false,flush = false, fullhouse;
        
        boolean fourofakind = false, straightflush = false, 
        royalflush = false;			
        for (int k = 0; k<4; k++) { 
            if (hand.get(k).getValue() == hand.get(k+1).getValue()&& (k-1<0||hand.get(k-1).getValue()!=hand.get(k).getValue())&& (k+2>4||hand.get(k+2).getValue()!=hand.get(k).getValue())) {
		if (pair == true) {
                    twopair = true; 	
		}
		pair = true;
		}
		if ((k<2) && hand.get(k).getValue() == hand.get(k+1).getValue() && hand.get(k+1).getValue() == hand.get(k+2).getValue() && hand.get(k+2) == hand.get(k+3)) {
                    fourofakind = true; 
		}
		if (!fourofakind && (k<3) && hand.get(k).getValue() == hand.get(k+1).getValue() && hand.get(k+1).getValue() == hand.get(k+2).getValue()) {
                    threeofakind = true; 
		}
		if ((k<1) && (hand.get(k+4).getValue()==12 && hand.get(k).getValue()==0|| hand.get(k).getValue() + 1 == hand.get(k+1).getValue()) && hand.get(k+1).getValue() +1 == hand.get(k+2).getValue() && hand.get(k+2).getValue() +1 == hand.get(k+3).getValue() && hand.get(k+3).getValue() +1 == hand.get(k+4).getValue()) {
                    straight=true;
                }
                if ((k<1) && hand.get(k).getSuit() == hand.get(k+1).getSuit() && hand.get(k+1).getSuit() == hand.get(k+2).getSuit() && hand.get(k+2).getSuit() == hand.get(k+3).getSuit() && hand.get(k+3).getSuit() == hand.get(k+4).getSuit()) {
                    flush = true; 
                    if (straight == true) {
			straightflush = true; 
			royalflush = hand.get(0).getValue() == 0 && hand.get(1).getValue() == 9;	
                    } 
				
                }
	}
	fullhouse= threeofakind & pair; 
	if (royalflush)
            return "¡Tienes una Flor Imperial!";
	if (straightflush)
            return "¡Tienes una Escalera de Color!";
	if (fourofakind)
            return "¡Tienes un Póker!";
	if (fullhouse)
            return "¡Tienes un Póker!";
	if (flush)
            return "¡Tienes un Color!";
	if (straight)
            return "¡Tienes una Escalera!";
	if (threeofakind)
            return "¡Tienes un Trío!";
	if (twopair)
            return "¡Tienes dos Pares!";
	if (pair)
            return "¡Tienes un Par!";
	else
            return "No tienes nada";
	
	}
}
