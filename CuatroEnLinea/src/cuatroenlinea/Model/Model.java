package cuatroenlinea.Model;

import java.util.ArrayList;

import cuatroenlinea.Entitys.PlayerEntity;

public class Model {
    private String newPlayerName;
    private ArrayList<PlayerEntity> players;
    
    public ArrayList<PlayerEntity> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<PlayerEntity> players) {
        this.players = players;
    }
    public String getNewPlayerName() {
        return newPlayerName;
    }
    public void setNewPlayerName(String newPlayerName) {
        this.newPlayerName = newPlayerName;
    }
    
}
