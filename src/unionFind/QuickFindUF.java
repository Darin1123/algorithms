package unionFind;

/**
 * quick-find
 */
public class QuickFindUF extends UF {

    /**
     * constructor
     * @param N pool size
     */
    public QuickFindUF(int N) {
        super(N);
    }

    /**
     * quick-find algorithm
     * @param p the input item
     * @return its group
     */
    @Override
    public int find(int p) {
        return id[p];
    }

    /**
     * union algorithm which is based on quick-find algorithm
     * @param p one item
     * @param q the other item
     */
    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID)
                id[i] = qID;
        count--;
    }
}
