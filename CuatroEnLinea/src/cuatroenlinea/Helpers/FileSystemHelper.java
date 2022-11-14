package cuatroenlinea.Helpers;

import java.io.FileWriter;
import java.io.IOException;

public abstract class FileSystemHelper {
    
    static public void createNewUserLocalStorage(String userName){
        final String currentDir = System.getProperty("user.dir") + "/CuatroEnLinea/data/";
        try{
            FileWriter fWriter = new FileWriter(currentDir + "player.json");
            fWriter.write(userName);
            fWriter.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

}
