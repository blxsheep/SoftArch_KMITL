package edu.parinya.softarchdesign.structural;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator {

    TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate "+ worker.getName() +" with TimeLogging");
    }

    public void service(){
        String pattern = "EEE MMM d HH:mm:ss z yyyy: ";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.print(date);
        super.service();

    }
}