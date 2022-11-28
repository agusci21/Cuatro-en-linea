package cuatroenlinea.Helpers;

import javax.swing.JOptionPane;

public class MessageHelper {

    private static boolean validateNotEmptyPlayers(
    String firstName,
    String secondName
  ) {
    if (
      firstName == null ||
      firstName.isEmpty() ||
      secondName == null ||
      secondName.isEmpty()
    ) {
      JOptionPane.showMessageDialog(null, "Seleccione 2 jugadores");
      return false;
    }
    return  true;
  }

  private static boolean validateNotAutoOponent(
    String firstName,
    String secondName
  ) {
    if (firstName.equals(secondName)) {
      JOptionPane.showMessageDialog(
        null,
        "No puede seleccionar dos veces el mismo jugador"
      );
      return true;
    }
    return false;
  }

  public static void validateOponents(String firstName,
  String secondName){

    if(validateNotEmptyPlayers(firstName, secondName)){
        validateNotAutoOponent(firstName, secondName);
    }
  }
}
