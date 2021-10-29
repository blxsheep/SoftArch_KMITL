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




    public void onComplete(){
        System.out.println("ON complete function in StringSubscriber checked !!!");
    }





}
