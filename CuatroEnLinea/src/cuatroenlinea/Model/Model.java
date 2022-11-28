package cuatroenlinea.Model;

import java.util.ArrayList;

import cuatroenlinea.Entities.PlayerEntity;

public class Model {
    private ArrayList<PlayerEntity> players;
    private PlayerEntity firstPlayer;
    private PlayerEntity secondPlayer;
    
    public PlayerEntity getFirstPlayer() {
        return firstPlayer;
    }
    public void setFirstPlayer(PlayerEntity firstPlayer) {
        this.firstPlayer = firstPlayer;
    }
    
    public PlayerEntity getSecondPlayer() {
        return secondPlayer;
    }
    public void setSecondPlayer(PlayerEntity secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
    public ArrayList<PlayerEntity> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<PlayerEntity> players) {
        this.players = players;
    }
}
