package cuatroenlinea.Helpers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import cuatroenlinea.Entitys.PlayerEntity;

public abstract class FileSystemHelper {
  static final String currentDir =
    System.getProperty("user.dir") + "/CuatroEnLinea/data/";

  public static void createNewUserLocalStorage(String userName) {
    try {
      FileWriter fWriter = new FileWriter(currentDir + "players.json");
      PlayerEntity newPlayer = new PlayerEntity(userName, 0);
      fWriter.write(newPlayer.toJson());
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
