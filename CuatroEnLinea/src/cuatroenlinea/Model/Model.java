package cuatroenlinea.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    String newPlayerName;
    ArrayList<HashMap<String, String>> players;

    public String createNewUserToJson(){
        return 
        "{" + 
        "   playerName : " + this.newPlayerName + 
        "}";
    }

    public void setNewPlayerName(String newPlayerName) {
        this.newPlayerName = newPlayerName;
    }
    
}
