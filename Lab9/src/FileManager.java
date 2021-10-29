import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public static void writeInFile(String text, String fileName){
        String temp  =  fileName+".txt";
        String oldText = "";
        try {
            File myObj = new File(temp);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");

                oldText  = new String(Files.readAllBytes(Path.of(temp)));

            }
            FileWriter Writer  = new FileWriter(temp);
            Writer.write(oldText+text+"\n");
            Writer.close();
            System.out.println("Write Successfully");
        } catch (IOException e) {
            System.out.println("Error Occur while writing file");
            e.printStackTrace();
        }
    }
}
