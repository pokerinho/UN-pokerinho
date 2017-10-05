package Data;

import java.util.ArrayList;
import java.util.Scanner;



public class Player {
	
    private final ArrayList<Card> hand = new ArrayList<>(); 
    private final Scanner input = new Scanner(System.in);
	
    public Player() {
	
    }
	
    public void addCard(Card card) { 
        hand.add(card);
    }
	
    @Override
    public String toString() {
	String info = "";
        info = hand.stream().map((card) -> card.toString() + "\n").reduce(info, String::concat);
        return info;	
    }

    public void rejectCards() {
	int reject;
	String rejected = ""; 
	System.out.println("¿Desear cambiar alguna carta? (1-Sí/0-No)");
	reject = input.nextInt();
		
	if (reject ==1) {
            System.out.println("¿Cuáles cartas deseas cambiar?");
            rejected = input.next();	
	}
	replace(rejected); 
	}
	
    private void replace(String rejected) {
	if (!rejected.equals("")) { 
            for (int j=0; j<rejected.length(); j++) {									
		int cardToRemove=Integer.parseInt(rejected.substring(j, j+1)); 
		Card card = Game.deck.draw();
		hand.set(cardToRemove-1,card); 
            }
            System.out.println("Tus nuevas cartas son\n");
            System.out.println(toString());		
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
        fullhouse = false;
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
            return "¡Tienes una Escalera de Color!!";
	if (fourofakind)
            return "¡Tienes un Póker!";
	if (fullhouse)
            return "¡Tienes un Full House!";
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
