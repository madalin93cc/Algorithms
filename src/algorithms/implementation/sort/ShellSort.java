package algorithms.implementation.sort;

/**
 * Based on h-sort
 * h-sort <=> insertion sort with stride length h
 * h ~ 3x + 1
 * worst-case: O(N^(3/2))
 */
public class ShellSort {
    public static void sort(Comparable [] a){
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h+1; // 1, 4, 13, 40

        while (h >= 1){
            for (int i = h; i < N; i++){
                for (int j = i; j >=h && SortUtil.less(a[j], a[j-h]); j-=h){
                    SortUtil.xchg(a, j, j-h);
                }
            }
            h = h/3;
        }
    }
}
