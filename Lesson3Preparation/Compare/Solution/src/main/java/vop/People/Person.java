package vop.People;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author erso
 */
public class Person implements Comparable<Person> {
    private String fName;
    private String lName;
    private GregorianCalendar birthDay;
    private double heigth;

    public Person(String fName, String lName, int bYear, int bMonth, int bDate, double heigth) {
        this.fName = fName;
        this.lName = lName;
        this.birthDay = new GregorianCalendar(bYear, bMonth, bDate);
        this.heigth = heigth;
    }

    @Override
    public String toString() {
        return "fName=" + fName + ", lName=" + lName + ", birthDay=" + birthDay.getTime() + ", height_" + heigth + '\n';
    }

    @Override
    public int compareTo(Person o) {
        int r = this.lName.compareTo(o.lName);
        if (r == 0) {
            r = this.fName.compareTo(o.fName);
        }
        if (r == 0) {
            r = this.birthDay.compareTo(o.birthDay);
        }
        return r;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("A", "BB", 1980, 3, 17, 1.87));
        list.add(new Person("B", "BB", 1980, 3, 8, 1.86));
        list.add(new Person("A", "AA", 1980, 3, 9, 1.67));
        list.add(new Person("A", "BB", 1980, 3, 10, 1.67));
        list.add(new Person("A", "BB", 1980, 3, 1, 1.66));
        list.add(new Person("A", "CC", 1980, 3, 1, 1.65));

        System.out.println(list);

        Collections.sort(list);
        System.out.println("\nsorted:\n" + list);

        Comparator<Person> comp = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int i = Double.compare(o1.heigth, o2.heigth);
                if (i == 0) {
                    i = o1.compareTo(o2);
                }
                return i;
            }
        };

        list.sort(comp);

        // region Alternative metoder ovenstående kan skrives på
        // Lambda / Anonymous function:
        Comparator<Person> compLambda = (o1, o2) -> {
            int i = Double.compare(o1.heigth, o2.heigth);
            if (i == 0) {
                i = o1.compareTo(o2);
            }
            return i;
        };

        // Lambda + comparingDouble
        Comparator<Person> compFunction = Comparator.comparingDouble((Person o) -> o.heigth).thenComparing(o -> o);
        // endregion

        System.out.println("\nsorted:\n" + list);

    }


}
