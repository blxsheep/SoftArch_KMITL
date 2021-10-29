import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber {

    public abstract void onSubscribe(Flow.Subscription subscription) ;
    public abstract void onNext(Object item) ;
    public abstract void update(String text);

    public void onError(Throwable throwable) {
        // implement here
        throwable.printStackTrace();
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



    public void onComplete(){
        System.out.println("ON complete function in StringSubscriber checked !!!");
    }





}
