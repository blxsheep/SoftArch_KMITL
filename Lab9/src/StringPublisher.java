import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPublisher implements Flow.Publisher {

    private final ArrayList<Flow.Subscriber> subscribers;

    // make list of subscriber

    StringPublisher(){
        this.subscribers = new ArrayList<Flow.Subscriber>();
    }
    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }
    public void unsubscribe(Flow.Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    public void publishSubscription(String text){

        for(Flow.Subscriber sub : this.subscribers ) {
            // use onNext like update.
            if(sub instanceof AlphabetSubscriber && containAlphabet(text)){
                sub.onNext(text);
            }
            if(sub instanceof NumberSubscriber && containNum(text)){
                sub.onNext(text);
            }
            if(sub instanceof SymbolSubscriber && containSymbol(text)){
                sub.onNext(text);
            }

        }






        ;
    }
    public boolean containNum (String text){
        String regex = "(.)*(\\d)(.)*";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text).matches();
    }
    public boolean containSymbol(String text){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
    public boolean containAlphabet(String text){
        return text.matches("[a-zA-Z]+");
    }



}
