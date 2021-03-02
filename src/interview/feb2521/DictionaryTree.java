package interview.feb2521;



/**
 * This is not completed and the insertion method is wrong
 * @author zefengwang
 * @date 2021-03-02
 */
public class DictionaryTree {
    private Node root;

    class LinkedListNode {
        Node node;
        LinkedListNode next;

        LinkedListNode(Node node) {
            this.node = node;
        }
    }

    class Node {
        char val;
        LinkedListNode head;

        Node(char digit) {
            this.val = digit;
        }
    }

    public void print() {
        print(this.root);
    }

    private void print(Node root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        if (root.head == null) return;
        LinkedListNode temp = root.head;
        while (temp != null) {
            print(temp.node);
            temp = temp.next;
        }
    }

    public void insertWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            this.insertChar(word.charAt(i), i);
        }
    }

    private void insertChar(char digit, int counter) {
    }

    public static void main(String[] args) {
        DictionaryTree tree = new DictionaryTree();
        tree.insertWord("13703089169");
        tree.print();
        System.out.println(tree.root.head.node.head.node.val);
    }
}
