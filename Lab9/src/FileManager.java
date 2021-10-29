import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    public static void ClearALlFile (){
        List<String> filenames =  Arrays.asList("Alphabet.txt","Number.txt","Symbol.txt");
        FileWriter writer = null;
        try {
            for (String filename : filenames) {
                writer = new FileWriter(filename);
                writer.write("");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
