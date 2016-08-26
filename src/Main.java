import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        TreshMap map = new TreshMap();
        map.put(10, 17);
        map.put(10, 14);
        map.put(12, 22);
        System.out.println(map.containsKey(10) + " " + map.containsKey(12) + " " + map.containsKey(11));
        System.out.println(map.containsKey(100500));
        map.show();
        System.out.println(map.remove(10));
        System.out.println(map.remove(10));
        System.out.println(map.containsKey(10));
        map.show();

    }
}
