/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuatroenlinea;

import cuatroenlinea.Controller.Controller;
import cuatroenlinea.View.MainMenuView;

public class CuatroEnLinea {

  public static void main(String[] args) {
    MainMenuView mainMenuView = new MainMenuView();
    Controller controller = new Controller(mainMenuView);

    controller.init();
    
  }
}
