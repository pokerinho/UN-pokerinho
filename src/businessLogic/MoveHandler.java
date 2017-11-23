/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import data.Card;
import data.Player;

/**
 *
 * @author wilder-eb
 */
public class MoveHandler {

    public static int categorizeHand(Player player) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                int compare = player.getCard(j).compareTo(player.getCard(j + 1));
                if (compare > 0) {
                    Card temp = player.getCard(j);
                    player.setCard(j, player.getCard(j + 1));
                    player.setCard(j + 1, temp);
                }
            }
        }
        boolean pair = false,
                twopair = false,
                threeofakind = false,
                straight = false,
                flush = false,
                fullhouse,
                fourofakind = false,
                straightflush = false,
                royalflush = false;
        for (int k = 0; k < 4; k++) {
            if (player.getCard(k).getValue() == player.getCard(k + 1).getValue() && (k - 1 < 0 || player.getCard(k - 1).getValue() != player.getCard(k).getValue()) && (k + 2 > 4 || player.getCard(k + 2).getValue() != player.getCard(k).getValue())) {
                if (pair == true) {
                    twopair = true;
                }
                pair = true;
            }
            if ((k < 2) && player.getCard(k).getValue() == player.getCard(k + 1).getValue() && player.getCard(k + 1).getValue() == player.getCard(k + 2).getValue() && player.getCard(k + 2) == player.getCard(k + 3)) {
                fourofakind = true;
            }
            if (!fourofakind && (k < 3) && player.getCard(k).getValue() == player.getCard(k + 1).getValue() && player.getCard(k + 1).getValue() == player.getCard(k + 2).getValue()) {
                threeofakind = true;
            }
            if ((k < 1) && (player.getCard(k + 4).getValue() == 12 && player.getCard(k).getValue() == 0 || player.getCard(k).getValue() + 1 == player.getCard(k + 1).getValue()) && player.getCard(k + 1).getValue() + 1 == player.getCard(k + 2).getValue() && player.getCard(k + 2).getValue() + 1 == player.getCard(k + 3).getValue() && player.getCard(k + 3).getValue() + 1 == player.getCard(k + 4).getValue()) {
                straight = true;
            }
            if ((k < 1) && player.getCard(k).getSuit() == player.getCard(k + 1).getSuit() && player.getCard(k + 1).getSuit() == player.getCard(k + 2).getSuit() && player.getCard(k + 2).getSuit() == player.getCard(k + 3).getSuit() && player.getCard(k + 3).getSuit() == player.getCard(k + 4).getSuit()) {
                flush = true;
                if (straight == true) {
                    straightflush = true;
                    royalflush = player.getCard(0).getValue() == 0 && player.getCard(1).getValue() == 9;
                }

            }
        }
        fullhouse = threeofakind & pair;
        if (royalflush) {
            return 5000;
        }
        if (straightflush) {
            return 200;
        }
        if (fourofakind) {
            return 100;
        }
        if (fullhouse) {
            return 50;
        }
        if (flush) {
            return 20;
        }
        if (straight) {
            return 10;
        }
        if (threeofakind) {
            return 3;
        }
        if (twopair) {
            return 2;
        }
        if (pair) {
            return 1;
        } else {
            return 0;
        }
    }
}
