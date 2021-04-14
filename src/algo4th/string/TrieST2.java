package algo4th.string;

public class TrieST2<Value> {
    private static final int R = 256;
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        int cnt = 0;
        if (x.val != null) {
            cnt++;
        }
        for (char c = 0; c < R; c++) {
            cnt += size(x.next[c]);
        }
        return cnt;
    }

    public String floor(String key) {
        // TODO
        return null;
    }

    public  String ceiling(String key) {
        // TODO
        return null;
    }

    public int rank(String key) {
        if (get(key) == null) {
            return -1;  // indicates a missing match
        }
        return rank(root, key ,0, 0) - 1;
    }

    private int rank(Node x, String key, int index, int rank) {
        if (x.val != null) {
            rank++;
        }
        if (index == key.length()) {
            return rank;
        }
        for (char c = 0; c < R; c++) {
            if (c < key.charAt(index)) {
                rank += size(x.next[c]);
            }
            if (c == key.charAt(index)) {
                return rank(x.next[c], key, ++index, rank);
            }
        }
        return -1;  // dummy return (never runs)
    }

    public String select(int index) {
        return select(this.root, index, "");
    }

    private String select(Node x, int index, String prefix) {
        if (x.val != null) {
            index = index - 1;
            if (index == -1) {
                return prefix;
            }
        }
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                int size = size(x.next[c]);
                if (index < size) {
                    return select(x.next[c], index, prefix + c);
                } else {
                    index -= size;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TrieST2<Integer> trieST = new TrieST2<>();
        trieST.put("shall", 1);
        trieST.put("she", 2);
        trieST.put("shell", 3);
        trieST.put("shore", 4);
        System.out.println(trieST.rank("shall"));
        System.out.println(trieST.rank("she"));
        System.out.println(trieST.rank("shell"));
        System.out.println(trieST.rank("shore"));
    }
}
