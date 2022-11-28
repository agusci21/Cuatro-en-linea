/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenlinea.Controller;

import cuatroenlinea.Entities.PlayerEntity;
import cuatroenlinea.Helpers.FileSystemHelper;
import cuatroenlinea.Helpers.MessageHelper;
import cuatroenlinea.Helpers.PlayersHelper;
import cuatroenlinea.Model.Model;
import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.MainMenuView;
import cuatroenlinea.View.SelectPlayersView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
    createNewPlayerView
      .getCreateNewPlayerSubmitButton()
      .addActionListener(this);
    createNewPlayerView.getCreateNewPlayerTextField().addActionListener(this);
    createNewPlayerView.getBackButton().addActionListener(this);
    //Select players buttons
    selectPlayersView.getPlayer1selectionList().addActionListener(this);

    selectPlayersView.getPlayer2selectionList().addActionListener(this);
    selectPlayersView.getSelectPlayerButton().addActionListener(this);
    selectPlayersView.getPlayButton().addActionListener(this);
    selectPlayersView.getBackButton().addActionListener(this);
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
      if (
        PlayersHelper.willBeDupplictedPlayers(
          createNewPlayerView.getCreateNewPlayerTextField().getText(),
          model.getPlayers()
        )
      ) {
        JOptionPane.showMessageDialog(null, "Ese nombre ya esta en uso");
        return;
      }
      FileSystemHelper.saveNewPlayer(
        createNewPlayerView.getCreateNewPlayerTextField().getText(),
        model.getPlayers()
      );
      mainMenuView.setVisible(true);
      createNewPlayerView.setVisible(false);
    } else if (pressedButton == createNewPlayerView.getBackButton()) {
      mainMenuView.setVisible(true);
      createNewPlayerView.setVisible(false);
    } else if (pressedButton == mainMenuView.getPlayButton()) {
      for (PlayerEntity player : model.getPlayers()) {
        selectPlayersView.getPlayer1selectionList().add(player.getName());
        selectPlayersView.getPlayer2selectionList().add(player.getName());
      }
      selectPlayersView.setVisible(true);
      mainMenuView.setVisible(false);
    } else if (pressedButton == selectPlayersView.getPlayer1selectionList()) {
      selectPlayersView
        .getFirstPlayerLabel()
        .setText(selectPlayersView.getPlayer1selectionList().getSelectedItem());
    } else if (pressedButton == selectPlayersView.getPlayer2selectionList()) {
      selectPlayersView
        .getSecondPlayerLabel()
        .setText(selectPlayersView.getPlayer2selectionList().getSelectedItem());
    } else if (pressedButton == selectPlayersView.getSelectPlayerButton()) {
      selectPlayersView
        .getSecondPlayerLabel()
        .setText(selectPlayersView.getPlayer2selectionList().getSelectedItem());
      selectPlayersView
        .getFirstPlayerLabel()
        .setText(selectPlayersView.getPlayer1selectionList().getSelectedItem());
    } else if (pressedButton == selectPlayersView.getBackButton()) {
      mainMenuView.setVisible(true);
      selectPlayersView.setVisible(false);
    } else if (pressedButton == selectPlayersView.getPlayButton()) {
      String firstName = selectPlayersView.getFirstPlayerLabel().getText();
      String secondName = selectPlayersView.getSecondPlayerLabel().getText();
      MessageHelper.validateOponents(firstName, secondName);
    }
  }
}
