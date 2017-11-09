/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author wilder-eb
 */
public class Player {
    
    private String playerName;
    private int credits;
    public final ArrayList<Card> hand = new ArrayList<>();
    
    public void addCard(Card card) { 
        hand.add(card);
    }
    
    public void getCard(int index){
        hand.get(index);
    }
    
    public void setCard(int cardToRemove, Card card){
        hand.set(cardToRemove, card);
    }
	
    @Override
    public String toString() {
	String info = "";
        info = hand.stream().map((card) -> card.toString() + "\n").reduce(info, String::concat);
        return info;	
    }
    
}
