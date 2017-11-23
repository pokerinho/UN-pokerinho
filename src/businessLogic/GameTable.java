package businessLogic;

import Data.Card;
import Data.Player;
import Data.Deck;
import UI.UI;

public class GameTable {

    public static void replace(UI ui, Deck deck, Player player) {
        int[] rejected = ui.askReject();
        for (int index = 0; index < rejected.length; index++) {
            if (rejected[index] > 0 && rejected[index] < 6) {
                int cardToRemove = rejected[index];
                Card card = deck.draw();
                player.setCard(cardToRemove - 1, card);
            }
        }
        ui.printNewCards(player);
    }
}
