package edu.parinya.softarchdesign.structural;
import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    Set<HealthcareServiceable> members = new LinkedHashSet<HealthcareServiceable>();

    public void addMember(HealthcareServiceable worker) {
        members.add(worker);
    }

    public void removeMember(HealthcareServiceable worker) {
        members.remove(worker);
    }

    public void service() {

        for (HealthcareServiceable member : members){
            member.service();
        }
    }

    public double getPrice() {

        double totalPrice = 0;
        for (HealthcareServiceable member : members){
            totalPrice += member.getPrice();
        }
        return totalPrice;
    }

}