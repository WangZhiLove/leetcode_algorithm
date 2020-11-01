package october;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFor {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        list.forEach((a) ->{
            list.remove(a);
        });
    }
}
