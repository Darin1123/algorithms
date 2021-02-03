package interview.wawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 机考模拟题
 * 给一个字符串, 返回一个去除所有重复字符后的字符串. 第一次出现的字符会被保留, 再次出现的则会被忽略.
 * 例:
 *     1e2eee2r2r2t -> 1e2rt
 */
public class MockTest {
    private final Set<Character> dictionary;

    public MockTest() {
        this.dictionary = new HashSet<>();
    }

    public String killDuplicatedChar(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (!dictionary.contains(str.charAt(i))) {
                builder.append(t);
                dictionary.add(t);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MockTest test = new MockTest();
        System.out.println(test.killDuplicatedChar(sc.nextLine()));
    }
}
