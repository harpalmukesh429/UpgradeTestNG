package JavaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class SortObject {
    public static void main(String[] args) {
        Person a = new Person("Peter", 120);
        Person b = new Person("Robin", 40);
        Person c = new Person("Amy", 100);
        Person d = new Person("Taylor", 75);
        Person e = new Person("Arin", 150);
        Person f = new Person("Arya", 120);

        List<Person> players = new ArrayList<>();
        players.add(a);
        players.add(b);
        players.add(c);
        players.add(d);
        players.add(e);
        players.add(f);
        Collections.sort(players, new Comparator<Person>() {
                    public int compare(Person p1, Person p2) {
                        if (p1.score != p2.score) {
                            return
                                    Integer.compare(p2.score, p1.score);

                        } else {
                            return p1.name.compareTo(p2.name);
                        }
                    }
                }
        );
        for (Person player : players) {
            System.out.println(player.toString());
        }
    }
}
