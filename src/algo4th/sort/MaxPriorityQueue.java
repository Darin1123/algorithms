package algo4th.sort;

public class MaxPriorityQueue<T extends Comparable> {
    private T[] queue;
    private int N = 0;

    /**
     * construct a priority queue with a maximum size
     * @param maxN the maximum size
     */
    public MaxPriorityQueue(int maxN) {
        this.queue = (T[]) new Comparable[maxN];
    }

    public boolean isEmpty() { return N==0; }

    public int size() { return N; }

    /**
     * insert an item
     * @param item the item
     */
    public void insert(T item) {

    }

    /**
     * pop the maximum item
     * @return the maximum item
     */
    public T delMax() {
        return null;
    }
}
