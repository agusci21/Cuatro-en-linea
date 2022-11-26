/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenlinea.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cuatroenlinea.Helpers.FileSystemHelper;
import cuatroenlinea.Model.Model;
import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.MainMenuView;


/**
 *
 * @author agust
 */
public class Controller implements ActionListener{
    private MainMenuView mainMenuView;
    private CreateNewPlayerView createNewPlayerView;
    private Model model;

    public Controller(
        Model model,
        MainMenuView mainMenuView, 
        CreateNewPlayerView createNewPlayerView
        ) {
        this.model = model;
        this.mainMenuView = mainMenuView;
        this.createNewPlayerView = createNewPlayerView;
    }

    public void init(){
        mainMenuView.getCreateNewPlayerButton().addActionListener(this);
        createNewPlayerView.getCreateNewPlayerSubmitButton().addActionListener(this);
        createNewPlayerView.getCreateNewPlayerTextField().addActionListener(this);
        mainMenuView.setVisible(true);
        System.out.println(FileSystemHelper.getPlayerJSONString());
        
    }

    public void loadSavedPlayers(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object pressedButton = e.getSource();

        if(pressedButton == mainMenuView.getCreateNewPlayerButton()){
            this.createNewPlayerView.setVisible(true);
            this.mainMenuView.setVisible(false);
        }else if(pressedButton == createNewPlayerView.getCreateNewPlayerSubmitButton()){
            model.setNewPlayerName(createNewPlayerView.getCreateNewPlayerTextField().getText());
            FileSystemHelper.createNewUserLocalStorage(model.getNewPlayerName());
        }
        
    }

    
}
