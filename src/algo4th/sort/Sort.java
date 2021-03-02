package algo4th.sort;

public class Sort {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (Comparable c : a) {
            System.out.print(c+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i=0; i<a.length-1; i++) {
            if (less(a[i+1], a[i])) {
                return false;
            }
        }
        return true;
    }
}
