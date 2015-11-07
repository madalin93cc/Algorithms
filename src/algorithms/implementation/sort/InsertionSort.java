package algorithms.implementation.sort;

/**
 * Iteration i swap a[i] with each larger entry to his left
 * (N^2)/4 compares
 * (N^2)/4 exchanges
 * best case: sorted array -> N-1 compares, 0 exchanges
 * worst case: descending order -> (N^2)/2 compares, (N^2)/2 exchanges
 * partial sorted arrays -> liniar time
 */
public class InsertionSort {

    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 0; i < N; i++){
            for (int j = i; j > 0; j--){
                if (SortUtil.less(a[j], a[j - 1])){
                    SortUtil.xchg(a, j, j - 1);
                } else break;
            }
        }
    }
}
