package java.homeworks.firstHomework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,4,5,6,7,8));
        CustomArrayList<Integer> lis = new CustomArrayList<>();
        lis.add(5);
        System.out.println(lis);


    }
}
