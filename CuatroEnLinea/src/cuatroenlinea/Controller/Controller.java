/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenlinea.Controller;

import cuatroenlinea.Helpers.FileSystemHelper;
import cuatroenlinea.Helpers.MessageHelper;
import cuatroenlinea.Helpers.PlayersHelper;
import cuatroenlinea.Model.PlayerModel;
import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.GameView;
import cuatroenlinea.View.MainMenuView;
import cuatroenlinea.View.SelectPlayersView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author agust
 */
public class Controller implements ActionListener {
  private MainMenuView mainMenuView;
  private CreateNewPlayerView createNewPlayerView;
  private SelectPlayersView selectPlayersView;
  private GameView gameView;
  private ArrayList<PlayerModel> players;
  private PlayerModel firstPlayer;
  private PlayerModel secondPlayer;
  private ArrayList<ArrayList<JPanel>> matrix;
  private ArrayList<JButton> gameButtons = new ArrayList<JButton>();
  private boolean isFirstPlayerTurn = true;

  public Controller(
    MainMenuView mainMenuView,
    CreateNewPlayerView createNewPlayerView,
    SelectPlayersView selectPlayersView,
    GameView gameView
  ) {
    this.mainMenuView = mainMenuView;
    this.createNewPlayerView = createNewPlayerView;
    this.selectPlayersView = selectPlayersView;
    this.gameView = gameView;
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

    //Game view
    setGameButtonsActions();
    initMatrix();

    //Commons acctions
    players = FileSystemHelper.getPlayersFromJSON();

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
          players
        )
      ) {
        JOptionPane.showMessageDialog(null, "Ese nombre ya esta en uso");
        return;
      }
      FileSystemHelper.saveNewPlayer(
        createNewPlayerView.getCreateNewPlayerTextField().getText(),
        players
      );
      mainMenuView.setVisible(true);
      createNewPlayerView.setVisible(false);
    } else if (pressedButton == createNewPlayerView.getBackButton()) {
      mainMenuView.setVisible(true);
      createNewPlayerView.setVisible(false);
    } else if (pressedButton == mainMenuView.getPlayButton()) {
      for (PlayerModel player : players) {
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
      if (MessageHelper.validateOponents(firstName, secondName)) {
        firstPlayer = PlayersHelper.getPlayerByName(firstName, players);
        secondPlayer = PlayersHelper.getPlayerByName(secondName, players);
        selectPlayersView.setVisible(false);
        gameView.setVisible(true);
        initMatrix();
      }
    } else if (gameButtons.contains(pressedButton)) {
      handleGameButtons(pressedButton);
    }
  }

  private void setGameButtonsActions() {
    gameView.gameBtn1.addActionListener(this);
    gameView.gameBtn2.addActionListener(this);
    gameView.gameBtn3.addActionListener(this);
    gameView.gameBtn4.addActionListener(this);
    gameView.gameBtn5.addActionListener(this);
    gameView.gameBtn6.addActionListener(this);
    gameView.gameBtn7.addActionListener(this);

    gameButtons.add(gameView.gameBtn1);
    gameButtons.add(gameView.gameBtn2);
    gameButtons.add(gameView.gameBtn3);
    gameButtons.add(gameView.gameBtn4);
    gameButtons.add(gameView.gameBtn5);
    gameButtons.add(gameView.gameBtn6);
    gameButtons.add(gameView.gameBtn7);
  }

  private void handleGameButtons(Object pressedButton) {
    int index = gameButtons.indexOf(pressedButton) + 1;
    System.out.println(index);
  }

  private void initMatrix() {
    ArrayList<ArrayList<JPanel>> panels = new ArrayList<ArrayList<JPanel>>();

    ArrayList<JPanel> panels1 = new ArrayList<JPanel>();
    ArrayList<JPanel> panels2 = new ArrayList<JPanel>();
    ArrayList<JPanel> panels3 = new ArrayList<JPanel>();
    ArrayList<JPanel> panels4 = new ArrayList<JPanel>();
    ArrayList<JPanel> panels5 = new ArrayList<JPanel>();
    ArrayList<JPanel> panels6 = new ArrayList<JPanel>();

    panels1.add(gameView.panel11);
    panels1.add(gameView.panel12);
    panels1.add(gameView.panel13);
    panels1.add(gameView.panel14);
    panels1.add(gameView.panel15);
    panels1.add(gameView.panel16);
    panels1.add(gameView.panel17);
    panels2.add(gameView.panel21);
    panels2.add(gameView.panel22);
    panels2.add(gameView.panel23);
    panels2.add(gameView.panel24);
    panels2.add(gameView.panel25);
    panels2.add(gameView.panel26);
    panels2.add(gameView.panel27);
    panels3.add(gameView.panel31);
    panels3.add(gameView.panel32);
    panels3.add(gameView.panel33);
    panels3.add(gameView.panel34);
    panels3.add(gameView.panel35);
    panels3.add(gameView.panel36);
    panels3.add(gameView.panel37);
    panels4.add(gameView.panel41);
    panels4.add(gameView.panel42);
    panels4.add(gameView.panel43);
    panels4.add(gameView.panel44);
    panels4.add(gameView.panel45);
    panels4.add(gameView.panel46);
    panels4.add(gameView.panel47);
    panels5.add(gameView.panel51);
    panels5.add(gameView.panel52);
    panels5.add(gameView.panel53);
    panels5.add(gameView.panel54);
    panels5.add(gameView.panel55);
    panels5.add(gameView.panel56);
    panels5.add(gameView.panel57);
    panels6.add(gameView.panel61);
    panels6.add(gameView.panel62);
    panels6.add(gameView.panel63);
    panels6.add(gameView.panel64);
    panels6.add(gameView.panel65);
    panels6.add(gameView.panel66);
    panels6.add(gameView.panel67);

    panels.add(panels1);
    panels.add(panels2);
    panels.add(panels3);
    panels.add(panels4);
    panels.add(panels5);
    panels.add(panels6);

    matrix = panels;

  }
}
