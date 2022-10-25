package interview.sept2622.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] data = new Scanner(System.in).next().split("@");
        Map<Character, Integer> map = new HashMap<>();
        for (String s : data[0].split(",")) {
            map.put(s.split(":")[0].charAt(0),
                    Integer.parseInt(s.split(":")[1]));
        }

        if (data.length == 2) {
            for (String s : data[1].split(",")) {
                String[] parts = s.split(":");
                char c = parts[0].charAt(0);
                int reduce = Integer.parseInt(parts[1]);
                map.put(c, map.get(c) - reduce);
            }
        }

        boolean foo = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                if (!foo) {
                    System.out.print(entry.getKey() + ":" + entry.getValue());
                    foo = true;
                } else {
                    System.out.print("," + entry.getKey() + ":" + entry.getValue());
                }
            }
        }
    }
}
