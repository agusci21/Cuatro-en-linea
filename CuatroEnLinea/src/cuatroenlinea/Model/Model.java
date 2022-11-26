package cuatroenlinea.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {
    private String newPlayerName;
    private ArrayList<HashMap<String, String>> players;
    
    public String getNewPlayerName() {
        return newPlayerName;
    }
    public void setNewPlayerName(String newPlayerName) {
        this.newPlayerName = newPlayerName;
    }
    
}
