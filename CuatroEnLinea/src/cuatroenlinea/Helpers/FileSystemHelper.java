package cuatroenlinea.Helpers;

import cuatroenlinea.Model.PlayerModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FileSystemHelper {
  static final String currentDir =
    System.getProperty("user.dir") + "\\CuatroEnLinea\\data\\";

  public static void saveNewPlayer(
    String userName
  ) {
    try {
      String data = getPlayerTxtString();
      data += "," + (userName) + ","  + 0; 
      FileWriter fWriter = new FileWriter(currentDir + "players.txt");
      fWriter.write(data);
      fWriter.close();
      

    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public static void refreshPoints(ArrayList<PlayerModel> players){
    String data = "";
    for(PlayerModel player : players){
      data += player.getName() + "," + player.getScores() + ",";
    }
    try {
      FileWriter fWriter = new FileWriter(currentDir + "players.txt");
      fWriter.write(data);
      fWriter.close();
    } catch (IOException e) {}

  }

  public static void createPlayersTxt() {
    try {
      
      File file = new File(currentDir + "players.txt");
      if(file.exists()){
        return;
      }
      file.createNewFile();
  } catch (IOException e) {}
    
  }

  public static String getPlayerTxtString() {
    File file = new File(currentDir + "players.txt");
    String data = "";
    try {
      Scanner sc = new Scanner(file);
      while(sc.hasNextLine()){
        data += sc.nextLine();
      }
      sc.close();
      return data;
    } catch (FileNotFoundException e) {}

    return "";
  }

  public static ArrayList<PlayerModel> getPlayersFromTxt() {
   
    ArrayList<PlayerModel> players = new ArrayList<PlayerModel>();
    String data = getPlayerTxtString();

    String[] pairs = data.split(",");

    for(int  i = 0; i < pairs.length; i +=2 ){
      players.add(new PlayerModel(pairs[i], Integer.parseInt(pairs[i + 1])));
    }
    
    return players;
  }
}
