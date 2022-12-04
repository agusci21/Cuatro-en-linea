/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuatroenlinea;

import cuatroenlinea.Controller.Controller;
import cuatroenlinea.Helpers.FileSystemHelper;
import cuatroenlinea.Model.Table;
import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.GameView;
import cuatroenlinea.View.MainMenuView;
import cuatroenlinea.View.ResultsView;
import cuatroenlinea.View.SelectPlayersView;

public class CuatroEnLinea {

  public static void main(String[] args) {
    System.out.print("\033[H\033[2J");
    FileSystemHelper.createPlayersTxt();

    MainMenuView mainMenuView = new MainMenuView();
    ResultsView resultsView = new ResultsView();
    CreateNewPlayerView createNewPlayerView = new CreateNewPlayerView();
    SelectPlayersView selectPlayersView = new SelectPlayersView();
    GameView gameView = new GameView();
    Table table = new Table();

    Controller controller = new Controller(
      mainMenuView,
      resultsView,
      createNewPlayerView,
      selectPlayersView,
      gameView,
      table
    );
    controller.init();
  }
}
