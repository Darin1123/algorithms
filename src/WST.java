public class WST<T> {
    private static final int R = 256;  // extended ASCII
    private Node root;  // root of trie
    private int n;  // number of keys in trie
    
    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }
    
    public T get(String key) {
        if (key == null) return null;
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (T) x.val;
    }

    public void put(String key, T value) {
        if (key == null) return;

        if (root == null) {
            root = new Node();
        }
        put(root, key, value, 0);
    }

    private Node get(Node node, String key, int i) {
        if (node == null) return null;
        if (i == key.length()) return node;
        char c = key.charAt(i);
        return get(node.next[c], key, i + 1);
    }

    private Node put(Node node, String key, T value, int i) {
        if (node == null) {
            node = new Node();
        }
        if (i == key.length()) {
            if (node.val == null) {
                n++;
                node.val = value;
                return node;
            }
        }
        char c = key.charAt(i);
        node.next[c] = put(node.next[c], key, value, i + 1);
        return node;
    }

    public static void main(String[] args) {
        WST<String> wst = new WST<>();

        wst.put("Java", "OOP");

        System.out.println(wst.get("Java"));
    }
}
