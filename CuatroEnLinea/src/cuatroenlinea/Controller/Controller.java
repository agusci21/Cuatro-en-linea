/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenlinea.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.MainMenuView;

/**
 *
 * @author agust
 */
public class Controller implements ActionListener{
    private MainMenuView mainMenuView;
    private CreateNewPlayerView createNewPlayerView;
    public Controller(MainMenuView mainMenuView, CreateNewPlayerView createNewPlayerView) {
        this.mainMenuView = mainMenuView;
        this.createNewPlayerView = createNewPlayerView;
    }

    public void init(){
        mainMenuView.getCreateNewPlayerButton().addActionListener(this);

        mainMenuView.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object pressedButton = e.getSource();

        if(pressedButton == mainMenuView.getCreateNewPlayerButton()){
            this.createNewPlayerView.setVisible(true);
            this.mainMenuView.setVisible(false);
        }
        
    }

    
}
