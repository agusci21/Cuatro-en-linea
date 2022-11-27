/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenlinea.Controller;

import cuatroenlinea.Helpers.FileSystemHelper;
import cuatroenlinea.Model.Model;
import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.MainMenuView;
import cuatroenlinea.View.SelectPlayersView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author agust
 */
public class Controller implements ActionListener {
  private MainMenuView mainMenuView;
  private CreateNewPlayerView createNewPlayerView;
  private SelectPlayersView selectPlayersView;
  private Model model;

  public Controller(
    Model model,
    MainMenuView mainMenuView,
    CreateNewPlayerView createNewPlayerView,
    SelectPlayersView selectPlayersView
  ) {
    this.model = model;
    this.mainMenuView = mainMenuView;
    this.createNewPlayerView = createNewPlayerView;
    this.selectPlayersView = selectPlayersView;
  }

  public void init() {
    // Main View buttons
    mainMenuView.getCreateNewPlayerButton().addActionListener(this);
    mainMenuView.getPlayButton().addActionListener(this);

    // create new player buttons
    createNewPlayerView.getCreateNewPlayerTextField().addActionListener(this);

    //Select players buttons

    //Commons acctions
    model.setPlayers(FileSystemHelper.getPlayersFromJSON());
    mainMenuView.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object pressedButton = e.getSource();

    if (pressedButton == mainMenuView.getCreateNewPlayerButton()) {
      this.createNewPlayerView.setVisible(true);
      this.mainMenuView.setVisible(false);
    } else if (
      pressedButton == createNewPlayerView.getCreateNewPlayerSubmitButton()
    ) {
      FileSystemHelper.saveNewPlayer(
        createNewPlayerView.getCreateNewPlayerTextField().getText(),
        model.getPlayers()
      );
      mainMenuView.setVisible(true);
      createNewPlayerView.setVisible(false);
    } else if (pressedButton == mainMenuView.getPlayButton()) {
      selectPlayersView.setVisible(true);
      mainMenuView.setVisible(false);
    }
  }
}
