package cuatroenlinea.Model;

import java.util.ArrayList;

import cuatroenlinea.Entitys.PlayerEntity;

public class Model {
    private ArrayList<PlayerEntity> players;
    
    public ArrayList<PlayerEntity> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<PlayerEntity> players) {
        this.players = players;
    }
}
