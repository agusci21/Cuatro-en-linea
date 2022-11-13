/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenlinea.Controller;

import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.MainMenuView;

/**
 *
 * @author agust
 */
public class Controller {
    private MainMenuView mainMenuView;
    private CreateNewPlayerView createNewPlayerView;
    public Controller(MainMenuView mainMenuView, CreateNewPlayerView createNewPlayerView) {
        this.mainMenuView = mainMenuView;
        this.createNewPlayerView = createNewPlayerView;
    }

    public void init(){
        mainMenuView.setVisible(true);
    }

    
}
