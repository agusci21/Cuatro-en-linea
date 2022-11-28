/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuatroenlinea;

import cuatroenlinea.Controller.Controller;
import cuatroenlinea.Helpers.FileSystemHelper;
import cuatroenlinea.Model.Model;
import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.MainMenuView;
import cuatroenlinea.View.SelectPlayersView;

public class CuatroEnLinea {

  public static void main(String[] args) {
    System.out.print("\033[H\033[2J");
    FileSystemHelper.createPlayersJSON();

    MainMenuView mainMenuView = new MainMenuView();
    CreateNewPlayerView createNewPlayerView = new CreateNewPlayerView();
    SelectPlayersView selectPlayersView = new SelectPlayersView();

    Model model = new Model();

    Controller controller = new Controller(
      model,
      mainMenuView,
      createNewPlayerView,
      selectPlayersView
    );
    controller.init();
  }
}
