/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author wilder-eb
 */
public class Player implements Serializable {
    
    private String playerName;
    private int credits;
    private ArrayList<Card> hand;
    
    public Player(String playerName, int credits){
        this.playerName = playerName;
        this.credits = credits;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits += credits;
    }
    
    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
    public void addCard(Card card) { 
        hand.add(card);
    }
    
    public Card getCard(int index){
        return hand.get(index);
    }
    
    public void setCard(int cardToRemove, Card card){
        hand.set(cardToRemove, card);
    }
    
    public void newHand(){
        this.hand = new ArrayList<>();
    }
	
    @Override
    public String toString() {
	String info = "";
        info = hand.stream().map((card) -> card.toString() + "\n").reduce(info, String::concat);
        return info;	
    }
    
}
