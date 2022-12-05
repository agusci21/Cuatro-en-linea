/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuatroenlinea.Controller;

import cuatroenlinea.Helpers.PlayersHelper;
import cuatroenlinea.Model.PlayerModel;
import cuatroenlinea.Model.Table;
import cuatroenlinea.View.CreateNewPlayerView;
import cuatroenlinea.View.GameView;
import cuatroenlinea.View.MainMenuView;
import cuatroenlinea.View.ResultsView;
import cuatroenlinea.View.SelectPlayersView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author agust
 */
public class Controller implements ActionListener {
  private MainMenuView mainMenuView;
  private ResultsView resultsView;
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
    ResultsView resultsView,
    CreateNewPlayerView createNewPlayerView,
    SelectPlayersView selectPlayersView,
    GameView gameView,
    Table table
  ) {
    this.mainMenuView = mainMenuView;
    this.resultsView = resultsView;
    this.createNewPlayerView = createNewPlayerView;
    this.selectPlayersView = selectPlayersView;
    this.gameView = gameView;
    this.table = table;
  }

  public void init() {
    // Main View buttons
    mainMenuView.getCreateNewPlayerButton().addActionListener(this);
    mainMenuView.getPlayButton().addActionListener(this);
    mainMenuView.getViewResultsButton().addActionListener(this);

    //Results view
    resultsView.getBackButton().addActionListener(this);

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
    createPlayersTxt();
    players = getPlayersFromTxt();
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
      players = getPlayersFromTxt();
      if (
        PlayersHelper.willBeDupplictedPlayers(
          createNewPlayerView.getCreateNewPlayerTextField().getText(),
          players
        )
      ) {
        JOptionPane.showMessageDialog(null, "Ese nombre ya esta en uso");
        return;
      }
      saveNewPlayer(
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
      players = getPlayersFromTxt();
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
      if (validateOponents(firstName, secondName)) {
        firstPlayer = PlayersHelper.getPlayerByName(firstName, players);
        secondPlayer = PlayersHelper.getPlayerByName(secondName, players);
        selectPlayersView.setVisible(false);
        gameView.setVisible(true);
        table.restartPointMatrix();
        initPanelsMatrix();
      }
    } else if (gameButtons.contains(pressedButton)) {
      handleGameButtons(pressedButton);
    } else if (pressedButton == mainMenuView.getViewResultsButton()) {
      resultsView.getResultsList().removeAll();

      players = getPlayersFromTxt();

      for (PlayerModel player : players) {
        resultsView
          .getResultsList()
          .add(player.getName() + ": " + player.getScores());
      }

      resultsView.setVisible(true);
      mainMenuView.setVisible(false);
    } else if (pressedButton == resultsView.getBackButton()) {
      mainMenuView.setVisible(true);
      resultsView.setVisible(false);
    }
  }

  public void resetPanelsColor() {
    for (int i = 0; i < panels.length; i++) {
      for (int j = 0; j < panels[0].length; j++) {
        panels[i][j].setBackground(Color.CYAN);
      }
    }
  }

  private void setGameButtonsActions() {
    gameView.getgameBtn1().addActionListener(this);
    gameView.getgameBtn2().addActionListener(this);
    gameView.getgameBtn3().addActionListener(this);
    gameView.getgameBtn4().addActionListener(this);
    gameView.getgameBtn5().addActionListener(this);
    gameView.getgameBtn6().addActionListener(this);
    gameView.getgameBtn7().addActionListener(this);

    gameButtons.add(gameView.getgameBtn1());
    gameButtons.add(gameView.getgameBtn2());
    gameButtons.add(gameView.getgameBtn3());
    gameButtons.add(gameView.getgameBtn4());
    gameButtons.add(gameView.getgameBtn5());
    gameButtons.add(gameView.getgameBtn6());
    gameButtons.add(gameView.getgameBtn7());
  }

  private void handleGameButtons(Object pressedButton) {
    int index = gameButtons.indexOf(pressedButton);
    int firstFreePosition = table.getFirstEmptyPanel(index);

    if (firstFreePosition == -1) return;

    table.setValueAt(isFirstPlayerTurn ? 1 : 2, index, firstFreePosition);
    panels[index][firstFreePosition].setBackground(
        isFirstPlayerTurn ? Color.red : Color.blue
      );
    if (table.noPosibleMovements()) {
      JOptionPane.showMessageDialog(null, "Empate, sin mas jugadas");
      mainMenuView.setVisible(true);
      gameView.setVisible(false);
      refreshPoints(players);
      resetPanelsColor();
      isFirstPlayerTurn = true;
      return;
    }
    if (table.veryficateWinner()) {
      JOptionPane.showMessageDialog(
        null,
        "Felicitaciones " +
        (isFirstPlayerTurn ? firstPlayer.getName() : secondPlayer.getName()) +
        " has ganado"
      );
      mainMenuView.setVisible(true);
      gameView.setVisible(false);
      if (isFirstPlayerTurn) {
        firstPlayer.incrementPoints();
      } else {
        secondPlayer.incrementPoints();
      }
      refreshPoints(players);
      resetPanelsColor();
      isFirstPlayerTurn = true;
      return;
    }
    isFirstPlayerTurn = !isFirstPlayerTurn;
  }

  private void initPanelsMatrix() {
    JPanel[][] locPanels = new JPanel[7][6];

    locPanels[1 - 1][1 - 1] = gameView.getpanel11();
    locPanels[2 - 1][1 - 1] = gameView.getpanel12();
    locPanels[3 - 1][1 - 1] = gameView.getpanel13();
    locPanels[4 - 1][1 - 1] = gameView.getpanel14();
    locPanels[5 - 1][1 - 1] = gameView.getpanel15();
    locPanels[6 - 1][1 - 1] = gameView.getpanel16();
    locPanels[7 - 1][1 - 1] = gameView.getpanel17();
    locPanels[1 - 1][2 - 1] = gameView.getpanel21();
    locPanels[2 - 1][2 - 1] = gameView.getpanel22();
    locPanels[3 - 1][2 - 1] = gameView.getpanel23();
    locPanels[4 - 1][2 - 1] = gameView.getpanel24();
    locPanels[5 - 1][2 - 1] = gameView.getpanel25();
    locPanels[6 - 1][2 - 1] = gameView.getpanel26();
    locPanels[7 - 1][2 - 1] = gameView.getpanel27();
    locPanels[1 - 1][3 - 1] = gameView.getpanel31();
    locPanels[2 - 1][3 - 1] = gameView.getpanel32();
    locPanels[3 - 1][3 - 1] = gameView.getpanel33();
    locPanels[4 - 1][3 - 1] = gameView.getpanel34();
    locPanels[5 - 1][3 - 1] = gameView.getpanel35();
    locPanels[6 - 1][3 - 1] = gameView.getpanel36();
    locPanels[7 - 1][3 - 1] = gameView.getpanel37();
    locPanels[1 - 1][4 - 1] = gameView.getpanel41();
    locPanels[2 - 1][4 - 1] = gameView.getpanel42();
    locPanels[3 - 1][4 - 1] = gameView.getpanel43();
    locPanels[4 - 1][4 - 1] = gameView.getpanel44();
    locPanels[5 - 1][4 - 1] = gameView.getpanel45();
    locPanels[6 - 1][4 - 1] = gameView.getpanel46();
    locPanels[7 - 1][4 - 1] = gameView.getpanel47();
    locPanels[1 - 1][5 - 1] = gameView.getpanel51();
    locPanels[2 - 1][5 - 1] = gameView.getpanel52();
    locPanels[3 - 1][5 - 1] = gameView.getpanel53();
    locPanels[4 - 1][5 - 1] = gameView.getpanel54();
    locPanels[5 - 1][5 - 1] = gameView.getpanel55();
    locPanels[6 - 1][5 - 1] = gameView.getpanel56();
    locPanels[7 - 1][5 - 1] = gameView.getpanel57();
    locPanels[1 - 1][6 - 1] = gameView.getpanel61();
    locPanels[2 - 1][6 - 1] = gameView.getpanel62();
    locPanels[3 - 1][6 - 1] = gameView.getpanel63();
    locPanels[4 - 1][6 - 1] = gameView.getpanel64();
    locPanels[5 - 1][6 - 1] = gameView.getpanel65();
    locPanels[6 - 1][6 - 1] = gameView.getpanel66();
    locPanels[7 - 1][6 - 1] = gameView.getpanel67();

    panels = locPanels;
  }

  final String currentDir =
    System.getProperty("user.dir") + "\\CuatroEnLinea\\data\\";

  public void saveNewPlayer(String userName) {
    try {
      String data = getPlayerTxtString();
      String aux = data.isBlank() ? "" : ",";
      data += aux + (userName) + "," + 0;
      FileWriter fWriter = new FileWriter(currentDir + "players.txt");
      fWriter.write(data);
      fWriter.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public void refreshPoints(ArrayList<PlayerModel> players) {
    String data = "";
    for (PlayerModel player : players) {
      data += player.getName() + "," + player.getScores() + ",";
    }
    try {
      FileWriter fWriter = new FileWriter(currentDir + "players.txt");
      fWriter.write(data);
      fWriter.close();
    } catch (IOException e) {}
  }

  public void createPlayersTxt() {
    try {
      File file = new File(currentDir + "players.txt");
      if (file.exists()) {
        return;
      }
      file.createNewFile();
    } catch (IOException e) {}
  }

  public String getPlayerTxtString() {
    File file = new File(currentDir + "players.txt");
    String data = "";
    try {
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        data += sc.nextLine();
      }
      sc.close();
      return data;
    } catch (FileNotFoundException e) {}

    return "";
  }

  public ArrayList<PlayerModel> getPlayersFromTxt() {
    ArrayList<PlayerModel> players = new ArrayList<PlayerModel>();
    String data = getPlayerTxtString();

    if (data.isBlank()) {
      return players;
    }

    String[] pairs = data.split(",");

    for (int i = 0; i < pairs.length; i += 2) {
      players.add(new PlayerModel(pairs[i], Integer.parseInt(pairs[i + 1])));
    }

    return players;
  }

  private boolean validateNotEmptyPlayers(String firstName, String secondName) {
    if (
      firstName == null ||
      firstName.isEmpty() ||
      secondName == null ||
      secondName.isEmpty()
    ) {
      JOptionPane.showMessageDialog(null, "Seleccione 2 jugadores");
      return false;
    }
    return true;
  }

  private boolean validateNotAutoOponent(String firstName, String secondName) {
    if (firstName.equals(secondName)) {
      JOptionPane.showMessageDialog(
        null,
        "No puede seleccionar dos veces el mismo jugador"
      );
      return false;
    }
    return true;
  }

  public boolean validateOponents(String firstName, String secondName) {
    return (
      validateNotEmptyPlayers(firstName, secondName) &&
      validateNotAutoOponent(firstName, secondName)
    );
  }
}
