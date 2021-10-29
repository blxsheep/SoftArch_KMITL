import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AlphabetSubscriber extends StringSubscriber{
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        // implement here
        subscription.request(Long.MAX_VALUE); // effectively unbounded

    }

    @Override
    public void onNext(Object item) {
        // implement here
        // not sure what you want from onNext
    }
    public void update(String text){
        if(containAlphabet(text)){
            // append to file
            StringSubscriber.writeInFile(text,"Alphabet");
        }
    }
    public boolean containAlphabet(String text){
        return text.matches("[a-zA-Z]+");
    }


}
