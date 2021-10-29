

import java.io.File;
import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolSubscriber extends StringSubscriber{
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        // implement here
        subscription.request(Long.MAX_VALUE); // effectively unbounded
        ;
    }

    @Override
    public void onNext(Object item) {
        // implement here
        // I see no reason to implement on next here
    }
    public void update(String text){
        if(containSymbol(text)){
            //append to text
            FileManager.writeInFile(text,"Symbol");
        }
    }
    public boolean containSymbol(String text){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }





}
