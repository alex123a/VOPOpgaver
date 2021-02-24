package vop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MountainSet {
    private Set<Mountain> set;

    public MountainSet() {
        this.set = new TreeSet<>();
    }

    public Set<Mountain> get() {
        return set;
    }

    public Set<Mountain> sortByRange(Comparator comp) {
        comp = new MountainRangeComparator();
        Set<Mountain> newSet = new TreeSet<>(comp);
        newSet.addAll(this.set);
        return newSet;
    }

    public static void main(String[] args) {
        MountainSet mSet = new MountainSet();
        File file = new File("C:/Users/alexv/Documents/GitHub/exercises/Lesson3/Mountains/Exercise/src/main/resources/vop/FranskeBjerge.csv");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] attributes = scanner.nextLine().split(";");
                mSet.get().add(new Mountain(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4], attributes[5]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Check path");
        }

        System.out.println(mSet.get());
        System.out.println();
        System.out.println(mSet.sortByRange(new MountainRangeComparator()));
    }
}
