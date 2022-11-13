/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenlinea.Controller;

import cuatroenlinea.View.MainMenuView;

/**
 *
 * @author agust
 */
public class Controller {
    private MainMenuView mainMenuView;

    public Controller(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;
    }

    public void init(){
        mainMenuView.setVisible(true);
    }

    
}
