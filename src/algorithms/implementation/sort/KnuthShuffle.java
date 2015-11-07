package algorithms.implementation.sort;

/**
 * Shuffle an array
 * Version of shuffle: For each entry generate an random real number and sort the array based on those numbers
 * In iteration i pick integer r between 0 and i uniformely at random
 * swap a[i] and a[r]
 */
public class KnuthShuffle {
    public static void shuffle(Comparable [] a){
        int N = a.length;

        for (int i = 0; i < N; i++){
            int r = (int)(Math.round(Math.random() * i));
            SortUtil.xchg(a, i, r);
        }
    }
}
