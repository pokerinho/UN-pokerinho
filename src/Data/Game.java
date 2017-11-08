package Data;

import BussinessLogic.GameTable;

public class Game {

    private GameTable user = new GameTable();
    public static Deck deck = new Deck();

    public void play() {
        for (int i = 0; i < 5; i++) {
            Card card = deck.draw();
            user.addCard(card);
        }

        System.out.println("\nTus cartas son:\n");
        System.out.println(user.toString());
        user.rejectCards();
        System.out.println();
        System.out.println(user.categorizeHand());
    }
}
