package cuatroenlinea.Helpers;

import cuatroenlinea.Entities.PlayerEntity;
import java.util.ArrayList;

public abstract class PlayersHelper {

  public static boolean areDupplicatedPlayers(ArrayList<PlayerEntity> players) {
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

  public static PlayerEntity getPlayerByName(
    String name,
    ArrayList<PlayerEntity> players
  ) {
    for (PlayerEntity player : players) {
      if (player.getName().equals(name)) {
        return player;
      }
    }
    return null;
  }
}
