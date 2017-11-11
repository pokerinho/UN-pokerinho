package Data;
import java.util.ArrayList; 
import java.util.Collections; 

public class Deck {
	
    private final ArrayList<Card> cards;
	
    public Deck() {
        cards = new ArrayList<>(); 
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
		Card newCard = new Card(i, j);
		cards.add(newCard);
            }
	}
	shuffle(); 
    }

    public void shuffle() {
	Collections.shuffle(cards); 
    }								
	
    public Card draw() { 
	Card returnCard = cards.get(0);  
	cards.remove(0); 
	return returnCard; 
		
    }
}
