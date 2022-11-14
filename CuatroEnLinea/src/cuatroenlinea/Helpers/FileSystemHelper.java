package cuatroenlinea.Helpers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class FileSystemHelper {
  static final String currentDir =
    System.getProperty("user.dir") + "/CuatroEnLinea/data/";

  public static void createNewUserLocalStorage(String userName) {
    try {
      FileWriter fWriter = new FileWriter(currentDir + "players.json");
      fWriter.write(userName);
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

  public static ArrayList<Object> getPlayersFromJSON() {
    try {
      FileReader fReader = new FileReader(currentDir + "\\players.json");
      String jsonString = "";
      int character = fReader.read();
      while (character != -1) {
        jsonString += (char) character;
        character = fReader.read();
      }
      System.out.println(jsonString);
    } catch (IOException e) {}
    return new ArrayList<Object>();
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
