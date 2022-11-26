package cuatroenlinea.Helpers;

import cuatroenlinea.Entitys.PlayerEntity;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class FileSystemHelper {
  static final String currentDir =
    System.getProperty("user.dir") + "/CuatroEnLinea/data/";

  public static void saveNewPlayer(
    String userName,
    ArrayList<PlayerEntity> currentPlayers
  ) {
    try {
      FileWriter fWriter = new FileWriter(currentDir + "players.json");
      PlayerEntity newPlayer = new PlayerEntity(userName, 0);
      currentPlayers.add(newPlayer);

      String players = "";

      for (int i = 0; i < currentPlayers.size() - 1; i++) {
        players += currentPlayers.get(i).toJson();
        players += ", ";
      }

      players += currentPlayers.get(currentPlayers.size() - 1).toJson();
      players = "{\"players\": [" + players + "]}";
      fWriter.write(players);
      fWriter.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public static void createPlayersJSON() {
    if (!fileExists(currentDir + "\\players.json")) {
      try {
        FileWriter fWriter = new FileWriter(currentDir + "players.json");
        fWriter.write("{\"players\":[]}");
        fWriter.close();
      } catch (IOException e) {
        System.out.println(e);
      }
    }
  }

  public static String getPlayerJSONString() {
    try {
      FileReader fReader = new FileReader(currentDir + "\\players.json");
      String jsonString = "";

      int character = fReader.read();
      while (character != -1) {
        jsonString += (char) character;
        character = fReader.read();
      }
      fReader.close();
      return jsonString;
    } catch (Exception e) {}
    return "";
  }

  public static ArrayList<PlayerEntity> getPlayersFromJSON() {
    String jsonString = getPlayerJSONString();
    JSONObject playersJson = new JSONObject(jsonString);
    JSONArray playersArray = (JSONArray) playersJson.get("players");
    ArrayList<PlayerEntity> players = new ArrayList<PlayerEntity>();

    for (int i = 0; i < playersArray.length(); i++) {
      JSONObject playerObject = (JSONObject) playersArray.get(i);
      players.add(PlayerEntity.fromJson(playerObject));
    }

    return players;
  }

  public static boolean fileExists(String directoryFileName) {
    try {
      FileReader fReader = new FileReader(directoryFileName);
      fReader.close();
      return true;
    } catch (IOException e) {
      return false;
    }
  }
}
