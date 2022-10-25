package interview.sept2422;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String frequencySort(String s) {
        if (s.length() == 1) {
            return s;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency.merge(c, 1, Integer::sum);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(frequency.entrySet());

        list.sort((a, b) -> -(a.getValue() - b.getValue()));

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Character, Integer> f : list) {
            for (int i = 0; i < f.getValue(); i++) {
                builder.append(f.getKey());
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(new Solution().frequencySort(s));
    }
}