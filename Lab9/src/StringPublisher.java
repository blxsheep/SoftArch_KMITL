import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;
import java.util.concurrent.ForkJoinPool;


public class StringPublisher implements Flow.Publisher {

    private final ArrayList<StringSubscriber> subscribers;
    private final ExecutorService executor = ForkJoinPool.commonPool(); // daemon-based
    private boolean subscribed; // true after first subscribe


    // make list of subscriber

    StringPublisher(){
        this.subscribers = new ArrayList<StringSubscriber>();
    }
    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        if (subscribed)
            subscriber.onError(new IllegalStateException()); // only one allowed
        else {
            subscribed = true;
            subscriber.onSubscribe(new StringSubscription(subscriber, executor));
        }
    }

    public void addSubscriber(StringSubscriber sub){
        this.subscribers.add(sub);
    }
    public void removeSubscriber(StringSubscriber sub){
        this.subscribers.remove(sub);
    }


    public void publish(String text){
        for(StringSubscriber sub : this.subscribers ) {
            sub.update(text);
            // let each class.update filter text
        }
    }


}
