package businessLogic;

import DAL.PlayerState;
import data.Card;
import data.Deck;
import data.Player;
import UI.UI;
import UI.CLI;
import UI.GUI;
import java.io.IOException;

public class GameEngine {

    private static Deck deck;
    private static Player player;
    private static UI ui;

    private static void selectUI(String[] args) {
        if (args.length == 0) {
            ui = new GUI();
        } else if (args[0].equals("text")) {
            ui = new CLI();
        } else {
            ui = new GUI();
        }
    }

    public static void main(String[] args) {
        selectUI(args);
        do { 
            ui.printWelcome();
            player = new Player(ui.askName(), 100);
            mainMenu();
            eliminatePlayer();
        } while (ui.printGameOver());
    }

    public static void mainMenu() {
        do {
            ui.printMainMenu(player);
            switch (ui.askMenuOption()) {
                case 1: {
                    startGame();
                }
                break;
                case 2: {
                    ui.printInstructions();
                }
                break;
                case 3: {
                    try {
                        PlayerState.savePlayer(player, ui);
                        ui.printSaved();
                    } catch (IOException exception) {
                        ui.printError(UI.ERROR_IO);
                    }
                }
                break;
                case 4: {
                    try {
                        player = PlayerState.loadPlayer(ui);
                        ui.printLoaded();
                    } catch (IOException exception) {
                        ui.printError(UI.ERROR_IO);
                    }              
                }
                break;
                case 0: {
                    System.exit(0);
                }
            }
        } while (player.getCredits() > 0);
    }

    private static void startGame() {
        deck = new Deck();
        ui.printCredits(player);
        int bet = ui.askBetAmount(player);
        player.setCredits(-bet);
        player.newHand();
        for (int i = 0; i < 5; i++) {
            Card card = deck.draw();
            player.addCard(card);
        }
        play();
        bet *= MoveHandler.categorizeHand(player);
        player.setCredits(bet);
        ui.printCredits(player);
    }

    private static void play() {
        ui.printCards(player);
        GameTable.replace(ui, deck, player);
        ui.printCards(player);
        ui.printCategorizeHand(player);
    }

    public static void eliminatePlayer() {
        player = new Player(player.getPlayerName(), 100);
        try {
            PlayerState.savePlayer(player, ui);
        } catch (IOException exception) {
            ui.printError(UI.ERROR_IO);
        }
    }
}
