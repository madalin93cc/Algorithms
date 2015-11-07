package algorithms.implementation.sort;

/**
 * In iteration i find the smallest remaining entry
 * swap a[i] and a[min]
 * N^2 / 2 compares
 * N exchanges
 */
public class SelectionSort {
    public static void sort(Comparable a[]){
        int N = a.length;
        for (int i = 0; i < N; i++){
            int min = i;
            for (int j = i + 1; j < N; j++){
                if (SortUtil.less(a[j], a[min])){
                    min = j;
                }
            }
            SortUtil.xchg(a, i, min);
        }
    }
}
