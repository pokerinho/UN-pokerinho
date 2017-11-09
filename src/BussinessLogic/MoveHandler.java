/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLogic;

import Data.Card;
import Data.Player;

/**
 *
 * @author wilder-eb
 */
public class MoveHandler {
    
    public static String categorizeHand(Player player){ 
	for (int i = 0; i<5; i++){ 
            for (int j = 0; j<4; j++) {
		int compare = player.getCard(j).compareTo(player.getCard(j+1)); 
                if (compare>0){ 
                    Card temp=player.getCard(j);
                    player.setCard(j,player.getCard(j+1));
                    player.setCard(j+1, temp);
		}
            }
	}
	boolean pair = false, twopair = false, threeofakind = false,straight = false,flush = false, fullhouse;
        
        boolean fourofakind = false, straightflush = false, 
        royalflush = false;			
        for (int k = 0; k<4; k++) { 
            if (player.getCard(k).getValue() == player.getCard(k+1).getValue()&& (k-1<0||player.getCard(k-1).getValue()!=player.getCard(k).getValue())&& (k+2>4||player.getCard(k+2).getValue()!=player.getCard(k).getValue())) {
		if (pair == true) {
                    twopair = true; 	
		}
		pair = true;
		}
		if ((k<2) && player.getCard(k).getValue() == player.getCard(k+1).getValue() && player.getCard(k+1).getValue() == player.getCard(k+2).getValue() && player.getCard(k+2) == player.getCard(k+3)) {
                    fourofakind = true; 
		}
		if (!fourofakind && (k<3) && player.getCard(k).getValue() == player.getCard(k+1).getValue() && player.getCard(k+1).getValue() == player.getCard(k+2).getValue()) {
                    threeofakind = true; 
		}
		if ((k<1) && (player.getCard(k+4).getValue()==12 && player.getCard(k).getValue()==0|| player.getCard(k).getValue() + 1 == player.getCard(k+1).getValue()) && player.getCard(k+1).getValue() +1 == player.getCard(k+2).getValue() && player.getCard(k+2).getValue() +1 == player.getCard(k+3).getValue() && player.getCard(k+3).getValue() +1 == player.getCard(k+4).getValue()) {
                    straight=true;
                }
                if ((k<1) && player.getCard(k).getSuit() == player.getCard(k+1).getSuit() && player.getCard(k+1).getSuit() == player.getCard(k+2).getSuit() && player.getCard(k+2).getSuit() == player.getCard(k+3).getSuit() && player.getCard(k+3).getSuit() == player.getCard(k+4).getSuit()) {
                    flush = true; 
                    if (straight == true) {
			straightflush = true; 
			royalflush = player.getCard(0).getValue() == 0 && player.getCard(1).getValue() == 9;	
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
