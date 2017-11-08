package Data;
import BussinessLogic.Deck;

public class Game {
		
    private Player user; 
    public static Deck deck; 
		
    public Game() {
        user = new Player();
        deck = new Deck();
    }
		
    public void play() {
	for(int i = 0; i<5; i++) { 
	Card card = deck.draw();
	user.addCard(card);
    }
         
    System.out.println("\nTus cartas son:\n");
    System.out.println(user.toString()); 
    user.rejectCards();	
    System.out.println();
    System.out.println(user.categorizeHand());
    }

    static class deck {

        public deck() {
        }
    }
}
