package javaHomeWork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(2,4,5,6,7,8,3,11,10));
        CustomArrayList<Integer> cal1 = new CustomArrayList<>();
        cal1.add(5);
        System.out.println(cal1);
        CustomArrayList<Integer> cal2= new CustomArrayList<>(list);
        System.out.println(cal2);
        //cal2.remove(2);
        System.out.println(cal2.contains(8));

        System.out.println(cal2);
        cal2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println(cal2);


    }
}
