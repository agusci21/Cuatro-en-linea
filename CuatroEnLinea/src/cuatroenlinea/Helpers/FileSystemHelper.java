package cuatroenlinea.Helpers;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;

public abstract class FileSystemHelper {
    
    static public void createNewUserLocalStorage(){
        final String currentDir = System.getProperty("user.dir") + "/CuatroEnLinea/data/";
        System.out.println("PATH:" + currentDir );
        try{
            FileWriter fWriter = new FileWriter(currentDir + "asd.txt");
            fWriter.write("Hola, funciona");
            fWriter.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }

}
