// use as base decorator
package edu.parinya.softarchdesign.structural;
public abstract class HealthcareWorkerDecorator extends HealthcareWorker {
    protected HealthcareServiceable worker ;
    //constructor
    HealthcareWorkerDecorator(HealthcareWorker worker){
        super(worker);
        this.worker  =worker;
    }
    public void service() {
        worker.service();
    }
    public double getPrice(){
       return  worker.getPrice();
    }
}