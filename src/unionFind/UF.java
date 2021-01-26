package unionFind;

/**
 * From "Algorithms 4th edition"
 * The <code>find</code> method and <code>union</code> method are set
 * to be abstract to help focusing.
 */
public abstract class UF {
    protected int[] id;
    protected int count; // number of groups (range: [1, N])

    /**
     * The constructor of UF
     * @param N the size of the pool
     */
    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    /**
     * return the size of the pool
     * @return the size of the pool
     */
    public int count() {
        return count;
    }

    /**
     * check the connectivity of two items
     * @param p one item
     * @param q the other item
     * @return true if connected
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * find the group which the input item belongs to
     * @param p the input item
     * @return the belonged group
     */
    public abstract int find(int p);

    /**
     * connect the two groups which are indicated by the two inputs
     * @param p one item
     * @param q the other item
     */
    public abstract void union(int p, int q);
}
