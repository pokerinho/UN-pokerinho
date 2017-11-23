/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import data.Player;
import UI.UI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author wilder-eb
 */
public class PlayerState {
    
    private static final File file = new File("Player.obj");
    private static FileInputStream input = null;
    private static FileOutputStream output = null;
    
    public static void savePlayer(Player player, UI ui) throws IOException{
        try{
            output = new FileOutputStream(file);
            try (ObjectOutputStream os = new ObjectOutputStream(output)) {
                os.writeObject(player);
                os.close();
            }
        }
        catch(FileNotFoundException exception){
            file.createNewFile();
        }
    }
    
    public static Player loadPlayer(UI ui) throws IOException{
        Player player = null;
        try{
            input = new FileInputStream(file);
            try (ObjectInputStream os = new ObjectInputStream(input)) {
                Object loadedPlayer = os.readObject();
                player = (Player) loadedPlayer;
                os.close();
            }
        }
        catch(FileNotFoundException | ClassNotFoundException exception){
            ui.printError(UI.ERROR_IO);
        }
        return player;
    }
}
