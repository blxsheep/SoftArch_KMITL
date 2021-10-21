package edu.parinya.softarchdesign.structural;
public class  TaxPayingHealthcareWorker extends HealthcareWorkerDecorator {
    // use 10 percent tax
    double tax_rate = 1.1 ;
    TaxPayingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate "+ worker.getName() +" with TaxPaying");
    }
    public double getPrice() {
        return super.getPrice()*tax_rate;
    }
}