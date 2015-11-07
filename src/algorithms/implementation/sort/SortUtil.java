package algorithms.implementation.sort;

/**
 * Created by Colezea on 06/09/2015.
 */
public class SortUtil {
    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void xchg(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
