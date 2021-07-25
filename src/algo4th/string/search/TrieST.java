package algo4th.string.search;

public class TrieST<Value> {
    private static final int R = 256;
    private Node root;

    private String lastKey;  // for floor method

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
        @Override
        public String toString() {
            return val == null ? "empty" : "" + val;
        }
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
        return floor(root, key, new StringBuilder());
    }

    private String floor(Node node, String key, StringBuilder tracker) {
        if (node == null) {
            return null;
        }
        for (char c = 0; c < R; c++) {
            if (node.next[c] != null) {
                tracker.append(c);
                if (node.next[c].val != null) {  // this is a key
                    if (tracker.toString().compareTo(key) > 0) {  // current key greater than input key
                        return lastKey;  // return last key
                    } else if (tracker.toString().compareTo(key) == 0) {
                        return tracker.toString();
                    } else {  // current key less than input key
                        lastKey = tracker.toString();
                        String possibleKey = floor(node.next[c], key, tracker);
                        if (possibleKey != null) {
                            return possibleKey;
                        }
                    }
                } else {  // this is not a key
                    String possibleKey = floor(node.next[c], key, tracker);
                    if (possibleKey != null) {  // still no luck, keep looking down
                        return possibleKey;
                    }
                }
                tracker.deleteCharAt(tracker.length() - 1);  // back track
            }
        }
        // the next array contains no next nodes
        return null;
    }

    public String ceiling(String key) {
        return ceiling(root, key, new StringBuilder());
    }

    private String ceiling(Node node, String key, StringBuilder tracker) {
        if (node == null) {
            return null;
        }
        for (char c = 0; c < R; c++) {
            tracker.append(c);
            if (node.next[c] != null) {
                if (node.next[c].val != null) {  // this is a key
                    if (tracker.toString().compareTo(key) >= 0) {  // current key greater than input key
                        return tracker.toString();  // return this key
                    } else {
                        String possibleKey = ceiling(node.next[c], key, tracker);
                        if (possibleKey != null) {  // still no luck, keep looking down
                            return possibleKey;
                        }
                    }
                } else {  // this is not a key
                    String possibleKey = ceiling(node.next[c], key, tracker);
                    if (possibleKey != null) {  // still no luck, keep looking down
                        return possibleKey;
                    }
                }
            }
            tracker.deleteCharAt(tracker.length() - 1);  // back track
        }
        // the next array contains no next nodes
        return null;
    }

    public int rank(String key) {
        if (get(key) == null) {
            return -1;  // indicates a missing match
        }
        return rank(root, key ,0, 0);
    }

    private int rank(Node node, String key, int index, int rank) {
        if (node.val != null) {
            if (index == key.length()) {
                return rank;
            } else {
                rank++;
            }
        }
        for (char c = 0; c < R; c++) {
            if (c < key.charAt(index)) {
                rank += size(node.next[c]);
            }
            if (c == key.charAt(index)) {
                return rank(node.next[c], key, ++index, rank);
            }
        }
        return -1;
    }

    public String select(int index) {
        return select(this.root, index, new StringBuilder());
    }

    private String select(Node x, int index, StringBuilder prefix) {
        if (x.val != null && (--index == -1)) {
            return prefix.toString();
        }
        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) {
                int size = size(x.next[c]);
                if (index < size) {
                    return select(x.next[c], index, prefix.append(c));
                } else {
                    index -= size;
                }
            }
        }
        return null;
    }
}
