package JavaPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class findDuplicatesInArray {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("B");
        arrayList.add("D");
        arrayList.add("A");
        System.out.println(getDuplicatesInArray(arrayList));
    }
    public static ArrayList<String> getDuplicatesInArray(ArrayList<String> arrayList)  {
        Set<String> duplicates = new HashSet<>(arrayList);
        for (String duplicate : duplicates) {
            arrayList.remove(duplicate);
        }
        return arrayList;
    }
}
