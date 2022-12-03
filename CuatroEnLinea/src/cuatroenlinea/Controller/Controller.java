/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenlinea.Controller;

import cuatroenlinea.Helpers.FileSystemHelper;
import cuatroenlinea.Helpers.MessageHelper;
import cuatroenlinea.Helpers.PlayersHelper;
import cuatroenlinea.Model.PlayerModel;
import cuatroenlinea.Model.Table;
import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.GameView;
import cuatroenlinea.View.MainMenuView;
import cuatroenlinea.View.SelectPlayersView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
  private JPanel[][] panels;
  private ArrayList<JButton> gameButtons = new ArrayList<JButton>();
  private boolean isFirstPlayerTurn = true;
  private Table table;

  public Controller(
    MainMenuView mainMenuView,
    CreateNewPlayerView createNewPlayerView,
    SelectPlayersView selectPlayersView,
    GameView gameView,
    Table table
  ) {
    this.mainMenuView = mainMenuView;
    this.createNewPlayerView = createNewPlayerView;
    this.selectPlayersView = selectPlayersView;
    this.gameView = gameView;
    this.table = table;
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

    //Commons acctions
    players = FileSystemHelper.getPlayersFromTxt();

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
        createNewPlayerView.getCreateNewPlayerTextField().getText()
      );
      mainMenuView.setVisible(true);
      createNewPlayerView.setVisible(false);
    } else if (pressedButton == createNewPlayerView.getBackButton()) {
      mainMenuView.setVisible(true);
      createNewPlayerView.setVisible(false);
    } else if (pressedButton == mainMenuView.getPlayButton()) {
      selectPlayersView.getPlayer1selectionList().removeAll();
      selectPlayersView.getPlayer2selectionList().removeAll();
      players = FileSystemHelper.getPlayersFromTxt();
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
        table.restartPointMatrix();
        initPanelsMatrix();
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
    int index = gameButtons.indexOf(pressedButton);
    int firstFreePosition = table.getFirstEmptyPanel(index);

    if (firstFreePosition == -1) return;

    table.setValueAt(isFirstPlayerTurn ? 1 : 2, index, firstFreePosition);
    panels[index][firstFreePosition].setBackground(
        isFirstPlayerTurn ? Color.red : Color.blue
      );
    if (table.veryficateWinner()) {
      JOptionPane.showMessageDialog(
        null,
        "Felicitaciones jugador " + (isFirstPlayerTurn ? 1 : 2) + " has ganado"
      );
      mainMenuView.setVisible(true);
      gameView.setVisible(false);
      
    }
    isFirstPlayerTurn = !isFirstPlayerTurn;
  }
  private void initPanelsMatrix(){

    JPanel[][] locPanels =new JPanel[7][6];

    locPanels[1 - 1][1 - 1] = gameView.panel11;
    locPanels[2 - 1][1 - 1] = gameView.panel12;
    locPanels[3 - 1][1 - 1] = gameView.panel13;
    locPanels[4 - 1][1 - 1] = gameView.panel14;
    locPanels[5 - 1][1 - 1] = gameView.panel15;
    locPanels[6 - 1][1 - 1] = gameView.panel16;
    locPanels[7 - 1][1 - 1] = gameView.panel17;
    locPanels[1 - 1][2 - 1] = gameView.panel21;
    locPanels[2 - 1][2 - 1] = gameView.panel22;
    locPanels[3 - 1][2 - 1] = gameView.panel23;
    locPanels[4 - 1][2 - 1] = gameView.panel24;
    locPanels[5 - 1][2 - 1] = gameView.panel25;
    locPanels[6 - 1][2 - 1] = gameView.panel26;
    locPanels[7 - 1][2 - 1] = gameView.panel27;
    locPanels[1 - 1][3 - 1] = gameView.panel31;
    locPanels[2 - 1][3 - 1] = gameView.panel32;
    locPanels[3 - 1][3 - 1] = gameView.panel33;
    locPanels[4 - 1][3 - 1] = gameView.panel34;
    locPanels[5 - 1][3 - 1] = gameView.panel35;
    locPanels[6 - 1][3 - 1] = gameView.panel36;
    locPanels[7 - 1][3 - 1] = gameView.panel37;
    locPanels[1 - 1][4 - 1] = gameView.panel41;
    locPanels[2 - 1][4 - 1] = gameView.panel42;
    locPanels[3 - 1][4 - 1] = gameView.panel43;
    locPanels[4 - 1][4 - 1] = gameView.panel44;
    locPanels[5 - 1][4 - 1] = gameView.panel45;
    locPanels[6 - 1][4 - 1] = gameView.panel46;
    locPanels[7 - 1][4 - 1] = gameView.panel47;
    locPanels[1 - 1][5 - 1] = gameView.panel51;
    locPanels[2 - 1][5 - 1] = gameView.panel52;
    locPanels[3 - 1][5 - 1] = gameView.panel53;
    locPanels[4 - 1][5 - 1] = gameView.panel54;
    locPanels[5 - 1][5 - 1] = gameView.panel55;
    locPanels[6 - 1][5 - 1] = gameView.panel56;
    locPanels[7 - 1][5 - 1] = gameView.panel57;
    locPanels[1 - 1][6 - 1] = gameView.panel61;
    locPanels[2 - 1][6 - 1] = gameView.panel62;
    locPanels[3 - 1][6 - 1] = gameView.panel63;
    locPanels[4 - 1][6 - 1] = gameView.panel64;
    locPanels[5 - 1][6 - 1] = gameView.panel65;
    locPanels[6 - 1][6 - 1] = gameView.panel66;
    locPanels[7 - 1][6 - 1] = gameView.panel67;

    panels = locPanels;
  }
}
