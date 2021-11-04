package edu.parinya.softarchdesign.behavior2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class WeightStrategy implements SortStrategy {
    // YOU MAY ADD UP TO 5 LINES OF CODE BELOW THIS COMMENT !! A LINE OF CODE MAY CONTAIN UP TO ONE SEMI-COLON !!
    public void customSort(List<Person> people){
        Collections.sort(people,new Comparator<Person>(){
            public int compare(Person p1 , Person p2){
                return p1.getWeight().compareTo(p2.getWeight());
            }
        });
    };
}
