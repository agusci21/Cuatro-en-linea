package cuatroenlinea.Helpers;

import java.util.ArrayList;

import cuatroenlinea.Model.PlayerModel;

public abstract class PlayersHelper {

  public static boolean areDupplicatedPlayers(ArrayList<PlayerModel> players) {
    boolean areDupplicatedPlayers = false;
    for (int i = 0; i < players.size() - 1; i++) {
      String firstName = players.get(i).getName();
      for (int j = i + 1; j < players.size(); j++) {
        String secondName = players.get(j).getName();
        if (firstName.equals(secondName)) {
          areDupplicatedPlayers = true;
          break;
        }
      }
    }
    return areDupplicatedPlayers;
  }

  public static boolean willBeDupplictedPlayers(
    String name,
    ArrayList<PlayerModel> players
  ) {
    for (PlayerModel player : players) {
      if (player.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public static PlayerModel getPlayerByName(
    String name,
    ArrayList<PlayerModel> players
  ) {
    for (PlayerModel player : players) {
      if (player.getName().equals(name)) {
        return player;
      }
    }
    return null;
  }
}
