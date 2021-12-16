package Bai1;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class RunMain {
	public static void main(String[] args) {
	
		List <Person> person = new ArrayList <>();
		
		for(int i=0; i<3; i++) {
			Person p = new Person();
			p.Nhap();
			person.add(p);
		}
		
		Collections.sort(person);
		for(Person p : person) {
				System.out.println(p.toString());
		}
		
		
        Collections.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person truoc, Person sau) {
               return truoc.getId() - sau.getId();
            }
        });
        
        Collections.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person truoc, Person sau) {
            	if(truoc.getName().compareToIgnoreCase(sau.getName())==0) {
            		return sau.getAddress().compareTo(truoc.getAddress());
            	}
            	else {
            		return truoc.getName().compareTo(sau.getName());
            	}
            		
            }
        });
        
        for (Person p : person) {
        		System.out.println(p.toString());
        	}

	}
}
