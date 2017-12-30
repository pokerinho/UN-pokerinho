package data;

import java.io.Serializable;

public class Card implements Comparable<Card>, Serializable{ 

    private final int suit;
    private final int value;
    private final String[] suits = {"♥","♦","♣","♠"}; 
    private final String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};											
		
    public Card(int s, int v) {
	suit = s;
	value = v;
    }
		
    public int getSuit() { 
	return suit;
    }
		
    public int getValue() {
	return value;
    }
    
    public String generateResourceName(){
        String name = values[value] + "_of_" + suits[suit] + ".png";
        return name;
    }
		
    @Override
    public String toString() { 
	String info = values[value] + " de " + suits[suit];	
    return info;
    }
		
    @Override
    public int compareTo(Card other) { 
	if (this.getValue() > other.getValue())
            return 1;
	else if (this.getValue() < other.getValue())
            return -1;
	else
            return 0;
	}
}
